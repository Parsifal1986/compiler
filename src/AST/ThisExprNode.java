package AST;

import Tools.Position;

public class ThisExprNode extends ExprNode {
  public ThisExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
