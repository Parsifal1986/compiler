package AST;

import Tools.Position;

public class VarDefStmtNode extends StmtNode {
  public VarDefStmtNode(Position pos) {
    super(pos);
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
