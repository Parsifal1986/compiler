package AST;

import Tools.Position;
import Tools.Type;

public class VarDefStmtNode extends StmtNode {
  public Type type;
  public String name;
  public ExprNode init;

  public VarDefStmtNode(Position pos) {
    super(pos);
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
