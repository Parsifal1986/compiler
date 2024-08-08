package AST;

import Tools.Position;

public class ClassInitializeNode extends StmtNode {
  public String classname;

  public ClassInitializeNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
