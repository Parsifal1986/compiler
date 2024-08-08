package AST.Stmt;

import AST.ASTNode;
import Tools.Position;

abstract public class StmtNode extends ASTNode {
  public StmtNode(Position pos) {
    super(pos);
  }
}
