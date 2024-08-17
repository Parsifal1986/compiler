package AST.Other;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Tools.Position;
import Tools.IRsema.register;

public class InitNode extends ASTNode {
  public String varname;
  public ExprNode expr;
  public register val;

  public InitNode(Position pos, String varname, ExprNode expr) {
    super(pos);
    this.varname = varname;
    this.expr = expr;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
