package codegen;

import java.util.ArrayList;

import Tools.IRsema.declaration;
import Tools.IRsema.func;
import Tools.RISCVsema.section.asmsection;

public class AsmTranslator {
  private ArrayList<func> functons;
  private declaration decl;
  private ArrayList<asmsection> sections;
  
  public AsmTranslator(declaration decl, ArrayList<func> functons, ArrayList<asmsection> sections) {
    this.decl = decl;
    this.functons = functons;
    this.sections = sections;
  }

  public void Trans() {
    sections.addAll(decl.trans());

    for (func functons : functons) {
      sections.add(functons.trans_to_asm());
    }
  }
}
