package AST;

import Tools.Position;

public class UnaryExprNode extends ExprNode {
  public UnaryExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
