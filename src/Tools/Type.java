package Tools;

import java.util.ArrayList;

import org.antlr.v4.runtime.Token;

import Parser.MxParser.ArrayConstContext;
import Parser.MxParser.ConstTypeContext;
import Tools.error.SyntaxError;

public class Type {
  private String typename;
  private int dim;
  public boolean isfunc = false;
  public String funcname = null;
  public ArrayList<Type> params = null;

  public static Type GetType(ConstTypeContext c) {
    if (c.True() != null || c.False() != null) {
      return new Type("bool", 0);
    } else if (c.Null() != null) {
      return new Type("null", 0);
    } else if (c.DemicalConst() != null) {
      return new Type("int", 0);
    } else if (c.StringConst() != null) {
      return new Type("string", 0);
    } else if (c.arrayConst() != null) {
      return GetArrayConstType(c.arrayConst());
    } else {
      throw new SyntaxError("Unknown type", new Position(c));
    }
  }

  public static Type GetArrayConstType(ArrayConstContext c) {
    if (c.constType().size() == 0) {
      return new Type("null", 0);
    }
    Type t = GetType(c.constType(0));
    for (int i = 0; i < c.constType().size(); i++) {
      Type tmp_t = GetType(c.constType(i));
      if (!t.equals(tmp_t)) {
        throw new SyntaxError("Array type mismatch", new Position(c));
      }
    }
    return new Type(t.typename, t.dim + 1);
  }

  public static Type GetArrayDefType(String typename, String token) {
    int dim = (int) token.chars().filter(ch -> ch == '[').count();
    return new Type(typename, dim);
  }

  public Type(Type t) {
    this.typename = t.typename;
    this.dim = t.dim;
    this.isfunc = t.isfunc;
    this.funcname = t.funcname;
    this.params = t.params;
  }

  public Type(String typename, int dim) {
    this.typename = typename;
    this.dim = dim;
  }

  public Type(Token type) {
    this.dim = (int) type.getText().chars().filter(ch -> ch == '[').count();
    this.typename = type.getText().replaceAll("[[]]", "");
  }
  
  public Type(String type) {
    this.dim = (int) type.chars().filter(ch -> ch == '[').count();
    this.typename = type.replaceAll("[\\[\\]]", "");
  }

  public boolean IsBuildIn() {
    return typename.equals("int") || typename.equals("bool") || typename.equals("string") || typename.equals("null");
  }

  public String getTypename() {
    if (dim != 0) {
      return "_array";
    }
    return typename;
  }

  public String getfinaltype() {
    return typename;
  }

  public int getDim() {
    return dim;
  }

  public boolean equals(Type t) {
    if (this.dim != 0 && t.typename == "null") {
      return true;
    }
    if (this.typename == "null" && t.dim != 0) {
      return true;
    }
    if (!IsBuildIn() && t.typename == "null") {
      return true;
    }
    if (typename == "null" && !t.IsBuildIn()) {
      return true;
    }
    return typename.equals(t.typename) && dim == t.dim;
  }

  public String ToIrType() {
    if (typename.equals("void")) {
      return "void";
    }
    if (dim != 0) {
      return "ptr";
    }
    if (typename.equals("int")) {
      return "i32";
    }
    if (typename.equals("bool")) {
      return "i1";
    }
    return "ptr";
  }
}
