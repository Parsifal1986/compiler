package AST;

import Tools.Type;
import Tools.Position;

public class TypeNode extends ASTNode {
  public Type type;

  public TypeNode(Position pos, Type type) {
    super(pos);
    this.type = type;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
