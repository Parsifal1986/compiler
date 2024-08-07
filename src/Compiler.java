import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import Parser.MxLexer;
import Parser.MxParser;
import Tools.MxErrorListener;

public class Compiler {
  public static void main(String[] args) throws Exception {
    String filename = "test.mx";
    InputStream input = new FileInputStream(filename);
    MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
    lexer.removeErrorListeners();
    lexer.addErrorListener(new MxErrorListener());
    MxParser parser = new MxParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();
    parser.addErrorListener(new MxErrorListener());
    ParseTree parseTreeRoot = parser.program();
  }
}
