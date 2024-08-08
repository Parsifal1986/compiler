package AST.Stmt;

import java.util.ArrayList;

import AST.ASTVisitor;
import Tools.Position;

public class BlockStmtNode extends StmtNode {
  public ArrayList<StmtNode> stmts;

  public BlockStmtNode(Position pos) {
    super(pos);
    stmts = new ArrayList<StmtNode>();
  }

  public void Add(StmtNode stmt) {
    stmts.add(stmt);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
  
}
