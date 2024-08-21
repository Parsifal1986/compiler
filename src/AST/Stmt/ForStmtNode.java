package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Tools.Position;

public class ForStmtNode extends StmtNode {
  public StmtNode init;
  public ExprNode cond, step;
  public StmtNode body;

  public ForStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}