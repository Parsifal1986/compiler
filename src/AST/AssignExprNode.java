package AST;

import Tools.Position;

public class AssignExprNode extends ExprNode {
  ExprNode lhs, rhs;

  public AssignExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
