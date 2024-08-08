package AST;

import Tools.Position;

public class WhileStmtNode extends StmtNode {
  public ExprNode condition;
  public StmtNode stmt;
  
  public WhileStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}