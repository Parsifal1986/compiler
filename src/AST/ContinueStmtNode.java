package AST;

import Tools.Position;

public class ContinueStmtNode extends StmtNode {
  public ContinueStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}