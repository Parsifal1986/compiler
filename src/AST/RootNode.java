package AST;

import Tools.Position;

public class RootNode extends ASTNode {
  public RootNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}
