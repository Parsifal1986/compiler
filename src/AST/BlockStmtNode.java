package AST;

import java.util.ArrayList;

import Tools.Position;

public class BlockStmtNode extends StmtNode {
  public ArrayList<StmtNode> stmts;

  public BlockStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
  
}
