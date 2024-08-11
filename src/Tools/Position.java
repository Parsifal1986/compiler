package Tools;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

public class Position {
  public int line, charpos;

  public Position() {
    line = 0;
    charpos = 0;
  }

  public Position(ParserRuleContext ctx) {
    line = ctx.getStart().getLine();
    charpos = ctx.getStart().getCharPositionInLine();
  }

  public Position(int line, int charpos) {
    this.line = line;
    this.charpos = charpos;
  }

  public Pair<Integer, Integer> getPos() {
    return new Pair<>(line, charpos);
  }
}
