package Tools;

import java.util.HashMap;

import Tools.error.SyntaxError;

public class scope {
  public HashMap<String, Type> Identifier;
  public HashMap<String, Type> functions;
  public scope parent;
  public boolean InLoop;
  public boolean InFunc;

  public scope(scope parent) {
    this.parent = parent;
    this.Identifier = new HashMap<String, Type>();
    this.InLoop = parent.InLoop;
    this.InFunc = parent.InFunc;
  }


  public boolean CheckIdentifier(String name) {
    if (Identifier.containsKey(name)) {
      return true;
    }
    if (parent != null) {
      return parent.CheckIdentifier(name);
    }
    return false;
  }

  public void AddIdentifier(String name, Type type, Position pos) {
    if (Identifier.containsKey(name)) {
      throw new SyntaxError("Variable " + name + " already exists", pos);
    }
    Identifier.put(name, type);
  }

  public void ReplaceIdentifier(String name, Type type) {
    Identifier.put(name, type);
  }

  public boolean CheckFunction(String name) {
    if (functions.containsKey(name)) {
      return true;
    }
    if (parent != null) {
      return parent.CheckFunction(name);
    }
    return false;
  }

  public void AddFunction(String name, Type retType, Position pos) {
    if (functions.containsKey(name)) {
      throw new SyntaxError("Function " + name + " already exists", pos);
    }
    functions.put(name, retType);
  }

  public void ReplaceFunction(String name, Type retType) {
    functions.put(name, retType);
  }
}
