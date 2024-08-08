package AST;

import Tools.Position;

public class NewExprNode extends PrimeExprNode {
  public NewExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
