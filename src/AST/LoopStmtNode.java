package AST;

import Tools.Position;

public class LoopStmtNode extends StmtNode {
  public LoopStmtNode(Position pos) {
    super(pos);
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
