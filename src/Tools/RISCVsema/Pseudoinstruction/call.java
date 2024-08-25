package Tools.RISCVsema.Pseudoinstruction;

import Tools.RISCVsema.command;

public class call extends command{
  String name;
  
  public call(String name){
    super(null);
    this.name = name;
  }
  
  @Override
  public String toString() {
    return "call " + name;
  }
}
