package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import Tools.Entity;

public class branch extends control {
  public Entity condition;
  public block trueBlock;
  public block falseBlock;

  public branch(Entity condition, block trueBlock, block falseBlock) {
    this.condition = condition;
    this.trueBlock = trueBlock;
    this.falseBlock = falseBlock;
  }

  @Override
  public ArrayList<block> next() {
    if (condition == null) {
      return new ArrayList<block>(Arrays.asList(trueBlock));
    } else {
      return new ArrayList<block>(Arrays.asList(trueBlock, falseBlock));
    }
  }

  @Override
  public void print(PrintStream out) {
    out.println("br " + (condition == null ? "label " + trueBlock.name : condition.tostring() + ", label " + trueBlock.name
        + ", label " + falseBlock.name));
  }
}