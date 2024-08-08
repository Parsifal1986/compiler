// Generated from /root/repository/compiler/src/Parser/Mx.g4 by ANTLR 4.9.3
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, If=5, Else=6, Return=7, Break=8, Continue=9, 
		New=10, Class=11, Null=12, True=13, False=14, This=15, For=16, While=17, 
		Inc=18, Dec=19, Plus=20, Minus=21, Multi=22, Div=23, Mod=24, Less=25, 
		Greater=26, LessEqual=27, GreaterEqual=28, Equal=29, NotEqual=30, And=31, 
		Or=32, Not=33, BitNot=34, BitAnd=35, BitOr=36, BitXor=37, LeftShift=38, 
		RightShift=39, Dot=40, LeftParen=41, RightParen=42, LeftBracket=43, RightBracket=44, 
		LeftBrace=45, RightBrace=46, Whitespace=47, Newline=48, BlockComment=49, 
		LineComment=50, Semi=51, BasicType=52, Void=53, Bool=54, Int=55, String=56, 
		Identifier=57, DemicalConst=58, StringConst=59, FstringHead=60, FstringBody=61, 
		FstringTail=62;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_array = 2, RULE_constType = 3, RULE_arrayConst = 4, 
		RULE_varDef = 5, RULE_assign = 6, RULE_expression = 7, RULE_primary = 8, 
		RULE_suffix = 9, RULE_suffixcontent = 10, RULE_funcDef = 11, RULE_arrayInitialize = 12, 
		RULE_classInitialize = 13, RULE_newexp = 14, RULE_fstring = 15, RULE_suite = 16, 
		RULE_condition = 17, RULE_whileRule = 18, RULE_forRule = 19, RULE_breakRule = 20, 
		RULE_continueRule = 21, RULE_returnRule = 22, RULE_statement = 23, RULE_classDef = 24, 
		RULE_constructFuncDef = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "array", "constType", "arrayConst", "varDef", "assign", 
			"expression", "primary", "suffix", "suffixcontent", "funcDef", "arrayInitialize", 
			"classInitialize", "newexp", "fstring", "suite", "condition", "whileRule", 
			"forRule", "breakRule", "continueRule", "returnRule", "statement", "classDef", 
			"constructFuncDef"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'?'", "':'", "'if'", "'else'", "'return'", "'break'", 
			"'continue'", "'new'", "'class'", "'null'", "'true'", "'false'", "'this'", 
			"'for'", "'while'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", 
			"'~'", "'&'", "'|'", "'^'", "'<<'", "'>>'", "'.'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", null, null, null, null, "';'", null, "'void'", "'bool'", 
			"'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "If", "Else", "Return", "Break", "Continue", 
			"New", "Class", "Null", "True", "False", "This", "For", "While", "Inc", 
			"Dec", "Plus", "Minus", "Multi", "Div", "Mod", "Less", "Greater", "LessEqual", 
			"GreaterEqual", "Equal", "NotEqual", "And", "Or", "Not", "BitNot", "BitAnd", 
			"BitOr", "BitXor", "LeftShift", "RightShift", "Dot", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Whitespace", 
			"Newline", "BlockComment", "LineComment", "Semi", "BasicType", "Void", 
			"Bool", "Int", "String", "Identifier", "DemicalConst", "StringConst", 
			"FstringHead", "FstringBody", "FstringTail"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Class) | (1L << BasicType) | (1L << Identifier))) != 0)) {
				{
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(52);
					funcDef();
					}
					break;
				case 2:
					{
					setState(53);
					varDef();
					}
					break;
				case 3:
					{
					setState(54);
					classDef();
					}
					break;
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode BasicType() { return getToken(MxParser.BasicType, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(BasicType);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public TerminalNode BasicType() { return getToken(MxParser.BasicType, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !(_la==BasicType || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(68);
			match(LeftBracket);
			setState(69);
			match(RightBracket);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					match(LeftBracket);
					setState(71);
					match(RightBracket);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstTypeContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode DemicalConst() { return getToken(MxParser.DemicalConst, 0); }
		public TerminalNode StringConst() { return getToken(MxParser.StringConst, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public ArrayConstContext arrayConst() {
			return getRuleContext(ArrayConstContext.class,0);
		}
		public ConstTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstTypeContext constType() throws RecognitionException {
		ConstTypeContext _localctx = new ConstTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constType);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case True:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(True);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(False);
				}
				break;
			case DemicalConst:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(DemicalConst);
				}
				break;
			case StringConst:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(StringConst);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(Null);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				arrayConst();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayConstContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<ConstTypeContext> constType() {
			return getRuleContexts(ConstTypeContext.class);
		}
		public ConstTypeContext constType(int i) {
			return getRuleContext(ConstTypeContext.class,i);
		}
		public ArrayConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayConstContext arrayConst() throws RecognitionException {
		ArrayConstContext _localctx = new ArrayConstContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LeftBrace);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftBrace) | (1L << DemicalConst) | (1L << StringConst))) != 0)) {
				{
				setState(86);
				constType();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(87);
					match(T__0);
					setState(88);
					constType();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(96);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			type();
			setState(99);
			assign();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(100);
				match(T__0);
				setState(101);
				assign();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(Identifier);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(110);
				match(T__1);
				setState(111);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Multi() { return getToken(MxParser.Multi, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(MxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public TerminalNode RightShift() { return getToken(MxParser.RightShift, 0); }
		public TerminalNode LeftShift() { return getToken(MxParser.LeftShift, 0); }
		public TerminalNode Greater() { return getToken(MxParser.Greater, 0); }
		public TerminalNode Less() { return getToken(MxParser.Less, 0); }
		public TerminalNode GreaterEqual() { return getToken(MxParser.GreaterEqual, 0); }
		public TerminalNode LessEqual() { return getToken(MxParser.LessEqual, 0); }
		public TerminalNode NotEqual() { return getToken(MxParser.NotEqual, 0); }
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public TerminalNode BitAnd() { return getToken(MxParser.BitAnd, 0); }
		public TerminalNode BitXor() { return getToken(MxParser.BitXor, 0); }
		public TerminalNode BitOr() { return getToken(MxParser.BitOr, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public BinaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssignExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssignExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssignExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpContext extends ExpressionContext {
		public Token Pre;
		public Token Suf;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode BitNot() { return getToken(MxParser.BitNot, 0); }
		public TerminalNode Inc() { return getToken(MxParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(MxParser.Dec, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public UnaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryExpContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrimaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrimaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrimaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParenExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParenExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParenExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParenExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExpContext extends ExpressionContext {
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public SuffixExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuffixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuffixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuffixExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FstringExpContext extends ExpressionContext {
		public FstringContext fstring() {
			return getRuleContext(FstringContext.class,0);
		}
		public FstringExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFstringExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFstringExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFstringExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterTernaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitTernaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitTernaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new SuffixExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				suffix();
				}
				break;
			case 3:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(LeftParen);
				setState(118);
				expression(0);
				setState(119);
				match(RightParen);
				}
				break;
			case 4:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				_la = _input.LA(1);
				if ( !(_la==Not || _la==BitNot) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(122);
				expression(17);
				}
				break;
			case 5:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				((UnaryExpContext)_localctx).Pre = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
					((UnaryExpContext)_localctx).Pre = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(124);
				expression(15);
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(125);
				match(Minus);
				}
				setState(126);
				expression(14);
				}
				break;
			case 7:
				{
				_localctx = new FstringExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				fstring();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(131);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multi) | (1L << Div) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(134);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(135);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(136);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(137);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(138);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(140);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << Greater) | (1L << LessEqual) | (1L << GreaterEqual))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(141);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(143);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(144);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(146);
						match(BitAnd);
						}
						setState(147);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(149);
						match(BitXor);
						}
						setState(150);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(152);
						match(BitOr);
						}
						setState(153);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(155);
						match(And);
						}
						setState(156);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(158);
						match(Or);
						}
						setState(159);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new TernaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(161);
						match(T__2);
						}
						setState(162);
						expression(0);
						{
						setState(163);
						match(T__3);
						}
						setState(164);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new AssignExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(167);
						match(T__1);
						}
						setState(168);
						expression(2);
						}
						break;
					case 13:
						{
						_localctx = new UnaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(170);
						((UnaryExpContext)_localctx).Suf = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
							((UnaryExpContext)_localctx).Suf = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ConstTypeContext constType() {
			return getRuleContext(ConstTypeContext.class,0);
		}
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public NewexpContext newexp() {
			return getRuleContext(NewexpContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primary);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(Identifier);
				}
				break;
			case Null:
			case True:
			case False:
			case LeftBrace:
			case DemicalConst:
			case StringConst:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				constType();
				}
				break;
			case This:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(This);
				}
				break;
			case New:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				newexp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuffixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<SuffixcontentContext> suffixcontent() {
			return getRuleContexts(SuffixcontentContext.class);
		}
		public SuffixcontentContext suffixcontent(int i) {
			return getRuleContext(SuffixcontentContext.class,i);
		}
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_suffix);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			primary();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					suffixcontent();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuffixcontentContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public SuffixcontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffixcontent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuffixcontent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuffixcontent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuffixcontent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixcontentContext suffixcontent() throws RecognitionException {
		SuffixcontentContext _localctx = new SuffixcontentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_suffixcontent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dot:
				{
				setState(189);
				match(Dot);
				setState(190);
				match(Identifier);
				}
				break;
			case LeftBracket:
				{
				setState(191);
				match(LeftBracket);
				setState(192);
				expression(0);
				setState(193);
				match(RightBracket);
				}
				break;
			case LeftParen:
				{
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(195);
					match(LeftParen);
					{
					setState(196);
					expression(0);
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(197);
						match(T__0);
						setState(198);
						expression(0);
						}
						}
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(204);
					match(RightParen);
					}
					break;
				case 2:
					{
					setState(206);
					match(LeftParen);
					setState(207);
					match(RightParen);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TypeContext retType;
		public Token funcName;
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			((FuncDefContext)_localctx).retType = type();
			setState(213);
			((FuncDefContext)_localctx).funcName = match(Identifier);
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(214);
				match(LeftParen);
				{
				setState(215);
				type();
				setState(216);
				match(Identifier);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(217);
					match(T__0);
					setState(218);
					type();
					setState(219);
					match(Identifier);
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(226);
				match(RightParen);
				}
				break;
			case 2:
				{
				setState(228);
				match(LeftParen);
				setState(229);
				match(RightParen);
				}
				break;
			}
			setState(232);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayConstContext arrayConst() {
			return getRuleContext(ArrayConstContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public ArrayInitializeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitialize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayInitialize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayInitialize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializeContext arrayInitialize() throws RecognitionException {
		ArrayInitializeContext _localctx = new ArrayInitializeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayInitialize);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				{
				setState(234);
				type();
				setState(235);
				match(T__1);
				setState(236);
				arrayConst();
				}
				}
				break;
			case 2:
				{
				{
				setState(238);
				type();
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(239);
					match(LeftBracket);
					setState(240);
					expression(0);
					setState(241);
					match(RightBracket);
					}
					break;
				case 2:
					{
					setState(243);
					match(LeftBracket);
					setState(244);
					match(RightBracket);
					}
					break;
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(253);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(247);
							match(LeftBracket);
							setState(248);
							expression(0);
							setState(249);
							match(RightBracket);
							}
							break;
						case 2:
							{
							setState(251);
							match(LeftBracket);
							setState(252);
							match(RightBracket);
							}
							break;
						}
						} 
					}
					setState(257);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassInitializeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ClassInitializeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInitialize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassInitialize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassInitialize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInitializeContext classInitialize() throws RecognitionException {
		ClassInitializeContext _localctx = new ClassInitializeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classInitialize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(Identifier);
			setState(261);
			match(LeftParen);
			setState(262);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewexpContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public ArrayInitializeContext arrayInitialize() {
			return getRuleContext(ArrayInitializeContext.class,0);
		}
		public ClassInitializeContext classInitialize() {
			return getRuleContext(ClassInitializeContext.class,0);
		}
		public NewexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewexpContext newexp() throws RecognitionException {
		NewexpContext _localctx = new NewexpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(New);
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(265);
				arrayInitialize();
				}
				break;
			case 2:
				{
				setState(266);
				classInitialize();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FstringContext extends ParserRuleContext {
		public TerminalNode FstringHead() { return getToken(MxParser.FstringHead, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FstringTail() { return getToken(MxParser.FstringTail, 0); }
		public List<TerminalNode> FstringBody() { return getTokens(MxParser.FstringBody); }
		public TerminalNode FstringBody(int i) {
			return getToken(MxParser.FstringBody, i);
		}
		public FstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFstring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFstring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FstringContext fstring() throws RecognitionException {
		FstringContext _localctx = new FstringContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(FstringHead);
			setState(270);
			expression(0);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FstringBody) {
				{
				{
				setState(271);
				match(FstringBody);
				setState(272);
				expression(0);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
			match(FstringTail);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(LeftBrace);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << New) | (1L << Class) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << For) | (1L << While) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Semi) | (1L << BasicType) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				{
				setState(281);
				statement();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext conditionExp;
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(If);
			setState(290);
			match(LeftParen);
			setState(291);
			((ConditionContext)_localctx).conditionExp = expression(0);
			setState(292);
			match(RightParen);
			setState(293);
			((ConditionContext)_localctx).trueStmt = statement();
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(294);
				match(Else);
				setState(295);
				((ConditionContext)_localctx).falseStmt = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileRuleContext extends ParserRuleContext {
		public ExpressionContext conditionExp;
		public StatementContext Stmt;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileRuleContext whileRule() throws RecognitionException {
		WhileRuleContext _localctx = new WhileRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_whileRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(While);
			setState(299);
			match(LeftParen);
			setState(300);
			((WhileRuleContext)_localctx).conditionExp = expression(0);
			setState(301);
			match(RightParen);
			setState(302);
			((WhileRuleContext)_localctx).Stmt = statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForRuleContext extends ParserRuleContext {
		public ExpressionContext initExpr;
		public ExpressionContext condExpr;
		public ExpressionContext stepExpr;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForRuleContext forRule() throws RecognitionException {
		ForRuleContext _localctx = new ForRuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(For);
			setState(305);
			match(LeftParen);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(306);
				((ForRuleContext)_localctx).initExpr = expression(0);
				}
			}

			setState(309);
			match(Semi);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(310);
				((ForRuleContext)_localctx).condExpr = expression(0);
				}
			}

			setState(313);
			match(Semi);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(314);
				((ForRuleContext)_localctx).stepExpr = expression(0);
				}
			}

			setState(317);
			match(RightParen);
			setState(318);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakRuleContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public BreakRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBreakRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBreakRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBreakRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakRuleContext breakRule() throws RecognitionException {
		BreakRuleContext _localctx = new BreakRuleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_breakRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(Break);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueRuleContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public ContinueRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterContinueRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitContinueRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitContinueRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueRuleContext continueRule() throws RecognitionException {
		ContinueRuleContext _localctx = new ContinueRuleContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_continueRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(Continue);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnRuleContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterReturnRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitReturnRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitReturnRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnRuleContext returnRule() throws RecognitionException {
		ReturnRuleContext _localctx = new ReturnRuleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(Return);
			setState(325);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDefStmtContext extends StatementContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarDefStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmtContext extends StatementContext {
		public ForRuleContext forRule() {
			return getRuleContext(ForRuleContext.class,0);
		}
		public ForStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StatementContext {
		public WhileRuleContext whileRule() {
			return getRuleContext(WhileRuleContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDefStmtContext extends StatementContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public ClassDefStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDefStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStmtContext extends StatementContext {
		public BreakRuleContext breakRule() {
			return getRuleContext(BreakRuleContext.class,0);
		}
		public BreakStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExpressionStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEmptyStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEmptyStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEmptyStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatementContext {
		public ReturnRuleContext returnRule() {
			return getRuleContext(ReturnRuleContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStmtContext extends StatementContext {
		public ContinueRuleContext continueRule() {
			return getRuleContext(ContinueRuleContext.class,0);
		}
		public ContinueStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitContinueStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionStmtContext extends StatementContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConditionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConditionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConditionStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuiteStmtContext extends StatementContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public SuiteStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuiteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuiteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuiteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statement);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new SuiteStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				suite();
				}
				break;
			case 2:
				_localctx = new VarDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				varDef();
				}
				break;
			case 3:
				_localctx = new ClassDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				classDef();
				}
				break;
			case 4:
				_localctx = new ConditionStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
				condition();
				}
				break;
			case 5:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(331);
				breakRule();
				}
				break;
			case 6:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(332);
				continueRule();
				}
				break;
			case 7:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(333);
				returnRule();
				}
				break;
			case 8:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(334);
				whileRule();
				}
				break;
			case 9:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(335);
				forRule();
				}
				break;
			case 10:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(336);
				expression(0);
				setState(337);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(339);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public Token classname;
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ConstructFuncDefContext> constructFuncDef() {
			return getRuleContexts(ConstructFuncDefContext.class);
		}
		public ConstructFuncDefContext constructFuncDef(int i) {
			return getRuleContext(ConstructFuncDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(Class);
			setState(343);
			((ClassDefContext)_localctx).classname = match(Identifier);
			setState(344);
			match(LeftBrace);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BasicType || _la==Identifier) {
				{
				setState(348);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(345);
					varDef();
					}
					break;
				case 2:
					{
					setState(346);
					funcDef();
					}
					break;
				case 3:
					{
					setState(347);
					constructFuncDef();
					}
					break;
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(353);
			match(RightBrace);
			setState(354);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFuncDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ConstructFuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFuncDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstructFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstructFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstructFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructFuncDefContext constructFuncDef() throws RecognitionException {
		ConstructFuncDefContext _localctx = new ConstructFuncDefContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constructFuncDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(Identifier);
			setState(357);
			match(LeftParen);
			setState(358);
			match(RightParen);
			setState(359);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u016c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5V\n\5\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\5\6a"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\7\3\7\3\b\3\b\3"+
		"\b\5\bs\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0083\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ae\n\t\f\t\16\t\u00b1\13\t"+
		"\3\n\3\n\3\n\3\n\5\n\u00b7\n\n\3\13\3\13\7\13\u00bb\n\13\f\13\16\13\u00be"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ca\n\f\f\f\16\f"+
		"\u00cd\13\f\3\f\3\f\3\f\3\f\5\f\u00d3\n\f\5\f\u00d5\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0\n\r\f\r\16\r\u00e3\13\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00e9\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00f8\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0100\n"+
		"\16\f\16\16\16\u0103\13\16\5\16\u0105\n\16\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\5\20\u010e\n\20\3\21\3\21\3\21\3\21\7\21\u0114\n\21\f\21\16\21"+
		"\u0117\13\21\3\21\3\21\3\22\3\22\7\22\u011d\n\22\f\22\16\22\u0120\13\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012b\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0136\n\25\3\25\3\25\5\25\u013a"+
		"\n\25\3\25\3\25\5\25\u013e\n\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0157\n\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u015f\n\32\f"+
		"\32\16\32\u0162\13\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\2\3"+
		"\20\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\n\4"+
		"\2\66\66;;\3\2#$\3\2\24\25\3\2\30\32\3\2\26\27\3\2()\3\2\33\36\3\2\37"+
		" \2\u0195\2;\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\bU\3\2\2\2\nW\3\2\2\2\fd\3"+
		"\2\2\2\16o\3\2\2\2\20\u0082\3\2\2\2\22\u00b6\3\2\2\2\24\u00b8\3\2\2\2"+
		"\26\u00d4\3\2\2\2\30\u00d6\3\2\2\2\32\u0104\3\2\2\2\34\u0106\3\2\2\2\36"+
		"\u010a\3\2\2\2 \u010f\3\2\2\2\"\u011a\3\2\2\2$\u0123\3\2\2\2&\u012c\3"+
		"\2\2\2(\u0132\3\2\2\2*\u0142\3\2\2\2,\u0144\3\2\2\2.\u0146\3\2\2\2\60"+
		"\u0156\3\2\2\2\62\u0158\3\2\2\2\64\u0166\3\2\2\2\66:\5\30\r\2\67:\5\f"+
		"\7\28:\5\62\32\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2"+
		";<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\2\2\3?\3\3\2\2\2@D\5\6\4\2AD\7\66\2"+
		"\2BD\7;\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EF\t\2\2\2FG\7-\2"+
		"\2GL\7.\2\2HI\7-\2\2IK\7.\2\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2"+
		"M\7\3\2\2\2NL\3\2\2\2OV\7\17\2\2PV\7\20\2\2QV\7<\2\2RV\7=\2\2SV\7\16\2"+
		"\2TV\5\n\6\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2"+
		"\2V\t\3\2\2\2W`\7/\2\2X]\5\b\5\2YZ\7\3\2\2Z\\\5\b\5\2[Y\3\2\2\2\\_\3\2"+
		"\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2\2_]\3\2\2\2`X\3\2\2\2`a\3\2\2\2ab\3\2"+
		"\2\2bc\7\60\2\2c\13\3\2\2\2de\5\4\3\2ej\5\16\b\2fg\7\3\2\2gi\5\16\b\2"+
		"hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\65\2"+
		"\2n\r\3\2\2\2or\7;\2\2pq\7\4\2\2qs\5\20\t\2rp\3\2\2\2rs\3\2\2\2s\17\3"+
		"\2\2\2tu\b\t\1\2u\u0083\5\22\n\2v\u0083\5\24\13\2wx\7+\2\2xy\5\20\t\2"+
		"yz\7,\2\2z\u0083\3\2\2\2{|\t\3\2\2|\u0083\5\20\t\23}~\t\4\2\2~\u0083\5"+
		"\20\t\21\177\u0080\7\27\2\2\u0080\u0083\5\20\t\20\u0081\u0083\5 \21\2"+
		"\u0082t\3\2\2\2\u0082v\3\2\2\2\u0082w\3\2\2\2\u0082{\3\2\2\2\u0082}\3"+
		"\2\2\2\u0082\177\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u00af\3\2\2\2\u0084"+
		"\u0085\f\17\2\2\u0085\u0086\t\5\2\2\u0086\u00ae\5\20\t\20\u0087\u0088"+
		"\f\16\2\2\u0088\u0089\t\6\2\2\u0089\u00ae\5\20\t\17\u008a\u008b\f\r\2"+
		"\2\u008b\u008c\t\7\2\2\u008c\u00ae\5\20\t\16\u008d\u008e\f\f\2\2\u008e"+
		"\u008f\t\b\2\2\u008f\u00ae\5\20\t\r\u0090\u0091\f\13\2\2\u0091\u0092\t"+
		"\t\2\2\u0092\u00ae\5\20\t\f\u0093\u0094\f\n\2\2\u0094\u0095\7%\2\2\u0095"+
		"\u00ae\5\20\t\13\u0096\u0097\f\t\2\2\u0097\u0098\7\'\2\2\u0098\u00ae\5"+
		"\20\t\n\u0099\u009a\f\b\2\2\u009a\u009b\7&\2\2\u009b\u00ae\5\20\t\t\u009c"+
		"\u009d\f\7\2\2\u009d\u009e\7!\2\2\u009e\u00ae\5\20\t\b\u009f\u00a0\f\6"+
		"\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00ae\5\20\t\7\u00a2\u00a3\f\5\2\2\u00a3"+
		"\u00a4\7\5\2\2\u00a4\u00a5\5\20\t\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\5"+
		"\20\t\5\u00a7\u00ae\3\2\2\2\u00a8\u00a9\f\4\2\2\u00a9\u00aa\7\4\2\2\u00aa"+
		"\u00ae\5\20\t\4\u00ab\u00ac\f\22\2\2\u00ac\u00ae\t\4\2\2\u00ad\u0084\3"+
		"\2\2\2\u00ad\u0087\3\2\2\2\u00ad\u008a\3\2\2\2\u00ad\u008d\3\2\2\2\u00ad"+
		"\u0090\3\2\2\2\u00ad\u0093\3\2\2\2\u00ad\u0096\3\2\2\2\u00ad\u0099\3\2"+
		"\2\2\u00ad\u009c\3\2\2\2\u00ad\u009f\3\2\2\2\u00ad\u00a2\3\2\2\2\u00ad"+
		"\u00a8\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\21\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b7"+
		"\7;\2\2\u00b3\u00b7\5\b\5\2\u00b4\u00b7\7\21\2\2\u00b5\u00b7\5\36\20\2"+
		"\u00b6\u00b2\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\23\3\2\2\2\u00b8\u00bc\5\22\n\2\u00b9\u00bb\5\26\f\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\25\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7*\2\2\u00c0\u00d5"+
		"\7;\2\2\u00c1\u00c2\7-\2\2\u00c2\u00c3\5\20\t\2\u00c3\u00c4\7.\2\2\u00c4"+
		"\u00d5\3\2\2\2\u00c5\u00c6\7+\2\2\u00c6\u00cb\5\20\t\2\u00c7\u00c8\7\3"+
		"\2\2\u00c8\u00ca\5\20\t\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00ce\u00cf\7,\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d1\7+\2\2\u00d1\u00d3"+
		"\7,\2\2\u00d2\u00c5\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00bf\3\2\2\2\u00d4\u00c1\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\27\3\2\2"+
		"\2\u00d6\u00d7\5\4\3\2\u00d7\u00e8\7;\2\2\u00d8\u00d9\7+\2\2\u00d9\u00da"+
		"\5\4\3\2\u00da\u00e1\7;\2\2\u00db\u00dc\7\3\2\2\u00dc\u00dd\5\4\3\2\u00dd"+
		"\u00de\7;\2\2\u00de\u00e0\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\u00e3\3\2"+
		"\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e5\7,\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e7\7+\2"+
		"\2\u00e7\u00e9\7,\2\2\u00e8\u00d8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00eb\5\"\22\2\u00eb\31\3\2\2\2\u00ec\u00ed\5\4\3\2\u00ed"+
		"\u00ee\7\4\2\2\u00ee\u00ef\5\n\6\2\u00ef\u0105\3\2\2\2\u00f0\u00f7\5\4"+
		"\3\2\u00f1\u00f2\7-\2\2\u00f2\u00f3\5\20\t\2\u00f3\u00f4\7.\2\2\u00f4"+
		"\u00f8\3\2\2\2\u00f5\u00f6\7-\2\2\u00f6\u00f8\7.\2\2\u00f7\u00f1\3\2\2"+
		"\2\u00f7\u00f5\3\2\2\2\u00f8\u0101\3\2\2\2\u00f9\u00fa\7-\2\2\u00fa\u00fb"+
		"\5\20\t\2\u00fb\u00fc\7.\2\2\u00fc\u0100\3\2\2\2\u00fd\u00fe\7-\2\2\u00fe"+
		"\u0100\7.\2\2\u00ff\u00f9\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0104\u00ec\3\2\2\2\u0104\u00f0\3\2\2\2\u0105\33\3\2\2"+
		"\2\u0106\u0107\7;\2\2\u0107\u0108\7+\2\2\u0108\u0109\7,\2\2\u0109\35\3"+
		"\2\2\2\u010a\u010d\7\f\2\2\u010b\u010e\5\32\16\2\u010c\u010e\5\34\17\2"+
		"\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\37\3\2\2\2\u010f\u0110"+
		"\7>\2\2\u0110\u0115\5\20\t\2\u0111\u0112\7?\2\2\u0112\u0114\5\20\t\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7@\2\2\u0119"+
		"!\3\2\2\2\u011a\u011e\7/\2\2\u011b\u011d\5\60\31\2\u011c\u011b\3\2\2\2"+
		"\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\60\2\2\u0122#\3\2\2\2\u0123"+
		"\u0124\7\7\2\2\u0124\u0125\7+\2\2\u0125\u0126\5\20\t\2\u0126\u0127\7,"+
		"\2\2\u0127\u012a\5\60\31\2\u0128\u0129\7\b\2\2\u0129\u012b\5\60\31\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b%\3\2\2\2\u012c\u012d\7\23\2\2"+
		"\u012d\u012e\7+\2\2\u012e\u012f\5\20\t\2\u012f\u0130\7,\2\2\u0130\u0131"+
		"\5\60\31\2\u0131\'\3\2\2\2\u0132\u0133\7\22\2\2\u0133\u0135\7+\2\2\u0134"+
		"\u0136\5\20\t\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3"+
		"\2\2\2\u0137\u0139\7\65\2\2\u0138\u013a\5\20\t\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\7\65\2\2\u013c\u013e\5"+
		"\20\t\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\7,\2\2\u0140\u0141\5\60\31\2\u0141)\3\2\2\2\u0142\u0143\7\n\2\2"+
		"\u0143+\3\2\2\2\u0144\u0145\7\13\2\2\u0145-\3\2\2\2\u0146\u0147\7\t\2"+
		"\2\u0147\u0148\5\20\t\2\u0148/\3\2\2\2\u0149\u0157\5\"\22\2\u014a\u0157"+
		"\5\f\7\2\u014b\u0157\5\62\32\2\u014c\u0157\5$\23\2\u014d\u0157\5*\26\2"+
		"\u014e\u0157\5,\27\2\u014f\u0157\5.\30\2\u0150\u0157\5&\24\2\u0151\u0157"+
		"\5(\25\2\u0152\u0153\5\20\t\2\u0153\u0154\7\65\2\2\u0154\u0157\3\2\2\2"+
		"\u0155\u0157\7\65\2\2\u0156\u0149\3\2\2\2\u0156\u014a\3\2\2\2\u0156\u014b"+
		"\3\2\2\2\u0156\u014c\3\2\2\2\u0156\u014d\3\2\2\2\u0156\u014e\3\2\2\2\u0156"+
		"\u014f\3\2\2\2\u0156\u0150\3\2\2\2\u0156\u0151\3\2\2\2\u0156\u0152\3\2"+
		"\2\2\u0156\u0155\3\2\2\2\u0157\61\3\2\2\2\u0158\u0159\7\r\2\2\u0159\u015a"+
		"\7;\2\2\u015a\u0160\7/\2\2\u015b\u015f\5\f\7\2\u015c\u015f\5\30\r\2\u015d"+
		"\u015f\5\64\33\2\u015e\u015b\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015d\3"+
		"\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0163\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\7\60\2\2\u0164\u0165\7"+
		"\65\2\2\u0165\63\3\2\2\2\u0166\u0167\7;\2\2\u0167\u0168\7+\2\2\u0168\u0169"+
		"\7,\2\2\u0169\u016a\5\"\22\2\u016a\65\3\2\2\2#9;CLU]`jr\u0082\u00ad\u00af"+
		"\u00b6\u00bc\u00cb\u00d2\u00d4\u00e1\u00e8\u00f7\u00ff\u0101\u0104\u010d"+
		"\u0115\u011e\u012a\u0135\u0139\u013d\u0156\u015e\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}