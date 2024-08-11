package Tools;

import java.util.ArrayList;
import java.util.HashMap;

import Tools.error.SyntaxError;

public class scope {
  public HashMap<String, Type> Identifier;
  public HashMap<String, Type> functions;
  public HashMap<String, ArrayList<Type>> funcparams;
  public scope parent;
  public boolean InLoop;
  public boolean InFunc;
  public boolean replacemode;
  public boolean hasreturn;
  public String funcname;

  public scope(scope parent) {
    this.parent = parent;
    this.Identifier = new HashMap<String, Type>();
    this.functions = new HashMap<String, Type>();
    this.funcparams = new HashMap<String, ArrayList<Type>>();
    replacemode = false;
    if (parent != null) {
      this.InLoop = parent.InLoop;
      this.InFunc = parent.InFunc;
      this.funcname = parent.funcname;
    }
  }


  public boolean CheckIdentifier(String name) {
    if (Identifier.containsKey(name)) {
      return true;
    }
    if (parent != null && !functions.containsKey(name)) {
      return parent.CheckIdentifier(name);
    }
    return false;
  }

  public void AddIdentifier(String name, Type type, Position pos) {
    if (Identifier.containsKey(name) && !replacemode) {
      throw new SyntaxError("Variable " + name + " already exists", pos);
    }
    Identifier.put(name, type);
  }

  public Type GetIdentifier(String name) {
    if (Identifier.containsKey(name)) {
      return Identifier.get(name);
    }
    if (parent != null) {
      return parent.GetIdentifier(name);
    }
    return null;
  }

  public void ReplaceIdentifier(String name, Type type) {
    Identifier.put(name, type);
  }

  public boolean CheckFunction(String name) {
    if (functions.containsKey(name)) {
      return true;
    }
    if (parent != null && !Identifier.containsKey(name)) {
      return parent.CheckFunction(name);
    }
    return false;
  }

  public void AddFunction(String name, Type retType, ArrayList<Type> funcparams, Position pos) {
    if (functions.containsKey(name) && !replacemode) {
      throw new SyntaxError("Function " + name + " already exists", pos);
    }
    functions.put(name, retType);
    this.funcparams.put(name, funcparams);
  }

  public void ReplaceFunction(String name, Type retType, ArrayList<Type> funcparams) {
    functions.put(name, retType);
    this.funcparams.put(name, funcparams);
  }

  public Type GetFunctionRetType(String name) {
    if (functions.containsKey(name)) {
      return functions.get(name);
    }
    if (parent != null) {
      return parent.GetFunctionRetType(name);
    }
    return null;
  }

  public ArrayList<Type> GetFunctionParams(String name) {
    if (funcparams.containsKey(name)) {
      return funcparams.get(name);
    }
    if (parent != null) {
      return parent.GetFunctionParams(name);
    }
    return null;
  }
}
