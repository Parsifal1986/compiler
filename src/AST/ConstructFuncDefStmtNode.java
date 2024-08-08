package AST;

import Tools.Position;

public class ConstructFuncDefStmtNode extends StmtNode {
  public String classname;
  public BlockStmtNode block;

  public ConstructFuncDefStmtNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
