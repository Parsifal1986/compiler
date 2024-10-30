package Tools;

import java.util.ArrayList;
import java.util.HashMap;

import Tools.error.SyntaxError;

public class Class {
  public String name;
  public HashMap<String, Type> functions;
  public HashMap<String, Type> members;
  public HashMap<String, ArrayList<Type>> funcparams;
  public HashMap<String, Integer> memberoffset;
  public HashMap<String, String> functionrename;
  public ArrayList<Type> vtable;
  public int size = 0;

  public int size() {
    return size;
  }

  public Class() {
    functions = new HashMap<String, Type>();
    members = new HashMap<String, Type>();
    funcparams = new HashMap<String, ArrayList<Type>>();
  }

  public void  Convert() {
    memberoffset = new HashMap<String, Integer>();
    functionrename = new HashMap<String, String>();
    vtable = new ArrayList<Type>();
    int offset = 0;
    for (String keySet : members.keySet()) {
      vtable.add(members.get(keySet));
      memberoffset.put(keySet, offset);
      offset++;
    }
    size = vtable.size() * 4;
    for (String keySet : functions.keySet()) {
      functionrename.put(keySet, name + "." + keySet);
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
    type.ismember = true;
    members.put(name, type);
  }
}