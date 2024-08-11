package AST.Expr;

import AST.ASTVisitor;
import Parser.MxParser.ConstTypeContext;
import Tools.Position;
import Tools.Type;

public class ConstExprNode extends ExprNode {
  public ConstExprNode(Position pos) {
    super(pos);
  }

  public ConstExprNode(ConstTypeContext ctx) {
    super(new Position(ctx));
    exprType = Type.GetType(ctx);
    islvalue = false;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
