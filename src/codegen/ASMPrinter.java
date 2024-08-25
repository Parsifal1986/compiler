package codegen;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.RISCVsema.section.asmsection;

public class ASMPrinter {
  ArrayList<asmsection> sections;
  
  public ASMPrinter(ArrayList<asmsection> sections) {
    this.sections = sections;
  }

  public void print(PrintStream out) {
    for (asmsection section : sections) {
      section.print(out);
      out.println("");
    }
  }
}
