package AST.Other;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import Tools.Position;

public class RootNode extends ASTNode {
  public ArrayList<DeclarationNode> declarations;

  public RootNode(Position pos) {
    super(pos);
    declarations = new ArrayList<DeclarationNode>();
  }

  public void AddDecalration(DeclarationNode declaration) {
    declarations.add(declaration);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}
