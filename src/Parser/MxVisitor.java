package Parser;

// Generated from src/Parser/Mx.g4 by ANTLR 4.9.3
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
	 * Visit a parse tree produced by {@link MxParser#mainDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDef(MxParser.MainDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayInitialize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitialize(MxParser.ArrayInitializeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayVisit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVisit(MxParser.ArrayVisitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#memberVisit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberVisit(MxParser.MemberVisitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MxParser.ArgumentListContext ctx);
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
	 * Visit a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(MxParser.CycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(MxParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(MxParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#memberVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberVarDef(MxParser.MemberVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#memberFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberFuncDef(MxParser.MemberFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constructFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructFuncDef(MxParser.ConstructFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classInitialize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInitialize(MxParser.ClassInitializeContext ctx);
}