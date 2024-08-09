package AST.Expr;

import java.util.ArrayList;

import AST.ASTVisitor;
import Tools.Position;

public class FstringExprNode extends ExprNode {
  public ArrayList<String> strings;
  public ArrayList<ExprNode> exprs;

  public FstringExprNode(Position pos) {
    super(pos);
    strings = new ArrayList<String>();
    exprs = new ArrayList<ExprNode>();
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
