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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, If=7, Else=8, Return=9, 
		Break=10, Continue=11, New=12, Class=13, Null=14, True=15, False=16, This=17, 
		For=18, While=19, Inc=20, Dec=21, Plus=22, Minus=23, Multi=24, Div=25, 
		Mod=26, Less=27, Greater=28, LessEqual=29, GreaterEqual=30, Equal=31, 
		NotEqual=32, And=33, Or=34, Not=35, BitNot=36, BitAnd=37, BitOr=38, BitXor=39, 
		LeftShift=40, RightShift=41, Dot=42, LeftParen=43, RightParen=44, LeftBracket=45, 
		RightBracket=46, LeftBrace=47, RightBrace=48, Whitespace=49, Newline=50, 
		BlockComment=51, LineComment=52, Semi=53, Array=54, BasicType=55, Void=56, 
		Bool=57, Int=58, String=59, Identifier=60, Classname=61, DemicalConst=62, 
		StringConst=63, FstringHead=64, FstringBody=65, FstringTail=66;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "If", "Else", "Return", 
			"Break", "Continue", "New", "Class", "Null", "True", "False", "This", 
			"For", "While", "Inc", "Dec", "Plus", "Minus", "Multi", "Div", "Mod", 
			"Less", "Greater", "LessEqual", "GreaterEqual", "Equal", "NotEqual", 
			"And", "Or", "Not", "BitNot", "BitAnd", "BitOr", "BitXor", "LeftShift", 
			"RightShift", "Dot", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Whitespace", "Newline", "BlockComment", "LineComment", 
			"Semi", "Array", "BasicType", "Void", "Bool", "Int", "String", "Identifier", 
			"Classname", "DemicalConst", "PositiveConst", "StringConst", "EscapeChar", 
			"FstringHead", "FstringBody", "FstringTail", "Fstring", "Printable", 
			"FPrintable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'?'", "':'", "'()'", "'[]'", "'if'", "'else'", "'return'", 
			"'break'", "'continue'", "'new'", "'class'", "'null'", "'true'", "'false'", 
			"'this'", "'for'", "'while'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"'!'", "'~'", "'&'", "'|'", "'^'", "'<<'", "'>>'", "'.'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", null, null, null, null, "';'", null, null, 
			"'void'", "'bool'", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "If", "Else", "Return", "Break", 
			"Continue", "New", "Class", "Null", "True", "False", "This", "For", "While", 
			"Inc", "Dec", "Plus", "Minus", "Multi", "Div", "Mod", "Less", "Greater", 
			"LessEqual", "GreaterEqual", "Equal", "NotEqual", "And", "Or", "Not", 
			"BitNot", "BitAnd", "BitOr", "BitXor", "LeftShift", "RightShift", "Dot", 
			"LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
			"RightBrace", "Whitespace", "Newline", "BlockComment", "LineComment", 
			"Semi", "Array", "BasicType", "Void", "Bool", "Int", "String", "Identifier", 
			"Classname", "DemicalConst", "StringConst", "FstringHead", "FstringBody", 
			"FstringTail"
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
		case 59:
			Identifier_action((RuleContext)_localctx, actionIndex);
			break;
		case 63:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u01c3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\6\62\u012c\n\62\r\62\16\62\u012d\3\62\3\62\3"+
		"\63\3\63\5\63\u0134\n\63\3\63\5\63\u0137\n\63\3\63\3\63\3\64\3\64\3\64"+
		"\3\64\7\64\u013f\n\64\f\64\16\64\u0142\13\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\7\65\u014d\n\65\f\65\16\65\u0150\13\65\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\5\67\u0158\n\67\3\67\3\67\3\67\3\67\3\67\7\67\u015f"+
		"\n\67\f\67\16\67\u0162\13\67\38\38\38\38\58\u0168\n8\39\39\39\39\39\3"+
		":\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\7=\u0181\n=\f=\16"+
		"=\u0184\13=\3=\3=\3>\3>\3?\3?\5?\u018c\n?\3@\3@\7@\u0190\n@\f@\16@\u0193"+
		"\13@\3A\3A\3A\7A\u0198\nA\fA\16A\u019b\13A\3A\3A\3A\3B\3B\3B\3B\3B\3B"+
		"\5B\u01a6\nB\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3F\3F\7F\u01b8"+
		"\nF\fF\16F\u01bb\13F\3G\3G\3H\3H\3H\5H\u01c2\nH\3\u0140\2I\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"?}@\177\2\u0081A\u0083\2\u0085B\u0087C\u0089D\u008b\2\u008d\2\u008f\2"+
		"\3\2\n\4\2\13\13\"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2"+
		"\62;\6\2\f\f\17\17$$^^\7\2\f\f\17\17$$&&^^\2\u01d1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\u0081\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\3\u0091"+
		"\3\2\2\2\5\u0093\3\2\2\2\7\u0095\3\2\2\2\t\u0097\3\2\2\2\13\u0099\3\2"+
		"\2\2\r\u009c\3\2\2\2\17\u009f\3\2\2\2\21\u00a2\3\2\2\2\23\u00a7\3\2\2"+
		"\2\25\u00ae\3\2\2\2\27\u00b4\3\2\2\2\31\u00bd\3\2\2\2\33\u00c1\3\2\2\2"+
		"\35\u00c7\3\2\2\2\37\u00cc\3\2\2\2!\u00d1\3\2\2\2#\u00d7\3\2\2\2%\u00dc"+
		"\3\2\2\2\'\u00e0\3\2\2\2)\u00e6\3\2\2\2+\u00e9\3\2\2\2-\u00ec\3\2\2\2"+
		"/\u00ee\3\2\2\2\61\u00f0\3\2\2\2\63\u00f2\3\2\2\2\65\u00f4\3\2\2\2\67"+
		"\u00f6\3\2\2\29\u00f8\3\2\2\2;\u00fa\3\2\2\2=\u00fd\3\2\2\2?\u0100\3\2"+
		"\2\2A\u0103\3\2\2\2C\u0106\3\2\2\2E\u0109\3\2\2\2G\u010c\3\2\2\2I\u010e"+
		"\3\2\2\2K\u0110\3\2\2\2M\u0112\3\2\2\2O\u0114\3\2\2\2Q\u0116\3\2\2\2S"+
		"\u0119\3\2\2\2U\u011c\3\2\2\2W\u011e\3\2\2\2Y\u0120\3\2\2\2[\u0122\3\2"+
		"\2\2]\u0124\3\2\2\2_\u0126\3\2\2\2a\u0128\3\2\2\2c\u012b\3\2\2\2e\u0136"+
		"\3\2\2\2g\u013a\3\2\2\2i\u0148\3\2\2\2k\u0153\3\2\2\2m\u0157\3\2\2\2o"+
		"\u0167\3\2\2\2q\u0169\3\2\2\2s\u016e\3\2\2\2u\u0173\3\2\2\2w\u0177\3\2"+
		"\2\2y\u017e\3\2\2\2{\u0187\3\2\2\2}\u018b\3\2\2\2\177\u018d\3\2\2\2\u0081"+
		"\u0194\3\2\2\2\u0083\u01a5\3\2\2\2\u0085\u01a7\3\2\2\2\u0087\u01ad\3\2"+
		"\2\2\u0089\u01b1\3\2\2\2\u008b\u01b9\3\2\2\2\u008d\u01bc\3\2\2\2\u008f"+
		"\u01c1\3\2\2\2\u0091\u0092\7.\2\2\u0092\4\3\2\2\2\u0093\u0094\7?\2\2\u0094"+
		"\6\3\2\2\2\u0095\u0096\7A\2\2\u0096\b\3\2\2\2\u0097\u0098\7<\2\2\u0098"+
		"\n\3\2\2\2\u0099\u009a\7*\2\2\u009a\u009b\7+\2\2\u009b\f\3\2\2\2\u009c"+
		"\u009d\7]\2\2\u009d\u009e\7_\2\2\u009e\16\3\2\2\2\u009f\u00a0\7k\2\2\u00a0"+
		"\u00a1\7h\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2\u00a4"+
		"\u00a5\7u\2\2\u00a5\u00a6\7g\2\2\u00a6\22\3\2\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7t\2\2"+
		"\u00ac\u00ad\7p\2\2\u00ad\24\3\2\2\2\u00ae\u00af\7d\2\2\u00af\u00b0\7"+
		"t\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7m\2\2\u00b3\26"+
		"\3\2\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7p\2\2\u00b7"+
		"\u00b8\7v\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7w\2\2"+
		"\u00bb\u00bc\7g\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7"+
		"g\2\2\u00bf\u00c0\7y\2\2\u00c0\32\3\2\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3"+
		"\7n\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7u\2\2\u00c6"+
		"\34\3\2\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7n\2\2\u00ca"+
		"\u00cb\7n\2\2\u00cb\36\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7t\2\2\u00ce"+
		"\u00cf\7w\2\2\u00cf\u00d0\7g\2\2\u00d0 \3\2\2\2\u00d1\u00d2\7h\2\2\u00d2"+
		"\u00d3\7c\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7g\2\2"+
		"\u00d6\"\3\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7j\2\2\u00d9\u00da\7k"+
		"\2\2\u00da\u00db\7u\2\2\u00db$\3\2\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de"+
		"\7q\2\2\u00de\u00df\7t\2\2\u00df&\3\2\2\2\u00e0\u00e1\7y\2\2\u00e1\u00e2"+
		"\7j\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7g\2\2\u00e5"+
		"(\3\2\2\2\u00e6\u00e7\7-\2\2\u00e7\u00e8\7-\2\2\u00e8*\3\2\2\2\u00e9\u00ea"+
		"\7/\2\2\u00ea\u00eb\7/\2\2\u00eb,\3\2\2\2\u00ec\u00ed\7-\2\2\u00ed.\3"+
		"\2\2\2\u00ee\u00ef\7/\2\2\u00ef\60\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1\62"+
		"\3\2\2\2\u00f2\u00f3\7\61\2\2\u00f3\64\3\2\2\2\u00f4\u00f5\7\'\2\2\u00f5"+
		"\66\3\2\2\2\u00f6\u00f7\7>\2\2\u00f78\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9"+
		":\3\2\2\2\u00fa\u00fb\7>\2\2\u00fb\u00fc\7?\2\2\u00fc<\3\2\2\2\u00fd\u00fe"+
		"\7@\2\2\u00fe\u00ff\7?\2\2\u00ff>\3\2\2\2\u0100\u0101\7?\2\2\u0101\u0102"+
		"\7?\2\2\u0102@\3\2\2\2\u0103\u0104\7#\2\2\u0104\u0105\7?\2\2\u0105B\3"+
		"\2\2\2\u0106\u0107\7(\2\2\u0107\u0108\7(\2\2\u0108D\3\2\2\2\u0109\u010a"+
		"\7~\2\2\u010a\u010b\7~\2\2\u010bF\3\2\2\2\u010c\u010d\7#\2\2\u010dH\3"+
		"\2\2\2\u010e\u010f\7\u0080\2\2\u010fJ\3\2\2\2\u0110\u0111\7(\2\2\u0111"+
		"L\3\2\2\2\u0112\u0113\7~\2\2\u0113N\3\2\2\2\u0114\u0115\7`\2\2\u0115P"+
		"\3\2\2\2\u0116\u0117\7>\2\2\u0117\u0118\7>\2\2\u0118R\3\2\2\2\u0119\u011a"+
		"\7@\2\2\u011a\u011b\7@\2\2\u011bT\3\2\2\2\u011c\u011d\7\60\2\2\u011dV"+
		"\3\2\2\2\u011e\u011f\7*\2\2\u011fX\3\2\2\2\u0120\u0121\7+\2\2\u0121Z\3"+
		"\2\2\2\u0122\u0123\7]\2\2\u0123\\\3\2\2\2\u0124\u0125\7_\2\2\u0125^\3"+
		"\2\2\2\u0126\u0127\7}\2\2\u0127`\3\2\2\2\u0128\u0129\7\177\2\2\u0129b"+
		"\3\2\2\2\u012a\u012c\t\2\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b\62"+
		"\2\2\u0130d\3\2\2\2\u0131\u0133\7\17\2\2\u0132\u0134\7\f\2\2\u0133\u0132"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0137\7\f\2\2\u0136"+
		"\u0131\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\b\63"+
		"\2\2\u0139f\3\2\2\2\u013a\u013b\7\61\2\2\u013b\u013c\7,\2\2\u013c\u0140"+
		"\3\2\2\2\u013d\u013f\13\2\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2"+
		"\u0140\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0143\u0144\7,\2\2\u0144\u0145\7\61\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\b\64\2\2\u0147h\3\2\2\2\u0148\u0149\7\61\2\2\u0149\u014a\7\61\2"+
		"\2\u014a\u014e\3\2\2\2\u014b\u014d\n\3\2\2\u014c\u014b\3\2\2\2\u014d\u0150"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0152\b\65\2\2\u0152j\3\2\2\2\u0153\u0154\7=\2\2"+
		"\u0154l\3\2\2\2\u0155\u0158\5o8\2\u0156\u0158\5{>\2\u0157\u0155\3\2\2"+
		"\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\7]\2\2\u015a\u015b"+
		"\7_\2\2\u015b\u0160\3\2\2\2\u015c\u015d\7]\2\2\u015d\u015f\7_\2\2\u015e"+
		"\u015c\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161n\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0168\5q9\2\u0164\u0168"+
		"\5s:\2\u0165\u0168\5u;\2\u0166\u0168\5w<\2\u0167\u0163\3\2\2\2\u0167\u0164"+
		"\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168p\3\2\2\2\u0169"+
		"\u016a\7x\2\2\u016a\u016b\7q\2\2\u016b\u016c\7k\2\2\u016c\u016d\7f\2\2"+
		"\u016dr\3\2\2\2\u016e\u016f\7d\2\2\u016f\u0170\7q\2\2\u0170\u0171\7q\2"+
		"\2\u0171\u0172\7n\2\2\u0172t\3\2\2\2\u0173\u0174\7k\2\2\u0174\u0175\7"+
		"p\2\2\u0175\u0176\7v\2\2\u0176v\3\2\2\2\u0177\u0178\7u\2\2\u0178\u0179"+
		"\7v\2\2\u0179\u017a\7t\2\2\u017a\u017b\7k\2\2\u017b\u017c\7p\2\2\u017c"+
		"\u017d\7i\2\2\u017dx\3\2\2\2\u017e\u0182\t\4\2\2\u017f\u0181\t\5\2\2\u0180"+
		"\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\b=\3\2\u0186"+
		"z\3\2\2\2\u0187\u0188\5y=\2\u0188|\3\2\2\2\u0189\u018c\5\177@\2\u018a"+
		"\u018c\7\62\2\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c~\3\2\2\2"+
		"\u018d\u0191\t\6\2\2\u018e\u0190\t\7\2\2\u018f\u018e\3\2\2\2\u0190\u0193"+
		"\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0080\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194\u0199\7$\2\2\u0195\u0198\5\u008dG\2\u0196\u0198\5"+
		"\u0083B\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2"+
		"\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u0199"+
		"\3\2\2\2\u019c\u019d\7$\2\2\u019d\u019e\bA\4\2\u019e\u0082\3\2\2\2\u019f"+
		"\u01a0\7^\2\2\u01a0\u01a6\7^\2\2\u01a1\u01a2\7^\2\2\u01a2\u01a6\7p\2\2"+
		"\u01a3\u01a4\7^\2\2\u01a4\u01a6\7$\2\2\u01a5\u019f\3\2\2\2\u01a5\u01a1"+
		"\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u0084\3\2\2\2\u01a7\u01a8\7h\2\2\u01a8"+
		"\u01a9\7$\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\5\u008bF\2\u01ab\u01ac\7"+
		"&\2\2\u01ac\u0086\3\2\2\2\u01ad\u01ae\7&\2\2\u01ae\u01af\5\u008bF\2\u01af"+
		"\u01b0\7&\2\2\u01b0\u0088\3\2\2\2\u01b1\u01b2\7&\2\2\u01b2\u01b3\5\u008b"+
		"F\2\u01b3\u01b4\7$\2\2\u01b4\u008a\3\2\2\2\u01b5\u01b8\5\u008fH\2\u01b6"+
		"\u01b8\5\u0083B\2\u01b7\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb"+
		"\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u008c\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bc\u01bd\n\b\2\2\u01bd\u008e\3\2\2\2\u01be\u01c2\n\t"+
		"\2\2\u01bf\u01c0\7&\2\2\u01c0\u01c2\7&\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf"+
		"\3\2\2\2\u01c2\u0090\3\2\2\2\24\2\u012d\u0133\u0136\u0140\u014e\u0157"+
		"\u0160\u0167\u0182\u018b\u0191\u0197\u0199\u01a5\u01b7\u01b9\u01c1\5\b"+
		"\2\2\3=\2\3A\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}