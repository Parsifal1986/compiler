package AST.Expr;

import AST.ASTVisitor;
import Tools.Position;
import Tools.Type;

public class BinaryExprNode extends ExprNode {
  public ExprNode lhs, rhs;
  public Opcode op;

  public BinaryExprNode(Position pos) {
    super(pos);
    exprType = new Type("bool", 0);
    islvalue = false;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public enum Opcode {
    MUL, DIV, MOD, ADD, SUB, SHL, SHR, LT, GT, LE, GE, EQ, NE, BIT_AND, BIT_XOR, BIT_OR, AND, OR
  }
}
