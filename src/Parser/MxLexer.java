package Parser;

// Generated from src/Parser/Mx.g4 by ANTLR 4.9.3
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, BuildInFunc=31, 
		If=32, Else=33, Return=34, Break=35, Continue=36, New=37, Class=38, Null=39, 
		This=40, For=41, While=42, LeftParen=43, RightParen=44, LeftBracket=45, 
		RightBracket=46, LeftBrace=47, RightBrace=48, Whitespace=49, Newline=50, 
		BlockComment=51, LineComment=52, Semi=53, BasicType=54, Identifier=55, 
		Array=56, Classname=57, Const=58, PositiveConst=59, ArrayConst=60, StringConst=61, 
		EscapeChar=62, FstringHead=63, FstringBody=64, FstringTail=65;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "BuildInFunc", "If", "Else", 
			"Return", "Break", "Continue", "New", "Class", "Null", "True", "False", 
			"This", "For", "While", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Whitespace", "Newline", "BlockComment", "LineComment", 
			"Semi", "Void", "Bool", "Int", "String", "BasicType", "Identifier", "Array", 
			"Classname", "Const", "DemicalConst", "PositiveConst", "ArrayConst", 
			"StringConst", "EscapeChar", "FstringHead", "FstringBody", "FstringTail", 
			"Printable", "FPrintable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int main()'", "'='", "','", "'[]'", "'!'", "'~'", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'>>'", "'<<'", "'>'", "'<'", "'>='", 
			"'<='", "'!='", "'=='", "'&'", "'^'", "'|'", "'&&'", "'||'", "'?'", "':'", 
			"'.'", "'()'", null, "'if'", "'else'", "'return'", "'break'", "'continue'", 
			"'new'", "'class'", "'null'", "'this'", "'for'", "'while'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "BuildInFunc", "If", "Else", 
			"Return", "Break", "Continue", "New", "Class", "Null", "This", "For", 
			"While", "LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
			"RightBrace", "Whitespace", "Newline", "BlockComment", "LineComment", 
			"Semi", "BasicType", "Identifier", "Array", "Classname", "Const", "PositiveConst", 
			"ArrayConst", "StringConst", "EscapeChar", "FstringHead", "FstringBody", 
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
		case 60:
			Identifier_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u0242\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0138"+
		"\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\6\64\u018e\n\64\r\64\16\64\u018f\3\64\3\64\3\65\3\65\5\65\u0196"+
		"\n\65\3\65\5\65\u0199\n\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u01a1\n"+
		"\66\f\66\16\66\u01a4\13\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\7\67\u01af\n\67\f\67\16\67\u01b2\13\67\3\67\3\67\38\38\39\39\39\39\3"+
		"9\3:\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\5=\u01d1"+
		"\n=\3>\3>\7>\u01d5\n>\f>\16>\u01d8\13>\3>\3>\3?\3?\5?\u01de\n?\3?\3?\3"+
		"?\3?\3?\7?\u01e5\n?\f?\16?\u01e8\13?\3@\3@\3A\3A\3A\3A\3A\3A\5A\u01f2"+
		"\nA\3B\3B\5B\u01f6\nB\3C\3C\7C\u01fa\nC\fC\16C\u01fd\13C\3D\3D\3D\3D\7"+
		"D\u0203\nD\fD\16D\u0206\13D\5D\u0208\nD\3D\3D\3E\3E\3E\7E\u020f\nE\fE"+
		"\16E\u0212\13E\3E\3E\3E\3F\3F\3F\3F\3F\3F\5F\u021d\nF\3G\3G\3G\3G\3G\7"+
		"G\u0224\nG\fG\16G\u0227\13G\3G\3G\3H\3H\3H\5H\u022e\nH\3H\3H\3I\3I\3I"+
		"\7I\u0235\nI\fI\16I\u0238\13I\3I\3I\3J\3J\3K\3K\3K\5K\u0241\nK\4\u01a2"+
		"\u0236\2L\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U*W+Y,[-]._/a\60c\61e\62g\63i\64"+
		"k\65m\66o\67q\2s\2u\2w\2y8{9}:\177;\u0081<\u0083\2\u0085=\u0087>\u0089"+
		"?\u008b@\u008dA\u008fB\u0091C\u0093\2\u0095\2\3\2\n\4\2\13\13\"\"\4\2"+
		"\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\6\2\f\f\17\17$$^^\7"+
		"\2\f\f\17\17$$&&^^\2\u0260\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a"+
		"\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2"+
		"\2\2\2o\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0097\3\2\2\2\5\u00a2"+
		"\3\2\2\2\7\u00a4\3\2\2\2\t\u00a6\3\2\2\2\13\u00a9\3\2\2\2\r\u00ab\3\2"+
		"\2\2\17\u00ad\3\2\2\2\21\u00b0\3\2\2\2\23\u00b3\3\2\2\2\25\u00b5\3\2\2"+
		"\2\27\u00b7\3\2\2\2\31\u00b9\3\2\2\2\33\u00bb\3\2\2\2\35\u00bd\3\2\2\2"+
		"\37\u00c0\3\2\2\2!\u00c3\3\2\2\2#\u00c5\3\2\2\2%\u00c7\3\2\2\2\'\u00ca"+
		"\3\2\2\2)\u00cd\3\2\2\2+\u00d0\3\2\2\2-\u00d3\3\2\2\2/\u00d5\3\2\2\2\61"+
		"\u00d7\3\2\2\2\63\u00d9\3\2\2\2\65\u00dc\3\2\2\2\67\u00df\3\2\2\29\u00e1"+
		"\3\2\2\2;\u00e3\3\2\2\2=\u00e5\3\2\2\2?\u0137\3\2\2\2A\u0139\3\2\2\2C"+
		"\u013c\3\2\2\2E\u0141\3\2\2\2G\u0148\3\2\2\2I\u014e\3\2\2\2K\u0157\3\2"+
		"\2\2M\u015b\3\2\2\2O\u0161\3\2\2\2Q\u0166\3\2\2\2S\u016b\3\2\2\2U\u0171"+
		"\3\2\2\2W\u0176\3\2\2\2Y\u017a\3\2\2\2[\u0180\3\2\2\2]\u0182\3\2\2\2_"+
		"\u0184\3\2\2\2a\u0186\3\2\2\2c\u0188\3\2\2\2e\u018a\3\2\2\2g\u018d\3\2"+
		"\2\2i\u0198\3\2\2\2k\u019c\3\2\2\2m\u01aa\3\2\2\2o\u01b5\3\2\2\2q\u01b7"+
		"\3\2\2\2s\u01bc\3\2\2\2u\u01c1\3\2\2\2w\u01c5\3\2\2\2y\u01d0\3\2\2\2{"+
		"\u01d2\3\2\2\2}\u01dd\3\2\2\2\177\u01e9\3\2\2\2\u0081\u01f1\3\2\2\2\u0083"+
		"\u01f5\3\2\2\2\u0085\u01f7\3\2\2\2\u0087\u01fe\3\2\2\2\u0089\u020b\3\2"+
		"\2\2\u008b\u021c\3\2\2\2\u008d\u021e\3\2\2\2\u008f\u022a\3\2\2\2\u0091"+
		"\u0231\3\2\2\2\u0093\u023b\3\2\2\2\u0095\u0240\3\2\2\2\u0097\u0098\7k"+
		"\2\2\u0098\u0099\7p\2\2\u0099\u009a\7v\2\2\u009a\u009b\7\"\2\2\u009b\u009c"+
		"\7o\2\2\u009c\u009d\7c\2\2\u009d\u009e\7k\2\2\u009e\u009f\7p\2\2\u009f"+
		"\u00a0\7*\2\2\u00a0\u00a1\7+\2\2\u00a1\4\3\2\2\2\u00a2\u00a3\7?\2\2\u00a3"+
		"\6\3\2\2\2\u00a4\u00a5\7.\2\2\u00a5\b\3\2\2\2\u00a6\u00a7\7]\2\2\u00a7"+
		"\u00a8\7_\2\2\u00a8\n\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa\f\3\2\2\2\u00ab"+
		"\u00ac\7\u0080\2\2\u00ac\16\3\2\2\2\u00ad\u00ae\7-\2\2\u00ae\u00af\7-"+
		"\2\2\u00af\20\3\2\2\2\u00b0\u00b1\7/\2\2\u00b1\u00b2\7/\2\2\u00b2\22\3"+
		"\2\2\2\u00b3\u00b4\7-\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7/\2\2\u00b6\26"+
		"\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba"+
		"\32\3\2\2\2\u00bb\u00bc\7\'\2\2\u00bc\34\3\2\2\2\u00bd\u00be\7@\2\2\u00be"+
		"\u00bf\7@\2\2\u00bf\36\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2\7>\2\2\u00c2"+
		" \3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\"\3\2\2\2\u00c5\u00c6\7>\2\2\u00c6"+
		"$\3\2\2\2\u00c7\u00c8\7@\2\2\u00c8\u00c9\7?\2\2\u00c9&\3\2\2\2\u00ca\u00cb"+
		"\7>\2\2\u00cb\u00cc\7?\2\2\u00cc(\3\2\2\2\u00cd\u00ce\7#\2\2\u00ce\u00cf"+
		"\7?\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7?\2\2\u00d1\u00d2\7?\2\2\u00d2,\3"+
		"\2\2\2\u00d3\u00d4\7(\2\2\u00d4.\3\2\2\2\u00d5\u00d6\7`\2\2\u00d6\60\3"+
		"\2\2\2\u00d7\u00d8\7~\2\2\u00d8\62\3\2\2\2\u00d9\u00da\7(\2\2\u00da\u00db"+
		"\7(\2\2\u00db\64\3\2\2\2\u00dc\u00dd\7~\2\2\u00dd\u00de\7~\2\2\u00de\66"+
		"\3\2\2\2\u00df\u00e0\7A\2\2\u00e08\3\2\2\2\u00e1\u00e2\7<\2\2\u00e2:\3"+
		"\2\2\2\u00e3\u00e4\7\60\2\2\u00e4<\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6\u00e7"+
		"\7+\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb"+
		"\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u0138\7v\2\2\u00ed\u00ee\7r\2\2\u00ee"+
		"\u00ef\7t\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7v\2\2"+
		"\u00f2\u00f3\7n\2\2\u00f3\u0138\7p\2\2\u00f4\u00f5\7r\2\2\u00f5\u00f6"+
		"\7t\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7v\2\2\u00f9"+
		"\u00fa\7K\2\2\u00fa\u00fb\7p\2\2\u00fb\u0138\7v\2\2\u00fc\u00fd\7r\2\2"+
		"\u00fd\u00fe\7t\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100\u0101"+
		"\7v\2\2\u0101\u0102\7n\2\2\u0102\u0103\7p\2\2\u0103\u0104\7K\2\2\u0104"+
		"\u0105\7p\2\2\u0105\u0138\7v\2\2\u0106\u0107\7i\2\2\u0107\u0108\7g\2\2"+
		"\u0108\u0109\7v\2\2\u0109\u010a\7U\2\2\u010a\u010b\7v\2\2\u010b\u010c"+
		"\7t\2\2\u010c\u010d\7k\2\2\u010d\u010e\7p\2\2\u010e\u0138\7i\2\2\u010f"+
		"\u0110\7i\2\2\u0110\u0111\7g\2\2\u0111\u0112\7v\2\2\u0112\u0113\7K\2\2"+
		"\u0113\u0114\7p\2\2\u0114\u0138\7v\2\2\u0115\u0116\7v\2\2\u0116\u0117"+
		"\7q\2\2\u0117\u0118\7U\2\2\u0118\u0119\7v\2\2\u0119\u011a\7t\2\2\u011a"+
		"\u011b\7k\2\2\u011b\u011c\7p\2\2\u011c\u0138\7i\2\2\u011d\u011e\7n\2\2"+
		"\u011e\u011f\7g\2\2\u011f\u0120\7p\2\2\u0120\u0121\7i\2\2\u0121\u0122"+
		"\7v\2\2\u0122\u0138\7j\2\2\u0123\u0124\7u\2\2\u0124\u0125\7w\2\2\u0125"+
		"\u0126\7d\2\2\u0126\u0127\7u\2\2\u0127\u0128\7v\2\2\u0128\u0129\7t\2\2"+
		"\u0129\u012a\7k\2\2\u012a\u012b\7p\2\2\u012b\u0138\7i\2\2\u012c\u012d"+
		"\7r\2\2\u012d\u012e\7c\2\2\u012e\u012f\7t\2\2\u012f\u0130\7u\2\2\u0130"+
		"\u0131\7g\2\2\u0131\u0132\7K\2\2\u0132\u0133\7p\2\2\u0133\u0138\7v\2\2"+
		"\u0134\u0135\7q\2\2\u0135\u0136\7t\2\2\u0136\u0138\7f\2\2\u0137\u00e8"+
		"\3\2\2\2\u0137\u00ed\3\2\2\2\u0137\u00f4\3\2\2\2\u0137\u00fc\3\2\2\2\u0137"+
		"\u0106\3\2\2\2\u0137\u010f\3\2\2\2\u0137\u0115\3\2\2\2\u0137\u011d\3\2"+
		"\2\2\u0137\u0123\3\2\2\2\u0137\u012c\3\2\2\2\u0137\u0134\3\2\2\2\u0138"+
		"@\3\2\2\2\u0139\u013a\7k\2\2\u013a\u013b\7h\2\2\u013bB\3\2\2\2\u013c\u013d"+
		"\7g\2\2\u013d\u013e\7n\2\2\u013e\u013f\7u\2\2\u013f\u0140\7g\2\2\u0140"+
		"D\3\2\2\2\u0141\u0142\7t\2\2\u0142\u0143\7g\2\2\u0143\u0144\7v\2\2\u0144"+
		"\u0145\7w\2\2\u0145\u0146\7t\2\2\u0146\u0147\7p\2\2\u0147F\3\2\2\2\u0148"+
		"\u0149\7d\2\2\u0149\u014a\7t\2\2\u014a\u014b\7g\2\2\u014b\u014c\7c\2\2"+
		"\u014c\u014d\7m\2\2\u014dH\3\2\2\2\u014e\u014f\7e\2\2\u014f\u0150\7q\2"+
		"\2\u0150\u0151\7p\2\2\u0151\u0152\7v\2\2\u0152\u0153\7k\2\2\u0153\u0154"+
		"\7p\2\2\u0154\u0155\7w\2\2\u0155\u0156\7g\2\2\u0156J\3\2\2\2\u0157\u0158"+
		"\7p\2\2\u0158\u0159\7g\2\2\u0159\u015a\7y\2\2\u015aL\3\2\2\2\u015b\u015c"+
		"\7e\2\2\u015c\u015d\7n\2\2\u015d\u015e\7c\2\2\u015e\u015f\7u\2\2\u015f"+
		"\u0160\7u\2\2\u0160N\3\2\2\2\u0161\u0162\7p\2\2\u0162\u0163\7w\2\2\u0163"+
		"\u0164\7n\2\2\u0164\u0165\7n\2\2\u0165P\3\2\2\2\u0166\u0167\7v\2\2\u0167"+
		"\u0168\7t\2\2\u0168\u0169\7w\2\2\u0169\u016a\7g\2\2\u016aR\3\2\2\2\u016b"+
		"\u016c\7h\2\2\u016c\u016d\7c\2\2\u016d\u016e\7n\2\2\u016e\u016f\7u\2\2"+
		"\u016f\u0170\7g\2\2\u0170T\3\2\2\2\u0171\u0172\7v\2\2\u0172\u0173\7j\2"+
		"\2\u0173\u0174\7k\2\2\u0174\u0175\7u\2\2\u0175V\3\2\2\2\u0176\u0177\7"+
		"h\2\2\u0177\u0178\7q\2\2\u0178\u0179\7t\2\2\u0179X\3\2\2\2\u017a\u017b"+
		"\7y\2\2\u017b\u017c\7j\2\2\u017c\u017d\7k\2\2\u017d\u017e\7n\2\2\u017e"+
		"\u017f\7g\2\2\u017fZ\3\2\2\2\u0180\u0181\7*\2\2\u0181\\\3\2\2\2\u0182"+
		"\u0183\7+\2\2\u0183^\3\2\2\2\u0184\u0185\7]\2\2\u0185`\3\2\2\2\u0186\u0187"+
		"\7_\2\2\u0187b\3\2\2\2\u0188\u0189\7}\2\2\u0189d\3\2\2\2\u018a\u018b\7"+
		"\177\2\2\u018bf\3\2\2\2\u018c\u018e\t\2\2\2\u018d\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u0192\b\64\2\2\u0192h\3\2\2\2\u0193\u0195\7\17\2\2\u0194\u0196"+
		"\7\f\2\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0199\3\2\2\2\u0197"+
		"\u0199\7\f\2\2\u0198\u0193\3\2\2\2\u0198\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u019b\b\65\2\2\u019bj\3\2\2\2\u019c\u019d\7\61\2\2\u019d\u019e"+
		"\7,\2\2\u019e\u01a2\3\2\2\2\u019f\u01a1\13\2\2\2\u01a0\u019f\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7,\2\2\u01a6\u01a7\7\61\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\b\66\2\2\u01a9l\3\2\2\2\u01aa\u01ab\7\61\2"+
		"\2\u01ab\u01ac\7\61\2\2\u01ac\u01b0\3\2\2\2\u01ad\u01af\n\3\2\2\u01ae"+
		"\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\b\67\2\2\u01b4"+
		"n\3\2\2\2\u01b5\u01b6\7=\2\2\u01b6p\3\2\2\2\u01b7\u01b8\7x\2\2\u01b8\u01b9"+
		"\7q\2\2\u01b9\u01ba\7k\2\2\u01ba\u01bb\7f\2\2\u01bbr\3\2\2\2\u01bc\u01bd"+
		"\7d\2\2\u01bd\u01be\7q\2\2\u01be\u01bf\7q\2\2\u01bf\u01c0\7n\2\2\u01c0"+
		"t\3\2\2\2\u01c1\u01c2\7k\2\2\u01c2\u01c3\7p\2\2\u01c3\u01c4\7v\2\2\u01c4"+
		"v\3\2\2\2\u01c5\u01c6\7u\2\2\u01c6\u01c7\7v\2\2\u01c7\u01c8\7t\2\2\u01c8"+
		"\u01c9\7k\2\2\u01c9\u01ca\7p\2\2\u01ca\u01cb\7i\2\2\u01cbx\3\2\2\2\u01cc"+
		"\u01d1\5q9\2\u01cd\u01d1\5s:\2\u01ce\u01d1\5u;\2\u01cf\u01d1\5w<\2\u01d0"+
		"\u01cc\3\2\2\2\u01d0\u01cd\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01cf\3\2"+
		"\2\2\u01d1z\3\2\2\2\u01d2\u01d6\t\4\2\2\u01d3\u01d5\t\5\2\2\u01d4\u01d3"+
		"\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\b>\3\2\u01da|\3\2\2\2\u01db"+
		"\u01de\5y=\2\u01dc\u01de\5\177@\2\u01dd\u01db\3\2\2\2\u01dd\u01dc\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\7]\2\2\u01e0\u01e1\7_\2\2\u01e1\u01e6"+
		"\3\2\2\2\u01e2\u01e3\7]\2\2\u01e3\u01e5\7_\2\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7~\3\2\2\2"+
		"\u01e8\u01e6\3\2\2\2\u01e9\u01ea\5{>\2\u01ea\u0080\3\2\2\2\u01eb\u01f2"+
		"\5Q)\2\u01ec\u01f2\5S*\2\u01ed\u01f2\5\u0083B\2\u01ee\u01f2\5\u0089E\2"+
		"\u01ef\u01f2\5O(\2\u01f0\u01f2\5\u0087D\2\u01f1\u01eb\3\2\2\2\u01f1\u01ec"+
		"\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1"+
		"\u01f0\3\2\2\2\u01f2\u0082\3\2\2\2\u01f3\u01f6\5\u0085C\2\u01f4\u01f6"+
		"\7\62\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6\u0084\3\2\2\2"+
		"\u01f7\u01fb\t\6\2\2\u01f8\u01fa\t\7\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd"+
		"\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u0086\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fe\u0207\7}\2\2\u01ff\u0204\5\u0081A\2\u0200\u0201\7"+
		".\2\2\u0201\u0203\5\u0081A\2\u0202\u0200\3\2\2\2\u0203\u0206\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2"+
		"\2\2\u0207\u01ff\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020a\7\177\2\2\u020a\u0088\3\2\2\2\u020b\u0210\7$\2\2\u020c\u020f\5"+
		"\u0093J\2\u020d\u020f\5\u008bF\2\u020e\u020c\3\2\2\2\u020e\u020d\3\2\2"+
		"\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213"+
		"\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0214\7$\2\2\u0214\u0215\bE\4\2\u0215"+
		"\u008a\3\2\2\2\u0216\u0217\7^\2\2\u0217\u021d\7^\2\2\u0218\u0219\7^\2"+
		"\2\u0219\u021d\7p\2\2\u021a\u021b\7^\2\2\u021b\u021d\7$\2\2\u021c\u0216"+
		"\3\2\2\2\u021c\u0218\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u008c\3\2\2\2\u021e"+
		"\u021f\7h\2\2\u021f\u0220\7$\2\2\u0220\u0225\3\2\2\2\u0221\u0224\5\u0095"+
		"K\2\u0222\u0224\5\u008bF\2\u0223\u0221\3\2\2\2\u0223\u0222\3\2\2\2\u0224"+
		"\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\3\2"+
		"\2\2\u0227\u0225\3\2\2\2\u0228\u0229\7&\2\2\u0229\u008e\3\2\2\2\u022a"+
		"\u022d\7&\2\2\u022b\u022e\5\u0095K\2\u022c\u022e\5\u008bF\2\u022d\u022b"+
		"\3\2\2\2\u022d\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\7&\2\2\u0230"+
		"\u0090\3\2\2\2\u0231\u0236\7&\2\2\u0232\u0235\5\u0095K\2\u0233\u0235\5"+
		"\u008bF\2\u0234\u0232\3\2\2\2\u0234\u0233\3\2\2\2\u0235\u0238\3\2\2\2"+
		"\u0236\u0237\3\2\2\2\u0236\u0234\3\2\2\2\u0237\u0239\3\2\2\2\u0238\u0236"+
		"\3\2\2\2\u0239\u023a\7$\2\2\u023a\u0092\3\2\2\2\u023b\u023c\n\b\2\2\u023c"+
		"\u0094\3\2\2\2\u023d\u0241\n\t\2\2\u023e\u023f\7&\2\2\u023f\u0241\7&\2"+
		"\2\u0240\u023d\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0096\3\2\2\2\33\2\u0137"+
		"\u018f\u0195\u0198\u01a2\u01b0\u01d0\u01d6\u01dd\u01e6\u01f1\u01f5\u01fb"+
		"\u0204\u0207\u020e\u0210\u021c\u0223\u0225\u022d\u0234\u0236\u0240\5\b"+
		"\2\2\3>\2\3E\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}