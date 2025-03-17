import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import Tools.RISCVsema.section.asmsection;
import codegen.AsmPrinter;
import codegen.AsmTranslator;
import codegen.BranchRefiner;
import codegen.CommonSubexpressionEliminator;
import codegen.DeadCodeEliminator;
import codegen.DivOptimizer;
import codegen.ConstPropagator;
import codegen.Global2Localer;
import codegen.Mem2Reger;
import codegen.PhiCleaner;
import codegen.Processor;
import codegen.RegAllocator;
import codegen.Renamer;

public class Compiler {
  public static void main(String[] args) throws Exception {
    try {
      // String filename = "test.mx";
      // InputStream input = new FileInputStream(filename);
      // String IRoutput = "test.out";
      // PrintStream output = new PrintStream(IRoutput);
      String currentFile = System.getProperty("user.dir");
      Path filePath = Paths.get(currentFile, "/src/Tools/buildin/builtin.s");
      // Path filePath = Paths.get(currentFile, "../src/Tools/buildin/builtin.s");
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
      ArrayList<func> functions = new ArrayList<func>();
      IRbulider irbulider = new IRbulider(gscope, functions, decl);
      irbulider.visit(ASTRoot);
      Global2Localer global2Localer = new Global2Localer(functions, decl);
      global2Localer.ToLocal();
      Mem2Reger mem2Reger = new Mem2Reger(functions);
      mem2Reger.ToReg();
      Renamer renamer = new Renamer(functions);
      renamer.Rename();
      ConstPropagator constPropagator = new ConstPropagator(functions);
      constPropagator.Propagate();
      CommonSubexpressionEliminator cse = new CommonSubexpressionEliminator(functions);
      cse.CS_Elimination();
      // IRPrinter irPrinter = new IRPrinter(decl, output, functions);
      // irPrinter.print();
      PhiCleaner phiCleaner = new PhiCleaner(functions);
      phiCleaner.CleanPhi();  
      DivOptimizer divOptimizer = new DivOptimizer(functions);
      divOptimizer.OptimizeDiv();
      Processor processor = new Processor(functions);
      processor.Process();
      BranchRefiner branchRefiner = new BranchRefiner(functions);
      branchRefiner.Refine();
      DeadCodeEliminator dce = new DeadCodeEliminator(functions);
      dce.DC_Eliminate();
      RegAllocator regAllocator = new RegAllocator(functions);
      regAllocator.Alloc();
      ArrayList<asmsection> sections = new ArrayList<asmsection>();
      AsmTranslator asmTranslator = new AsmTranslator(decl, functions, sections);
      asmTranslator.Trans();
      AsmPrinter asmPrinter = new AsmPrinter(sections);
      asmPrinter.Print(output);
      BufferedReader br = new BufferedReader(new FileReader(filePath.toAbsolutePath().toString()));
      String line;
      while ((line = br.readLine()) != null) {
        output.println(line);
      }
      br.close();
    } catch (Tools.error.Error e) {
      // System.err.println(e.getMessage() + " at " + e.getErrorLine().line + ":" + e.getErrorLine().charpos);
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }
}
