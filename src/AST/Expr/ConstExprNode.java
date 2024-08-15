package AST.Expr;

import AST.ASTVisitor;
import Parser.MxParser.ConstTypeContext;
import Tools.Position;
import Tools.Type;

public class ConstExprNode extends ExprNode {
  public ConstTypeContext ctx;
  public ArrayConstExprNode arrayConstExprNode;

  public ConstExprNode(Position pos) {
    super(pos);
  }

  public ConstExprNode(ConstTypeContext ctx) {
    super(new Position(ctx));
    exprType = Type.GetType(ctx);
    islvalue = false;
    this.ctx = ctx;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
