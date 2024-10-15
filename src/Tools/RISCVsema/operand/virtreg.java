package Tools.RISCVsema.operand;

public class virtreg extends reg {
  public boolean isGlobal = false;
  public String globalname;
  public int stackpos = -1;
  public phyreg phyreg;
  public int regId = -1;

  // public virtreg(int pos) {
  //   stackpos = pos;
  // }

  public virtreg(int pos, phyreg phyreg) {
    stackpos = pos;
    this.phyreg = phyreg;
  }

  public virtreg(String name) {
    globalname = name;
    isGlobal = true;
  }

  public virtreg(int regId) {
    this.regId = regId;
  }

  public int getStackPos() {
    return stackpos;
  }

  public phyreg getPhyreg() {
    return phyreg;
  }

  public String getGlobalPos() {
    return globalname;
  }

  @Override
  public String toString() {
    return null;
  }
}
