package AST;

import Tools.Position;
import Tools.Type;

public class IdentifierExprNode extends PrimeExprNode {
  public IdentifierExprNode(Position pos) {
    super(pos);
  }

  public IdentifierExprNode(Position pos, String text) {
    super(pos);
    type = Type.GetType(text);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
