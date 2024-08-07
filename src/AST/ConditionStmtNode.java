package AST;

import Tools.Position;

public class ConditionStmtNode extends StmtNode {
  ExprNode condition;
  StmtNode trueStmt;
  StmtNode falseStmt;

  public ConditionStmtNode(ExprNode condition, Position pos, StmtNode trueStmt, StmtNode falseStmt) {
    super(pos);
    this.condition = condition;
    this.trueStmt = trueStmt;
    this.falseStmt = falseStmt;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
