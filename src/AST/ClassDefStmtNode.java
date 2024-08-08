package AST;

import java.util.ArrayList;

import Tools.Position;

public class ClassDefStmtNode extends StmtNode {
  public String classname;
  public ConstructFuncDefStmtNode constructfuncdef;
  public ArrayList<VarDefStmtNode> vardefs;
  public ArrayList<FuncDefStmtNode> funcdefs;

  public ClassDefStmtNode(Position pos) {
    super(pos);
  }

  public void AddVarDef(VarDefStmtNode varDef) {
    vardefs.add(varDef);
  }

  public void AddFuncDef(FuncDefStmtNode funcDef) {
    funcdefs.add(funcDef);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
  
}
