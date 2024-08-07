package AST;

import Tools.Position;

public class FstringExprNode extends ExprNode {
  

  public FstringExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
