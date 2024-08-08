package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class UnaryExprNode extends ExprNode {
  public ExprNode expr;
  public Opcode op;
  public UnaryExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public enum Opcode {
    NEG, BIT_NOT, NOT, PRE_INC, PRE_DEC, SUF_INC, SUF_DEC
  }
}
