package AST.Stmt;

import java.util.ArrayList;

import AST.ASTVisitor;
import AST.Other.InitNode;
import Tools.Position;
import Tools.Type;

public class VarDefStmtNode extends StmtNode {
  public Type type;
  public ArrayList<InitNode> init;

  public VarDefStmtNode(Position pos) {
    super(pos);
    init = new ArrayList<InitNode>();
  }

  public void AddInit(InitNode init) {
    this.init.add(init);
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
