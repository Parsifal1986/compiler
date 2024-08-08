package AST;

import Parser.MxParser.ArrayConstContext;
import Tools.Position;
import Tools.Type;

public class ArrayConstExprNode extends ExprNode {
  public ArrayConstExprNode(Position pos) {
    super(pos);
  }

  public ArrayConstExprNode(ArrayConstContext ctx) {
    super(new Position(ctx));
    type = Type.GetArrayConstType(ctx);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
