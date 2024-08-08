package AST;

import java.util.ArrayList;

import Tools.Position;

public class FstringExprNode extends ExprNode {
  ArrayList<String> strings;
  ArrayList<ExprNode> exprs;

  public FstringExprNode(Position pos) {
    super(pos);
  }

  public void AddString(String str) {
    strings.add(str);
  }

  public void AddExpr(ExprNode expr) {
    exprs.add(expr);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
