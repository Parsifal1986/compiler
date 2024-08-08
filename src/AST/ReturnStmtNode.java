package AST;

import Tools.Position;

public class ReturnStmtNode extends StmtNode {
  ExprNode expr;

  public ReturnStmtNode(Position pos, ExprNode expr) {
    super(pos);
    this.expr = expr;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
