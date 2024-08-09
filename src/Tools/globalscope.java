package Tools;

import java.util.HashMap;

import Tools.error.SyntaxError;

public class globalscope extends scope {
  public HashMap<String, Class> classes;

  public globalscope() {
    super(null);
    classes = new HashMap<String, Class>();
    functions = new HashMap<String, Type>();
    classes.put("int", new Class());
    classes.put("bool", new Class());
    classes.put("string", new Class());
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
