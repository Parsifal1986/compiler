package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class ThisExprNode extends PrimeExprNode {
  public ThisExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
