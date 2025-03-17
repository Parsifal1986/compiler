package Tools.RISCVsema.section;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.RISCVsema.command;
import Tools.RISCVsema.Pseudoinstruction.ret;

public class textsection extends asmsection {
  public ArrayList<command> commands;
  public int stacksize;
  
  public textsection(String name, boolean isGlobal) {
    this.name = name;
    this.isGlobal = isGlobal;
    commands = new ArrayList<command>();
  }

  public void add(command command) {
    commands.add(command);
  }

  public void add(Integer index, command command) {
    commands.add(index, command);
  }

  public void addAll(ArrayList<command> commands) {
    this.commands.addAll(commands);
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(".text");
    out.println(".globl " + name);
    out.println(name + ":");
    for (command command : commands) {
      if (command.label != null) {
        out.println("." + command.label + ":");
      }
      if (command instanceof ret) {
        if (-2048 <= stacksize && stacksize < 2048) {
          out.println("  addi sp, sp, " + stacksize);
        } else {
          out.println("  li t0, " + stacksize);
          out.println("  add sp, sp, t0");
        }
      }
      out.println("\t" + command.toString());
    }
  }
}
