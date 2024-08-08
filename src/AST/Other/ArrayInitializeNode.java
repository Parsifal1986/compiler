package AST.Other;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Expr.ArrayConstExprNode;
import AST.Expr.ExprNode;
import Tools.Position;
import Tools.Type;

public class ArrayInitializeNode extends ASTNode {
  public Type type;
  ArrayConstExprNode expr;
  ArrayList<ExprNode> size;

  public ArrayInitializeNode(Position pos) {
    super(pos);
    size = new ArrayList<ExprNode>();
  }

  public void AddSize(ExprNode size) {
    this.size.add(size);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
