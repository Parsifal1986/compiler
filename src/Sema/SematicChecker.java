package Sema;

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
import AST.Stmt.ExprStmtNode;
import AST.Stmt.ForStmtNode;
import AST.Stmt.FuncDefStmtNode;
import AST.Stmt.ReturnStmtNode;
import AST.Stmt.StmtNode;
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.WhileStmtNode;
import AST.Stmt.FuncDefStmtNode.ParameterList;
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
    for (ClassDefStmtNode classdefs : it.classdefs) {
      classdefs.accept(this);
    }
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      funcdefs.accept(this);
    }
    for (VarDefStmtNode vardefs : it.vardefs) {
      vardefs.accept(this);
    }
  }
  
  @Override
  public void visit(TypeNode it) {}

  @Override
  public void visit(ArrayInitializeNode it) {
    if (it.size.size() > 0) {
      for (ExprNode size : it.size) {
        size.accept(this);
      }
    } else {
      it.expr.accept(this);
      if (it.type.getDim() != it.expr.type.getDim()) {
        throw new SyntaxError("Error: Array dimension mismatch", it.pos);
      }
    }
  }

  @Override
  public void visit(ClassInitializeNode it) {
    if (!gscope.CheckClass(it.classname)) {
      throw new SyntaxError("Error: Undefined class " + it.classname, it.pos);
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
    it.expr.accept(this);
  }

  @Override
  public void visit(ArrayNode it) {}

  @Override
  public void visit(BlockStmtNode it) {
    current_scope = new scope(current_scope);
    for (StmtNode stmts : it.stmts) {
      stmts.accept(this);
    }
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(WhileStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InLoop = true;
    it.condition.accept(this);
    it.stmt.accept(this);
    current_scope.InLoop = false;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ConditionStmtNode it) {
    it.condition.accept(this);
    it.trueStmt.accept(this);
    if (it.falseStmt != null) {
      it.falseStmt.accept(this);
    }
  }
  
  @Override
  public void visit(ContinueStmtNode it) {
    if (current_scope.InLoop = false) {
      throw new SyntaxError("Error: Continue statement not in loop", it.pos);
    }
  }
  
  @Override
  public void visit(VarDefStmtNode it) {
    for (InitNode init : it.init) {
      init.accept(this);
    }
  }
  
  @Override
  public void visit(ExprStmtNode it) {
    it.expr.accept(this);
  }
  
  @Override
  public void visit(ClassDefStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.Identifier.put("This", new Type(it.classname, 0));
    for (VarDefStmtNode vardefs : it.vardefs) {
      vardefs.accept(this);
    }
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      funcdefs.accept(this);
    }
    it.constructfuncdef.accept(this);
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(FuncDefStmtNode it) {
    current_scope = new scope(current_scope);
    current_scope.InFunc = true;
    for (FuncDefStmtNode.ParameterList parameters : it.parameters) {
      current_scope.AddIdentifier(parameters.name, parameters.type, it.pos);
    }
    it.body.accept(this);
    current_scope.InFunc = false;
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ReturnStmtNode it) {
    if (current_scope.InFunc == false) {
      throw new SyntaxError("Error: Return statement not in function", it.pos);
    }
    it.expr.accept(this);
  }
  
  @Override
  public void visit(BreakStmtNode it) {
    if (current_scope.InLoop = false) {
      throw new SyntaxError("Error: Break statement not in loop", it.pos);
    }
  }
  
  @Override
  public void visit(ForStmtNode it) {
    current_scope = new scope(current_scope);
    it.init.accept(this);
    it.cond.accept(this);
    it.step.accept(this);
    it.body.accept(this);
    current_scope = current_scope.parent;
  }
  
  @Override
  public void visit(ConstructFuncDefStmtNode it) {
    current_scope = new scope(current_scope);
    it.block.accept(this);
    current_scope = current_scope.parent;
  }


  @Override
  public void visit(ConstExprNode it) {}
  
  @Override
  public void visit(IdentifierExprNode it) {}
  
  @Override
  public void visit(FstringExprNode it) {
    for (ExprNode exprs : it.exprs) {
      exprs.accept(this);
    }
  }
  
  @Override
  public void visit(NewExprNode it) {}
  
  @Override
  public void visit(UnaryExprNode it) {}
  
  @Override
  public void visit(BinaryExprNode it) {}
  
  @Override
  public void visit(TernaryExprNode it) {}
  
  @Override
  public void visit(ThisExprNode it) {}
  
  @Override
  public void visit(AssignExprNode it) {}
  
  @Override
  public void visit(SuffixExprNode it) {}
  
  @Override
  public void visit(PrimeExprNode it) {}
  
  @Override
  public void visit(ArrayConstExprNode it) {}
}
