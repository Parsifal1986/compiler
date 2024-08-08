// Generated from /root/repository/compiler/src/Parser/Mx.g4 by ANTLR 4.9.3
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "If", "Else", "Return", "Break", "Continue", 
			"New", "Class", "Null", "True", "False", "This", "For", "While", "Inc", 
			"Dec", "Plus", "Minus", "Multi", "Div", "Mod", "Less", "Greater", "LessEqual", 
			"GreaterEqual", "Equal", "NotEqual", "And", "Or", "Not", "BitNot", "BitAnd", 
			"BitOr", "BitXor", "LeftShift", "RightShift", "Dot", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Whitespace", 
			"Newline", "BlockComment", "LineComment", "Semi", "BasicType", "Void", 
			"Bool", "Int", "String", "Identifier", "DemicalConst", "PositiveConst", 
			"StringConst", "EscapeChar", "FstringHead", "FstringBody", "FstringTail", 
			"Fstring", "Printable", "FPrintable"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 56:
			Identifier_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
			StringConst_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void Identifier_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			  if (getText().length() > 64) {
			    throw new RuntimeException("Identifier too long:" + getText());
			  }

			break;
		}
	}
	private void StringConst_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			  if (getText().length() > 257) {
			    throw new RuntimeException("String Const too long:" + getText());
			  }

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01a5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\6\60\u011e\n\60\r\60\16\60\u011f"+
		"\3\60\3\60\3\61\3\61\5\61\u0126\n\61\3\61\5\61\u0129\n\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\62\7\62\u0131\n\62\f\62\16\62\u0134\13\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u013f\n\63\f\63\16\63\u0142\13"+
		"\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\5\65\u014c\n\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\3"+
		"9\39\3:\3:\7:\u0165\n:\f:\16:\u0168\13:\3:\3:\3;\3;\5;\u016e\n;\3<\3<"+
		"\7<\u0172\n<\f<\16<\u0175\13<\3=\3=\3=\7=\u017a\n=\f=\16=\u017d\13=\3"+
		"=\3=\3=\3>\3>\3>\3>\3>\3>\5>\u0188\n>\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3"+
		"A\3A\3A\3A\3B\3B\7B\u019a\nB\fB\16B\u019d\13B\3C\3C\3D\3D\3D\5D\u01a4"+
		"\nD\3\u0132\2E\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\67m8o9q:s;u<w\2y={\2}>\177?\u0081@\u0083\2\u0085\2\u0087\2\3"+
		"\2\n\4\2\13\13\"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62"+
		";\6\2\f\f\17\17$$^^\7\2\f\f\17\17$$&&^^\2\u01b1\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3"+
		"\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u008d\3\2\2\2\t\u008f\3\2\2\2"+
		"\13\u0091\3\2\2\2\r\u0094\3\2\2\2\17\u0099\3\2\2\2\21\u00a0\3\2\2\2\23"+
		"\u00a6\3\2\2\2\25\u00af\3\2\2\2\27\u00b3\3\2\2\2\31\u00b9\3\2\2\2\33\u00be"+
		"\3\2\2\2\35\u00c3\3\2\2\2\37\u00c9\3\2\2\2!\u00ce\3\2\2\2#\u00d2\3\2\2"+
		"\2%\u00d8\3\2\2\2\'\u00db\3\2\2\2)\u00de\3\2\2\2+\u00e0\3\2\2\2-\u00e2"+
		"\3\2\2\2/\u00e4\3\2\2\2\61\u00e6\3\2\2\2\63\u00e8\3\2\2\2\65\u00ea\3\2"+
		"\2\2\67\u00ec\3\2\2\29\u00ef\3\2\2\2;\u00f2\3\2\2\2=\u00f5\3\2\2\2?\u00f8"+
		"\3\2\2\2A\u00fb\3\2\2\2C\u00fe\3\2\2\2E\u0100\3\2\2\2G\u0102\3\2\2\2I"+
		"\u0104\3\2\2\2K\u0106\3\2\2\2M\u0108\3\2\2\2O\u010b\3\2\2\2Q\u010e\3\2"+
		"\2\2S\u0110\3\2\2\2U\u0112\3\2\2\2W\u0114\3\2\2\2Y\u0116\3\2\2\2[\u0118"+
		"\3\2\2\2]\u011a\3\2\2\2_\u011d\3\2\2\2a\u0128\3\2\2\2c\u012c\3\2\2\2e"+
		"\u013a\3\2\2\2g\u0145\3\2\2\2i\u014b\3\2\2\2k\u014d\3\2\2\2m\u0152\3\2"+
		"\2\2o\u0157\3\2\2\2q\u015b\3\2\2\2s\u0162\3\2\2\2u\u016d\3\2\2\2w\u016f"+
		"\3\2\2\2y\u0176\3\2\2\2{\u0187\3\2\2\2}\u0189\3\2\2\2\177\u018f\3\2\2"+
		"\2\u0081\u0193\3\2\2\2\u0083\u019b\3\2\2\2\u0085\u019e\3\2\2\2\u0087\u01a3"+
		"\3\2\2\2\u0089\u008a\7.\2\2\u008a\4\3\2\2\2\u008b\u008c\7?\2\2\u008c\6"+
		"\3\2\2\2\u008d\u008e\7A\2\2\u008e\b\3\2\2\2\u008f\u0090\7<\2\2\u0090\n"+
		"\3\2\2\2\u0091\u0092\7k\2\2\u0092\u0093\7h\2\2\u0093\f\3\2\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098"+
		"\16\3\2\2\2\u0099\u009a\7t\2\2\u009a\u009b\7g\2\2\u009b\u009c\7v\2\2\u009c"+
		"\u009d\7w\2\2\u009d\u009e\7t\2\2\u009e\u009f\7p\2\2\u009f\20\3\2\2\2\u00a0"+
		"\u00a1\7d\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7c\2\2"+
		"\u00a4\u00a5\7m\2\2\u00a5\22\3\2\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7"+
		"q\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac"+
		"\7p\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7g\2\2\u00ae\24\3\2\2\2\u00af\u00b0"+
		"\7p\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7y\2\2\u00b2\26\3\2\2\2\u00b3\u00b4"+
		"\7e\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7u\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7w\2\2\u00bb"+
		"\u00bc\7n\2\2\u00bc\u00bd\7n\2\2\u00bd\32\3\2\2\2\u00be\u00bf\7v\2\2\u00bf"+
		"\u00c0\7t\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7g\2\2\u00c2\34\3\2\2\2\u00c3"+
		"\u00c4\7h\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7u\2\2"+
		"\u00c7\u00c8\7g\2\2\u00c8\36\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7"+
		"j\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7u\2\2\u00cd \3\2\2\2\u00ce\u00cf"+
		"\7h\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7t\2\2\u00d1\"\3\2\2\2\u00d2\u00d3"+
		"\7y\2\2\u00d3\u00d4\7j\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7n\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7$\3\2\2\2\u00d8\u00d9\7-\2\2\u00d9\u00da\7-\2\2\u00da"+
		"&\3\2\2\2\u00db\u00dc\7/\2\2\u00dc\u00dd\7/\2\2\u00dd(\3\2\2\2\u00de\u00df"+
		"\7-\2\2\u00df*\3\2\2\2\u00e0\u00e1\7/\2\2\u00e1,\3\2\2\2\u00e2\u00e3\7"+
		",\2\2\u00e3.\3\2\2\2\u00e4\u00e5\7\61\2\2\u00e5\60\3\2\2\2\u00e6\u00e7"+
		"\7\'\2\2\u00e7\62\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9\64\3\2\2\2\u00ea\u00eb"+
		"\7@\2\2\u00eb\66\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00ee\7?\2\2\u00ee8"+
		"\3\2\2\2\u00ef\u00f0\7@\2\2\u00f0\u00f1\7?\2\2\u00f1:\3\2\2\2\u00f2\u00f3"+
		"\7?\2\2\u00f3\u00f4\7?\2\2\u00f4<\3\2\2\2\u00f5\u00f6\7#\2\2\u00f6\u00f7"+
		"\7?\2\2\u00f7>\3\2\2\2\u00f8\u00f9\7(\2\2\u00f9\u00fa\7(\2\2\u00fa@\3"+
		"\2\2\2\u00fb\u00fc\7~\2\2\u00fc\u00fd\7~\2\2\u00fdB\3\2\2\2\u00fe\u00ff"+
		"\7#\2\2\u00ffD\3\2\2\2\u0100\u0101\7\u0080\2\2\u0101F\3\2\2\2\u0102\u0103"+
		"\7(\2\2\u0103H\3\2\2\2\u0104\u0105\7~\2\2\u0105J\3\2\2\2\u0106\u0107\7"+
		"`\2\2\u0107L\3\2\2\2\u0108\u0109\7>\2\2\u0109\u010a\7>\2\2\u010aN\3\2"+
		"\2\2\u010b\u010c\7@\2\2\u010c\u010d\7@\2\2\u010dP\3\2\2\2\u010e\u010f"+
		"\7\60\2\2\u010fR\3\2\2\2\u0110\u0111\7*\2\2\u0111T\3\2\2\2\u0112\u0113"+
		"\7+\2\2\u0113V\3\2\2\2\u0114\u0115\7]\2\2\u0115X\3\2\2\2\u0116\u0117\7"+
		"_\2\2\u0117Z\3\2\2\2\u0118\u0119\7}\2\2\u0119\\\3\2\2\2\u011a\u011b\7"+
		"\177\2\2\u011b^\3\2\2\2\u011c\u011e\t\2\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\b\60\2\2\u0122`\3\2\2\2\u0123\u0125\7\17\2\2\u0124\u0126"+
		"\7\f\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0129\7\f\2\2\u0128\u0123\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2"+
		"\2\2\u012a\u012b\b\61\2\2\u012bb\3\2\2\2\u012c\u012d\7\61\2\2\u012d\u012e"+
		"\7,\2\2\u012e\u0132\3\2\2\2\u012f\u0131\13\2\2\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7,\2\2\u0136\u0137\7\61\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\b\62\2\2\u0139d\3\2\2\2\u013a\u013b\7\61\2"+
		"\2\u013b\u013c\7\61\2\2\u013c\u0140\3\2\2\2\u013d\u013f\n\3\2\2\u013e"+
		"\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\b\63\2\2\u0144"+
		"f\3\2\2\2\u0145\u0146\7=\2\2\u0146h\3\2\2\2\u0147\u014c\5k\66\2\u0148"+
		"\u014c\5m\67\2\u0149\u014c\5o8\2\u014a\u014c\5q9\2\u014b\u0147\3\2\2\2"+
		"\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014cj\3"+
		"\2\2\2\u014d\u014e\7x\2\2\u014e\u014f\7q\2\2\u014f\u0150\7k\2\2\u0150"+
		"\u0151\7f\2\2\u0151l\3\2\2\2\u0152\u0153\7d\2\2\u0153\u0154\7q\2\2\u0154"+
		"\u0155\7q\2\2\u0155\u0156\7n\2\2\u0156n\3\2\2\2\u0157\u0158\7k\2\2\u0158"+
		"\u0159\7p\2\2\u0159\u015a\7v\2\2\u015ap\3\2\2\2\u015b\u015c\7u\2\2\u015c"+
		"\u015d\7v\2\2\u015d\u015e\7t\2\2\u015e\u015f\7k\2\2\u015f\u0160\7p\2\2"+
		"\u0160\u0161\7i\2\2\u0161r\3\2\2\2\u0162\u0166\t\4\2\2\u0163\u0165\t\5"+
		"\2\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\b:"+
		"\3\2\u016at\3\2\2\2\u016b\u016e\5w<\2\u016c\u016e\7\62\2\2\u016d\u016b"+
		"\3\2\2\2\u016d\u016c\3\2\2\2\u016ev\3\2\2\2\u016f\u0173\t\6\2\2\u0170"+
		"\u0172\t\7\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0173\u0174\3\2\2\2\u0174x\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u017b"+
		"\7$\2\2\u0177\u017a\5\u0085C\2\u0178\u017a\5{>\2\u0179\u0177\3\2\2\2\u0179"+
		"\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u017f\7$\2\2\u017f"+
		"\u0180\b=\4\2\u0180z\3\2\2\2\u0181\u0182\7^\2\2\u0182\u0188\7^\2\2\u0183"+
		"\u0184\7^\2\2\u0184\u0188\7p\2\2\u0185\u0186\7^\2\2\u0186\u0188\7$\2\2"+
		"\u0187\u0181\3\2\2\2\u0187\u0183\3\2\2\2\u0187\u0185\3\2\2\2\u0188|\3"+
		"\2\2\2\u0189\u018a\7h\2\2\u018a\u018b\7$\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018d\5\u0083B\2\u018d\u018e\7&\2\2\u018e~\3\2\2\2\u018f\u0190\7&\2\2"+
		"\u0190\u0191\5\u0083B\2\u0191\u0192\7&\2\2\u0192\u0080\3\2\2\2\u0193\u0194"+
		"\7&\2\2\u0194\u0195\5\u0083B\2\u0195\u0196\7$\2\2\u0196\u0082\3\2\2\2"+
		"\u0197\u019a\5\u0087D\2\u0198\u019a\5{>\2\u0199\u0197\3\2\2\2\u0199\u0198"+
		"\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u0084\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u019f\n\b\2\2\u019f\u0086\3\2"+
		"\2\2\u01a0\u01a4\n\t\2\2\u01a1\u01a2\7&\2\2\u01a2\u01a4\7&\2\2\u01a3\u01a0"+
		"\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u0088\3\2\2\2\22\2\u011f\u0125\u0128"+
		"\u0132\u0140\u014b\u0166\u016d\u0173\u0179\u017b\u0187\u0199\u019b\u01a3"+
		"\5\b\2\2\3:\2\3=\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}