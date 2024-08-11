package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class PrimeExprNode extends ExprNode {
  public NewExprNode newExpr;
  public IdentifierExprNode identifierExpr;
  public ConstExprNode constExpr;
  public ThisExprNode thisExpr;
  public ExprNode parenExpr;
  
  public PrimeExprNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
