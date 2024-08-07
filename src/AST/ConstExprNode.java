package AST;

import Tools.Position;

public class ConstExprNode extends ExprNode {
  public ConstExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
