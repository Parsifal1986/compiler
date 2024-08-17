package AST.Stmt;

import Tools.Position;
import Tools.Type;
import Tools.IRsema.register;

import java.util.ArrayList;

import AST.ASTVisitor;

public class FuncDefStmtNode extends StmtNode {
  public Type retType;
  public String funcName;
  public ArrayList<ParameterList> parameters;
  public ArrayList<register> parameter_regs;
  public BlockStmtNode body;

  public FuncDefStmtNode(Position pos) {
    super(pos);
    parameters = new ArrayList<ParameterList>();
  }

  public void Add(Type type, String name) {
    parameters.add(new ParameterList(type, name));
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  public static class ParameterList {
    public ParameterList(Type type, String name) {
      this.type = type;
      this.name = name;
    }

    public Type type;
    public String name;
  }
  
}
