package Tools;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import Parser.MxParser.ArrayConstContext;
import Parser.MxParser.ConstTypeContext;

public class Type {
  private String typename;
  private int dim;
  private static Map<String, Type> types = new HashMap<String,Type>();

  public static Type GetType(String identifer) {
    return types.get(identifer);
  }

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
      throw new RuntimeException("Unknown type");
    }
  }

  public static Type GetArrayConstType(ArrayConstContext c) {
    int dim = 0;
    for (int i = 0; i < c.constType().size(); i++) {
      dim = Math.max(dim, GetType(c.constType(i)).dim);
    }
    return new Type("array", dim + 1);
  }

  public static Type GetArrayDefType(String typename, String token) {
    int dim = (int) token.chars().filter(ch -> ch == '[').count();
    return new Type(typename, dim);
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

  public String getTypename() {
    return typename;
  }

  public int getDim() {
    return dim;
  }
}
