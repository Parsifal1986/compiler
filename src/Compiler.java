import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import AST.Other.RootNode;
import IRgen.IRPrinter;
import IRgen.IRbulider;
import Parser.MxLexer;
import Parser.MxParser;
import Sema.ASTBuilder;
import Sema.SematicChecker;
import Sema.SymbolCollector;
import Tools.MxErrorListener;
import Tools.globalscope;
import Tools.IRsema.declaration;
import Tools.IRsema.func;

public class Compiler {
  public static void main(String[] args) throws Exception {
    try {
      // String filename = "test.mx";
      // InputStream input = new FileInputStream(filename);
      // String IRoutput = "test.ll";
      // PrintStream output = new PrintStream(IRoutput);
      InputStream input = System.in;
      PrintStream output = System.out;
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
      gscope.Convert();
      SematicChecker sematicChecker = new SematicChecker(gscope);
      sematicChecker.visit(ASTRoot);
      declaration decl = new declaration(gscope);
      ArrayList<func> functons = new ArrayList<func>();
      IRbulider irbulider = new IRbulider(gscope, functons, decl);
      irbulider.visit(ASTRoot);
      IRPrinter irPrinter = new IRPrinter(decl, output, functons);
      irPrinter.print();
    } catch (Tools.error.Error e) {
      // System.err.println(e.getMessage() + " at " + e.getErrorLine().line + ":" + e.getErrorLine().charpos);
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }
}
