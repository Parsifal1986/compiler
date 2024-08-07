package AST;

import Tools.Position;

public class PrimeExprNode extends ExprNode {
  public PrimeExprNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
