package AST;

public interface ASTVisitor {

  void visit(RootNode it);
  void visit(TypeNode it);
  void visit(ArrayInitializeNode it);
  void visit(ClassInitializeNode it);
  void visit(SuffixContentNode it);

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