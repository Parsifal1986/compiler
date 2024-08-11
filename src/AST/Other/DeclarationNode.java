package AST.Other;

import Tools.Position;
import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stmt.ClassDefStmtNode;
import AST.Stmt.FuncDefStmtNode;
import AST.Stmt.VarDefStmtNode;

public class DeclarationNode extends ASTNode {
  public FuncDefStmtNode funcDef;
  public ClassDefStmtNode classDef;
  public VarDefStmtNode varDef;
  
  public DeclarationNode(Position pos) {
    super(pos);
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
