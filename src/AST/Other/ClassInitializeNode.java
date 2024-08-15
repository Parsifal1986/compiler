package AST.Other;

import AST.ASTNode;
import AST.ASTVisitor;
import Tools.Entity;
import Tools.Position;

public class ClassInitializeNode extends ASTNode {
  public String classname;
  public Entity val;

  public ClassInitializeNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
