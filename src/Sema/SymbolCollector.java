package Sema;

import AST.ASTVisitor;
import AST.Expr.ArrayConstExprNode;
import AST.Expr.AssignExprNode;
import AST.Expr.BinaryExprNode;
import AST.Expr.ConstExprNode;
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
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.WhileStmtNode;
import Tools.globalscope;
import Tools.error.SyntaxError;
import Tools.Class;

public class SymbolCollector implements ASTVisitor {
  globalscope gscope;

  public SymbolCollector(globalscope gscope) {
    this.gscope = gscope;
  }

  @Override
  public void visit(RootNode it) {
    for (VarDefStmtNode vardefs : it.vardefs) {
      if (gscope.CheckClass(vardefs.type.getTypename())) {
        for (InitNode init : vardefs.init) {
          gscope.ReplaceIdentifier(init.varname, vardefs.type);
        }
      } else {
        throw new SyntaxError("Error: Undefined class " + vardefs.type.getTypename(), vardefs.pos);
      }
    }
    for (FuncDefStmtNode funcdefs : it.funcdefs) {
      if (funcdefs.retType.getTypename() == "void" || gscope.CheckClass(funcdefs.retType.getTypename())) {
        gscope.ReplaceFunction(funcdefs.funcName, funcdefs.retType);
      } else {
        throw new SyntaxError("Error: Function return an undefined type", funcdefs.pos);
      }
    }
    for (ClassDefStmtNode classdefs : it.classdefs) {
      Class classdef = new Class();
      for (VarDefStmtNode vardefs : classdefs.vardefs) {
        if (gscope.CheckClass(vardefs.type.getTypename())) {
          for (InitNode init : vardefs.init) {
            classdef.AddMember(init.varname, vardefs.type, vardefs.pos);
          }
        } else {
          throw new SyntaxError("Error: Undefined class " + vardefs.type.getTypename(), vardefs.pos);
        }
      }
      for (FuncDefStmtNode funcdefs : classdefs.funcdefs) {
        if (funcdefs.retType.getTypename() == "void" || gscope.CheckClass(funcdefs.retType.getTypename())) {
          classdef.AddFunction(funcdefs.funcName, funcdefs.retType, funcdefs.pos);
        } else {
          throw new SyntaxError("Error: Function return an undefined type", funcdefs.pos);
        }
      }
      gscope.ReplaceClass(classdefs.classname, classdef);
    }
  }
  
  @Override
  public void visit(TypeNode it) {}

  @Override
  public void visit(ArrayInitializeNode it) {}

  @Override
  public void visit(ClassInitializeNode it) {}

  @Override
  public void visit(SuffixContentNode it) {}

  @Override
  public void visit(InitNode it) {}

  @Override
  public void visit(ArrayNode it) {}

  @Override
  public void visit(BlockStmtNode it) {}
  
  @Override
  public void visit(WhileStmtNode it) {}
  
  @Override
  public void visit(ConditionStmtNode it) {}
  
  @Override
  public void visit(ContinueStmtNode it) {}
  
  @Override
  public void visit(VarDefStmtNode it) {}
  
  @Override
  public void visit(ExprStmtNode it) {}
  
  @Override
  public void visit(ClassDefStmtNode it) {}
  
  @Override
  public void visit(FuncDefStmtNode it) {}
  
  @Override
  public void visit(ReturnStmtNode it) {}
  
  @Override
  public void visit(BreakStmtNode it) {}
  
  @Override
  public void visit(ForStmtNode it) {}
  
  @Override
  public void visit(ConstructFuncDefStmtNode it) {}


  @Override
  public void visit(ConstExprNode it) {}
  
  @Override
  public void visit(IdentifierExprNode it) {}
  
  @Override
  public void visit(FstringExprNode it) {}
  
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

