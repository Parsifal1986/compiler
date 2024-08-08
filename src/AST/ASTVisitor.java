package AST;

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

public interface ASTVisitor {

  void visit(RootNode it);
  void visit(TypeNode it);
  void visit(ArrayInitializeNode it);
  void visit(ClassInitializeNode it);
  void visit(SuffixContentNode it);
  void visit(InitNode it);
  void visit(ArrayNode it);

  void visit(BlockStmtNode it);
  void visit(WhileStmtNode it);
  void visit(ConditionStmtNode it);
  void visit(ContinueStmtNode it);
  void visit(VarDefStmtNode it);
  void visit(ExprStmtNode it);
  void visit(ClassDefStmtNode it);
  void visit(FuncDefStmtNode it);
  void visit(ReturnStmtNode it);
  void visit(BreakStmtNode it);
  void visit(ForStmtNode it);
  void visit(ConstructFuncDefStmtNode it);

  void visit(ConstExprNode it);
  void visit(IdentifierExprNode it);
  void visit(FstringExprNode it);
  void visit(NewExprNode it);
  void visit(UnaryExprNode it);
  void visit(BinaryExprNode it);
  void visit(TernaryExprNode it);
  void visit(ThisExprNode it);
  void visit(AssignExprNode it);
  void visit(SuffixExprNode it);
  void visit(PrimeExprNode it);
  void visit(ArrayConstExprNode it);

}