package AST;

import Tools.Position;

public class TernaryExprNode extends ExprNode {
  public TernaryExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
