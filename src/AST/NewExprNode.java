package AST;

import Tools.Position;

public class NewExprNode extends ExprNode {
  public NewExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
