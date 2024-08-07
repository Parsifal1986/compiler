package AST;

import Tools.Position;

public class IdentifierExprNode extends ExprNode {
  public IdentifierExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
