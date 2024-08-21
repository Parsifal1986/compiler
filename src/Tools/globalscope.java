package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Tools.error.SyntaxError;

public class globalscope extends scope {
  public HashMap<String, Class> classes;
  public HashMap<String, String> IRclasses;

  public globalscope() {
    super(null);
    classes = new HashMap<String, Class>();
    Class intClass = new Class();
    intClass.size = 32;
    classes.put("int", intClass);
    Class booClass = new Class();
    booClass.size = 8;
    classes.put("bool", booClass);
    Class stringClass = new Class();
    stringClass.name = "string";
    stringClass.size = 8;
    stringClass.AddFunction("length", new Type("int", 0), new Position(0, 0), new ArrayList<>());
    stringClass.AddFunction("substring", new Type("string", 0), new Position(0, 0), new ArrayList<>(Arrays.asList(new Type("int", 0), new Type("int", 0))));
    stringClass.AddFunction("parseInt", new Type("int", 0), new Position(0, 0), new ArrayList<>());
    stringClass.AddFunction("ord", new Type("int", 0), new Position(0, 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    classes.put("string", stringClass);
    Class arrayClaass = new Class();
    arrayClaass.name = "_array";
    arrayClaass.AddFunction("size", new Type("int", 0), new Position(0, 0), new ArrayList<>());
    classes.put("_array", arrayClaass);
    ReplaceFunction("print", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("string", 0))));
    ReplaceFunction("println", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("string", 0))));
    ReplaceFunction("printInt", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    ReplaceFunction("printlnInt", new Type("void", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
    ReplaceFunction("getString", new Type("string", 0), new ArrayList<>());
    ReplaceFunction("getInt", new Type("int", 0), new ArrayList<>());
    ReplaceFunction("toString", new Type("string", 0), new ArrayList<>(Arrays.asList(new Type("int", 0))));
  }

  public String GetIRClass(Type type) {
    if (type.getDim() > 0) {
      return "ptr";
    } else {
      return IRclasses.get(type.getfinaltype());
    }
  }

  public void Convert() {
    IRclasses = new HashMap<>();
    for (String keySet : classes.keySet()) {
      String afterConvert;
      if (keySet == "int") {
        afterConvert = "i32";
      } else if (keySet == "bool") {
        afterConvert = "i1";
      } else if (keySet == "_array" || keySet == "string") {
        afterConvert = "ptr";
      } else {
        afterConvert = "%class." + keySet;
      }
      IRclasses.put(keySet, afterConvert);
      classes.get(keySet).Convert();
    }
    for (String keySet : functions.keySet()) {
      if (!keySet.equals("main") && !keySet.equals("print") && !keySet.equals("println") && !keySet.equals("printInt") && !keySet.equals("printlnInt") && !keySet.equals("getString") && !keySet.equals("getInt") && !keySet.equals("toString")) {
        functionrename.put(keySet, "." + keySet);
      } else {
        functionrename.put(keySet, keySet);
      }
    }
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
