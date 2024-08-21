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
  public ArrayList<Reflection> parameter_regs;
  public BlockStmtNode body;

  public FuncDefStmtNode(Position pos) {
    super(pos);
    parameters = new ArrayList<ParameterList>();
    parameter_regs = new ArrayList<Reflection>();
  }

  public void Add(Type type, String name) {
    parameters.add(new ParameterList(type, name));
  }

  public void AddReflection(register param, register ptr) {
    parameter_regs.add(new Reflection(param, ptr));
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

  public static class Reflection {
    public register param;
    public register ptr;
    
    public Reflection(register param, register ptr) {
      this.param = param;
      this.ptr = ptr;
    }
  }
  
}
