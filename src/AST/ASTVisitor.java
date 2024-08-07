package AST;

public interface ASTVisitor {

  void visit(RootNode it);

  void visit(BlockStmtNode it);
  void visit(JumpStmtNode it);
  void visit(ConditionStmtNode it);
  void visit(LoopStmtNode it);
  void visit(VarDefStmtNode it);
  void visit(ExprStmtNode it);
  void visit(ClassDefStmtNode it);
  void visit(FuncDefStmtNode it);

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

}