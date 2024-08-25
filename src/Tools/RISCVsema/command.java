package Tools.RISCVsema;

abstract public class command {
  public String label;

  public command(String label) {
    this.label = label;
  }
  
  abstract public String toString();
}
