package AST;

import Tools.Position;

public class SuffixExprNode extends ExprNode {
  PrimeExprNode primeExpr;
  SuffixType type;
  ExprNode expr;

  public SuffixExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public enum SuffixType {
    ARRV, FUNCC, MEMBERV;
  }
}
