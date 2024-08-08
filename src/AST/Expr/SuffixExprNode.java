package AST.Expr;

import java.util.ArrayList;

import AST.ASTVisitor;
import AST.Other.SuffixContentNode;
import Tools.Position;

public class SuffixExprNode extends ExprNode {
  public PrimeExprNode primeExpr;
  public ArrayList<SuffixContentNode> suffixContent;

  public SuffixExprNode(Position pos) {
    super(pos);
    suffixContent = new ArrayList<SuffixContentNode>();
  }

  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public void AddSuffix(SuffixContentNode suffixContentNode) {
    this.suffixContent.add(suffixContentNode);
  }
}
