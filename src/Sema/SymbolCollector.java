package Sema;

import java.util.ArrayList;

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
import AST.Stmt.VarDefStmtNode;
import AST.Stmt.WhileStmtNode;
import Tools.globalscope;
import Tools.error.SyntaxError;
import Tools.Class;
import Tools.Type;

public class SymbolCollector implements ASTVisitor {
  globalscope gscope;

  public SymbolCollector(globalscope gscope) {
    this.gscope = gscope;
  }

  @Override
  public void visit(RootNode it) {
    for (DeclarationNode decl : it.declarations) {
      decl.accept(this);
    }
    if (!gscope.CheckFunction("main")) {
      throw new SyntaxError("Error: Main function not found", it.pos);
    } else if (!gscope.GetFunctionRetType("main").getTypename().equals("int")) {
      throw new SyntaxError("Error: Main function should return int", it.pos);
    }
  }

  @Override
  public void visit(DeclarationNode it) {
    if (it.funcDef != null) {
      if (gscope.CheckClass(it.funcDef.funcName) || gscope.CheckIdentifier(it.funcDef.funcName)) {
        throw new SyntaxError("Multiple Definitions", it.funcDef.pos);
      }
      it.funcDef.accept(this);
      if (it.funcDef.retType.getTypename().equals("void") || gscope.CheckClass(it.funcDef.retType.getTypename())) {
        ArrayList<Type> funcparams = new ArrayList<Type>();
        for (FuncDefStmtNode.ParameterList parameters : it.funcDef.parameters) {
          funcparams.add(parameters.type);
        }
        gscope.ReplaceFunction(it.funcDef.funcName, it.funcDef.retType, funcparams);
      } else {
        // throw new SyntaxError("Error: Function return an undefined type", it.funcDef.pos);
        throw new SyntaxError("Undefined Identifier", it.funcDef.pos);
      }
    } else if (it.classDef != null) {
      it.classDef.accept(this);
      Class classdef = new Class();
      classdef.name = it.classDef.classname;
      for (VarDefStmtNode vardefs : it.classDef.vardefs) {
        if (gscope.CheckClass(vardefs.type.getfinaltype())) {
          for (InitNode init : vardefs.init) {
            classdef.AddMember(init.varname, vardefs.type, vardefs.pos);
          }
        } else {
          // throw new SyntaxError("Error: Undefined class " + vardefs.type.getTypename(), vardefs.pos);
          throw new SyntaxError("Undefined Identifier", vardefs.pos);
        }
      }
      for (FuncDefStmtNode funcdefs : it.classDef.funcdefs) {
        if (funcdefs.retType.getfinaltype().equals("void") || gscope.CheckClass(funcdefs.retType.getfinaltype())) {
          ArrayList<Type> funcparams = new ArrayList<Type>();
          for (FuncDefStmtNode.ParameterList parameters : funcdefs.parameters) {
            funcparams.add(parameters.type);
          }
          classdef.AddFunction(funcdefs.funcName, funcdefs.retType, funcdefs.pos, funcparams);
        } else {
          // throw new SyntaxError("Error: Function return an undefined type", funcdefs.pos);
          throw new SyntaxError("Undefined Identifier", funcdefs.pos);
        }
      }
      gscope.ReplaceClass(it.classDef.classname, classdef);
    } else if (it.varDef != null) {
      // it.varDef.accept(this);
      // if (gscope.CheckClass(it.varDef.type.getTypename())) {
      //   for (InitNode init : it.varDef.init) {
      //     gscope.ReplaceIdentifier(init.varname, it.varDef.type);
      //   }
      // } else {
      //   throw new SyntaxError("Error: Undefined class " + it.varDef.type.getTypename(), it.varDef.pos);
      // }
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

  @Override
  public void visit(EmptyStmtNode it) {}
}

