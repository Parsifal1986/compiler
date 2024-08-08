package AST;

import Tools.Position;
import Tools.Type;

import java.util.ArrayList;

public class FuncDefStmtNode extends StmtNode {
  public Type retType;
  public String funcName;
  public ArrayList<ParameterList> parameters;
  public BlockStmtNode body;

  public FuncDefStmtNode(Position pos) {
    super(pos);
  }

  public void Add(Type type, String name) {
    parameters.add(new ParameterList(type, name));
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  private static class ParameterList {
    public ParameterList(Type type, String name) {
      this.type = type;
      this.name = name;
    }

    public Type type;
    public String name;
  }
  
}
