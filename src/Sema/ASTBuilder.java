package Sema;

import AST.ASTNode;
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
import AST.Stmt.ExprStmtNode;
import AST.Stmt.ForStmtNode;
import AST.Stmt.FuncDefStmtNode;
import AST.Stmt.ReturnStmtNode;
import AST.Stmt.StmtNode;
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.WhileStmtNode;
import Parser.MxBaseVisitor;
import Parser.MxParser.ArrayConstContext;
import Parser.MxParser.ArrayContext;
import Parser.MxParser.ArrayInitializeContext;
import Parser.MxParser.AssignContext;
import Parser.MxParser.AssignExpContext;
import Parser.MxParser.BinaryExpContext;
import Parser.MxParser.BreakRuleContext;
import Parser.MxParser.BreakStmtContext;
import Parser.MxParser.ClassDefContext;
import Parser.MxParser.ClassDefStmtContext;
import Parser.MxParser.ClassInitializeContext;
import Parser.MxParser.ConditionContext;
import Parser.MxParser.ConditionStmtContext;
import Parser.MxParser.ConstTypeContext;
import Parser.MxParser.ConstructFuncDefContext;
import Parser.MxParser.ContinueRuleContext;
import Parser.MxParser.ContinueStmtContext;
import Parser.MxParser.EmptyStmtContext;
import Parser.MxParser.ExpressionStmtContext;
import Parser.MxParser.ForRuleContext;
import Parser.MxParser.ForStmtContext;
import Parser.MxParser.FstringContext;
import Parser.MxParser.FstringExpContext;
import Parser.MxParser.FuncDefContext;
import Parser.MxParser.NewexpContext;
import Parser.MxParser.ParenExpContext;
import Parser.MxParser.PrimaryContext;
import Parser.MxParser.PrimaryExpContext;
import Parser.MxParser.ProgramContext;
import Parser.MxParser.ReturnRuleContext;
import Parser.MxParser.ReturnStmtContext;
import Parser.MxParser.SuffixContext;
import Parser.MxParser.SuffixExpContext;
import Parser.MxParser.SuffixcontentContext;
import Parser.MxParser.SuiteContext;
import Parser.MxParser.SuiteStmtContext;
import Parser.MxParser.TernaryExpContext;
import Parser.MxParser.TypeContext;
import Parser.MxParser.UnaryExpContext;
import Parser.MxParser.VarDefContext;
import Parser.MxParser.VarDefStmtContext;
import Parser.MxParser.WhileRuleContext;
import Parser.MxParser.WhileStmtContext;
import Tools.Position;
import Tools.Type;
import Tools.globalscope;
import Tools.error.SyntaxError;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {
  private globalscope gscope;

  public ASTBuilder(globalscope gscope) {
    this.gscope = gscope;
  }

  @Override
  public ASTNode visitProgram(ProgramContext ctx) {
    RootNode root = new RootNode(new Position(ctx));
    for (FuncDefContext funcDefCtx : ctx.funcDef()) {
      FuncDefStmtNode funcDef = (FuncDefStmtNode) visit(funcDefCtx);
      if (gscope.CheckFunction(funcDef.funcName)) {
        throw new SyntaxError("Function " + funcDef.funcName + " already exists", funcDef.pos);
      }
      gscope.AddFunction(funcDef.funcName, null, funcDef.pos);
      root.AddFuncDef(funcDef);
    }
    for (ClassDefContext classDefCtx : ctx.classDef()) {
      ClassDefStmtNode classDef = (ClassDefStmtNode) visit(classDefCtx);
      if (gscope.CheckClass(classDef.classname)) {
        throw new SyntaxError("Class " + classDef.classname + " already exists", classDef.pos);
      }
      gscope.AddClass(classDef.classname, null, classDef.pos);
      root.AddClassDef(classDef);
    }
    for (VarDefContext varDefCtx : ctx.varDef()) {
      VarDefStmtNode varDef = (VarDefStmtNode) visit(varDefCtx);
      for (InitNode init : varDef.init) {
        if (gscope.CheckIdentifier(init.varname)) {
          throw new SyntaxError("Variable " + init.varname + " already exists", varDef.pos);
        }
        gscope.AddIdentifier(init.varname, null, varDef.pos);
      }
      root.AddVarDef(varDef);
    }

    return root;
  }

  @Override
  public ASTNode visitFuncDef(FuncDefContext ctx) {
    FuncDefStmtNode funcDef = new FuncDefStmtNode(new Position(ctx));
    funcDef.retType = ((TypeNode) visit(ctx.retType)).type;
    funcDef.funcName = ctx.funcName.getText();
    
    for(int i = 1; i < ctx.Identifier().size(); i++) {
      funcDef.Add(((TypeNode) visit(ctx.type(i))).type, ctx.Identifier(i).getText());
    }

    funcDef.body = (BlockStmtNode) visit(ctx.suite());
    return funcDef;
  }

  @Override
  public ASTNode visitArray(ArrayContext ctx) {
    return new ArrayNode(new Position(ctx), ctx.getText());
  }

  @Override
  public ASTNode visitVarDef(VarDefContext ctx) {
    VarDefStmtNode varDef = new VarDefStmtNode(new Position(ctx));
    varDef.type = ((TypeNode) visit(ctx.type())).type;
    ctx.assign().forEach(
      init -> varDef.AddInit((InitNode) visit(init))
    );
    return varDef;
  }

  @Override
  public ASTNode visitAssign(AssignContext ctx) {
    return new InitNode(new Position(ctx), ctx.Identifier().getText(), (ctx.expression() != null ? (ExprNode) visit(ctx.expression()) : null));
  }

  @Override
  public ASTNode visitPrimary(PrimaryContext ctx) {
    if (ctx.Identifier() != null) {
      return new IdentifierExprNode(new Position(ctx), ctx.Identifier().getText());
    } else if (ctx.constType() != null) {
      return visit(ctx.constType());
    } else if (ctx.This() != null) {
      return new ThisExprNode(new Position(ctx)); // Scope
    } else if (ctx.newexp() != null) {
      return visit(ctx.newexp());
    } else {
      throw new SyntaxError("Unknown primary expression", new Position(ctx));
    }
  }

  @Override
  public ASTNode visitConstType(ConstTypeContext ctx) {
    return new ConstExprNode(ctx);
  }

  @Override
  public ASTNode visitNewexp(NewexpContext ctx) {
    return new NewExprNode(null);
  }
  
  @Override
  public ASTNode visitPrimaryExp(PrimaryExpContext ctx) {
    return visit(ctx.primary());
  }

  @Override
  public ASTNode visitArrayConst(ArrayConstContext ctx) {
    return new ArrayConstExprNode(ctx);
  }

  @Override
  public ASTNode visitClassDef(ClassDefContext ctx) {
    ClassDefStmtNode classDef = new ClassDefStmtNode(new Position(ctx));
    classDef.classname = ctx.classname.getText();
    if (ctx.constructFuncDef().size() > 0) {
      if (ctx.constructFuncDef().size() > 1) {
        throw new SyntaxError("Multiple construct function definition", new Position(ctx));
      } else {
        classDef.constructfuncdef = (ConstructFuncDefStmtNode) visit(ctx.constructFuncDef(0));
      }
    }
    ctx.varDef().forEach(
      varDef -> classDef.AddVarDef((VarDefStmtNode) visit(varDef))
    );
    ctx.funcDef().forEach(
      funcDef -> classDef.AddFuncDef((FuncDefStmtNode) visit(funcDef))
    );
    
    return classDef;
  }

  @Override
  public ASTNode visitConstructFuncDef(ConstructFuncDefContext ctx) {
    ConstructFuncDefStmtNode constructFuncDef = new ConstructFuncDefStmtNode(new Position(ctx));
    constructFuncDef.classname = ctx.Identifier().getText();
    constructFuncDef.block = (BlockStmtNode)visit(ctx.suite());
    return constructFuncDef;
  }

  @Override
  public ASTNode visitArrayInitialize(ArrayInitializeContext ctx) {
    ArrayInitializeNode arrayInitialize = new ArrayInitializeNode(new Position(ctx));
    if (ctx.arrayConst() != null) {
      arrayInitialize.type = ((ArrayConstExprNode)visit(ctx.arrayConst())).type;
    } else {
      arrayInitialize.type = Type.GetArrayDefType(ctx.type().getText(), ctx.getText());
      ctx.expression().forEach(
        expression -> arrayInitialize.AddSize((ExprNode) visit(expression))
      );
    }
    return arrayInitialize;
  }

  @Override
  public ASTNode visitType(TypeContext ctx) {
    return new TypeNode(new Position(ctx), new Type(ctx.getText()));
  }

  @Override
  public ASTNode visitBinaryExp(BinaryExpContext ctx) {
    BinaryExprNode binaryExpr = new BinaryExprNode(new Position(ctx));
    binaryExpr.lhs = (ExprNode) visit(ctx.expression(0));
    binaryExpr.rhs = (ExprNode) visit(ctx.expression(1));
    if (ctx.And() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.AND; 
    } else if (ctx.BitAnd() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.BIT_AND;
    } else if (ctx.Or() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.OR;
    } else if (ctx.BitOr() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.BIT_OR;
    } else if (ctx.BitXor() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.BIT_XOR;
    } else if (ctx.Plus() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.ADD;
    } else if (ctx.Minus() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.SUB;
    } else if (ctx.Multi() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.MUL;
    } else if (ctx.Div() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.DIV;
    } else if (ctx.Mod() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.MOD;
    } else if (ctx.LeftShift() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.SHL;
    } else if (ctx.RightShift() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.SHR;
    } else if (ctx.Less() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.LT;
    } else if (ctx.Greater() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.GT;
    } else if (ctx.LessEqual() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.LE;
    } else if (ctx.GreaterEqual() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.GE;
    } else if (ctx.Equal() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.EQ;
    } else if (ctx.NotEqual() != null) {
      binaryExpr.op = BinaryExprNode.Opcode.NE;
    } else {
      throw new SyntaxError("Unknown binary expression", new Position(ctx));
    }
    return binaryExpr;
  }

  @Override
  public ASTNode visitAssignExp(AssignExpContext ctx) {
    AssignExprNode assignexpr = new AssignExprNode(new Position(ctx));
    assignexpr.lhs = (ExprNode) visit(ctx.expression(0));
    assignexpr.rhs = (ExprNode) visit(ctx.expression(1));
    return assignexpr;
  }

  @Override
  public ASTNode visitUnaryExp(UnaryExpContext ctx) {
    UnaryExprNode unaryExpr = new UnaryExprNode(new Position(ctx));
    unaryExpr.expr = (ExprNode) visit(ctx.expression());
    if (ctx.BitNot() != null) {
      unaryExpr.op = UnaryExprNode.Opcode.BIT_NOT;
    } else if (ctx.Not() != null) {
      unaryExpr.op = UnaryExprNode.Opcode.NOT;
    } else if (ctx.Minus() != null) {
      unaryExpr.op = UnaryExprNode.Opcode.NEG;
    } else if (ctx.Pre != null) {
      if (ctx.Inc() != null) {
        unaryExpr.op = UnaryExprNode.Opcode.PRE_INC;
      } else if (ctx.Dec() != null) {
        unaryExpr.op = UnaryExprNode.Opcode.PRE_DEC;
      }
    } else if (ctx.Suf != null) {
      if (ctx.Inc() != null) {
        unaryExpr.op = UnaryExprNode.Opcode.SUF_INC;
      } else if (ctx.Dec() != null) {
        unaryExpr.op = UnaryExprNode.Opcode.SUF_DEC;
      }
    } else {
      throw new SyntaxError("Unknown unary expression", new Position(ctx));
    }
    return unaryExpr;
  }

  @Override
  public ASTNode visitParenExp(ParenExpContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public ASTNode visitSuffix(SuffixContext ctx) {
    SuffixExprNode suffixExpr = new SuffixExprNode(new Position(ctx));
    suffixExpr.primeExpr = (PrimeExprNode) visit(ctx.primary());
    ctx.suffixcontent().forEach(
      content -> suffixExpr.AddSuffix((SuffixContentNode) visit(content))
    );
    return suffixExpr;
  }

  @Override
  public ASTNode visitBreakRule(BreakRuleContext ctx) {
    return new BreakStmtNode(new Position(ctx));
  }

  @Override
  public ASTNode visitCondition(ConditionContext ctx) {
    ConditionStmtNode conditionStmt = new ConditionStmtNode(new Position(ctx));
    conditionStmt.condition = (ExprNode) visit(ctx.expression());
    conditionStmt.trueStmt = (StmtNode) visit(ctx.trueStmt);
    if (ctx.falseStmt != null) {
      conditionStmt.falseStmt = (StmtNode) visit(ctx.falseStmt);
    }
    return conditionStmt;
  }

  @Override
  public ASTNode visitContinueRule(ContinueRuleContext ctx) {
    return new ConditionStmtNode(new Position(ctx));
  }

  @Override
  public ASTNode visitReturnRule(ReturnRuleContext ctx) {
    return new ReturnStmtNode(new Position(ctx), (ExprNode) visit(ctx.expression()));
  }

  @Override
  public ASTNode visitSuffixExp(SuffixExpContext ctx) {
    return visit(ctx.suffix());
  }

  @Override
  public ASTNode visitClassInitialize(ClassInitializeContext ctx) {
    ClassInitializeNode classInitialize = new ClassInitializeNode(new Position(ctx));
    classInitialize.classname = ctx.Identifier().getText();
    return super.visitClassInitialize(ctx);
  }

  @Override
  public ASTNode visitForRule(ForRuleContext ctx) {
    ForStmtNode forStmt = new ForStmtNode(new Position(ctx));
    if (ctx.initExpr != null) {
      forStmt.init = (ExprNode) visit(ctx.initExpr);
    } else if (ctx.condExpr != null) {
      forStmt.cond = (ExprNode) visit(ctx.condExpr);
    } else if (ctx.stepExpr != null) {
      forStmt.step = (ExprNode) visit(ctx.stepExpr);
    }
    forStmt.body = (StmtNode) visit(ctx.statement());

    return forStmt;
  }

  public ASTNode visitWhileRule(WhileRuleContext ctx) {
    WhileStmtNode whileStmt = new WhileStmtNode(new Position(ctx));
    whileStmt.condition = (ExprNode) visit(ctx.expression());
    whileStmt.stmt = (StmtNode) visit(ctx.statement());
    return whileStmt;
  }

  @Override
  public ASTNode visitBreakStmt(BreakStmtContext ctx) {
    return visitBreakRule(ctx.breakRule());
  }

  @Override
  public ASTNode visitReturnStmt(ReturnStmtContext ctx) {
    return visitReturnRule(ctx.returnRule());
  }

  @Override
  public ASTNode visitClassDefStmt(ClassDefStmtContext ctx) {
    return visitClassDef(ctx.classDef());
  }

  @Override
  public ASTNode visitConditionStmt(ConditionStmtContext ctx) {
    return visitCondition(ctx.condition());
  }

  @Override
  public ASTNode visitContinueStmt(ContinueStmtContext ctx) {
    return visitContinueRule(ctx.continueRule());
  }

  @Override
  public ASTNode visitEmptyStmt(EmptyStmtContext ctx) {
    return null;
  }
  
  @Override
  public ASTNode visitExpressionStmt(ExpressionStmtContext ctx) {
    return new ExprStmtNode(new Position(ctx), (ExprNode) visit(ctx.expression()));
  }

  @Override
  public ASTNode visitSuiteStmt(SuiteStmtContext ctx) {
    return visit(ctx.suite());
  }

  @Override
  public ASTNode visitSuite(SuiteContext ctx) {
    BlockStmtNode block = new BlockStmtNode(new Position(ctx));
    ctx.statement().forEach(
      statement -> block.Add((StmtNode) visit(statement))
    );
    return block;
  }

  @Override
  public ASTNode visitForStmt(ForStmtContext ctx) {
    return visit(ctx.forRule());
  }

  @Override
  public ASTNode visitWhileStmt(WhileStmtContext ctx) {
    return visit(ctx.whileRule());
  }

  @Override
  public ASTNode visitTernaryExp(TernaryExpContext ctx) {
    TernaryExprNode ternaryExpr = new TernaryExprNode(new Position(ctx));
    ternaryExpr.condition = (ExprNode) visit(ctx.expression(0));
    ternaryExpr.trueExpr = (ExprNode) visit(ctx.expression(1));
    ternaryExpr.falseExpr = (ExprNode) visit(ctx.expression(2));
    return ternaryExpr;
  }

  @Override
  public ASTNode visitVarDefStmt(VarDefStmtContext ctx) {
    return visit(ctx.varDef());
  }

  @Override
  public ASTNode visitFstringExp(FstringExpContext ctx) {
    return visit(ctx.fstring());
  }

  @Override
  public ASTNode visitFstring(FstringContext ctx) {
    FstringExprNode fstringExpr = new FstringExprNode(new Position(ctx));
    ctx.expression().forEach(
      expression -> fstringExpr.AddExpr((ExprNode) visit(expression))
    );
    fstringExpr.AddString(ctx.FstringHead().getText());
    ctx.FstringBody().forEach(
      body -> fstringExpr.AddString(body.getText())
    );
    fstringExpr.AddString(ctx.FstringTail().getText());
    return fstringExpr;
  }

  @Override
  public ASTNode visitSuffixcontent(SuffixcontentContext ctx) {
    SuffixContentNode suffixContent = new SuffixContentNode(new Position(ctx));
    if (ctx.LeftBracket() != null) {
      suffixContent.type = SuffixContentNode.SuffixType.ARRV;
      suffixContent.add((ExprNode) visit(ctx.expression(0)));
    } else if (ctx.LeftParen() != null) {
      suffixContent.type = SuffixContentNode.SuffixType.FUNCC;
      if (ctx.expression().size() > 0) {
        ctx.expression().forEach(
          expression -> suffixContent.add((ExprNode) visit(expression))
        );
      } else {
        suffixContent.expr = null;
      }
    } else if (ctx.Dot() != null) {
      suffixContent.type = SuffixContentNode.SuffixType.MEMBERV;
      suffixContent.add((ExprNode) visit(ctx.Identifier()));
    }
    return suffixContent;
  }

}