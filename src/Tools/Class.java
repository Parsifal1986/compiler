package Tools;

import java.util.HashMap;

import Tools.error.SyntaxError;

public class Class {
  public HashMap<String, Type> functions;
  public HashMap<String, Type> members;

  public Class() {
    functions = new HashMap<String, Type>();
    members = new HashMap<String, Type>();
  }

  public boolean CheckFunction(String name) {
    if (functions.containsKey(name)) {
      return true;
    }
    return false;
  }

  public void AddFunction(String name, Type retType, Position pos) {
    if (functions.containsKey(name)) {
      throw new SyntaxError("Function " + name + " already exists", pos);
    }
    functions.put(name, retType);
  }

  public boolean CheckMember(String name) {
    if (members.containsKey(name)) {
      return true;
    }
    return false;
  }

  public void AddMember(String name, Type type, Position pos) {
    if (members.containsKey(name)) {
      throw new SyntaxError("Member " + name + " already exists", pos);
    }
    members.put(name, type);
  }
}