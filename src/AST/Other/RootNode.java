package AST.Other;

import java.util.ArrayList;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stmt.ClassDefStmtNode;
import AST.Stmt.FuncDefStmtNode;
import AST.Stmt.VarDefStmtNode;
import Tools.Position;

public class RootNode extends ASTNode {
  public ArrayList<FuncDefStmtNode> funcdefs;
  public ArrayList<ClassDefStmtNode> classdefs;
  public ArrayList<VarDefStmtNode> vardefs;

  public RootNode(Position pos) {
    super(pos);
    funcdefs = new ArrayList<FuncDefStmtNode>();
    classdefs = new ArrayList<ClassDefStmtNode>();
    vardefs = new ArrayList<VarDefStmtNode>();
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
