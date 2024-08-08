package AST;

import Tools.Position;
import Tools.Type;
import Tools.Entity;

abstract public class ExprNode extends ASTNode {
  public Type type;
  public Entity val;

  public ExprNode(Position pos) {
    super(pos);
  }

  public ExprNode(Position pos, Type type) {
    super(pos);
    this.type = type;
  }
}
