package AST.Expr;

import java.util.ArrayList;

import AST.ASTVisitor;
import Parser.MxParser.ArrayConstContext;
import Tools.Position;
import Tools.Type;

public class ArrayConstExprNode extends ExprNode {
  public ArrayList<ConstExprNode> value;
  public ArrayConstExprNode(Position pos) {
    super(pos);
  }

  public ArrayConstExprNode(ArrayConstContext ctx) {
    super(new Position(ctx));
    exprType = Type.GetArrayConstType(ctx);
    value = new ArrayList<ConstExprNode>();
    islvalue = false;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

}
