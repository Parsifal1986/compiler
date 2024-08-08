package AST;

import java.util.ArrayList;

import Tools.Position;

public class SuffixExprNode extends ExprNode {
  public PrimeExprNode primeExpr;
  public ArrayList<SuffixContentNode> suffixContent;

  public SuffixExprNode(Position pos) {
    super(pos);
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public void AddSuffix(SuffixContentNode suffixContentNode) {
    this.suffixContent.add(suffixContentNode);
  }
}
