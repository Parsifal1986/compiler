package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class IdentifierExprNode extends ExprNode {
  public String Id;
  public IdentifierExprNode(Position pos) {
    super(pos);
  }

  public IdentifierExprNode(Position pos, String text) {
    super(pos);
    Id = text;
    islvalue = true;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
