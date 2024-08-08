package AST;

import java.util.ArrayList;

import Tools.Position;

public class SuffixContentNode extends ASTNode {
  public SuffixType type;
  public ArrayList<ExprNode> expr;

  public SuffixContentNode(Position pos) {
    super(pos);
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
