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
import AST.Stmt.FuncDefStmtNode.Reflection;
import Tools.Entity;
import Tools.Type;
import Tools.globalscope;
import Tools.IRsema.stringconst;
import Tools.IRsema.trans;
import Tools.IRsema.assign;
import Tools.IRsema.binary;
import Tools.IRsema.block;
import Tools.IRsema.branch;
import Tools.IRsema.call;
import Tools.IRsema.cmp;
import Tools.IRsema.constant32;
import Tools.IRsema.constant1;
import Tools.IRsema.declaration;
import Tools.IRsema.func;
import Tools.IRsema.getelementptr;
import Tools.IRsema.global;
import Tools.IRsema.load;
import Tools.IRsema.nullptr;
import Tools.IRsema.phi;
import Tools.IRsema.register;
import Tools.IRsema.ret;
import Tools.Class;

public class IRbulider implements ASTVisitor {
  globalscope gscope;
  func currentFunc;
  ArrayList<func> functions;
  func globalinit;
  block currentBlock;
  block continueTo;
  block breakTo;
  declaration decl;
  int cnt = 0;
  Class currentClass;
  register thisptr;
  ArrayList<VarDefStmtNode> globalvardefs;
  
  public IRbulider(globalscope gscope, ArrayList<func> functions, declaration decl) {
    this.gscope = gscope;
    this.functions = functions;
    this.decl = decl;
    this.globalinit = new func();
    this.globalinit.headblock = new block("globalinit");
    this.globalinit.name = "globalinit";
    this.globalinit.type = "void";
    this.globalvardefs = new ArrayList<>();
    functions.add(globalinit);
    gscope.Convert();
  }

  @Override
  public void visit(RootNode it) {
    for (DeclarationNode declarations : it.declarations) {
      declarations.accept(this);
    }
    processGlobalVar();
  }

  void processGlobalVar() {
    currentFunc = globalinit;
    currentBlock = globalinit.headblock;
    for (VarDefStmtNode globalvardefs : globalvardefs) {
      for (InitNode init : globalvardefs.init) {
        decl.global.add(new global(init.val, globalvardefs.type.ToIrType()));
        if (init.expr != null) {
          init.accept(this);
          currentBlock.statements.add(new assign(init.val, init.expr.val));
        }
      }
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
      currentFunc.entry.add(new func.EntryPair(reg, "ptr"));
      ArrayList<Entity> size = new ArrayList<>();
      for (int i = 0; i < it.size.size(); i++) {
        it.size.get(i).accept(this);
        size.add(it.size.get(i).val);
      }
      defineArray(size, it.type, reg, 0, it.type.getDim());
      register tmp = new register("ptr");
      currentBlock.add(new load(tmp, reg));
      it.val = tmp;
    }
  }

  public void defineArray(ArrayList<Entity> size, Type type, register reg, int level, int all_size) {
    if (level == size.size()) {
      if (all_size == size.size()) {
        currentBlock.add(new assign(reg, new constant32(0)));
        // if (type.getfinaltype() == "int") {
          
        // } else if (type.getfinaltype() == "bool") {

        // }
        // register tmp = new register(type);
        // currentBlock.add(new call("malloc", tmp, "ptr", new ArrayList<Entity>(Arrays.asList(new constant32(gscope.classes.get(type.getfinaltype()).size())))));
        // if (!type.IsBuildIn()) {
        //   currentBlock.add(new call(type.getfinaltype() + "." + type.getfinaltype(), null, "ptr", new ArrayList<>(Arrays.asList(tmp))));
        // }
      }
      return;
    }
    register tmp = new register("ptr");
    Type currentType = new Type(type.getfinaltype(), type.getDim() - level- 1);
    int typeSize = 0;
    if (currentType.ToIrType() == "i1") {
      typeSize = 1;
    } else {
      typeSize = 4;
    }
    currentBlock.add(new call("newarray", tmp, "ptr", new ArrayList<Entity>(Arrays.asList(size.get(level), new constant32(typeSize)))));
    currentBlock.add(new assign(reg, tmp));
    currentBlock = currentBlock.newblock("array.for" + level + ".init");
    String initname = currentBlock.name;
    register index = new register("i32");
    register nextIndex = new register("i32");
    block condBlock = new block("array.for" + level + ".cond"), bodyBlock = new block("array.for" + level + ".body"), stepBlock = new block("array.for" + level + ".step"), nextBlock = new block("array.for" + level + ".end");
    currentBlock.next = new branch(null, stepBlock, null);
    currentBlock = condBlock;
    register cmpreg = new register("i8");
    currentBlock.add(new cmp(cmpreg, index, size.get(level), cmp.opcode.slt));
    currentBlock.next = new branch(cmpreg, bodyBlock, nextBlock);
    currentBlock = bodyBlock;
    register newreg = new register("ptr");
    currentBlock.add(new getelementptr(currentType.ToIrType().equals("i1") ? "i8" : currentType.ToIrType(), newreg, tmp, new ArrayList<>(Arrays.asList(index))));
    defineArray(size, type, newreg, level + 1, all_size);
    String name = currentBlock.name;
    currentBlock.next = new branch(null, stepBlock, null);
    currentBlock = stepBlock;
    currentBlock.add(new phi(index, nextIndex, new constant32(0), name, initname));
    currentBlock.add(new binary(binary.opcode.add, index, new constant32(1), nextIndex));
    currentBlock.next = new branch(null, condBlock, null);
    currentBlock = nextBlock;
  }
  
  @Override
  public void visit(ClassInitializeNode it) {
    register reg = new register("ptr");
    currentBlock.add(new call("malloc", reg, "ptr", new ArrayList<Entity>(Arrays.asList(new constant32(gscope.classes.get(it.classname).size())))));
    currentBlock.add(new call(it.classname + "." + it.classname, null, "void", new ArrayList<>(Arrays.asList(reg))));
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
    } else if (it.varDef != null) {
      globalvardefs.add(it.varDef);
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
    block condBlock = currentBlock.newblock("while.cond");
    currentBlock = condBlock;
    block oldContinueTo = continueTo, oldBreakTo = breakTo;
    it.condition.accept(this);
    block bodyBlock = new block("while.body"), nextBlock = new block("while.end");
    continueTo = condBlock; breakTo = nextBlock;
    currentBlock.next = new branch(it.condition.val, bodyBlock, nextBlock);
    currentBlock = bodyBlock;
    it.stmt.accept(this);
    currentBlock.next = new branch(null, condBlock, null);
    currentBlock = nextBlock;
    continueTo = oldContinueTo; breakTo = oldBreakTo;
  }
  
  @Override
  public void visit(ConditionStmtNode it) {
    it.condition.accept(this);
    if (it.falseStmt != null) {
      block trueBlock = new block("if.true"), falseBlock = new block("if.false"), nextBlock = new block("if.end");
      currentBlock.next = new branch(it.condition.val, trueBlock, falseBlock);
      currentBlock = trueBlock;
      it.trueStmt.accept(this);
      currentBlock.next = new branch(null, nextBlock, null);
      currentBlock = falseBlock;
      it.falseStmt.accept(this);
      currentBlock.next = new branch(null, nextBlock, null);
      currentBlock = nextBlock;
    } else {
      block trueBlock = new block("if.true"), nextBlock = new block("if.end");
      currentBlock.next = new branch(it.condition.val, trueBlock, nextBlock);
      currentBlock = trueBlock;
      it.trueStmt.accept(this);
      currentBlock.next = new branch(null, nextBlock, null);
      currentBlock = nextBlock;
    }
  }
  
  @Override
  public void visit(ContinueStmtNode it) {
    currentBlock.next = new branch(null, continueTo, null);
    currentBlock = new block(null);
  }
  
  @Override
  public void visit(VarDefStmtNode it) {
    for (InitNode init : it.init) {
      currentFunc.entry.add(new func.EntryPair(init.val, it.type.ToIrType()));
      init.accept(this);
      if (init.expr != null) {
        currentBlock.statements.add(new assign(init.val, init.expr.val));
      }
    }
  }
  
  @Override
  public void visit(ExprStmtNode it) {
    it.expr.accept(this);
  }
  
  @Override
  public void visit(ClassDefStmtNode it) {
    currentClass = gscope.classes.get(it.classname);
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      thisptr = funcdefs.parameter_regs.get(funcdefs.parameter_regs.size() - 1).param;
      funcdefs.accept(this);
    }
    currentFunc = new func();
    currentFunc.name = it.classname + "." + it.classname;
    currentFunc.type = "void";
    functions.add(currentFunc);
    currentBlock = new block("common");
    currentFunc.headblock = currentBlock;
    if (it.constructfuncdef == null) {
      thisptr = new register("ptr", "This", false);
    } else {
      thisptr = it.constructfuncdef.Thisorigin;
    }
    currentFunc.args.add(thisptr.type + " " + thisptr.tostring());
    for (VarDefStmtNode vardefs : it.vardefs) {
      for (InitNode init : vardefs.init) {
        if (init.expr != null) {
          init.expr.accept(this);
          String ptrType = gscope.IRclasses.get(it.classname);
          ArrayList<Entity> index = new ArrayList<>();
          index.add(new constant32(currentClass.memberoffset.get(init.varname)));
          register newreg = new register("ptr");
          currentBlock.add(new getelementptr(ptrType.equals("i1") ? "i8" : ptrType, newreg, thisptr, index));
          currentBlock.statements.add(new assign(newreg, init.expr.val));
        }
      }
    }
    if (it.constructfuncdef != null) {
      it.constructfuncdef.accept(this);
    }
    currentClass = null;
  }
  
  @Override
  public void visit(FuncDefStmtNode it) {
    currentFunc = new func();
    functions.add(currentFunc);
    if (currentClass != null) {
      currentFunc.name = currentClass.name + "." + it.funcName;
    } else {
      if (it.funcName.equals("main")) {
        currentFunc.name = it.funcName;
      } else {
        currentFunc.name = "." + it.funcName;
      }
    }
    currentFunc.type = it.retType.ToIrType();
    currentBlock = new block("common");
    currentFunc.headblock = currentBlock;
    if (it.funcName.equals("main")) {
      currentBlock.add(new call(globalinit.name, null, "void", new ArrayList<>()));
    }
    for (Reflection parameter_regs : it.parameter_regs) {
      currentFunc.entry.add(new func.EntryPair(parameter_regs.ptr, parameter_regs.param.type));
      currentBlock.add(new assign(parameter_regs.ptr, parameter_regs.param));
      currentFunc.args.add(parameter_regs.param.type + " " + parameter_regs.param.tostring());
    }
    it.body.accept(this);
  }
  
  @Override
  public void visit(ReturnStmtNode it) {
    if (it.expr != null) {
      it.expr.accept(this);
      currentBlock.next = new ret(it.expr.val);
    } else {
      currentBlock.next = new ret(null);
    }
    currentBlock = new block(null);
  }
  
  @Override
  public void visit(BreakStmtNode it) {
    currentBlock.next = new branch(null, breakTo, null);
    currentBlock = new block(null);
  }
  
  @Override
  public void visit(ForStmtNode it) {
    currentBlock = currentBlock.newblock("for.init");
    if (it.init != null) {
      it.init.accept(this);
    }
    block condBlock = new block("for.cond"), bodyBlock = new block("for.body"), stepBlock = new block("for.step"), nextBlock = new block("for.end");
    currentBlock.next = new branch(null, condBlock, null);
    currentBlock = condBlock;
    if (it.cond != null) {
      it.cond.accept(this);
      currentBlock.next = new branch(it.cond.val, bodyBlock, nextBlock);
    } else {
      currentBlock.next = new branch(null, bodyBlock, null);
    }
    currentBlock = bodyBlock;
    block oldContinueTo = continueTo, oldBreakTo = breakTo;
    continueTo = stepBlock; breakTo = nextBlock;
    it.body.accept(this);
    currentBlock.next = new branch(null, stepBlock, null);
    currentBlock = stepBlock;
    if (it.step != null) {
      it.step.accept(this);
    }
    currentBlock.next = new branch(null, condBlock, null);
    currentBlock = nextBlock;
    continueTo = oldContinueTo; breakTo = oldBreakTo;
  }
  
  @Override
  public void visit(ConstructFuncDefStmtNode it) {
    it.block.accept(this);
  }
  
  @Override
  public void visit(EmptyStmtNode it) {}

  
  @Override
  public void visit(ConstExprNode it) {
    if (it.ctx.True() != null) {
      it.val = new constant1(true);
    } else if (it.ctx.False() != null) {
      it.val = new constant1(false);
    } else if (it.ctx.DemicalConst() != null) {
      it.val = new constant32(Integer.parseInt(it.ctx.DemicalConst().toString()));
    } else if (it.ctx.StringConst() != null) {
      register reg = new register(new Type("string", 0), ".str", true);
      String content = it.ctx.StringConst().toString();
      content = content.substring(1, content.length() - 1);
      content = content.replace("\\n", "\n").replace("\\t", "\t").replace("\\\"", "\\22");
      int length = content.replace("\\22", "\"").replace("\\\\", "\\").length();
      decl.global.add(new stringconst(reg, length + 1, "i8", content));
      it.val = reg;
    } else if (it.ctx.arrayConst() != null) {
      it.arrayConstExprNode.accept(this);
      it.val = it.arrayConstExprNode.val;
    } else if (it.ctx.Null() != null) {
      it.val = new nullptr();
    }
  }
  
  @Override
  public void visit(IdentifierExprNode it) {
    if (!it.exprType.isfunc) {
      if (currentClass != null) {
        if (currentClass.members.containsKey(it.Id)) {
          String ptrType = gscope.IRclasses.get(currentClass.name);
          ArrayList<Entity> index = new ArrayList<>();
          index.add(new constant32(0));
          index.add(new constant32(currentClass.memberoffset.get(it.Id)));
          register newreg = new register("ptr");
          currentBlock.add(new getelementptr(ptrType.equals("i1") ? "i8" : ptrType, newreg, thisptr, index));
          if (ptrType.equals("i1")) {
            register transreg = new register("ptr");
            currentBlock.add(new trans(transreg, newreg));
            it.val = transreg;
          } else {
            it.val = newreg;
          }
        }
      }
      if (!it.needlvalue) {
        register tmpreg = new register(it.exprType);
        currentBlock.add(new load(tmpreg, (register)it.val));
        it.val = tmpreg;
      }
    }
  }
  
  @Override
  public void visit(FstringExprNode it) {
    register tmpreg = new register("ptr");
    for (int i = 0; i < it.exprs.size() * 2; i++) {
      if (i % 2 == 0) {
        register reg = new register(new Type("string", 0), ".str", true);
        String content = it.strings.get(i / 2);
        content = content.substring(2, content.length() - 1);
        decl.global.add(new stringconst(reg, content.length() + 1, "i8", content));
        register tmpreg2 = new register("ptr");
        currentBlock.add(new call("string.add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, reg))));
        tmpreg = tmpreg2;
      } else {
        it.exprs.get(i / 2).accept(this);
        register tostring = new register("ptr");
        currentBlock.add(new call("to_string", tostring, "ptr", new ArrayList<>(Arrays.asList(it.exprs.get(i / 2).val))));
        register tmpreg2 = new register("ptr");
        currentBlock.add(new call("string.add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, it.exprs.get(i / 2).val))));
        tmpreg = tmpreg2;
      }
    }
    register reg = new register(new Type("string", 0), ".str", true);
    String content = it.strings.get(it.strings.size() - 1);
    content = content.substring(2, content.length() - 1);
    decl.global.add(new stringconst(reg, content.length() + 1, "i8", content));
    register tmpreg2 = new register("ptr");
    currentBlock.add(new call("string.add", tmpreg2, "ptr", new ArrayList<>(Arrays.asList(tmpreg, reg))));
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
        register reg = new register("i1");
        currentBlock.add(new cmp(reg, it.expr.val, new constant32(0), cmp.opcode.eq));
        it.val = reg;
      } else if (it.exprType.getTypename() == "bool") {
        register reg = new register("i1");
        currentBlock.add(new cmp(reg, it.expr.val, new constant1(false), cmp.opcode.eq));
        it.val = reg;
      }
    } else if (it.op == UnaryExprNode.Opcode.BIT_NOT) {
      register reg = new register("i32");
      it.val = reg;
      currentBlock.add(new binary(binary.opcode.xor, it.expr.val, new constant32(-1), reg));
    } else if (it.op == UnaryExprNode.Opcode.NEG) {
      register reg = new register("i32");
      it.val = reg;
      currentBlock.add(new binary(binary.opcode.sub, new constant32(0), it.expr.val, reg));
    } else {
      register reg = new register(it.exprType);
      currentBlock.add(new load(reg, (register) it.expr.val));
      register tmp = new register(it.exprType);
      if (it.op == UnaryExprNode.Opcode.PRE_DEC) {
        it.val = it.expr.val;
        currentBlock.add(new binary(binary.opcode.sub, reg, new constant32(1), tmp));
        it.islvalue = true;
      } else if (it.op == UnaryExprNode.Opcode.PRE_INC) {
        it.val = it.expr.val;
        currentBlock.add(new binary(binary.opcode.add, reg, new constant32(1), tmp));
        it.islvalue = true;
      } else if (it.op == UnaryExprNode.Opcode.SUF_DEC) {
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.sub, reg, new constant32(1), tmp));
      } else if (it.op == UnaryExprNode.Opcode.SUF_INC) {
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.add, reg, new constant32(1), tmp));
      }
      currentBlock.add(new assign((register) it.expr.val, tmp));
    }
    if (!it.needlvalue && it.islvalue) {
      register tmpreg = new register(it.exprType);
      currentBlock.add(new load(tmpreg, (register) it.val));
      it.val = tmpreg;
    }
  }
  
  @Override
  public void visit(BinaryExprNode it) {
    if (it.op != BinaryExprNode.Opcode.AND && it.op != BinaryExprNode.Opcode.OR) {
      it.lhs.accept(this);
      it.rhs.accept(this);
      if (it.op == BinaryExprNode.Opcode.ADD) {
        if (it.lhs.exprType.getTypename().equals("int")) {
          register reg = new register("i32");
          it.val = reg;
          currentBlock.add(new binary(binary.opcode.add, it.lhs.val, it.rhs.val, reg));
        } else if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("ptr");
          currentBlock.add(new call("string.add", reg, "ptr", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        }
      } else if (it.op == BinaryExprNode.Opcode.SUB) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.sub, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.MUL) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.mul, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.DIV) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.sdiv, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.MOD) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.srem, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.SHL) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.shl, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.SHR) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.ashr, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.LT) {
        if (it.lhs.exprType.getTypename().equals("int")) {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.slt));
        } else if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.lt", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        }
      } else if (it.op == BinaryExprNode.Opcode.GT) {
        if (it.lhs.exprType.getTypename().equals("int")) {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sgt));
        } else if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.gt", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        }
      } else if (it.op == BinaryExprNode.Opcode.LE) {
        if (it.lhs.exprType.getTypename().equals("int")) {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sle));
        } else if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.le", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        }
      } else if (it.op == BinaryExprNode.Opcode.GE) {
        if (it.lhs.exprType.getTypename().equals("int")) {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.sge));
        } else if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.ge", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        }
      } else if (it.op == BinaryExprNode.Opcode.EQ) {
        if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.eq", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        } else {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.eq));
        }
      } else if (it.op == BinaryExprNode.Opcode.NE) {
        if (it.lhs.exprType.getTypename().equals("string")) {
          register reg = new register("i1");
          currentBlock.add(new call("string.ne", reg, "i1", new ArrayList<>(Arrays.asList(it.lhs.val, it.rhs.val))));
          it.val = reg;
        } else {
          register reg = new register("i1");
          it.val = reg;
          currentBlock.add(new cmp(reg, it.lhs.val, it.rhs.val, cmp.opcode.ne));
        }
      } else if (it.op == BinaryExprNode.Opcode.BIT_AND) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.and, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.BIT_XOR) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.xor, it.lhs.val, it.rhs.val, reg));
      } else if (it.op == BinaryExprNode.Opcode.BIT_OR) {
        register reg = new register("i32");
        it.val = reg;
        currentBlock.add(new binary(binary.opcode.or, it.lhs.val, it.rhs.val, reg));
      } 
    } else if (it.op == BinaryExprNode.Opcode.AND) {
      it.lhs.accept(this);
      block trueBlock = new block("and.true"), falseBlock = new block("and.false"), nextBlock = new block("and.end");
      currentBlock.next = new branch(it.lhs.val, trueBlock, falseBlock);
      currentBlock = trueBlock;
      it.rhs.accept(this);
      currentBlock.next = new branch(it.rhs.val, nextBlock, falseBlock);
      String trueBlockName = currentBlock.name;
      currentBlock = falseBlock;
      currentBlock.next = new branch(null, nextBlock, null);
      String falseBlockName = currentBlock.name;
      currentBlock = nextBlock;
      register reg = new register("i1");
      currentBlock.add(new phi(reg, new constant1(true), new constant1(false), trueBlockName, falseBlockName));
      it.val = reg;
    } else if (it.op == BinaryExprNode.Opcode.OR) {
      it.lhs.accept(this);
      block trueBlock = new block("or.true"), falseBlock = new block("or.false"), nextBlock = new block("or.end");
      currentBlock.next = new branch(it.lhs.val, trueBlock, falseBlock);
      currentBlock = trueBlock;
      currentBlock.next = new branch(null, nextBlock, null);
      String trueBlockName = currentBlock.name;
      currentBlock = falseBlock;
      it.rhs.accept(this);
      currentBlock.next = new branch(it.rhs.val, trueBlock, nextBlock);
      String falseBlockName = currentBlock.name;
      currentBlock = nextBlock;
      register reg = new register("i1");
      currentBlock.add(new phi(reg, new constant1(true), new constant1(false), trueBlockName, falseBlockName));
      it.val = reg;
    }
  }
  
  @Override
  public void visit(TernaryExprNode it) {
    it.condition.accept(this);
    block trueBlock = new block("ternary.true"), falseBlock = new block("ternary.false"), nextBlock = new block("ternary.end");
    currentBlock.next = new branch(it.condition.val, trueBlock, falseBlock);
    currentBlock = trueBlock;
    it.trueExpr.accept(this);
    String trueBlockName = currentBlock.name;
    currentBlock.next = new branch(null, nextBlock, null);
    currentBlock = falseBlock;
    it.falseExpr.accept(this);
    currentBlock.next = new branch(null, nextBlock, null);
    String falseBlockName = currentBlock.name;
    currentBlock = nextBlock;
    if (it.trueExpr.exprType.getTypename().equals("void")) {
      it.val = null;
    } else {
      register reg = new register(it.trueExpr.exprType);
      currentBlock.add(new phi(reg, it.trueExpr.val, it.falseExpr.val, trueBlockName, falseBlockName));
      it.val = reg;
    }
  }
  
  @Override
  public void visit(ThisExprNode it) {}
  
  @Override
  public void visit(AssignExprNode it) {
    it.lhs.accept(this);
    it.rhs.accept(this);
    currentBlock.add(new assign((register)it.lhs.val, it.rhs.val));
    it.val = it.rhs.val;
  }
  
  @Override
  public void visit(SuffixExprNode it) {
    it.primeExpr.accept(this);
    register reg = (register)it.primeExpr.val;
    Type nowType = it.primeExpr.exprType;
    boolean islvalue = it.primeExpr.needlvalue;
    for (SuffixContentNode suffixContent : it.suffixContent) {
      if (suffixContent.type == SuffixContentNode.SuffixType.ARRV) {
        if (islvalue) {
          register newreg = new register(nowType);
          currentBlock.add(new load(newreg, reg));
          reg = newreg;
        }
        ArrayList<Entity> index = new ArrayList<>();
        suffixContent.accept(this);
        index.add(suffixContent.expr.get(0).val);
        nowType = new Type(nowType.getfinaltype(), nowType.getDim() - 1);
        register newreg = new register("ptr");
        currentBlock.add(new getelementptr(nowType.ToIrType().equals("i1") ? "i8" : nowType.ToIrType(), newreg, reg, index));
        reg = newreg;
        islvalue = true;
      } else if (suffixContent.type == SuffixContentNode.SuffixType.FUNCC) {
        ArrayList<Entity> args = new ArrayList<>();
        for (ExprNode expr : suffixContent.expr) {
          expr.accept(this);
          args.add(expr.val);
        }
        if (reg != null) {
          if (islvalue) {
            register newreg = new register(nowType);
            currentBlock.add(new load(newreg, reg));
            reg = newreg;
          }
          args.add(reg);
        } else if (currentClass != null) {
          String[] tmp = nowType.funcname.split("\\.");
          int size = tmp.length;
          if (size > 1 && currentClass.name.equals(tmp[0]) && currentClass.CheckFunction(tmp[1])) {
            args.add(thisptr);
          }
        }
        if (nowType.ToIrType() != "void" ) {
          reg = new register(nowType.ToIrType());
        } else {
          reg = null;
        }
        currentBlock.add(new call(nowType.funcname, reg, nowType.ToIrType(), args));
        islvalue = false;
      } else if (suffixContent.type == SuffixContentNode.SuffixType.MEMBERV) {
        if (islvalue) {
          register newreg = new register(nowType);
          currentBlock.add(new load(newreg, reg));
          reg = newreg;
        }
        Class oldClass = currentClass;
        currentClass = gscope.classes.get(nowType.getTypename());
        register oldthisptr = thisptr;
        thisptr = reg;
        suffixContent.expr.get(0).needlvalue = true;
        suffixContent.accept(this);
        nowType = suffixContent.expr.get(0).exprType;
        // if (suffixContent.expr.get(0).exprType.isfunc) {
        //   String classname = nowType.getTypename();
        //   nowType = new Type(gscope.classes.get(classname).functions.get(id));
        //   nowType.funcname = gscope.classes.get(classname).functionrename.get(id);
        //   nowType.isfunc = true;
        // } else {
        //   String ptrType = gscope.IRclasses.get(it.exprType.getTypename());
        //   ArrayList<Entity> index = new ArrayList<>();
        //   index.add(new constant32(gscope.classes.get(nowType.getTypename()).memberoffset.get(id)));
        //   register newreg = new register(gscope.IRclasses.get(it.exprType.getTypename()));
        //   current_block.add(new getelementptr(ptrType, newreg, reg, index));
        //   reg = newreg;
        //   it.exprType = suffixContent.expr.get(0).exprType;
        // }
        if (suffixContent.expr.get(0).exprType.isfunc) {
          islvalue = false;
        } else {
          islvalue = true;
          reg = (register) suffixContent.expr.get(0).val;
        }
        currentClass = oldClass;
        thisptr = oldthisptr;
      }
    }
    if (!it.needlvalue && islvalue) {
      register tmpreg = new register(nowType);
      currentBlock.add(new load(tmpreg, reg));
      reg = tmpreg;
    }
    it.val = reg;
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
    currentBlock.add(new call("newarray", reg, "ptr", args));
    it.val = reg;
    for (ConstExprNode value : it.value) {
      value.accept(this);
    }
  }
}