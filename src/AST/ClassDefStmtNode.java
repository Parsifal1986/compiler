package AST;

import java.util.ArrayList;

import Tools.Position;

public class ClassDefStmtNode extends StmtNode {
  String classname;
  public ArrayList<VarDefStmtNode> vardefs;
  public ArrayList<FuncDefStmtNode> funcdefs;

  public ClassDefStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
  
}
