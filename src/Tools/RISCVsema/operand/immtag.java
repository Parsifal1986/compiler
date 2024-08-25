package Tools.RISCVsema.operand;

public class immtag extends imm{
  String tag;
  range r;

  public immtag(String tag, range r) {
    this.tag = tag;
    this.r = r;
  }

  @Override
  public String toString() {
    return r + "(" + (tag)+ ")" ;
  }

  public enum range {
    HIGH, LOW, FULL;

    @Override
    public String toString() {
      switch (this) {
        case HIGH:
          return "%hi";
        case LOW:
          return "%lo";
        case FULL:
          return "";
        default:
          return null;
      }
    }
  }
}
