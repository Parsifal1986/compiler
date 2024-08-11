import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import AST.ASTNode;
import AST.Other.RootNode;
import Parser.MxLexer;
import Parser.MxParser;
import Sema.ASTBuilder;
import Sema.SematicChecker;
import Sema.SymbolCollector;
import Tools.MxErrorListener;
import Tools.globalscope;

public class Compiler {
  public static void main(String[] args) throws Exception {
    try {
      // String filename = "test.mx";
      // InputStream input = new FileInputStream(filename);
      InputStream input = System.in;
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
      SymbolCollector symbolCollector = new SymbolCollector(gscope);
      symbolCollector.visit(ASTRoot);
      SematicChecker sematicChecker = new SematicChecker(gscope);
      sematicChecker.visit(ASTRoot);
    } catch (Tools.error.Error e) {
      System.err.println(e.getMessage() + " at " + e.getErrorLine().line + ":" + e.getErrorLine().charpos);
      System.exit(1);
    }
  }
}
