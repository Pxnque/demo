// Generated from c:/AutomatasII/primerlenguaje/demo/src/main/antlr4/com/example/Language.g4 by ANTLR 4.13.1

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_program = 0, RULE_instruccion = 1, RULE_print = 2, RULE_declaracion = 3, 
		RULE_incdec = 4, RULE_ifdecla = 5, RULE_condicional = 6, RULE_fordecla = 7, 
		RULE_whiledecla = 8, RULE_expr = 9, RULE_termino = 10, RULE_factor = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruccion", "print", "declaracion", "incdec", "ifdecla", 
			"condicional", "fordecla", "whiledecla", "expr", "termino", "factor"
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

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				instruccion();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
			setState(29);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode SEMI() { return getToken(LanguageParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode OP_ASIGN() { return getToken(LanguageParser.OP_ASIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public IfdeclaContext ifdecla() {
			return getRuleContext(IfdeclaContext.class,0);
		}
		public FordeclaContext fordecla() {
			return getRuleContext(FordeclaContext.class,0);
		}
		public WhiledeclaContext whiledecla() {
			return getRuleContext(WhiledeclaContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruccion);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case PRINT:
			case INT:
			case FLOAT:
			case BOOL:
			case STRING:
			case CHAR:
			case TRUE:
			case FALSE:
			case FLOAT_NUM:
			case NUM:
			case ID:
			case STRING_LITERAL:
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(31);
					((InstruccionContext)_localctx).ID = match(ID);
					setState(32);
					match(OP_ASIGN);
					setState(35);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						setState(33);
						expr();
						}
						break;
					case 2:
						{
						setState(34);
						condicional();
						}
						break;
					}

					        String varName = (((InstruccionContext)_localctx).ID!=null?((InstruccionContext)_localctx).ID.getText():null);
					        checkVariableExists(varName, ((InstruccionContext)_localctx).ID);
					        VariableInfo info = symbolTable.get(varName);
					        info.initialized = true;
					    
					}
					break;
				case 2:
					{
					setState(39);
					expr();
					}
					break;
				case 3:
					{
					setState(40);
					condicional();
					}
					break;
				case 4:
					{
					setState(41);
					declaracion();
					}
					break;
				case 5:
					{
					setState(42);
					incdec();
					}
					break;
				case 6:
					{
					setState(43);
					print();
					}
					break;
				}
				setState(46);
				match(SEMI);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				ifdecla();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				fordecla();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				whiledecla();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LanguageParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(PRINT);
			setState(54);
			match(LPAREN);
			{
			setState(55);
			expr();
			}
			setState(56);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public Token tipo;
		public Token ID;
		public Token OP_ASIGN;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LanguageParser.CHAR, 0); }
		public TerminalNode OP_ASIGN() { return getToken(LanguageParser.OP_ASIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((DeclaracionContext)_localctx).tipo = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4160749568L) != 0)) ) {
				((DeclaracionContext)_localctx).tipo = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(59);
			((DeclaracionContext)_localctx).ID = match(ID);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASIGN) {
				{
				setState(60);
				((DeclaracionContext)_localctx).OP_ASIGN = match(OP_ASIGN);
				setState(61);
				expr();
				}
			}


			        String varName = (((DeclaracionContext)_localctx).ID!=null?((DeclaracionContext)_localctx).ID.getText():null);
			        if (symbolTable.containsKey(varName)) {
			            throw new RuntimeException("Variable duplicada '" + varName + "' en línea " + ((DeclaracionContext)_localctx).ID.getLine());
			        }
			        boolean isInitialized = ((DeclaracionContext)_localctx).OP_ASIGN != null;
			        symbolTable.put(varName, new VariableInfo((((DeclaracionContext)_localctx).tipo!=null?((DeclaracionContext)_localctx).tipo.getText():null).toLowerCase(), isInitialized));
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncdecContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INC() { return getToken(LanguageParser.INC, 0); }
		public TerminalNode DEC() { return getToken(LanguageParser.DEC, 0); }
		public IncdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incdec; }
	}

	public final IncdecContext incdec() throws RecognitionException {
		IncdecContext _localctx = new IncdecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_incdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((IncdecContext)_localctx).ID = match(ID);

			        checkVariableExists((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			        VariableInfo info = symbolTable.get((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null));
			        checkVariableInitialized((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			    
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfdeclaContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(LanguageParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(LanguageParser.LPAREN, i);
		}
		public List<CondicionalContext> condicional() {
			return getRuleContexts(CondicionalContext.class);
		}
		public CondicionalContext condicional(int i) {
			return getRuleContext(CondicionalContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(LanguageParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(LanguageParser.RPAREN, i);
		}
		public List<TerminalNode> LCURLY() { return getTokens(LanguageParser.LCURLY); }
		public TerminalNode LCURLY(int i) {
			return getToken(LanguageParser.LCURLY, i);
		}
		public List<TerminalNode> RCURLY() { return getTokens(LanguageParser.RCURLY); }
		public TerminalNode RCURLY(int i) {
			return getToken(LanguageParser.RCURLY, i);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public List<TerminalNode> ELSEIF() { return getTokens(LanguageParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(LanguageParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public IfdeclaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifdecla; }
	}

	public final IfdeclaContext ifdecla() throws RecognitionException {
		IfdeclaContext _localctx = new IfdeclaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifdecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(IF);
			setState(71);
			match(LPAREN);
			setState(72);
			condicional();
			setState(73);
			match(RPAREN);
			setState(74);
			match(LCURLY);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				instruccion();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
			setState(80);
			match(RCURLY);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(81);
				match(ELSEIF);
				setState(82);
				match(LPAREN);
				setState(83);
				condicional();
				setState(84);
				match(RPAREN);
				setState(85);
				match(LCURLY);
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					instruccion();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
				setState(91);
				match(RCURLY);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(98);
				match(ELSE);
				setState(99);
				match(LCURLY);
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(100);
					instruccion();
					}
					}
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
				setState(105);
				match(RCURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(LanguageParser.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(LanguageParser.MENOR, 0); }
		public TerminalNode MAYORIGUAL() { return getToken(LanguageParser.MAYORIGUAL, 0); }
		public TerminalNode MENORIGUAL() { return getToken(LanguageParser.MENORIGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(LanguageParser.DIFERENTE, 0); }
		public TerminalNode OR() { return getToken(LanguageParser.OR, 0); }
		public TerminalNode AND() { return getToken(LanguageParser.AND, 0); }
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			expr();
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 522240L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(111);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FordeclaContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(LanguageParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(LanguageParser.SEMI, i);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public TerminalNode LCURLY() { return getToken(LanguageParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(LanguageParser.RCURLY, 0); }
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public FordeclaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fordecla; }
	}

	public final FordeclaContext fordecla() throws RecognitionException {
		FordeclaContext _localctx = new FordeclaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fordecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(FOR);
			setState(114);
			match(LPAREN);
			setState(115);
			declaracion();
			setState(116);
			match(SEMI);
			setState(117);
			condicional();
			setState(118);
			match(SEMI);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(119);
				incdec();
				}
			}

			setState(122);
			match(RPAREN);
			setState(123);
			match(LCURLY);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				instruccion();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
			setState(129);
			match(RCURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhiledeclaContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LanguageParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public TerminalNode LCURLY() { return getToken(LanguageParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(LanguageParser.RCURLY, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public WhiledeclaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whiledecla; }
	}

	public final WhiledeclaContext whiledecla() throws RecognitionException {
		WhiledeclaContext _localctx = new WhiledeclaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whiledecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(WHILE);
			setState(132);
			match(LPAREN);
			setState(133);
			condicional();
			setState(134);
			match(RPAREN);
			setState(135);
			match(LCURLY);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				instruccion();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549741133952L) != 0) );
			setState(141);
			match(RCURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> OP_SUMA() { return getTokens(LanguageParser.OP_SUMA); }
		public TerminalNode OP_SUMA(int i) {
			return getToken(LanguageParser.OP_SUMA, i);
		}
		public List<TerminalNode> OP_RESTA() { return getTokens(LanguageParser.OP_RESTA); }
		public TerminalNode OP_RESTA(int i) {
			return getToken(LanguageParser.OP_RESTA, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		int _la;
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				termino();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_SUMA) {
					{
					{
					setState(144);
					match(OP_SUMA);
					setState(145);
					termino();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				termino();
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_RESTA) {
					{
					{
					setState(152);
					match(OP_RESTA);
					setState(153);
					termino();
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TerminoContext extends ParserRuleContext {
		public Token OP_DIV;
		public FactorContext divisor;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> OP_MULT() { return getTokens(LanguageParser.OP_MULT); }
		public TerminalNode OP_MULT(int i) {
			return getToken(LanguageParser.OP_MULT, i);
		}
		public List<TerminalNode> OP_DIV() { return getTokens(LanguageParser.OP_DIV); }
		public TerminalNode OP_DIV(int i) {
			return getToken(LanguageParser.OP_DIV, i);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termino);
		int _la;
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				factor();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_MULT) {
					{
					{
					setState(162);
					match(OP_MULT);
					setState(163);
					factor();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				factor();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_DIV) {
					{
					{
					setState(170);
					((TerminoContext)_localctx).OP_DIV = match(OP_DIV);
					setState(171);
					((TerminoContext)_localctx).divisor = factor();

					        // Validar división por cero en literales
					        if (((TerminoContext)_localctx).divisor.NUM() != null) {
					            checkDivisionByZero(((TerminoContext)_localctx).divisor.NUM().getText(), ((TerminoContext)_localctx).OP_DIV);
					        }
					    
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode NUM() { return getToken(LanguageParser.NUM, 0); }
		public TerminalNode FLOAT_NUM() { return getToken(LanguageParser.FLOAT_NUM, 0); }
		public TerminalNode TRUE() { return getToken(LanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LanguageParser.FALSE, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(LanguageParser.STRING_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(LanguageParser.CHAR_LITERAL, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(NUM);
				}
				break;
			case FLOAT_NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(FLOAT_NUM);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(FALSE);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(STRING_LITERAL);
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				match(CHAR_LITERAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				((FactorContext)_localctx).ID = match(ID);

				        checkVariableExists((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID);
				        checkVariableInitialized((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID);
				    
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				match(LPAREN);
				setState(190);
				expr();
				setState(191);
				match(RPAREN);
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

	public static final String _serializedATN =
		"\u0004\u0001\'\u00c4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"$\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001-\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00014\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003?\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005M\b\u0005"+
		"\u000b\u0005\f\u0005N\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005X\b\u0005\u000b\u0005"+
		"\f\u0005Y\u0001\u0005\u0001\u0005\u0005\u0005^\b\u0005\n\u0005\f\u0005"+
		"a\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005f\b\u0005\u000b"+
		"\u0005\f\u0005g\u0001\u0005\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007y\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007~\b\u0007\u000b\u0007"+
		"\f\u0007\u007f\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0004\b\u008a\b\b\u000b\b\f\b\u008b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0093\b\t\n\t\f\t\u0096\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u009b\b\t\n\t\f\t\u009e\t\t\u0003\t\u00a0\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u00a5\b\n\n\n\f\n\u00a8\t\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00af\b\n\n\n\f\n\u00b2\t\n\u0003\n\u00b4\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00c2\b\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0003\u0001\u0000\u001b"+
		"\u001f\u0001\u0000\u0013\u0014\u0001\u0000\u000b\u0012\u00d7\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00045\u0001\u0000"+
		"\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000"+
		"\nF\u0001\u0000\u0000\u0000\fm\u0001\u0000\u0000\u0000\u000eq\u0001\u0000"+
		"\u0000\u0000\u0010\u0083\u0001\u0000\u0000\u0000\u0012\u009f\u0001\u0000"+
		"\u0000\u0000\u0014\u00b3\u0001\u0000\u0000\u0000\u0016\u00c1\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f \u0005$\u0000\u0000 #\u0005\u0005\u0000\u0000!$\u0003"+
		"\u0012\t\u0000\"$\u0003\f\u0006\u0000#!\u0001\u0000\u0000\u0000#\"\u0001"+
		"\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0006\u0001\uffff\uffff"+
		"\u0000&-\u0001\u0000\u0000\u0000\'-\u0003\u0012\t\u0000(-\u0003\f\u0006"+
		"\u0000)-\u0003\u0006\u0003\u0000*-\u0003\b\u0004\u0000+-\u0003\u0004\u0002"+
		"\u0000,\u001f\u0001\u0000\u0000\u0000,\'\u0001\u0000\u0000\u0000,(\u0001"+
		"\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		",+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0005\u0006\u0000"+
		"\u0000/4\u0001\u0000\u0000\u000004\u0003\n\u0005\u000014\u0003\u000e\u0007"+
		"\u000024\u0003\u0010\b\u00003,\u0001\u0000\u0000\u000030\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u00004\u0003\u0001"+
		"\u0000\u0000\u000056\u0005\u001a\u0000\u000067\u0005\u0007\u0000\u0000"+
		"78\u0003\u0012\t\u000089\u0005\b\u0000\u00009\u0005\u0001\u0000\u0000"+
		"\u0000:;\u0007\u0000\u0000\u0000;>\u0005$\u0000\u0000<=\u0005\u0005\u0000"+
		"\u0000=?\u0003\u0012\t\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0006\u0003\uffff\uffff\u0000A\u0007"+
		"\u0001\u0000\u0000\u0000BC\u0005$\u0000\u0000CD\u0006\u0004\uffff\uffff"+
		"\u0000DE\u0007\u0001\u0000\u0000E\t\u0001\u0000\u0000\u0000FG\u0005\u0015"+
		"\u0000\u0000GH\u0005\u0007\u0000\u0000HI\u0003\f\u0006\u0000IJ\u0005\b"+
		"\u0000\u0000JL\u0005\t\u0000\u0000KM\u0003\u0002\u0001\u0000LK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P_\u0005\n\u0000\u0000QR\u0005"+
		"\u0017\u0000\u0000RS\u0005\u0007\u0000\u0000ST\u0003\f\u0006\u0000TU\u0005"+
		"\b\u0000\u0000UW\u0005\t\u0000\u0000VX\u0003\u0002\u0001\u0000WV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005\n\u0000"+
		"\u0000\\^\u0001\u0000\u0000\u0000]Q\u0001\u0000\u0000\u0000^a\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`k\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005\u0016\u0000\u0000"+
		"ce\u0005\t\u0000\u0000df\u0003\u0002\u0001\u0000ed\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ij\u0005\n\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000kb\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\u000b\u0001"+
		"\u0000\u0000\u0000mn\u0003\u0012\t\u0000no\u0007\u0002\u0000\u0000op\u0003"+
		"\u0012\t\u0000p\r\u0001\u0000\u0000\u0000qr\u0005\u0018\u0000\u0000rs"+
		"\u0005\u0007\u0000\u0000st\u0003\u0006\u0003\u0000tu\u0005\u0006\u0000"+
		"\u0000uv\u0003\f\u0006\u0000vx\u0005\u0006\u0000\u0000wy\u0003\b\u0004"+
		"\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000z{\u0005\b\u0000\u0000{}\u0005\t\u0000\u0000|~\u0003\u0002"+
		"\u0001\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0005\n\u0000\u0000\u0082\u000f"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0019\u0000\u0000\u0084\u0085"+
		"\u0005\u0007\u0000\u0000\u0085\u0086\u0003\f\u0006\u0000\u0086\u0087\u0005"+
		"\b\u0000\u0000\u0087\u0089\u0005\t\u0000\u0000\u0088\u008a\u0003\u0002"+
		"\u0001\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0005\n\u0000"+
		"\u0000\u008e\u0011\u0001\u0000\u0000\u0000\u008f\u0094\u0003\u0014\n\u0000"+
		"\u0090\u0091\u0005\u0001\u0000\u0000\u0091\u0093\u0003\u0014\n\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u00a0\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097"+
		"\u009c\u0003\u0014\n\u0000\u0098\u0099\u0005\u0002\u0000\u0000\u0099\u009b"+
		"\u0003\u0014\n\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009e\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001"+
		"\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009f\u008f\u0001\u0000\u0000\u0000\u009f\u0097\u0001"+
		"\u0000\u0000\u0000\u00a0\u0013\u0001\u0000\u0000\u0000\u00a1\u00a6\u0003"+
		"\u0016\u000b\u0000\u00a2\u00a3\u0005\u0003\u0000\u0000\u00a3\u00a5\u0003"+
		"\u0016\u000b\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00b4\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a9\u00b0\u0003\u0016\u000b\u0000\u00aa\u00ab\u0005"+
		"\u0004\u0000\u0000\u00ab\u00ac\u0003\u0016\u000b\u0000\u00ac\u00ad\u0006"+
		"\n\uffff\uffff\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00aa\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00a9\u0001\u0000\u0000\u0000\u00b4\u0015\u0001"+
		"\u0000\u0000\u0000\u00b5\u00c2\u0005#\u0000\u0000\u00b6\u00c2\u0005\""+
		"\u0000\u0000\u00b7\u00c2\u0005 \u0000\u0000\u00b8\u00c2\u0005!\u0000\u0000"+
		"\u00b9\u00c2\u0005%\u0000\u0000\u00ba\u00c2\u0005&\u0000\u0000\u00bb\u00bc"+
		"\u0005$\u0000\u0000\u00bc\u00c2\u0006\u000b\uffff\uffff\u0000\u00bd\u00be"+
		"\u0005\u0007\u0000\u0000\u00be\u00bf\u0003\u0012\t\u0000\u00bf\u00c0\u0005"+
		"\b\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00b5\u0001\u0000"+
		"\u0000\u0000\u00c1\u00b6\u0001\u0000\u0000\u0000\u00c1\u00b7\u0001\u0000"+
		"\u0000\u0000\u00c1\u00b8\u0001\u0000\u0000\u0000\u00c1\u00b9\u0001\u0000"+
		"\u0000\u0000\u00c1\u00ba\u0001\u0000\u0000\u0000\u00c1\u00bb\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bd\u0001\u0000\u0000\u0000\u00c2\u0017\u0001\u0000"+
		"\u0000\u0000\u0014\u001b#,3>NY_gkx\u007f\u008b\u0094\u009c\u009f\u00a6"+
		"\u00b0\u00b3\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}