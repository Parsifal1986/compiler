package AST;

import Tools.Position;

public class ForStmtNode extends StmtNode {
  public ExprNode init, cond, step;
  public StmtNode body;

  public ForStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}