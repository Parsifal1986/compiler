package AST.Expr;

import java.util.ArrayList;

import AST.ASTVisitor;
import Tools.Position;
import Tools.Type;

public class FstringExprNode extends ExprNode {
  public ArrayList<String> strings;
  public ArrayList<ExprNode> exprs;

  public FstringExprNode(Position pos) {
    super(pos);
    strings = new ArrayList<String>();
    exprs = new ArrayList<ExprNode>();
    exprType = new Type("String", 0);
    islvalue = false;
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
