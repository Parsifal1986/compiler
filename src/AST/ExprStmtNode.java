package AST;

import Tools.Position;

public class ExprStmtNode extends StmtNode {
  public ExprNode expr;

  public ExprStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
