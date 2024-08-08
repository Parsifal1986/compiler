package AST;

import java.util.ArrayList;

import Tools.Position;

public class RootNode extends ASTNode {
  public ArrayList<FuncDefStmtNode> funcdefs = new ArrayList<>();
  public ArrayList<ClassDefStmtNode> classdefs = new ArrayList<>();
  public ArrayList<VarDefStmtNode> vardefs = new ArrayList<>();

  public RootNode(Position pos) {
    super(pos);
  }

  public void AddFuncDef(FuncDefStmtNode funcdef) {
    funcdefs.add(funcdef);
  }

  public void AddClassDef(ClassDefStmtNode classdef) {
    classdefs.add(classdef);
  }

  public void AddVarDef(VarDefStmtNode vardef) {
    vardefs.add(vardef);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  };
}
