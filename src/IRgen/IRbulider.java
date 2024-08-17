package IRgen;

import java.util.ArrayList;
import java.util.Arrays;

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
import AST.Stmt.FuncDefStmtNode.ParameterList;
import Tools.Entity;
import Tools.Type;
import Tools.globalscope;
import Tools.IRsema.alloca;
import Tools.IRsema.arrayInit;
import Tools.IRsema.assign;
import Tools.IRsema.binary;
import Tools.IRsema.block;
import Tools.IRsema.branch;
import Tools.IRsema.call;
import Tools.IRsema.cmp;
import Tools.IRsema.constant32;
import Tools.IRsema.constant8;
import Tools.IRsema.declaration;
import Tools.IRsema.func;
import Tools.IRsema.getelementptr;
import Tools.IRsema.load;
import Tools.IRsema.register;
import Tools.IRsema.ret;

public class IRbulider implements ASTVisitor {
  globalscope gscope;
  func current_func;
  ArrayList<func> functions;
  block current_block;
  block continue_to;
  block break_to;
  declaration decl;
  int cnt = 0;
  
  public IRbulider(globalscope gscope, ArrayList<func> functions) {
    this.gscope = gscope;
    this.functions = functions;
    gscope.Convert();
  }

  @Override
  public void visit(RootNode it) {
    for (DeclarationNode declarations : it.declarations) {
      declarations.accept(this);
    }
  }
  
  @Override
  public void visit(TypeNode it) {}
  
  @Override
  public void visit(ArrayInitializeNode it) {
    if (it.expr != null) {
      it.expr.accept(this);
      it.val = it.expr.val;
    } else if (it.size.size() > 0) {
      register reg = new register("ptr");
      constant32 size = new constant32(it.size.size());
      ArrayList<Entity> args = new ArrayList<>();
      args.add(size);
      for (ExprNode sizeExpr : it.size) {
        sizeExpr.accept(this);
        args.add(sizeExpr.val);
      }
      current_block.add(new call("new_array", reg, "ptr", args));
      it.val = reg;
    }
  }
  
  @Override
  public void visit(ClassInitializeNode it) {
    register reg = new register("ptr");
    current_block.add(new alloca(reg, gscope.IRclasses.get(it.classname)));
    current_block.add(new call(it.classname + "::" + it.classname, null, "ptr", new ArrayList<>(Arrays.asList(reg))));
    it.val = reg;
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
  public void visit(DeclarationNode it) {
    if (it.classDef != null) {
      it.classDef.accept(this);
    } else if (it.funcDef != null) {
      it.funcDef.accept(this);
    }
  }

  
  @Override
  public void visit(BlockStmtNode it) {
    for (StmtNode stmts : it.stmts) {
      stmts.accept(this);
    }
  }
  
  @Override
  public void visit(WhileStmtNode it) {
    current_block = current_block.newblock("while.cond");
    continue_to = current_block; break_to = current_block;
    it.condition.accept(this);
    block bodyBlock = new block("while.body"), nextBlock = new block("while.end");
    current_block.next = new branch(it.condition.val, bodyBlock, nextBlock);
    current_block = bodyBlock;
    it.stmt.accept(this);
    current_block = nextBlock;
  }
  
  @Override
  public void visit(ConditionStmtNode it) {
    it.condition.accept(this);
    block trueBlock = new block("if.true"), falseBlock = new block("if.false"), nextBlock = new block("if.end");
    current_block.next = new branch(it.condition.val, trueBlock, falseBlock);
    current_block = trueBlock;
    it.trueStmt.accept(this);
    current_block.next = new branch(null, nextBlock, null);
    current_block = falseBlock;
    it.falseStmt.accept(this);
    current_block.next = new branch(null, nextBlock, null);
    current_block = nextBlock;
  }
  
  @Override
  public void visit(ContinueStmtNode it) {
    current_block.next = new branch(null, continue_to, null);
  }
  
  @Override
  public void visit(VarDefStmtNode it) {
    for (InitNode init : it.init) {
      current_func.entry.put(init.varname, init.val);
      init.accept(this);
      if (init.expr != null) {
        current_block.statements.add(new assign(init.val, init.expr.val));
      }
    }
  }
  
  @Override
  public void visit(ExprStmtNode it) {
    it.expr.accept(this);
  }
  
  @Override
  public void visit(ClassDefStmtNode it) {
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      funcdefs.accept(this);
    }
  }
  
  @Override
  public void visit(FuncDefStmtNode it) {
    current_func = new func();
    functions.add(current_func);
    current_func.name = it.funcName;
    current_func.type = it.retType.ToIrType();
    for (ParameterList parameters : it.parameters) {
      current_func.args.add(parameters.name);
      register reg = new register(parameters.type, parameters.name);
      current_func.entry.put(parameters.name, reg);
    }
    current_block = new block("common");
    current_func.headblock = current_block;
    it.body.accept(this);
  }
  
  @Override
  public void visit(ReturnStmtNode it) {
    if (it.expr != null) {
      it.expr.accept(this);
      current_block.next = new ret(it.expr.val);
    } else {
      current_block.next = new ret(null);
    }
  }
  
  @Override
  public void visit(BreakStmtNode it) {
    current_block.next = new branch(null, break_to, null);
  }
  
  @Override
  public void visit(ForStmtNode it) {
    current_block = current_block.newblock("for.init");
    it.init.accept(this);
    block condBlock = new block("for.cond"), bodyBlock = new block("for.body"), nextBlock = new block("for.end");
    current_block.next = new branch(null, condBlock, null);
    current_block = condBlock;
    it.cond.accept(this);
    current_block.next = new branch(it.cond.val, bodyBlock, nextBlock);
    current_block = bodyBlock;
    continue_to = condBlock; break_to = nextBlock;
    it.body.accept(this);
    current_block.next = new branch(null, condBlock, null);
    current_block = nextBlock;
  }
  
  @Override
  public void visit(ConstructFuncDefStmtNode it) {
    current_func = new func();
    functions.add(current_func);
    current_block = new block("common");
    current_func.headblock = current_block;
    it.block.accept(this);
  }
  
  @Override
  public void visit(EmptyStmtNode it) {}

  
  @Override
  public void visit(ConstExprNode it) {
    if (it.ctx.True() != null) {
      it.val = new constant8(true);
    } else if (it.ctx.False() != null) {
      it.val = new constant8(false);
    } else if (it.ctx.DemicalConst() != null) {
      it.val = new constant32(Integer.parseInt(it.ctx.DemicalConst().toString()));
    } else if (it.ctx.StringConst() != null) {
      register reg = new register(new Type("string", 0), "str");
      String content = it.ctx.StringConst().toString();
      content = content.substring(1, content.length() - 1);
      decl.global.add(new arrayInit(reg, content.length() + 1, "i8", content));
      it.val = reg;
    } else if (it.ctx.arrayConst() != null) {
      it.arrayConstExprNode.accept(this);
      it.val = it.arrayConstExprNode.val;
    }
  }
  
  @Override
  public void visit(IdentifierExprNode it) {
    if (!it.exprType.isfunc) {
      if (!it.needlvalue) {
        register tmpreg = new register(it.exprType, null);
        current_block.add(new load(tmpreg, (register)it.val));
        it.val = tmpreg;
      }
    }
  }
  
  @Override
  public void visit(FstringExprNode it) {
    register tmpreg = new register("ptr");
    for (int i = 0; i < it.exprs.size() * 2; i++) {
      if (i % 2 == 0) {
        register reg = new register(new Type("string", 0), "str");
        String content = it.strings.get(i / 2);
        content = content.substring(2, content.length() - 1);
        decl.global.add(new arrayInit(reg, content.length() + 1, "i8", content));
        register tmpreg2 = new register("ptr");
        current_block.add(new call("string_add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, reg))));
        tmpreg = tmpreg2;
      } else {
        it.exprs.get(i / 2).accept(this);
        register tostring = new register("ptr");
        current_block.add(new call("to_string", tostring, "ptr", new ArrayList<>(Arrays.asList(it.exprs.get(i / 2).val))));
        register tmpreg2 = new register("ptr");
        current_block.add(new call("string_add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, it.exprs.get(i / 2).val))));
        tmpreg = tmpreg2;
      }
    }
    register reg = new register(new Type("string", 0), "str");
    String content = it.strings.get(it.strings.size() - 1);
    content = content.substring(2, content.length() - 1);
    decl.global.add(new arrayInit(reg, content.length() + 1, "i8", content));
    register tmpreg2 = new register("ptr");
    current_block.add(new call("string_add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, reg))));
    it.val = tmpreg2;
  }
  
  @Override
  public void visit(NewExprNode it) {
    if (it.arrayInitialize != null) {
      it.arrayInitialize.accept(this);
      it.val = it.arrayInitialize.val;
    } else if (it.classInitialize != null) {
      it.classInitialize.accept(this);
      it.val = it.classInitialize.val;
    }
  }
  
  @Override
  public void visit(UnaryExprNode it) {
    it.expr.accept(this);
    if (it.op == UnaryExprNode.Opcode.NOT) {
      if (it.exprType.getTypename().equals("int")) {
        register reg = new register("i8");
        current_block.add(new cmp(reg, it.expr.val, new constant32(0), cmp.opcode.eq));
        it.val = reg;
      } else if (it.exprType.getTypename() == "bool") {
        register reg = new register("i8");
        current_block.add(new cmp(reg, it.expr.val, new constant8(false), cmp.opcode.eq));
        it.val = reg;
      }
    } else if (it.op == UnaryExprNode.Opcode.BIT_NOT) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.xor, it.expr.val, new constant32(-1), reg));
    } else if (it.op == UnaryExprNode.Opcode.NEG) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.sub, new constant32(0), it.expr.val, reg));
    } else if (it.op == UnaryExprNode.Opcode.PRE_DEC) {
      register reg = new register(it.exprType, it.exprType.getTypename());
      it.val = it.expr.val;
      current_block.add(new binary(binary.opcode.sub, it.expr.val, new constant32(1), reg));
      current_block.add(new assign((register)it.expr.val, reg));
    } else if (it.op == UnaryExprNode.Opcode.PRE_INC) {
      register reg = new register(it.exprType, it.exprType.getTypename());
      it.val = reg;
      current_block.add(new binary(binary.opcode.add, it.expr.val, new constant32(1), reg));
      current_block.add(new assign((register)it.expr.val, reg));
    } else if (it.op == UnaryExprNode.Opcode.SUF_DEC) {
      register reg = new register(it.exprType, it.exprType.getTypename());
      it.val = reg;
      current_block.add(new binary(binary.opcode.sub, it.expr.val, new constant32(1), reg));
    } else if (it.op == UnaryExprNode.Opcode.SUF_INC) {
      register reg = new register(it.exprType, it.exprType.getTypename());
      it.val = reg;
      current_block.add(new binary(binary.opcode.add, it.expr.val, new constant32(1), reg));
    }
  }
  
  @Override
  public void visit(BinaryExprNode it) {
    it.lhs.accept(this);
    it.rhs.accept(this);
    if (it.op == BinaryExprNode.Opcode.ADD) {
      if (it.lhs.exprType.getTypename().equals("int")) {
        register reg = new register("i32");
        it.val = reg;
        current_block.add(new binary(binary.opcode.add, it.lhs.val, it.rhs.val, reg));
      } else if (it.lhs.exprType.getTypename().equals("string")) {
        register reg = new register("ptr");
        current_block.add(new call("string_add", reg, "ptr", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
        it.val = reg;
      }
    } else if (it.op == BinaryExprNode.Opcode.SUB) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.sub, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.MUL) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.mul, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.DIV) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.sdiv, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.MOD) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.srem, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.SHL) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.shl, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.SHR) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.ashr, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.LT) {
      if (it.lhs.exprType.getTypename().equals("int")) {
        register reg = new register("i8");
        it.val = reg;
        current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.slt));
      } else if (it.lhs.exprType.getTypename().equals("string")) {
        register reg = new register("i8");
        current_block.add(new call("string_lt", reg, "i8", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
        it.val = reg;
      }
    } else if (it.op == BinaryExprNode.Opcode.GT) {
      if (it.lhs.exprType.getTypename().equals("int")) {
        register reg = new register("i8");
        it.val = reg;
        current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sgt));
      } else if (it.lhs.exprType.getTypename().equals("string")) {
        register reg = new register("i8");
        current_block.add(new call("string_gt", reg, "i8", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
        it.val = reg;
      }
    } else if (it.op == BinaryExprNode.Opcode.LE) {
      if (it.lhs.exprType.getTypename().equals("int")) {
        register reg = new register("i8");
        it.val = reg;
        current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sle));
      } else if (it.lhs.exprType.getTypename().equals("string")) {
        register reg = new register("i8");
        current_block.add(new call("string_le", reg, "i8", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
        it.val = reg;
      }
    } else if (it.op == BinaryExprNode.Opcode.GE) {
      if (it.lhs.exprType.getTypename().equals("int")) {
        register reg = new register("i8");
        it.val = reg;
        current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sge));
      } else if (it.lhs.exprType.getTypename().equals("string")) {
        register reg = new register("i8");
        current_block.add(new call("string_ge", reg, "i8", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
        it.val = reg;
      }
    } else if (it.op == BinaryExprNode.Opcode.EQ) {
      register reg = new register("i8");
      it.val = reg;
      current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.eq));
    } else if (it.op == BinaryExprNode.Opcode.NE) {
      register reg = new register("i8");
      it.val = reg;
      current_block.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.ne));
    } else if (it.op == BinaryExprNode.Opcode.BIT_AND) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.and, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.BIT_XOR) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.xor, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.BIT_OR) {
      register reg = new register("i32");
      it.val = reg;
      current_block.add(new binary(binary.opcode.or, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.AND) {
      register reg = new register("i8");
      it.val = reg;
      current_block.add(new binary(binary.opcode.and, it.lhs.val, it.rhs.val, reg));
    } else if (it.op == BinaryExprNode.Opcode.OR) {
      register reg = new register("i8");
      it.val = reg;
      current_block.add(new binary(binary.opcode.or, it.lhs.val, it.rhs.val, reg));
    }
  }
  
  @Override
  public void visit(TernaryExprNode it) {
    it.condition.accept(this);
    block trueBlock = new block("ternary.true"), falseBlock = new block("ternary.false"), nextBlock = new block("ternary.end");
    current_block.next = new branch(it.condition.val, trueBlock, falseBlock);
    current_block = trueBlock;
    it.trueExpr.accept(this);
    current_block.next = new branch(null, nextBlock, null);
    current_block = falseBlock;
    it.falseExpr.accept(this);
    current_block.next = new branch(null, nextBlock, null);
    current_block = nextBlock;
  }
  
  @Override
  public void visit(ThisExprNode it) {}
  
  @Override
  public void visit(AssignExprNode it) {
    it.lhs.accept(this);
    it.rhs.accept(this);
    current_block.add(new assign((register)it.lhs.val, it.rhs.val));
    it.val = it.rhs.val;
  }
  
  @Override
  public void visit(SuffixExprNode it) {
    it.primeExpr.accept(this);
    register reg = (register)it.primeExpr.val;
    Type nowType = it.primeExpr.exprType;
    for (SuffixContentNode suffixContent : it.suffixContent) {
      if (suffixContent.type == SuffixContentNode.SuffixType.ARRV) {
        String ptrType = gscope.IRclasses.get(it.exprType.getTypename());
        ArrayList<Entity> index = new ArrayList<>();
        suffixContent.accept(this);
        index.add(suffixContent.expr.get(0).val);
        nowType = new Type(nowType.getTypename(), nowType.getDim() - 1);
        register newreg = new register(nowType, null);
        current_block.add(new getelementptr(ptrType, newreg, reg, index));
        reg = newreg;
      } else if (suffixContent.type == SuffixContentNode.SuffixType.FUNCC) {
        ArrayList<Entity> args = new ArrayList<>();
        if (reg != null) {
          args.add(reg);
        }
        for (ExprNode expr : suffixContent.expr) {
          expr.accept(this);
          args.add(expr.val);
        }
        current_block.add(new call(nowType.funcname, reg, nowType.ToIrType(), args));
      } else if (suffixContent.type == SuffixContentNode.SuffixType.MEMBERV) {
        String id = ((IdentifierExprNode)suffixContent.expr.get(0)).Id;
        if (suffixContent.expr.get(0).exprType.isfunc) {
          String classname = nowType.getTypename();
          nowType = new Type(gscope.classes.get(classname).functions.get(id));
          nowType.funcname = gscope.classes.get(classname).functionrename.get(id);
          nowType.isfunc = true;
        } else {
          String ptrType = gscope.IRclasses.get(it.exprType.getTypename());
          ArrayList<Entity> index = new ArrayList<>();
          index.add(new constant32(gscope.classes.get(nowType.getTypename()).memberoffset.get(id)));
          register newreg = new register(gscope.IRclasses.get(it.exprType.getTypename()));
          current_block.add(new getelementptr(ptrType, newreg, reg, index));
          reg = newreg;
          it.exprType = suffixContent.expr.get(0).exprType;
        }
      }
      it.val = reg;
    }
  }
  
  @Override
  public void visit(PrimeExprNode it) {
    if (it.constExpr != null) {
      it.constExpr.accept(this);
      it.val = it.constExpr.val;
      it.exprType = it.constExpr.exprType;
    } else if (it.identifierExpr != null) {
      it.identifierExpr.accept(this);
      it.val = it.identifierExpr.val;
      it.exprType = it.identifierExpr.exprType;
    } else if (it.newExpr != null) {
      it.newExpr.accept(this);
      it.val = it.newExpr.val;
      it.exprType = it.newExpr.exprType;
    } else if (it.thisExpr != null) {
      it.thisExpr.accept(this);
      it.val = it.thisExpr.val;
      it.exprType = it.thisExpr.exprType;
    } else if (it.parenExpr != null) {
      it.parenExpr.accept(this);
      it.val = it.parenExpr.val;
      it.exprType = it.parenExpr.exprType;
    }
  }
  
  @Override
  public void visit(ArrayConstExprNode it) {
    register reg = new register("ptr");
    constant32 size = new constant32(it.value.size());
    ArrayList<Entity> args = new ArrayList<>();
    args.add(size);
    for (ConstExprNode constType : it.value) {
      constType.accept(this);
      args.add(constType.val);
    }
    current_block.add(new call("new_array", reg, "ptr", args));
    it.val = reg;
    for (ConstExprNode value : it.value) {
      value.accept(this);
    }
  }
}