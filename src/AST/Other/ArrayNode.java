package AST.Other;

import AST.ASTNode;
import AST.ASTVisitor;
import Tools.Position;
import Tools.Type;

public class ArrayNode extends ASTNode {
  public Type type;

  public ArrayNode(Position pos, String type) {
    super(pos);
    this.type = new Type(type);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
