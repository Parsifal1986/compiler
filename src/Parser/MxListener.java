// Generated from /root/repository/compiler/src/Parser/Mx.g4 by ANTLR 4.9.3
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(MxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(MxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constType}.
	 * @param ctx the parse tree
	 */
	void enterConstType(MxParser.ConstTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constType}.
	 * @param ctx the parse tree
	 */
	void exitConstType(MxParser.ConstTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayConst}.
	 * @param ctx the parse tree
	 */
	void enterArrayConst(MxParser.ArrayConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayConst}.
	 * @param ctx the parse tree
	 */
	void exitArrayConst(MxParser.ArrayConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MxParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExp(MxParser.BinaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExp(MxParser.BinaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExp(MxParser.AssignExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExp(MxParser.AssignExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(MxParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(MxParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(MxParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(MxParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExp(MxParser.SuffixExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExp(MxParser.SuffixExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fstringExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFstringExp(MxParser.FstringExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fstringExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFstringExp(MxParser.FstringExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExp(MxParser.TernaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExp(MxParser.TernaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parenExp}.
	 * @param ctx the parse tree
	 */
	void enterParenExp(MxParser.ParenExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parenExp}.
	 * @param ctx the parse tree
	 */
	void exitParenExp(MxParser.ParenExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suffix}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(MxParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suffix}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(MxParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suffixcontent}.
	 * @param ctx the parse tree
	 */
	void enterSuffixcontent(MxParser.SuffixcontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suffixcontent}.
	 * @param ctx the parse tree
	 */
	void exitSuffixcontent(MxParser.SuffixcontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayInitialize}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitialize(MxParser.ArrayInitializeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayInitialize}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitialize(MxParser.ArrayInitializeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classInitialize}.
	 * @param ctx the parse tree
	 */
	void enterClassInitialize(MxParser.ClassInitializeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classInitialize}.
	 * @param ctx the parse tree
	 */
	void exitClassInitialize(MxParser.ClassInitializeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newexp}.
	 * @param ctx the parse tree
	 */
	void enterNewexp(MxParser.NewexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newexp}.
	 * @param ctx the parse tree
	 */
	void exitNewexp(MxParser.NewexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#fstring}.
	 * @param ctx the parse tree
	 */
	void enterFstring(MxParser.FstringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#fstring}.
	 * @param ctx the parse tree
	 */
	void exitFstring(MxParser.FstringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MxParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MxParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileRule}.
	 * @param ctx the parse tree
	 */
	void enterWhileRule(MxParser.WhileRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileRule}.
	 * @param ctx the parse tree
	 */
	void exitWhileRule(MxParser.WhileRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forRule}.
	 * @param ctx the parse tree
	 */
	void enterForRule(MxParser.ForRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forRule}.
	 * @param ctx the parse tree
	 */
	void exitForRule(MxParser.ForRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakRule}.
	 * @param ctx the parse tree
	 */
	void enterBreakRule(MxParser.BreakRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakRule}.
	 * @param ctx the parse tree
	 */
	void exitBreakRule(MxParser.BreakRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueRule}.
	 * @param ctx the parse tree
	 */
	void enterContinueRule(MxParser.ContinueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueRule}.
	 * @param ctx the parse tree
	 */
	void exitContinueRule(MxParser.ContinueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnRule}.
	 * @param ctx the parse tree
	 */
	void enterReturnRule(MxParser.ReturnRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnRule}.
	 * @param ctx the parse tree
	 */
	void exitReturnRule(MxParser.ReturnRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suiteStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSuiteStmt(MxParser.SuiteStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suiteStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSuiteStmt(MxParser.SuiteStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterClassDefStmt(MxParser.ClassDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitClassDefStmt(MxParser.ClassDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStmt(MxParser.ConditionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStmt(MxParser.ConditionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constructFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterConstructFuncDef(MxParser.ConstructFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitConstructFuncDef(MxParser.ConstructFuncDefContext ctx);
}