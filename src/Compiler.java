import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import AST.Other.RootNode;
import Parser.MxLexer;
import Parser.MxParser;
import Sema.ASTBuilder;
import Tools.MxErrorListener;
import Tools.globalscope;

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
    globalscope gscope = new globalscope();
    ASTBuilder astBuilder = new ASTBuilder(gscope);
    RootNode ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);
  }
}
