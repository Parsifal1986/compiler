package AST;

import java.util.ArrayList;

import Tools.Position;
import Tools.Type;

public class ArrayInitializeNode extends ASTNode {
  public Type type;
  ArrayConstExprNode expr;
  ArrayList<ExprNode> size;

  public ArrayInitializeNode(Position pos) {
    super(pos);
  }

  public void AddSize(ExprNode size) {
    this.size.add(size);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
