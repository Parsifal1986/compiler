package AST;

import Tools.Position;

public class ExprStmtNode extends StmtNode {
  public ExprNode expr;

  public ExprStmtNode(Position pos, ExprNode expr) {
    super(pos);
    this.expr = expr;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
