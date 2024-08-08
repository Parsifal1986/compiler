package AST;

import Tools.Position;

public class AssignExprNode extends ExprNode {
  public ExprNode lhs;
  public ExprNode rhs;

  public AssignExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
