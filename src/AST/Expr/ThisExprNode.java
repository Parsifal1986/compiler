package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class ThisExprNode extends ExprNode {
  public ThisExprNode(Position pos) {
    super(pos);
    islvalue = false;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
