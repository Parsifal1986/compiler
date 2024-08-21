package AST.Stmt;

import AST.ASTVisitor;
import Tools.Position;
import Tools.IRsema.register;

public class ConstructFuncDefStmtNode extends StmtNode {
  public String classname;
  public BlockStmtNode block;
  public register Thisorigin;
  public register Thisaddr;

  public ConstructFuncDefStmtNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
