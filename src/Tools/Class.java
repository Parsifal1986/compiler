package Tools;

import java.util.ArrayList;
import java.util.HashMap;

import Tools.error.SyntaxError;

public class Class {
  public HashMap<String, Type> functions;
  public HashMap<String, Type> members;
  public HashMap<String, ArrayList<Type>> funcparams;
  public HashMap<String, Integer> memberoffset;
  public HashMap<String, String> functionrename;
  public ArrayList<Type> vtable;

  public Class() {
    functions = new HashMap<String, Type>();
    members = new HashMap<String, Type>();
    funcparams = new HashMap<String, ArrayList<Type>>();
  }

  public void Convert(String classname) {
    memberoffset = new HashMap<String, Integer>();
    functionrename = new HashMap<String, String>();
    vtable = new ArrayList<Type>();
    int offset = 0;
    for (String keySet : members.keySet()) {
      vtable.add(members.get(keySet));
      memberoffset.put(keySet, offset);
      offset++;
    }
    for (String keySet : functions.keySet()) {
      functionrename.put(keySet, classname + "::" + keySet);
    }
  }

  public boolean CheckFunction(String name) {
    if (functions.containsKey(name)) {
      return true;
    }
    return false;
  }

  public void AddFunction(String name, Type retType, Position pos, ArrayList<Type> params) {
    if (functions.containsKey(name)) {
      // throw new SyntaxError("Function " + name + " already exists", pos);
      throw new SyntaxError("Multiple Definitions", pos);
    }
    functions.put(name, retType);
    funcparams.put(name, params);
  }

  public boolean CheckMember(String name) {
    if (members.containsKey(name)) {
      return true;
    }
    return false;
  }

  public void AddMember(String name, Type type, Position pos) {
    if (members.containsKey(name)) {
      // throw new SyntaxError("Member " + name + " already exists", pos);
      throw new SyntaxError("Multiple Definitions", pos);
    }
    members.put(name, type);
  }
}