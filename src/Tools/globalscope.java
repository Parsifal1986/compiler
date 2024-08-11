package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Tools.error.SyntaxError;

public class globalscope extends scope {
  public HashMap<String, Class> classes;

  public globalscope() {
    super(null);
    classes = new HashMap<String, Class>();
    classes.put("int", new Class());
    classes.put("bool", new Class());
    Class stringClass = new Class();
    stringClass.AddFunction("length", new Type("int", 0), new Position(0, 0), new ArrayList<>());
    stringClass.AddFunction("substring", new Type("string", 0), new Position(0, 0), new ArrayList<>(Arrays.asList(new Type("int", 0), new Type("int", 0))));
    stringClass.AddFunction("parseInt", new Type("int", 0), new Position(0, 0), new ArrayList<>());
    stringClass.AddFunction("ord", new Type("int", 0), new Position(0, 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    classes.put("string", stringClass);
    ReplaceFunction("print", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("string", 0))));
    ReplaceFunction("println", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("string", 0))));
    ReplaceFunction("printInt", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    ReplaceFunction("printlnInt", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    ReplaceFunction("getString", new Type("string", 0), new ArrayList<>());
    ReplaceFunction("getInt", new Type("int", 0), new ArrayList<>());
    ReplaceFunction("toString", new Type("string", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
  }

  public boolean CheckClass(String name) {
    if (classes.containsKey(name)) {
      return true;
    }
    return false;
  }

  public void AddClass(String name, Class c, Position pos) {
    if (classes.containsKey(name)) {
      throw new SyntaxError("Class " + name + " already exists", pos);
    }
    classes.put(name, c);
  }

  public void ReplaceClass(String name, Class c) {
    classes.put(name, c);
  }
}
