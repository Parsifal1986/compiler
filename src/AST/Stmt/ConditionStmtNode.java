package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Tools.Position;

public class ConditionStmtNode extends StmtNode {
  public ExprNode condition;
  public StmtNode trueStmt;
  public StmtNode falseStmt;

  public ConditionStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
