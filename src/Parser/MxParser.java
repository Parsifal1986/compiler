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
		RULE_program = 0, RULE_declaration = 1, RULE_type = 2, RULE_array = 3, 
		RULE_constType = 4, RULE_arrayConst = 5, RULE_varDef = 6, RULE_assign = 7, 
		RULE_expression = 8, RULE_primary = 9, RULE_parenExp = 10, RULE_suffix = 11, 
		RULE_suffixcontent = 12, RULE_funcDef = 13, RULE_arrayInitialize = 14, 
		RULE_classInitialize = 15, RULE_newexp = 16, RULE_fstring = 17, RULE_suite = 18, 
		RULE_condition = 19, RULE_whileRule = 20, RULE_forRule = 21, RULE_breakRule = 22, 
		RULE_continueRule = 23, RULE_returnRule = 24, RULE_statement = 25, RULE_classDef = 26, 
		RULE_constructFuncDef = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "type", "array", "constType", "arrayConst", 
			"varDef", "assign", "expression", "primary", "parenExp", "suffix", "suffixcontent", 
			"funcDef", "arrayInitialize", "classInitialize", "newexp", "fstring", 
			"suite", "condition", "whileRule", "forRule", "breakRule", "continueRule", 
			"returnRule", "statement", "classDef", "constructFuncDef"
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
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Class) | (1L << BasicType) | (1L << Identifier))) != 0)) {
				{
				{
				setState(56);
				declaration();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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

	public static class DeclarationContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				funcDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				varDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				classDef();
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
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(BasicType);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
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
		enterRule(_localctx, 6, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==BasicType || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(LeftBracket);
			setState(76);
			match(RightBracket);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					match(LeftBracket);
					setState(78);
					match(RightBracket);
					}
					} 
				}
				setState(83);
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
		enterRule(_localctx, 8, RULE_constType);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case True:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(True);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(False);
				}
				break;
			case DemicalConst:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(DemicalConst);
				}
				break;
			case StringConst:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				match(StringConst);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(Null);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
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
		enterRule(_localctx, 10, RULE_arrayConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(LeftBrace);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << LeftBrace) | (1L << DemicalConst) | (1L << StringConst))) != 0)) {
				{
				setState(93);
				constType();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(94);
					match(T__0);
					setState(95);
					constType();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(103);
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
		enterRule(_localctx, 12, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			type();
			setState(106);
			assign();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(107);
				match(T__0);
				setState(108);
				assign();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
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
		enterRule(_localctx, 14, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(Identifier);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(117);
				match(T__1);
				setState(118);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(122);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new SuffixExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				suffix();
				}
				break;
			case 3:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==Not || _la==BitNot) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
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
				setState(127);
				expression(15);
				}
				break;
			case 5:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(128);
				match(Minus);
				}
				setState(129);
				expression(14);
				}
				break;
			case 6:
				{
				_localctx = new FstringExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				fstring();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(134);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multi) | (1L << Div) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(135);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(136);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(137);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(138);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(140);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(141);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(143);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << Greater) | (1L << LessEqual) | (1L << GreaterEqual))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(144);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(146);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(149);
						match(BitAnd);
						}
						setState(150);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(152);
						match(BitXor);
						}
						setState(153);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(155);
						match(BitOr);
						}
						setState(156);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(158);
						match(And);
						}
						setState(159);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(161);
						match(Or);
						}
						setState(162);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new TernaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(164);
						match(T__2);
						}
						setState(165);
						expression(0);
						{
						setState(166);
						match(T__3);
						}
						setState(167);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new AssignExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(170);
						match(T__1);
						}
						setState(171);
						expression(2);
						}
						break;
					case 13:
						{
						_localctx = new UnaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(173);
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
				setState(178);
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
		public ParenExpContext parenExp() {
			return getRuleContext(ParenExpContext.class,0);
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
		enterRule(_localctx, 18, RULE_primary);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
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
				setState(180);
				constType();
				}
				break;
			case This:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(This);
				}
				break;
			case New:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				newexp();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				parenExp();
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

	public static class ParenExpContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParenExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExp; }
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

	public final ParenExpContext parenExp() throws RecognitionException {
		ParenExpContext _localctx = new ParenExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parenExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(LeftParen);
			setState(187);
			expression(0);
			setState(188);
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
		enterRule(_localctx, 22, RULE_suffix);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			primary();
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					suffixcontent();
					}
					} 
				}
				setState(196);
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
		enterRule(_localctx, 24, RULE_suffixcontent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dot:
				{
				setState(197);
				match(Dot);
				setState(198);
				match(Identifier);
				}
				break;
			case LeftBracket:
				{
				setState(199);
				match(LeftBracket);
				setState(200);
				expression(0);
				setState(201);
				match(RightBracket);
				}
				break;
			case LeftParen:
				{
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(203);
					match(LeftParen);
					{
					setState(204);
					expression(0);
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(205);
						match(T__0);
						setState(206);
						expression(0);
						}
						}
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(212);
					match(RightParen);
					}
					break;
				case 2:
					{
					setState(214);
					match(LeftParen);
					setState(215);
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
		enterRule(_localctx, 26, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((FuncDefContext)_localctx).retType = type();
			setState(221);
			((FuncDefContext)_localctx).funcName = match(Identifier);
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(222);
				match(LeftParen);
				{
				setState(223);
				type();
				setState(224);
				match(Identifier);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(225);
					match(T__0);
					setState(226);
					type();
					setState(227);
					match(Identifier);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(234);
				match(RightParen);
				}
				break;
			case 2:
				{
				setState(236);
				match(LeftParen);
				setState(237);
				match(RightParen);
				}
				break;
			}
			setState(240);
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
		enterRule(_localctx, 28, RULE_arrayInitialize);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				{
				setState(242);
				type();
				setState(243);
				match(T__1);
				setState(244);
				arrayConst();
				}
				}
				break;
			case 2:
				{
				{
				setState(246);
				type();
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
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
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(261);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
						case 1:
							{
							setState(255);
							match(LeftBracket);
							setState(256);
							expression(0);
							setState(257);
							match(RightBracket);
							}
							break;
						case 2:
							{
							setState(259);
							match(LeftBracket);
							setState(260);
							match(RightBracket);
							}
							break;
						}
						} 
					}
					setState(265);
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
		enterRule(_localctx, 30, RULE_classInitialize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(Identifier);
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(269);
				match(LeftParen);
				setState(270);
				match(RightParen);
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
		enterRule(_localctx, 32, RULE_newexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(New);
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(274);
				arrayInitialize();
				}
				break;
			case 2:
				{
				setState(275);
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
		enterRule(_localctx, 34, RULE_fstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(FstringHead);
			setState(279);
			expression(0);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FstringBody) {
				{
				{
				setState(280);
				match(FstringBody);
				setState(281);
				expression(0);
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
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
		enterRule(_localctx, 36, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LeftBrace);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << New) | (1L << Class) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << For) | (1L << While) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Semi) | (1L << BasicType) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				{
				setState(290);
				statement();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
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
		enterRule(_localctx, 38, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(If);
			setState(299);
			match(LeftParen);
			setState(300);
			((ConditionContext)_localctx).conditionExp = expression(0);
			setState(301);
			match(RightParen);
			setState(302);
			((ConditionContext)_localctx).trueStmt = statement();
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(303);
				match(Else);
				setState(304);
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
		enterRule(_localctx, 40, RULE_whileRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(While);
			setState(308);
			match(LeftParen);
			setState(309);
			((WhileRuleContext)_localctx).conditionExp = expression(0);
			setState(310);
			match(RightParen);
			setState(311);
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
		enterRule(_localctx, 42, RULE_forRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(For);
			setState(314);
			match(LeftParen);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(315);
				((ForRuleContext)_localctx).initExpr = expression(0);
				}
			}

			setState(318);
			match(Semi);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(319);
				((ForRuleContext)_localctx).condExpr = expression(0);
				}
			}

			setState(322);
			match(Semi);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(323);
				((ForRuleContext)_localctx).stepExpr = expression(0);
				}
			}

			setState(326);
			match(RightParen);
			setState(327);
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
		enterRule(_localctx, 44, RULE_breakRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
		enterRule(_localctx, 46, RULE_continueRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
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
		enterRule(_localctx, 48, RULE_returnRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(Return);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Inc) | (1L << Dec) | (1L << Minus) | (1L << Not) | (1L << BitNot) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Identifier) | (1L << DemicalConst) | (1L << StringConst) | (1L << FstringHead))) != 0)) {
				{
				setState(334);
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		enterRule(_localctx, 50, RULE_statement);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new SuiteStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				suite();
				}
				break;
			case 2:
				_localctx = new VarDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				varDef();
				}
				break;
			case 3:
				_localctx = new ClassDefStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				classDef();
				}
				break;
			case 4:
				_localctx = new ConditionStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				condition();
				}
				break;
			case 5:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				breakRule();
				setState(342);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(344);
				continueRule();
				setState(345);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(347);
				returnRule();
				setState(348);
				match(Semi);
				}
				break;
			case 8:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(350);
				whileRule();
				}
				break;
			case 9:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(351);
				forRule();
				}
				break;
			case 10:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(352);
				expression(0);
				setState(353);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(355);
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
		enterRule(_localctx, 52, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(Class);
			setState(359);
			((ClassDefContext)_localctx).classname = match(Identifier);
			setState(360);
			match(LeftBrace);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BasicType || _la==Identifier) {
				{
				setState(364);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(361);
					varDef();
					}
					break;
				case 2:
					{
					setState(362);
					funcDef();
					}
					break;
				case 3:
					{
					setState(363);
					constructFuncDef();
					}
					break;
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(369);
			match(RightBrace);
			setState(370);
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
		enterRule(_localctx, 54, RULE_constructFuncDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(Identifier);
			setState(373);
			match(LeftParen);
			setState(374);
			match(RightParen);
			setState(375);
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
		case 8:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u017c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\3\5\7"+
		"\5R\n\5\f\5\16\5U\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3"+
		"\7\7\7c\n\7\f\7\16\7f\13\7\5\7h\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bp\n\b\f"+
		"\b\16\bs\13\b\3\b\3\b\3\t\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0086\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b1\n\n\f\n\16"+
		"\n\u00b4\13\n\3\13\3\13\3\13\3\13\3\13\5\13\u00bb\n\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\7\r\u00c3\n\r\f\r\16\r\u00c6\13\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00d2\n\16\f\16\16\16\u00d5\13\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00db\n\16\5\16\u00dd\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00e8\n\17\f\17\16\17\u00eb\13\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00f1\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0100\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u0108\n\20\f\20\16\20\u010b\13\20\5\20\u010d\n\20\3\21\3\21\3\21\5\21"+
		"\u0112\n\21\3\22\3\22\3\22\5\22\u0117\n\22\3\23\3\23\3\23\3\23\7\23\u011d"+
		"\n\23\f\23\16\23\u0120\13\23\3\23\3\23\3\24\3\24\7\24\u0126\n\24\f\24"+
		"\16\24\u0129\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0134"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u013f\n\27\3\27"+
		"\3\27\5\27\u0143\n\27\3\27\3\27\5\27\u0147\n\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\5\32\u0152\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u0167\n\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u016f\n\34\f\34\16\34\u0172"+
		"\13\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\2\3\22\36\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\n\4\2\66\66;;"+
		"\3\2#$\3\2\24\25\3\2\30\32\3\2\26\27\3\2()\3\2\33\36\3\2\37 \2\u01a5\2"+
		"=\3\2\2\2\4E\3\2\2\2\6J\3\2\2\2\bL\3\2\2\2\n\\\3\2\2\2\f^\3\2\2\2\16k"+
		"\3\2\2\2\20v\3\2\2\2\22\u0085\3\2\2\2\24\u00ba\3\2\2\2\26\u00bc\3\2\2"+
		"\2\30\u00c0\3\2\2\2\32\u00dc\3\2\2\2\34\u00de\3\2\2\2\36\u010c\3\2\2\2"+
		" \u010e\3\2\2\2\"\u0113\3\2\2\2$\u0118\3\2\2\2&\u0123\3\2\2\2(\u012c\3"+
		"\2\2\2*\u0135\3\2\2\2,\u013b\3\2\2\2.\u014b\3\2\2\2\60\u014d\3\2\2\2\62"+
		"\u014f\3\2\2\2\64\u0166\3\2\2\2\66\u0168\3\2\2\28\u0176\3\2\2\2:<\5\4"+
		"\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2"+
		"\2\3A\3\3\2\2\2BF\5\34\17\2CF\5\16\b\2DF\5\66\34\2EB\3\2\2\2EC\3\2\2\2"+
		"ED\3\2\2\2F\5\3\2\2\2GK\5\b\5\2HK\7\66\2\2IK\7;\2\2JG\3\2\2\2JH\3\2\2"+
		"\2JI\3\2\2\2K\7\3\2\2\2LM\t\2\2\2MN\7-\2\2NS\7.\2\2OP\7-\2\2PR\7.\2\2"+
		"QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\t\3\2\2\2US\3\2\2\2V]\7\17\2"+
		"\2W]\7\20\2\2X]\7<\2\2Y]\7=\2\2Z]\7\16\2\2[]\5\f\7\2\\V\3\2\2\2\\W\3\2"+
		"\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\13\3\2\2\2^g\7/\2\2"+
		"_d\5\n\6\2`a\7\3\2\2ac\5\n\6\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2"+
		"eh\3\2\2\2fd\3\2\2\2g_\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\60\2\2j\r\3\2\2"+
		"\2kl\5\6\4\2lq\5\20\t\2mn\7\3\2\2np\5\20\t\2om\3\2\2\2ps\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\65\2\2u\17\3\2\2\2vy\7;\2\2wx\7"+
		"\4\2\2xz\5\22\n\2yw\3\2\2\2yz\3\2\2\2z\21\3\2\2\2{|\b\n\1\2|\u0086\5\24"+
		"\13\2}\u0086\5\30\r\2~\177\t\3\2\2\177\u0086\5\22\n\23\u0080\u0081\t\4"+
		"\2\2\u0081\u0086\5\22\n\21\u0082\u0083\7\27\2\2\u0083\u0086\5\22\n\20"+
		"\u0084\u0086\5$\23\2\u0085{\3\2\2\2\u0085}\3\2\2\2\u0085~\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u00b2\3\2"+
		"\2\2\u0087\u0088\f\17\2\2\u0088\u0089\t\5\2\2\u0089\u00b1\5\22\n\20\u008a"+
		"\u008b\f\16\2\2\u008b\u008c\t\6\2\2\u008c\u00b1\5\22\n\17\u008d\u008e"+
		"\f\r\2\2\u008e\u008f\t\7\2\2\u008f\u00b1\5\22\n\16\u0090\u0091\f\f\2\2"+
		"\u0091\u0092\t\b\2\2\u0092\u00b1\5\22\n\r\u0093\u0094\f\13\2\2\u0094\u0095"+
		"\t\t\2\2\u0095\u00b1\5\22\n\f\u0096\u0097\f\n\2\2\u0097\u0098\7%\2\2\u0098"+
		"\u00b1\5\22\n\13\u0099\u009a\f\t\2\2\u009a\u009b\7\'\2\2\u009b\u00b1\5"+
		"\22\n\n\u009c\u009d\f\b\2\2\u009d\u009e\7&\2\2\u009e\u00b1\5\22\n\t\u009f"+
		"\u00a0\f\7\2\2\u00a0\u00a1\7!\2\2\u00a1\u00b1\5\22\n\b\u00a2\u00a3\f\6"+
		"\2\2\u00a3\u00a4\7\"\2\2\u00a4\u00b1\5\22\n\7\u00a5\u00a6\f\5\2\2\u00a6"+
		"\u00a7\7\5\2\2\u00a7\u00a8\5\22\n\2\u00a8\u00a9\7\6\2\2\u00a9\u00aa\5"+
		"\22\n\5\u00aa\u00b1\3\2\2\2\u00ab\u00ac\f\4\2\2\u00ac\u00ad\7\4\2\2\u00ad"+
		"\u00b1\5\22\n\4\u00ae\u00af\f\22\2\2\u00af\u00b1\t\4\2\2\u00b0\u0087\3"+
		"\2\2\2\u00b0\u008a\3\2\2\2\u00b0\u008d\3\2\2\2\u00b0\u0090\3\2\2\2\u00b0"+
		"\u0093\3\2\2\2\u00b0\u0096\3\2\2\2\u00b0\u0099\3\2\2\2\u00b0\u009c\3\2"+
		"\2\2\u00b0\u009f\3\2\2\2\u00b0\u00a2\3\2\2\2\u00b0\u00a5\3\2\2\2\u00b0"+
		"\u00ab\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\23\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00bb"+
		"\7;\2\2\u00b6\u00bb\5\n\6\2\u00b7\u00bb\7\21\2\2\u00b8\u00bb\5\"\22\2"+
		"\u00b9\u00bb\5\26\f\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\25\3\2\2\2\u00bc"+
		"\u00bd\7+\2\2\u00bd\u00be\5\22\n\2\u00be\u00bf\7,\2\2\u00bf\27\3\2\2\2"+
		"\u00c0\u00c4\5\24\13\2\u00c1\u00c3\5\32\16\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\31\3\2\2"+
		"\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7*\2\2\u00c8\u00dd\7;\2\2\u00c9\u00ca"+
		"\7-\2\2\u00ca\u00cb\5\22\n\2\u00cb\u00cc\7.\2\2\u00cc\u00dd\3\2\2\2\u00cd"+
		"\u00ce\7+\2\2\u00ce\u00d3\5\22\n\2\u00cf\u00d0\7\3\2\2\u00d0\u00d2\5\22"+
		"\n\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7,"+
		"\2\2\u00d7\u00db\3\2\2\2\u00d8\u00d9\7+\2\2\u00d9\u00db\7,\2\2\u00da\u00cd"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00c7\3\2\2\2\u00dc"+
		"\u00c9\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\33\3\2\2\2\u00de\u00df\5\6\4"+
		"\2\u00df\u00f0\7;\2\2\u00e0\u00e1\7+\2\2\u00e1\u00e2\5\6\4\2\u00e2\u00e9"+
		"\7;\2\2\u00e3\u00e4\7\3\2\2\u00e4\u00e5\5\6\4\2\u00e5\u00e6\7;\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\7,\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00ef\7+\2\2\u00ef\u00f1\7,\2"+
		"\2\u00f0\u00e0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3"+
		"\5&\24\2\u00f3\35\3\2\2\2\u00f4\u00f5\5\6\4\2\u00f5\u00f6\7\4\2\2\u00f6"+
		"\u00f7\5\f\7\2\u00f7\u010d\3\2\2\2\u00f8\u00ff\5\6\4\2\u00f9\u00fa\7-"+
		"\2\2\u00fa\u00fb\5\22\n\2\u00fb\u00fc\7.\2\2\u00fc\u0100\3\2\2\2\u00fd"+
		"\u00fe\7-\2\2\u00fe\u0100\7.\2\2\u00ff\u00f9\3\2\2\2\u00ff\u00fd\3\2\2"+
		"\2\u0100\u0109\3\2\2\2\u0101\u0102\7-\2\2\u0102\u0103\5\22\n\2\u0103\u0104"+
		"\7.\2\2\u0104\u0108\3\2\2\2\u0105\u0106\7-\2\2\u0106\u0108\7.\2\2\u0107"+
		"\u0101\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u00f4\3\2\2\2\u010c\u00f8\3\2\2\2\u010d\37\3\2\2\2\u010e\u0111\7;\2\2"+
		"\u010f\u0110\7+\2\2\u0110\u0112\7,\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112!\3\2\2\2\u0113\u0116\7\f\2\2\u0114\u0117\5\36\20\2\u0115"+
		"\u0117\5 \21\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117#\3\2\2\2"+
		"\u0118\u0119\7>\2\2\u0119\u011e\5\22\n\2\u011a\u011b\7?\2\2\u011b\u011d"+
		"\5\22\n\2\u011c\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122"+
		"\7@\2\2\u0122%\3\2\2\2\u0123\u0127\7/\2\2\u0124\u0126\5\64\33\2\u0125"+
		"\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\60\2\2\u012b"+
		"\'\3\2\2\2\u012c\u012d\7\7\2\2\u012d\u012e\7+\2\2\u012e\u012f\5\22\n\2"+
		"\u012f\u0130\7,\2\2\u0130\u0133\5\64\33\2\u0131\u0132\7\b\2\2\u0132\u0134"+
		"\5\64\33\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134)\3\2\2\2\u0135"+
		"\u0136\7\23\2\2\u0136\u0137\7+\2\2\u0137\u0138\5\22\n\2\u0138\u0139\7"+
		",\2\2\u0139\u013a\5\64\33\2\u013a+\3\2\2\2\u013b\u013c\7\22\2\2\u013c"+
		"\u013e\7+\2\2\u013d\u013f\5\22\n\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0140\3\2\2\2\u0140\u0142\7\65\2\2\u0141\u0143\5\22\n\2\u0142"+
		"\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\7\65"+
		"\2\2\u0145\u0147\5\22\n\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\7,\2\2\u0149\u014a\5\64\33\2\u014a-\3\2\2\2"+
		"\u014b\u014c\7\n\2\2\u014c/\3\2\2\2\u014d\u014e\7\13\2\2\u014e\61\3\2"+
		"\2\2\u014f\u0151\7\t\2\2\u0150\u0152\5\22\n\2\u0151\u0150\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\63\3\2\2\2\u0153\u0167\5&\24\2\u0154\u0167\5\16\b"+
		"\2\u0155\u0167\5\66\34\2\u0156\u0167\5(\25\2\u0157\u0158\5.\30\2\u0158"+
		"\u0159\7\65\2\2\u0159\u0167\3\2\2\2\u015a\u015b\5\60\31\2\u015b\u015c"+
		"\7\65\2\2\u015c\u0167\3\2\2\2\u015d\u015e\5\62\32\2\u015e\u015f\7\65\2"+
		"\2\u015f\u0167\3\2\2\2\u0160\u0167\5*\26\2\u0161\u0167\5,\27\2\u0162\u0163"+
		"\5\22\n\2\u0163\u0164\7\65\2\2\u0164\u0167\3\2\2\2\u0165\u0167\7\65\2"+
		"\2\u0166\u0153\3\2\2\2\u0166\u0154\3\2\2\2\u0166\u0155\3\2\2\2\u0166\u0156"+
		"\3\2\2\2\u0166\u0157\3\2\2\2\u0166\u015a\3\2\2\2\u0166\u015d\3\2\2\2\u0166"+
		"\u0160\3\2\2\2\u0166\u0161\3\2\2\2\u0166\u0162\3\2\2\2\u0166\u0165\3\2"+
		"\2\2\u0167\65\3\2\2\2\u0168\u0169\7\r\2\2\u0169\u016a\7;\2\2\u016a\u0170"+
		"\7/\2\2\u016b\u016f\5\16\b\2\u016c\u016f\5\34\17\2\u016d\u016f\58\35\2"+
		"\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0174\7\60\2\2\u0174\u0175\7\65\2\2\u0175\67\3\2"+
		"\2\2\u0176\u0177\7;\2\2\u0177\u0178\7+\2\2\u0178\u0179\7,\2\2\u0179\u017a"+
		"\5&\24\2\u017a9\3\2\2\2%=EJS\\dgqy\u0085\u00b0\u00b2\u00ba\u00c4\u00d3"+
		"\u00da\u00dc\u00e9\u00f0\u00ff\u0107\u0109\u010c\u0111\u0116\u011e\u0127"+
		"\u0133\u013e\u0142\u0146\u0151\u0166\u016e\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}