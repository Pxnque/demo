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
		RPAREN=8, MAYOR=9, MENOR=10, MAYORIGUAL=11, MENORIGUAL=12, IGUAL=13, DIFERENTE=14, 
		OR=15, AND=16, LCURLY=17, RCURLY=18, IF=19, ELSE=20, ELSEIF=21, FOR=22, 
		INT=23, FLOAT=24, BOOL=25, STRING=26, CHAR=27, INC=28, DEC=29, NUM=30, 
		ID=31, WS=32;
	public static final int
		RULE_program = 0, RULE_instruccion = 1, RULE_declaracion = 2, RULE_incdec = 3, 
		RULE_ifdecla = 4, RULE_condicional = 5, RULE_fordecla = 6, RULE_expr = 7, 
		RULE_termino = 8, RULE_factor = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruccion", "declaracion", "incdec", "ifdecla", "condicional", 
			"fordecla", "expr", "termino", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'('", "')'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'||'", "'&&'", "'{'", "'}'", 
			"'if'", "'else'", "'else if'", "'for'", "'int'", "'float'", "'bool'", 
			"'string'", "'char'", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", 
			"LPAREN", "RPAREN", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", "IGUAL", 
			"DIFERENTE", "OR", "AND", "LCURLY", "RCURLY", "IF", "ELSE", "ELSEIF", 
			"FOR", "INT", "FLOAT", "BOOL", "STRING", "CHAR", "INC", "DEC", "NUM", 
			"ID", "WS"
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
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				instruccion();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3485991040L) != 0) );
			setState(25);
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
		public IfdeclaContext ifdecla() {
			return getRuleContext(IfdeclaContext.class,0);
		}
		public FordeclaContext fordecla() {
			return getRuleContext(FordeclaContext.class,0);
		}
		public IncdecContext incdec() {
			return getRuleContext(IncdecContext.class,0);
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
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				((InstruccionContext)_localctx).ID = match(ID);
				setState(28);
				match(OP_ASIGN);
				setState(31);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(29);
					expr();
					}
					break;
				case 2:
					{
					setState(30);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				condicional();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				declaracion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				ifdecla();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				fordecla();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(40);
				incdec();
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
		enterRule(_localctx, 4, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((DeclaracionContext)_localctx).tipo = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 260046848L) != 0)) ) {
				((DeclaracionContext)_localctx).tipo = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(44);
			((DeclaracionContext)_localctx).ID = match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASIGN) {
				{
				setState(45);
				((DeclaracionContext)_localctx).OP_ASIGN = match(OP_ASIGN);
				setState(46);
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
		enterRule(_localctx, 6, RULE_incdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			((IncdecContext)_localctx).ID = match(ID);
			 
			        checkVariableExists((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			        VariableInfo info = symbolTable.get((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null));
			        checkVariableInitialized((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			    
			setState(53);
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
		enterRule(_localctx, 8, RULE_ifdecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(IF);
			setState(56);
			match(LPAREN);
			setState(57);
			condicional();
			setState(58);
			match(RPAREN);
			setState(59);
			match(LCURLY);
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				instruccion();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3485991040L) != 0) );
			setState(65);
			match(RCURLY);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(66);
				match(ELSEIF);
				setState(67);
				match(LPAREN);
				setState(68);
				condicional();
				setState(69);
				match(RPAREN);
				setState(70);
				match(LCURLY);
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					instruccion();
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3485991040L) != 0) );
				setState(76);
				match(RCURLY);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(83);
				match(ELSE);
				setState(84);
				match(LCURLY);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					instruccion();
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3485991040L) != 0) );
				setState(90);
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
		enterRule(_localctx, 10, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			expr();
			setState(95);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 130560L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(96);
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
		enterRule(_localctx, 12, RULE_fordecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(FOR);
			setState(99);
			match(LPAREN);
			setState(100);
			declaracion();
			setState(101);
			match(SEMI);
			setState(102);
			condicional();
			setState(103);
			match(SEMI);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(104);
				incdec();
				}
			}

			setState(107);
			match(RPAREN);
			setState(108);
			match(LCURLY);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				instruccion();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3485991040L) != 0) );
			setState(114);
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
		enterRule(_localctx, 14, RULE_expr);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				termino();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_SUMA) {
					{
					{
					setState(117);
					match(OP_SUMA);
					setState(118);
					termino();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				termino();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_RESTA) {
					{
					{
					setState(125);
					match(OP_RESTA);
					setState(126);
					termino();
					}
					}
					setState(131);
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
		enterRule(_localctx, 16, RULE_termino);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				factor();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_MULT) {
					{
					{
					setState(135);
					match(OP_MULT);
					setState(136);
					factor();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				factor();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_DIV) {
					{
					{
					setState(143);
					((TerminoContext)_localctx).OP_DIV = match(OP_DIV);
					setState(144);
					((TerminoContext)_localctx).divisor = factor();

					        // Validar división por cero en literales
					        if (((TerminoContext)_localctx).divisor.NUM() != null) {
					            checkDivisionByZero(((TerminoContext)_localctx).divisor.NUM().getText(), ((TerminoContext)_localctx).OP_DIV);
					        }
					    
					}
					}
					setState(151);
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
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(NUM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((FactorContext)_localctx).ID = match(ID);
				 
				        checkVariableExists((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID);
				        checkVariableInitialized((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID); // <-- ¡Nueva línea!
				    
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(LPAREN);
				setState(158);
				expr();
				setState(159);
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
		"\u0004\u0001 \u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001*\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00020\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004>\b\u0004\u000b\u0004\f\u0004?\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004I\b\u0004\u000b\u0004\f\u0004J\u0001\u0004\u0001\u0004\u0005"+
		"\u0004O\b\u0004\n\u0004\f\u0004R\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0004\u0004W\b\u0004\u000b\u0004\f\u0004X\u0001\u0004\u0001\u0004"+
		"\u0003\u0004]\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006j\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0004\u0006o\b\u0006\u000b\u0006\f\u0006p\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007x\b\u0007\n\u0007\f\u0007{\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0080\b\u0007\n"+
		"\u0007\f\u0007\u0083\t\u0007\u0003\u0007\u0085\b\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u008a\b\b\n\b\f\b\u008d\t\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u0094\b\b\n\b\f\b\u0097\t\b\u0003\b\u0099\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a2\b\t\u0001"+
		"\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000"+
		"\u0003\u0001\u0000\u0017\u001b\u0001\u0000\u001c\u001d\u0001\u0000\t\u0010"+
		"\u00b1\u0000\u0015\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u0004+\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000\b7\u0001"+
		"\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000"+
		"\u000e\u0084\u0001\u0000\u0000\u0000\u0010\u0098\u0001\u0000\u0000\u0000"+
		"\u0012\u00a1\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000"+
		"\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0000\u0000\u0001"+
		"\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u001f\u0000\u0000"+
		"\u001c\u001f\u0005\u0005\u0000\u0000\u001d \u0003\u000e\u0007\u0000\u001e"+
		" \u0003\n\u0005\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\"\u0006\u0001\uffff"+
		"\uffff\u0000\"*\u0001\u0000\u0000\u0000#*\u0003\u000e\u0007\u0000$*\u0003"+
		"\n\u0005\u0000%*\u0003\u0004\u0002\u0000&*\u0003\b\u0004\u0000\'*\u0003"+
		"\f\u0006\u0000(*\u0003\u0006\u0003\u0000)\u001b\u0001\u0000\u0000\u0000"+
		")#\u0001\u0000\u0000\u0000)$\u0001\u0000\u0000\u0000)%\u0001\u0000\u0000"+
		"\u0000)&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000"+
		"\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+,\u0007\u0000\u0000\u0000"+
		",/\u0005\u001f\u0000\u0000-.\u0005\u0005\u0000\u0000.0\u0003\u000e\u0007"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0006\u0002\uffff\uffff\u00002\u0005\u0001\u0000\u0000"+
		"\u000034\u0005\u001f\u0000\u000045\u0006\u0003\uffff\uffff\u000056\u0007"+
		"\u0001\u0000\u00006\u0007\u0001\u0000\u0000\u000078\u0005\u0013\u0000"+
		"\u000089\u0005\u0007\u0000\u00009:\u0003\n\u0005\u0000:;\u0005\b\u0000"+
		"\u0000;=\u0005\u0011\u0000\u0000<>\u0003\u0002\u0001\u0000=<\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AP\u0005\u0012\u0000\u0000"+
		"BC\u0005\u0015\u0000\u0000CD\u0005\u0007\u0000\u0000DE\u0003\n\u0005\u0000"+
		"EF\u0005\b\u0000\u0000FH\u0005\u0011\u0000\u0000GI\u0003\u0002\u0001\u0000"+
		"HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005\u0012"+
		"\u0000\u0000MO\u0001\u0000\u0000\u0000NB\u0001\u0000\u0000\u0000OR\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"Q\\\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0005\u0014\u0000"+
		"\u0000TV\u0005\u0011\u0000\u0000UW\u0003\u0002\u0001\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\u0012\u0000\u0000"+
		"[]\u0001\u0000\u0000\u0000\\S\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]\t\u0001\u0000\u0000\u0000^_\u0003\u000e\u0007\u0000_`\u0007\u0002"+
		"\u0000\u0000`a\u0003\u000e\u0007\u0000a\u000b\u0001\u0000\u0000\u0000"+
		"bc\u0005\u0016\u0000\u0000cd\u0005\u0007\u0000\u0000de\u0003\u0004\u0002"+
		"\u0000ef\u0005\u0006\u0000\u0000fg\u0003\n\u0005\u0000gi\u0005\u0006\u0000"+
		"\u0000hj\u0003\u0006\u0003\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005\b\u0000\u0000ln\u0005\u0011"+
		"\u0000\u0000mo\u0003\u0002\u0001\u0000nm\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rs\u0005\u0012\u0000\u0000s\r\u0001\u0000\u0000"+
		"\u0000ty\u0003\u0010\b\u0000uv\u0005\u0001\u0000\u0000vx\u0003\u0010\b"+
		"\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0085\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000|\u0081\u0003\u0010\b\u0000}~\u0005\u0002\u0000"+
		"\u0000~\u0080\u0003\u0010\b\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084t\u0001\u0000\u0000\u0000\u0084|\u0001"+
		"\u0000\u0000\u0000\u0085\u000f\u0001\u0000\u0000\u0000\u0086\u008b\u0003"+
		"\u0012\t\u0000\u0087\u0088\u0005\u0003\u0000\u0000\u0088\u008a\u0003\u0012"+
		"\t\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u0099\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e\u0095\u0003\u0012\t\u0000\u008f\u0090\u0005\u0004\u0000\u0000"+
		"\u0090\u0091\u0003\u0012\t\u0000\u0091\u0092\u0006\b\uffff\uffff\u0000"+
		"\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000"+
		"\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000"+
		"\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0086\u0001\u0000\u0000\u0000"+
		"\u0098\u008e\u0001\u0000\u0000\u0000\u0099\u0011\u0001\u0000\u0000\u0000"+
		"\u009a\u00a2\u0005\u001e\u0000\u0000\u009b\u009c\u0005\u001f\u0000\u0000"+
		"\u009c\u00a2\u0006\t\uffff\uffff\u0000\u009d\u009e\u0005\u0007\u0000\u0000"+
		"\u009e\u009f\u0003\u000e\u0007\u0000\u009f\u00a0\u0005\b\u0000\u0000\u00a0"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a1\u009a\u0001\u0000\u0000\u0000\u00a1"+
		"\u009b\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000\u00a2"+
		"\u0013\u0001\u0000\u0000\u0000\u0012\u0017\u001f)/?JPX\\ipy\u0081\u0084"+
		"\u008b\u0095\u0098\u00a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}