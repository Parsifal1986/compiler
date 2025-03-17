package codegen;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.RISCVsema.section.asmsection;

public class AsmPrinter {
  ArrayList<asmsection> sections;
  
  public AsmPrinter(ArrayList<asmsection> sections) {
    this.sections = sections;
  }

  public void Print(PrintStream out) {
    for (asmsection section : sections) {
      section.print(out);
      out.println("");
    }
  }
}
