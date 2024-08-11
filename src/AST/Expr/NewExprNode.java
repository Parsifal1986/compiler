package AST.Expr;

import AST.ASTVisitor;
import AST.Other.ArrayInitializeNode;
import AST.Other.ClassInitializeNode;
import Tools.Position;

public class NewExprNode extends ExprNode {
  public ArrayInitializeNode arrayInitialize;
  public ClassInitializeNode classInitialize;
  public NewExprNode(Position pos) {
    super(pos);
    islvalue = false;
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
