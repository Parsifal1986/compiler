package Sema;

import java.util.ArrayList;

import AST.ASTVisitor;
import AST.Expr.ArrayConstExprNode;
import AST.Expr.AssignExprNode;
import AST.Expr.BinaryExprNode;
import AST.Expr.ConstExprNode;
import AST.Expr.ExprNode;
import AST.Expr.FstringExprNode;
import AST.Expr.IdentifierExprNode;
import AST.Expr.NewExprNode;
import AST.Expr.PrimeExprNode;
import AST.Expr.SuffixExprNode;
import AST.Expr.TernaryExprNode;
import AST.Expr.ThisExprNode;
import AST.Expr.UnaryExprNode;
import AST.Other.ArrayInitializeNode;
import AST.Other.ArrayNode;
import AST.Other.ClassInitializeNode;
import AST.Other.DeclarationNode;
import AST.Other.InitNode;
import AST.Other.RootNode;
import AST.Other.SuffixContentNode;
import AST.Other.TypeNode;
import AST.Stmt.BlockStmtNode;
import AST.Stmt.BreakStmtNode;
import AST.Stmt.ClassDefStmtNode;
import AST.Stmt.ConditionStmtNode;
import AST.Stmt.ConstructFuncDefStmtNode;
import AST.Stmt.ContinueStmtNode;
import AST.Stmt.EmptyStmtNode;
import AST.Stmt.ExprStmtNode;
import AST.Stmt.ForStmtNode;
import AST.Stmt.FuncDefStmtNode;
import AST.Stmt.ReturnStmtNode;
import AST.Stmt.StmtNode;
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.WhileStmtNode;
import Tools.globalscope;
import Tools.scope;
import Tools.error.SyntaxError;
import Tools.Type;

public class SematicChecker implements ASTVisitor {
  globalscope gscope;
  scope current_scope; 

  public SematicChecker(globalscope gscope) {
    this.current_scope = gscope;
    this.gscope = gscope;
  }

  @Override
  public void visit(RootNode it) {
    for (DeclarationNode decl : it.declarations) {
      decl.accept(this);
    }
  }

  @Override
  public void visit(DeclarationNode it) {
    if (it.funcDef != null) {
      current_scope.replacemode = true;
      it.funcDef.accept(this);
      current_scope.replacemode = false;
    } else if (it.classDef != null) {
      current_scope.replacemode = true;
      it.classDef.accept(this);
      current_scope.replacemode = false;
    } else if (it.varDef != null) {
      it.varDef.accept(this);
    }
  }
  
  @Override
  public void visit(TypeNode it) {}

  @Override
  public void visit(ArrayInitializeNode it) {
    if (it.size.size() > 0) {
      for (ExprNode size : it.size) {
        size.accept(this);
        if (!size.exprType.getTypename().equals("int")) {
          // throw new SyntaxError("Error: Array size not int", it.pos);
          throw new SyntaxError("Type Mismatch", it.pos);
        }
      }
    } else if (it.expr != null) {
      it.expr.accept(this);
      if (it.type.getDim() != it.expr.exprType.getDim()) {
        // throw new SyntaxError("Error: Array dimension mismatch", it.pos);
        throw new SyntaxError("Type Mismatch", it.pos);
      }
    }
  }

  @Override
  public void visit(ClassInitializeNode it) {
    if (!gscope.CheckClass(it.classname)) {
      // throw new SyntaxError("Error: Undefined class " + it.classname, it.pos);
      throw new SyntaxError("Undefined Identifier", it.pos);
    }
  }

  @Override
  public void visit(SuffixContentNode it) {
    for (ExprNode expr : it.expr) {
      expr.accept(this);
    }
  }

  @Override
  public void visit(InitNode it) {
    if (it.expr != null) {
      it.expr.accept(this);
    }
  }

  @Override
  public void visit(ArrayNode it) {}

  @Override
  public void visit(BlockStmtNode it) {
    current_scope = new scope(current_scope);
    for (StmtNode stmts : it.stmts) {
      stmts.accept(this);
    }
    current_scope.parent.hasreturn = current_scope.hasreturn;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(WhileStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InLoop = true;
    it.condition.accept(this);
    if (!it.condition.exprType.getTypename().equals("bool")) {
      // throw new SyntaxError("Error: While condition not bool", it.pos);
      throw new SyntaxError("Invalid Type", it.pos);
    }
    it.stmt.accept(this);
    current_scope.InLoop = false;
    current_scope.parent.hasreturn = current_scope.hasreturn;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ConditionStmtNode it) {
    it.condition.accept(this);
    if (!it.condition.exprType.getTypename().equals("bool") || it.condition.exprType.getDim() != 0) {
      // throw new SyntaxError("Error: Condition not bool", it.pos);
      throw new SyntaxError("Invalid Type", it.pos);
    }
    current_scope = new scope(current_scope);
    it.trueStmt.accept(this);
    current_scope.parent.hasreturn = current_scope.hasreturn;
    current_scope = current_scope.parent;
    if (it.falseStmt != null) {
      current_scope = new scope(current_scope);
      it.falseStmt.accept(this);
      current_scope.parent.hasreturn = current_scope.hasreturn;
      current_scope = current_scope.parent;
    }
  }
  
  @Override
  public void visit(ContinueStmtNode it) {
    if (current_scope.InLoop == false) {
      // throw new SyntaxError("Error: Continue statement not in loop", it.pos);
      throw new SyntaxError("Invalid Control Flow", it.pos);
    }
  }
  
  @Override
  public void visit(VarDefStmtNode it) {
    if (!gscope.CheckClass(it.type.getTypename())) {
      // throw new SyntaxError("Error: Variable type is class", it.pos);
      throw new SyntaxError("Undefined Identifier", it.pos);
    }
    for (InitNode init : it.init) {
      init.accept(this);
      if (init.expr == null) {
        current_scope.AddIdentifier(init.varname, it.type, it.pos);
      } else if (!it.type.equals(init.expr.exprType)) {
        // throw new SyntaxError("Error: Variable type mismatch", it.pos);
        throw new SyntaxError("Type Mismatch", it.pos);
      } else {
        current_scope.AddIdentifier(init.varname, it.type, it.pos);
      }
    }
  }
  
  @Override
  public void visit(ExprStmtNode it) {
    it.expr.accept(this);
  }
  
  @Override
  public void visit(ClassDefStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.functions = gscope.classes.get(it.classname).functions;
    current_scope.Identifier = gscope.classes.get(it.classname).members;
    current_scope.funcparams = gscope.classes.get(it.classname).funcparams;
    current_scope.Identifier.put("This", new Type(it.classname, 0));
    current_scope.replacemode = true;
    for (VarDefStmtNode vardefs : it.vardefs) {
      vardefs.accept(this);
    }
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      funcdefs.accept(this);
    }
    if (it.constructfuncdef != null) {
      it.constructfuncdef.accept(this);
    }
    current_scope.Identifier.remove("This");
    current_scope.replacemode = false;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(FuncDefStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InFunc = true;
    current_scope.funcname = it.funcName;
    ArrayList<Type> funcparams = new ArrayList<Type>();
    for (FuncDefStmtNode.ParameterList parameters : it.parameters) {
      current_scope.AddIdentifier(parameters.name, parameters.type, it.pos);
      funcparams.add(parameters.type);
    }
    current_scope.AddFunction(it.funcName, it.retType, funcparams, it.pos);
    it.body.accept(this);
    if (!current_scope.hasreturn && !it.retType.getTypename().equals("void") && !it.funcName.equals("main")) {
      // throw new SyntaxError("Error: Function has no return", it.pos);
      throw new SyntaxError("Invalid Control Flow", it.pos);
    }
    current_scope.hasreturn = false;
    current_scope.InFunc = false;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ReturnStmtNode it) {
    if (current_scope.InFunc == false) {
      // throw new SyntaxError("Error: Return statement not in function", it.pos);
      throw new SyntaxError("Invalid Control Flow", it.pos);
    }
    if (it.expr == null) {
      if (!current_scope.GetFunctionRetType(current_scope.funcname).getTypename().equals("void") && !current_scope.funcname.equals("main")) {
        // throw new SyntaxError("Error: Return type mismatch", it.pos);
        throw new SyntaxError("Type Mismatch", it.pos);
      }
    } else {
      it.expr.accept(this);
      if (!it.expr.exprType.equals(current_scope.GetFunctionRetType(current_scope.funcname))) {
        // throw new SyntaxError("Error: Return type mismatch", it.pos);
        throw new SyntaxError("Type Mismatch", it.pos);
      }
    }
    current_scope.hasreturn = true;
  }
  
  @Override
  public void visit(BreakStmtNode it) {
    if (current_scope.InLoop == false) {
      // throw new SyntaxError("Error: Break statement not in loop", it.pos);
      throw new SyntaxError("Invalid Control Flow", it.pos);
    }
  }
  
  @Override
  public void visit(ForStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InLoop = true;
    if (it.init != null) {
      it.init.accept(this);
    }
    if (it.cond != null) {
      it.cond.accept(this);
      if (!it.cond.exprType.getTypename().equals("bool")) {
        // throw new SyntaxError("Error: For condition not bool", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
    }
    if (it.step != null) {
      it.step.accept(this);
    }
    it.body.accept(this);
    current_scope.parent.hasreturn = current_scope.hasreturn;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ConstructFuncDefStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InFunc = true;
    current_scope.funcname = it.classname;
    current_scope.AddFunction(it.classname, new Type("void", 0), new ArrayList<>(), it.pos);
    it.block.accept(this);
    current_scope.hasreturn = false;
    current_scope.InFunc = false;
    current_scope = current_scope.parent;
  }

  @Override
  public void visit(EmptyStmtNode it) {}


  @Override
  public void visit(ConstExprNode it) {}
  
  @Override
  public void visit(IdentifierExprNode it) {
    if (current_scope.CheckIdentifier(it.Id.toString())) {
      it.exprType = current_scope.GetIdentifier(it.Id.toString());
      it.islvalue = true;
    } else if (current_scope.CheckFunction(it.Id.toString())) {
      it.exprType = new Type(current_scope.GetFunctionRetType(it.Id.toString()));
      it.exprType.isfunc = true;
      it.islvalue = false;
      it.exprType.params = current_scope.GetFunctionParams(it.Id.toString());
    } else {
      // throw new SyntaxError("Error: Undefined identifier " + it.Id.toString(), it.pos);
      throw new SyntaxError("Undefined Identifier", it.pos);
    }
  }
  
  @Override
  public void visit(FstringExprNode it) {
    for (ExprNode exprs : it.exprs) {
      exprs.accept(this);
      if (exprs.exprType.getDim() > 0) {
        // throw new SyntaxError("Error: Fstring expression not string", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      } else if (!exprs.exprType.getTypename().equals("bool") && !exprs.exprType.getTypename().equals("int") && !exprs.exprType.getTypename().equals("string")) {
        // throw new SyntaxError("Error: Fstring expression not int or string", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
    }
  }
  
  @Override
  public void visit(NewExprNode it) {
    if (it.arrayInitialize != null) {
      it.arrayInitialize.accept(this);
      it.exprType = it.arrayInitialize.type;
    } else {
      it.classInitialize.accept(this);
      it.exprType = new Type(it.classInitialize.classname, 0);
    }
  }
  
  @Override
  public void visit(UnaryExprNode it) {
    it.expr.accept(this);
    if (it.op == UnaryExprNode.Opcode.PRE_DEC || it.op == UnaryExprNode.Opcode.PRE_INC || it.op == UnaryExprNode.Opcode.SUF_DEC || it.op == UnaryExprNode.Opcode.SUF_INC) {
      if (it.expr.islvalue == false || !it.expr.exprType.getTypename().equals("int")) {
        // throw new SyntaxError("Error: Unary expression not lvalue", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      if (it.op == UnaryExprNode.Opcode.PRE_DEC || it.op == UnaryExprNode.Opcode.PRE_INC) {
        it.expr.islvalue = true;
      } else {
        it.expr.islvalue = false;
      }
      it.exprType = new Type("int", 0);
    }
    if (it.op == UnaryExprNode.Opcode.NOT) {
      if (!it.expr.exprType.getTypename().equals("bool") && !it.expr.exprType.getTypename().equals("int")) {
        // throw new SyntaxError("Error: Unary expression not bool or int", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("bool", 0);
      it.expr.islvalue = false;
    }
    if (it.op == UnaryExprNode.Opcode.NEG || it.op == UnaryExprNode.Opcode.BIT_NOT) {
      if (!it.expr.exprType.getTypename().equals("int")) {
        // throw new SyntaxError("Error: Unary expression not int", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("int", 0);
      it.expr.islvalue = false;
    }
    it.islvalue = it.expr.islvalue;
  }
  
  @Override
  public void visit(BinaryExprNode it) {
    it.lhs.accept(this);
    it.rhs.accept(this);
    if (it.op == BinaryExprNode.Opcode.MUL || it.op == BinaryExprNode.Opcode.DIV ||
        it.op == BinaryExprNode.Opcode.MOD || it.op == BinaryExprNode.Opcode.SUB ||
        it.op == BinaryExprNode.Opcode.SHL || it.op == BinaryExprNode.Opcode.SHR ||
        it.op == BinaryExprNode.Opcode.BIT_AND || it.op == BinaryExprNode.Opcode.BIT_XOR ||
        it.op == BinaryExprNode.Opcode.BIT_OR) {
      if (!it.lhs.exprType.getTypename().equals("int") || !it.rhs.exprType.getTypename().equals("int") ||
        it.lhs.exprType.getDim() > 0 ||it.rhs.exprType.getDim() > 0) {
        // throw new SyntaxError("Error: Binary expression not int", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("int", 0);
      it.islvalue = false;
    }
    if (it.op == BinaryExprNode.Opcode.ADD) {
      if ((!it.lhs.exprType.getTypename().equals("int") || !it.rhs.exprType.getTypename().equals("int")) &&
        (!it.lhs.exprType.getTypename().equals("string") || !it.rhs.exprType.getTypename().equals("string") ||
        it.lhs.exprType.getDim() > 0 || it.rhs.exprType.getDim() > 0)) {
        // throw new SyntaxError("Error: Binary expression not int or string", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      if (it.lhs.exprType.getTypename().equals("string") &&
          it.rhs.exprType.getTypename().equals("string")) {
        it.exprType = new Type("string", 0);
      } else {
        it.exprType = new Type("int", 0);
      }
      it.islvalue = false;
    }
    if (it.op == BinaryExprNode.Opcode.AND || it.op == BinaryExprNode.Opcode.OR) {
      if (it.lhs.exprType.getDim() > 0 || it.rhs.exprType.getDim() > 0) {
        // throw new SyntaxError("Error: Binary expression cannot be array", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      if ((!it.lhs.exprType.getTypename().equals("bool") && !it.lhs.exprType.getTypename().equals("int")) ||
        (!it.rhs.exprType.getTypename().equals("bool") && !it.rhs.exprType.getTypename().equals("int"))) {
        // throw new SyntaxError("Error: Binary expression not bool or int", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("bool", 0);
      it.islvalue = false;
    }
    if (it.op == BinaryExprNode.Opcode.LT || it.op == BinaryExprNode.Opcode.GT ||
        it.op == BinaryExprNode.Opcode.LE || it.op == BinaryExprNode.Opcode.GE) {
      if ((!it.lhs.exprType.getTypename().equals("int") || !it.rhs.exprType.getTypename().equals("int")) && 
          (!it.lhs.exprType.getTypename().equals("string") || !it.rhs.exprType.getTypename().equals("string") || 
          it.lhs.exprType.getDim() > 0 || it.rhs.exprType.getDim() > 0)) {
          // throw new SyntaxError("Error: Binary expression not int", it.pos);
          throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("bool", 0);
      it.islvalue = false;
    }
    if (it.op == BinaryExprNode.Opcode.NE || it.op == BinaryExprNode.Opcode.EQ) {
      if (!it.lhs.exprType.equals(it.rhs.exprType)) {
        // throw new SyntaxError("Error: Binary expression not same type", it.pos);
        throw new SyntaxError("Invalid Type", it.pos);
      }
      it.exprType = new Type("bool", 0);
      it.islvalue = false;
    }
  }
  
  @Override
  public void visit(TernaryExprNode it) {
    it.condition.accept(this);
    it.trueExpr.accept(this);
    it.falseExpr.accept(this);
    if (!it.condition.exprType.getTypename().equals("bool") || !it.trueExpr.exprType.equals(it.falseExpr.exprType)) {
      // throw new SyntaxError("Error: Ternary expression not bool or same type", it.pos);
      throw new SyntaxError("Invalid Type", it.pos);
    }
    it.exprType = it.trueExpr.exprType;
    it.islvalue = false;
  }
  
  @Override
  public void visit(ThisExprNode it) {
    it.exprType = new Type(current_scope.GetIdentifier("This").getTypename(), 0);
    it.islvalue = false;
  }
  
  @Override
  public void visit(AssignExprNode it) {
    it.lhs.accept(this);
    it.rhs.accept(this);
    if (it.lhs.islvalue == false) {
      // throw new SyntaxError("Error: Assign expression not lvalue", it.pos);
      throw new SyntaxError("Invalid Type", it.pos);
    }
    if (!it.lhs.exprType.equals(it.rhs.exprType)) {
      // throw new SyntaxError("Error: Assign expression not same type", it.pos);
      throw new SyntaxError("Type Mismatch", it.pos);
    }
    it.exprType = it.lhs.exprType;
    it.islvalue = false;
  }
  
  @Override
  public void visit(SuffixExprNode it) {
    it.primeExpr.accept(this);
    it.exprType = it.primeExpr.exprType;
    for (SuffixContentNode suffixContent : it.suffixContent) {
      if (suffixContent.type == SuffixContentNode.SuffixType.FUNCC) {
        suffixContent.accept(this);
        if (!it.exprType.isfunc) {
          // throw new SyntaxError("Error: Function call on non-function", it.pos);
          throw new SyntaxError("Invalid Type", it.pos);
        }
        if (suffixContent.expr.size() != it.exprType.params.size()) {
          // throw new SyntaxError("Error: Function call parameter mismatch", it.pos);
          throw new SyntaxError("Type Mismatch", it.pos);
        }
        for (int i = 0; i < suffixContent.expr.size(); i++) {
          if (!suffixContent.expr.get(i).exprType.equals(it.exprType.params.get(i))) {
            // throw new SyntaxError("Error: Function call parameter mismatch", it.pos);
            throw new SyntaxError("Type Mismatch", it.pos);
          }
        }
        it.islvalue = false;
        it.exprType.isfunc = false;
      } else if (suffixContent.type == SuffixContentNode.SuffixType.ARRV) {
        suffixContent.accept(this);
        if (suffixContent.expr.get(0).exprType.getDim() != 0 || !suffixContent.expr.get(0).exprType.getTypename().equals("int")) {
          // throw new SyntaxError("Error: Array access expression is not the right type", it.pos);
          throw new SyntaxError("Invalid Type", it.pos);
        }
        if (it.exprType.getDim() <= 0) {
          // throw new SyntaxError("Error: Array access on non-array", it.pos);
          throw new SyntaxError("Dimension Out Of Bound", it.pos);
        }
        it.exprType = new Type(it.exprType.getTypename(), it.exprType.getDim() - 1);
        it.islvalue = true;
      } else if (suffixContent.type == SuffixContentNode.SuffixType.MEMBERV) {
        if (!gscope.CheckClass(it.exprType.getTypename())) {
          // throw new SyntaxError("Error: Member access on non-class", it.pos);
          throw new SyntaxError("Invalid Type", it.pos);
        } else {
          if (it.exprType.getDim() > 0) {
            scope old_scope = current_scope;
            current_scope = new scope(null);
            current_scope.AddFunction("size", new Type("int", 0), new ArrayList<>(), it.pos);
            suffixContent.accept(this);
            it.exprType = suffixContent.expr.get(0).exprType;
            it.islvalue = suffixContent.expr.get(0).islvalue;
            current_scope = old_scope;
            return;
          }
          scope old_scope = current_scope;
          current_scope = new scope(null);
          current_scope.Identifier = gscope.classes.get(it.exprType.getTypename()).members;
          current_scope.functions = gscope.classes.get(it.exprType.getTypename()).functions;
          current_scope.funcparams = gscope.classes.get(it.exprType.getTypename()).funcparams;
          suffixContent.accept(this);
          it.exprType = suffixContent.expr.get(0).exprType;
          it.islvalue = suffixContent.expr.get(0).islvalue;
          if (it.exprType.isfunc) {
            it.islvalue = false;
          }
          current_scope = old_scope;
        }
      }  
    }
  }
  
  @Override
  public void visit(PrimeExprNode it) {
    if (it.identifierExpr != null) {
      it.identifierExpr.accept(this);
      it.exprType = it.identifierExpr.exprType;
      it.islvalue = it.identifierExpr.islvalue;
    } else if (it.thisExpr != null) {
      it.thisExpr.accept(this);
      it.exprType = it.thisExpr.exprType;
      it.islvalue = false;
    } else if (it.newExpr != null) {
      it.newExpr.accept(this);
      it.exprType = it.newExpr.exprType;
      it.islvalue = false;
    } else if (it.constExpr != null) {
      it.constExpr.accept(this);
      it.exprType = it.constExpr.exprType;
      it.islvalue = false;
    } else if (it.parenExpr != null) {
      it.parenExpr.accept(this);
      it.exprType = it.parenExpr.exprType;
      it.islvalue = it.parenExpr.islvalue;
    }
  }
  
  @Override
  public void visit(ArrayConstExprNode it) {
    for (ExprNode expr : it.value) {
      expr.accept(this);
    }
    int dim = 0;
    dim = it.value.get(0).exprType.getDim();
    for (ExprNode expr : it.value) {
      if (expr.exprType.getDim() != dim) {
        // throw new SyntaxError("Error: Array dimension mismatch", it.pos);
        throw new SyntaxError("Type Dismatch", it.pos);
      }
    }
  }
}