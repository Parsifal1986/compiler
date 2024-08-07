package AST;

import Tools.Position;

abstract public class ExprNode extends ASTNode {
  public Type type;
  public Entity val;

  public ExprNode(Position pos) {
    super(pos);
  }
}
