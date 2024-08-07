package AST;

import Tools.Position;
import java.util.List;

public class FuncDefStmtNode extends StmtNode {
  public String retType;
  public String funcName;
  public List<VarDefStmtNode> parameters;
  public BlockStmtNode body;

  public FuncDefStmtNode(String retType, String funcName, Position pos, List<VarDefStmtNode> parameters, BlockStmtNode body) {
    super(pos);
    this.retType = retType;
    this.funcName = funcName;
    this.parameters = parameters;
    this.body = body;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
  
}
