package Parser;

// Generated from src/Parser/Mx.g4 by ANTLR 4.9.3
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
	 * Enter a parse tree produced by {@link MxParser#mainDef}.
	 * @param ctx the parse tree
	 */
	void enterMainDef(MxParser.MainDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#mainDef}.
	 * @param ctx the parse tree
	 */
	void exitMainDef(MxParser.MainDefContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#arrayVisit}.
	 * @param ctx the parse tree
	 */
	void enterArrayVisit(MxParser.ArrayVisitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayVisit}.
	 * @param ctx the parse tree
	 */
	void exitArrayVisit(MxParser.ArrayVisitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MxParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#memberVisit}.
	 * @param ctx the parse tree
	 */
	void enterMemberVisit(MxParser.MemberVisitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#memberVisit}.
	 * @param ctx the parse tree
	 */
	void exitMemberVisit(MxParser.MemberVisitContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MxParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MxParser.ArgumentListContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterCycle(MxParser.CycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitCycle(MxParser.CycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(MxParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(MxParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(MxParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(MxParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#memberVarDef}.
	 * @param ctx the parse tree
	 */
	void enterMemberVarDef(MxParser.MemberVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#memberVarDef}.
	 * @param ctx the parse tree
	 */
	void exitMemberVarDef(MxParser.MemberVarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#memberFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterMemberFuncDef(MxParser.MemberFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#memberFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitMemberFuncDef(MxParser.MemberFuncDefContext ctx);
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
}