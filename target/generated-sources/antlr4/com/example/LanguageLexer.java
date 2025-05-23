// Generated from com/example/Language.g4 by ANTLR 4.9.2
package com.example;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_SUMA=1, OP_RESTA=2, OP_MULT=3, OP_DIV=4, OP_ASIGN=5, SEMI=6, LPAREN=7, 
		RPAREN=8, LCURLY=9, RCURLY=10, MAYOR=11, MENOR=12, MAYORIGUAL=13, MENORIGUAL=14, 
		IGUAL=15, DIFERENTE=16, OR=17, AND=18, INC=19, DEC=20, IF=21, ELSE=22, 
		ELSEIF=23, FOR=24, WHILE=25, PRINT=26, INT=27, FLOAT=28, BOOL=29, STRING=30, 
		CHAR=31, TRUE=32, FALSE=33, FLOAT_NUM=34, NUM=35, ID=36, STRING_LITERAL=37, 
		CHAR_LITERAL=38, WS=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", "LPAREN", 
			"RPAREN", "LCURLY", "RCURLY", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", 
			"IGUAL", "DIFERENTE", "OR", "AND", "INC", "DEC", "IF", "ELSE", "ELSEIF", 
			"FOR", "WHILE", "PRINT", "INT", "FLOAT", "BOOL", "STRING", "CHAR", "TRUE", 
			"FALSE", "FLOAT_NUM", "NUM", "ID", "STRING_LITERAL", "CHAR_LITERAL", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$e'", "'~>'", "'.'", "'#>'", "'=>'", "':0x'", "'[['", "']]'", 
			"'<<'", "'>>'", "'^^'", "'vv'", "'^^:'", "'vv:'", "'<->'", "':?'", "'$'", 
			"'@&'", "'i+'", "'d-'", "'@grok is this true?'", "'fallback'", "'then?'", 
			"'loop'", "'on'", "'say'", "'num'", "'dec'", "'bin'", "'txt'", "'ch'", 
			"'ye'", "'nope'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", 
			"LPAREN", "RPAREN", "LCURLY", "RCURLY", "MAYOR", "MENOR", "MAYORIGUAL", 
			"MENORIGUAL", "IGUAL", "DIFERENTE", "OR", "AND", "INC", "DEC", "IF", 
			"ELSE", "ELSEIF", "FOR", "WHILE", "PRINT", "INT", "FLOAT", "BOOL", "STRING", 
			"CHAR", "TRUE", "FALSE", "FLOAT_NUM", "NUM", "ID", "STRING_LITERAL", 
			"CHAR_LITERAL", "WS"
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


	    class VariableInfo {
	        String type;
	        boolean initialized;

	        VariableInfo(String type, boolean initialized) {
	            this.type = type;
	            this.initialized = initialized;
	        }
	    }

	    private HashMap<String, VariableInfo> symbolTable = new HashMap<>();

	    private void checkVariableExists(String varName, Token token) {
	        if (!symbolTable.containsKey(varName)) {
	            throw new RuntimeException("Variable no declarada '" + varName + "' en línea " + token.getLine());
	        }
	    }

	    private void checkVariableInitialized(String varName, Token token) {
	        VariableInfo info = symbolTable.get(varName);
	        if (info != null && !info.initialized) {
	            throw new RuntimeException("Variable no inicializada '" + varName + "' en línea " + token.getLine());
	        }
	    }

	    private void checkDivisionByZero(String divisorValue, Token opToken) {
	        try {
	            if (Integer.parseInt(divisorValue) == 0) {
	                throw new RuntimeException("División por cero detectada en línea " + opToken.getLine());
	            }
	        } catch (NumberFormatException e) {
	            // No es un número entero, validación solo para literales
	        }
	    }


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0108\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\6#\u00db\n#\r#"+
		"\16#\u00dc\3#\3#\6#\u00e1\n#\r#\16#\u00e2\3$\6$\u00e6\n$\r$\16$\u00e7"+
		"\3%\3%\7%\u00ec\n%\f%\16%\u00ef\13%\3&\3&\7&\u00f3\n&\f&\16&\u00f6\13"+
		"&\3&\3&\3\'\3\'\3\'\3\'\5\'\u00fe\n\'\3\'\3\'\3(\6(\u0103\n(\r(\16(\u0104"+
		"\3(\3(\2\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\"+
		"aac|\5\2\f\f\17\17$$\6\2\f\f\17\17))^^\5\2\13\f\16\17\"\"\2\u010e\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5T\3\2\2\2\7W\3"+
		"\2\2\2\tY\3\2\2\2\13\\\3\2\2\2\r_\3\2\2\2\17c\3\2\2\2\21f\3\2\2\2\23i"+
		"\3\2\2\2\25l\3\2\2\2\27o\3\2\2\2\31r\3\2\2\2\33u\3\2\2\2\35y\3\2\2\2\37"+
		"}\3\2\2\2!\u0081\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0089\3\2\2\2"+
		")\u008c\3\2\2\2+\u008f\3\2\2\2-\u00a3\3\2\2\2/\u00ac\3\2\2\2\61\u00b2"+
		"\3\2\2\2\63\u00b7\3\2\2\2\65\u00ba\3\2\2\2\67\u00be\3\2\2\29\u00c2\3\2"+
		"\2\2;\u00c6\3\2\2\2=\u00ca\3\2\2\2?\u00ce\3\2\2\2A\u00d1\3\2\2\2C\u00d4"+
		"\3\2\2\2E\u00da\3\2\2\2G\u00e5\3\2\2\2I\u00e9\3\2\2\2K\u00f0\3\2\2\2M"+
		"\u00f9\3\2\2\2O\u0102\3\2\2\2QR\7&\2\2RS\7g\2\2S\4\3\2\2\2TU\7\u0080\2"+
		"\2UV\7@\2\2V\6\3\2\2\2WX\7\60\2\2X\b\3\2\2\2YZ\7%\2\2Z[\7@\2\2[\n\3\2"+
		"\2\2\\]\7?\2\2]^\7@\2\2^\f\3\2\2\2_`\7<\2\2`a\7\62\2\2ab\7z\2\2b\16\3"+
		"\2\2\2cd\7]\2\2de\7]\2\2e\20\3\2\2\2fg\7_\2\2gh\7_\2\2h\22\3\2\2\2ij\7"+
		">\2\2jk\7>\2\2k\24\3\2\2\2lm\7@\2\2mn\7@\2\2n\26\3\2\2\2op\7`\2\2pq\7"+
		"`\2\2q\30\3\2\2\2rs\7x\2\2st\7x\2\2t\32\3\2\2\2uv\7`\2\2vw\7`\2\2wx\7"+
		"<\2\2x\34\3\2\2\2yz\7x\2\2z{\7x\2\2{|\7<\2\2|\36\3\2\2\2}~\7>\2\2~\177"+
		"\7/\2\2\177\u0080\7@\2\2\u0080 \3\2\2\2\u0081\u0082\7<\2\2\u0082\u0083"+
		"\7A\2\2\u0083\"\3\2\2\2\u0084\u0085\7&\2\2\u0085$\3\2\2\2\u0086\u0087"+
		"\7B\2\2\u0087\u0088\7(\2\2\u0088&\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7-\2\2\u008b(\3\2\2\2\u008c\u008d\7f\2\2\u008d\u008e\7/\2\2\u008e*\3"+
		"\2\2\2\u008f\u0090\7B\2\2\u0090\u0091\7i\2\2\u0091\u0092\7t\2\2\u0092"+
		"\u0093\7q\2\2\u0093\u0094\7m\2\2\u0094\u0095\7\"\2\2\u0095\u0096\7k\2"+
		"\2\u0096\u0097\7u\2\2\u0097\u0098\7\"\2\2\u0098\u0099\7v\2\2\u0099\u009a"+
		"\7j\2\2\u009a\u009b\7k\2\2\u009b\u009c\7u\2\2\u009c\u009d\7\"\2\2\u009d"+
		"\u009e\7v\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\u00a2\7A\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7c\2"+
		"\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7d\2\2\u00a8\u00a9"+
		"\7c\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7m\2\2\u00ab.\3\2\2\2\u00ac\u00ad"+
		"\7v\2\2\u00ad\u00ae\7j\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2\u00b0"+
		"\u00b1\7A\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7q\2\2\u00b4"+
		"\u00b5\7q\2\2\u00b5\u00b6\7r\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7q\2\2\u00b8"+
		"\u00b9\7p\2\2\u00b9\64\3\2\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7c\2\2\u00bc"+
		"\u00bd\7{\2\2\u00bd\66\3\2\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7w\2\2\u00c0"+
		"\u00c1\7o\2\2\u00c18\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7e\2\2\u00c5:\3\2\2\2\u00c6\u00c7\7d\2\2\u00c7\u00c8\7k\2\2\u00c8"+
		"\u00c9\7p\2\2\u00c9<\3\2\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7z\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd>\3\2\2\2\u00ce\u00cf\7e\2\2\u00cf\u00d0\7j\2\2\u00d0"+
		"@\3\2\2\2\u00d1\u00d2\7{\2\2\u00d2\u00d3\7g\2\2\u00d3B\3\2\2\2\u00d4\u00d5"+
		"\7p\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8\7g\2\2\u00d8"+
		"D\3\2\2\2\u00d9\u00db\t\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2"+
		"\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0"+
		"\7\60\2\2\u00df\u00e1\t\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3F\3\2\2\2\u00e4\u00e6\t"+
		"\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8H\3\2\2\2\u00e9\u00ed\t\3\2\2\u00ea\u00ec\t\4\2\2"+
		"\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00eeJ\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f4\7$\2\2\u00f1\u00f3"+
		"\n\5\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7$"+
		"\2\2\u00f8L\3\2\2\2\u00f9\u00fd\7)\2\2\u00fa\u00fe\n\6\2\2\u00fb\u00fc"+
		"\7^\2\2\u00fc\u00fe\13\2\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\7)\2\2\u0100N\3\2\2\2\u0101\u0103\t\7\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106\u0107\b(\2\2\u0107P\3\2\2\2\n\2\u00dc\u00e2"+
		"\u00e7\u00ed\u00f4\u00fd\u0104\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}