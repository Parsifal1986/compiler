package AST.Expr;

import java.util.ArrayList;

import AST.ASTVisitor;
import Parser.MxParser.ArrayConstContext;
import Tools.Position;
import Tools.Type;

public class ArrayConstExprNode extends ExprNode {
  public ArrayList<ExprNode> value;
  public ArrayConstExprNode(Position pos) {
    super(pos);
  }

  public ArrayConstExprNode(ArrayConstContext ctx) {
    super(new Position(ctx));
    type = Type.GetArrayConstType(ctx);
    value = new ArrayList<ExprNode>();
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
