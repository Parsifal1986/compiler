package Tools.RISCVsema;

import java.util.ArrayList;

public class asmblock {
  ArrayList<command> commands;
  int start;
  String name;
  ArrayList<asmblock> next;
}
