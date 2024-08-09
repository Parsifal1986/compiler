package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Tools.Position;

public class ReturnStmtNode extends StmtNode {
  public ExprNode expr;

  public ReturnStmtNode(Position pos, ExprNode expr) {
    super(pos);
    this.expr = expr;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
