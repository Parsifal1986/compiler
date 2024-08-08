package AST;

import Tools.Position;

public class TernaryExprNode extends ExprNode {
  public ExprNode condition;
  public ExprNode trueExpr;
  public ExprNode falseExpr;
  
  public TernaryExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
