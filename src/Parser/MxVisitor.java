// Generated from /root/repository/compiler/src/Parser/Mx.g4 by ANTLR 4.9.3
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MxParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstType(MxParser.ConstTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayConst(MxParser.ArrayConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MxParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExp(MxParser.BinaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExp(MxParser.AssignExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(MxParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(MxParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExp(MxParser.ParenExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExp(MxParser.SuffixExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fstringExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFstringExp(MxParser.FstringExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExp(MxParser.TernaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(MxParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suffixcontent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixcontent(MxParser.SuffixcontentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayInitialize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitialize(MxParser.ArrayInitializeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classInitialize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInitialize(MxParser.ClassInitializeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewexp(MxParser.NewexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#fstring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFstring(MxParser.FstringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MxParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#whileRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileRule(MxParser.WhileRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForRule(MxParser.ForRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#breakRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakRule(MxParser.BreakRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#continueRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueRule(MxParser.ContinueRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnRule(MxParser.ReturnRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suiteStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuiteStmt(MxParser.SuiteStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDefStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefStmt(MxParser.ClassDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStmt(MxParser.ConditionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constructFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructFuncDef(MxParser.ConstructFuncDefContext ctx);
}