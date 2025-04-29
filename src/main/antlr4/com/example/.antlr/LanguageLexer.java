// Generated from /home/angeld/MyCode/LangAutoII/demo/src/main/antlr4/com/example/Language.g4 by ANTLR 4.13.1

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_SUMA=1, OP_RESTA=2, OP_MULT=3, OP_DIV=4, OP_ASIGN=5, SEMI=6, LPAREN=7, 
		RPAREN=8, MAYOR=9, MENOR=10, MAYORIGUAL=11, MENORIGUAL=12, IGUAL=13, DIFERENTE=14, 
		OR=15, AND=16, LCURLY=17, RCURLY=18, IF=19, ELSE=20, ELSEIF=21, FOR=22, 
		INT=23, FLOAT=24, BOOL=25, STRING=26, CHAR=27, INC=28, DEC=29, PRINT=30, 
		NUM=31, ID=32, STRING_LITERAL=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", "LPAREN", 
			"RPAREN", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", "IGUAL", "DIFERENTE", 
			"OR", "AND", "LCURLY", "RCURLY", "IF", "ELSE", "ELSEIF", "FOR", "INT", 
			"FLOAT", "BOOL", "STRING", "CHAR", "INC", "DEC", "PRINT", "NUM", "ID", 
			"STRING_LITERAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'('", "')'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'||'", "'&&'", "'{'", "'}'", 
			"'if'", "'else'", "'else if'", "'for'", "'int'", "'float'", "'bool'", 
			"'string'", "'char'", "'++'", "'--'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", 
			"LPAREN", "RPAREN", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", "IGUAL", 
			"DIFERENTE", "OR", "AND", "LCURLY", "RCURLY", "IF", "ELSE", "ELSEIF", 
			"FOR", "INT", "FLOAT", "BOOL", "STRING", "CHAR", "INC", "DEC", "PRINT", 
			"NUM", "ID", "STRING_LITERAL", "WS"
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
		"\u0004\u0000\"\u00c6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0004\u001e\u00ac\b\u001e\u000b\u001e\f\u001e"+
		"\u00ad\u0001\u001f\u0001\u001f\u0005\u001f\u00b2\b\u001f\n\u001f\f\u001f"+
		"\u00b5\t\u001f\u0001 \u0001 \u0005 \u00b9\b \n \f \u00bc\t \u0001 \u0001"+
		" \u0001!\u0004!\u00c1\b!\u000b!\f!\u00c2\u0001!\u0001!\u0000\u0000\"\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"\u0001\u0000"+
		"\u0005\u0001\u000009\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000"+
		"\n\n\r\r\"\"\u0003\u0000\t\n\f\r  \u00c9\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000"+
		"\u0000\u0000\u0001E\u0001\u0000\u0000\u0000\u0003G\u0001\u0000\u0000\u0000"+
		"\u0005I\u0001\u0000\u0000\u0000\u0007K\u0001\u0000\u0000\u0000\tM\u0001"+
		"\u0000\u0000\u0000\u000bO\u0001\u0000\u0000\u0000\rQ\u0001\u0000\u0000"+
		"\u0000\u000fS\u0001\u0000\u0000\u0000\u0011U\u0001\u0000\u0000\u0000\u0013"+
		"W\u0001\u0000\u0000\u0000\u0015Y\u0001\u0000\u0000\u0000\u0017\\\u0001"+
		"\u0000\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000"+
		"\u0000\u001de\u0001\u0000\u0000\u0000\u001fh\u0001\u0000\u0000\u0000!"+
		"k\u0001\u0000\u0000\u0000#m\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000"+
		"\u0000\'r\u0001\u0000\u0000\u0000)w\u0001\u0000\u0000\u0000+\u007f\u0001"+
		"\u0000\u0000\u0000-\u0083\u0001\u0000\u0000\u0000/\u0087\u0001\u0000\u0000"+
		"\u00001\u008d\u0001\u0000\u0000\u00003\u0092\u0001\u0000\u0000\u00005"+
		"\u0099\u0001\u0000\u0000\u00007\u009e\u0001\u0000\u0000\u00009\u00a1\u0001"+
		"\u0000\u0000\u0000;\u00a4\u0001\u0000\u0000\u0000=\u00ab\u0001\u0000\u0000"+
		"\u0000?\u00af\u0001\u0000\u0000\u0000A\u00b6\u0001\u0000\u0000\u0000C"+
		"\u00c0\u0001\u0000\u0000\u0000EF\u0005+\u0000\u0000F\u0002\u0001\u0000"+
		"\u0000\u0000GH\u0005-\u0000\u0000H\u0004\u0001\u0000\u0000\u0000IJ\u0005"+
		"*\u0000\u0000J\u0006\u0001\u0000\u0000\u0000KL\u0005/\u0000\u0000L\b\u0001"+
		"\u0000\u0000\u0000MN\u0005=\u0000\u0000N\n\u0001\u0000\u0000\u0000OP\u0005"+
		";\u0000\u0000P\f\u0001\u0000\u0000\u0000QR\u0005(\u0000\u0000R\u000e\u0001"+
		"\u0000\u0000\u0000ST\u0005)\u0000\u0000T\u0010\u0001\u0000\u0000\u0000"+
		"UV\u0005>\u0000\u0000V\u0012\u0001\u0000\u0000\u0000WX\u0005<\u0000\u0000"+
		"X\u0014\u0001\u0000\u0000\u0000YZ\u0005>\u0000\u0000Z[\u0005=\u0000\u0000"+
		"[\u0016\u0001\u0000\u0000\u0000\\]\u0005<\u0000\u0000]^\u0005=\u0000\u0000"+
		"^\u0018\u0001\u0000\u0000\u0000_`\u0005=\u0000\u0000`a\u0005=\u0000\u0000"+
		"a\u001a\u0001\u0000\u0000\u0000bc\u0005!\u0000\u0000cd\u0005=\u0000\u0000"+
		"d\u001c\u0001\u0000\u0000\u0000ef\u0005|\u0000\u0000fg\u0005|\u0000\u0000"+
		"g\u001e\u0001\u0000\u0000\u0000hi\u0005&\u0000\u0000ij\u0005&\u0000\u0000"+
		"j \u0001\u0000\u0000\u0000kl\u0005{\u0000\u0000l\"\u0001\u0000\u0000\u0000"+
		"mn\u0005}\u0000\u0000n$\u0001\u0000\u0000\u0000op\u0005i\u0000\u0000p"+
		"q\u0005f\u0000\u0000q&\u0001\u0000\u0000\u0000rs\u0005e\u0000\u0000st"+
		"\u0005l\u0000\u0000tu\u0005s\u0000\u0000uv\u0005e\u0000\u0000v(\u0001"+
		"\u0000\u0000\u0000wx\u0005e\u0000\u0000xy\u0005l\u0000\u0000yz\u0005s"+
		"\u0000\u0000z{\u0005e\u0000\u0000{|\u0005 \u0000\u0000|}\u0005i\u0000"+
		"\u0000}~\u0005f\u0000\u0000~*\u0001\u0000\u0000\u0000\u007f\u0080\u0005"+
		"f\u0000\u0000\u0080\u0081\u0005o\u0000\u0000\u0081\u0082\u0005r\u0000"+
		"\u0000\u0082,\u0001\u0000\u0000\u0000\u0083\u0084\u0005i\u0000\u0000\u0084"+
		"\u0085\u0005n\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086.\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005f\u0000\u0000\u0088\u0089\u0005l\u0000"+
		"\u0000\u0089\u008a\u0005o\u0000\u0000\u008a\u008b\u0005a\u0000\u0000\u008b"+
		"\u008c\u0005t\u0000\u0000\u008c0\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"b\u0000\u0000\u008e\u008f\u0005o\u0000\u0000\u008f\u0090\u0005o\u0000"+
		"\u0000\u0090\u0091\u0005l\u0000\u0000\u00912\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005s\u0000\u0000\u0093\u0094\u0005t\u0000\u0000\u0094\u0095\u0005"+
		"r\u0000\u0000\u0095\u0096\u0005i\u0000\u0000\u0096\u0097\u0005n\u0000"+
		"\u0000\u0097\u0098\u0005g\u0000\u0000\u00984\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0005c\u0000\u0000\u009a\u009b\u0005h\u0000\u0000\u009b\u009c\u0005"+
		"a\u0000\u0000\u009c\u009d\u0005r\u0000\u0000\u009d6\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0005+\u0000\u0000\u009f\u00a0\u0005+\u0000\u0000\u00a0"+
		"8\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005-\u0000\u0000\u00a2\u00a3\u0005"+
		"-\u0000\u0000\u00a3:\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005p\u0000"+
		"\u0000\u00a5\u00a6\u0005r\u0000\u0000\u00a6\u00a7\u0005i\u0000\u0000\u00a7"+
		"\u00a8\u0005n\u0000\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9<\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ac\u0007\u0000\u0000\u0000\u00ab\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae>\u0001\u0000"+
		"\u0000\u0000\u00af\u00b3\u0007\u0001\u0000\u0000\u00b0\u00b2\u0007\u0002"+
		"\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4@\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b6\u00ba\u0005\"\u0000\u0000\u00b7\u00b9\b\u0003\u0000\u0000"+
		"\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005\"\u0000\u0000\u00beB\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c1\u0007\u0004\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0006!\u0000\u0000\u00c5D\u0001\u0000\u0000\u0000\u0005\u0000\u00ad"+
		"\u00b3\u00ba\u00c2\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}