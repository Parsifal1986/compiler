package AST;

import Tools.Position;

public class JumpStmtNode extends StmtNode {
  public JumpStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}