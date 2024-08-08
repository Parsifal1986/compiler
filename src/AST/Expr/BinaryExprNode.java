package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;

public class BinaryExprNode extends ExprNode {
  public ExprNode lhs, rhs;
  public Opcode op;

  public BinaryExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public enum Opcode {
    MUL, DIV, MOD, ADD, SUB, SHL, SHR, LT, GT, LE, GE, EQ, NE, BIT_AND, BIT_XOR, BIT_OR, AND, OR
  }
}
