package AST.Other;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Tools.Position;

public class SuffixContentNode extends ASTNode {
  public SuffixType type;
  public ArrayList<ExprNode> expr;

  public SuffixContentNode(Position pos) {
    super(pos);
    expr = new ArrayList<ExprNode>();
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public void add(ExprNode expr) {
    this.expr.add(expr);
  }

  public enum SuffixType {
    ARRV, FUNCC, MEMBERV;
  }
}
