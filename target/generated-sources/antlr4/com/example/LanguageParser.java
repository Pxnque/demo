// Generated from com\example\Language.g4 by ANTLR 4.9.2
package com.example;

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitProgram(this);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << NUM) | (1L << ID))) != 0) );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR))) != 0)) ) {
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

	public static class IncdecContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INC() { return getToken(LanguageParser.INC, 0); }
		public TerminalNode DEC() { return getToken(LanguageParser.DEC, 0); }
		public IncdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIncdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIncdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIncdec(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfdecla(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfdecla(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfdecla(this);
			else return visitor.visitChildren(this);
		}
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << NUM) | (1L << ID))) != 0) );
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << NUM) | (1L << ID))) != 0) );
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << NUM) | (1L << ID))) != 0) );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCondicional(this);
			else return visitor.visitChildren(this);
		}
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR) | (1L << MENOR) | (1L << MAYORIGUAL) | (1L << MENORIGUAL) | (1L << IGUAL) | (1L << DIFERENTE) | (1L << OR) | (1L << AND))) != 0)) ) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFordecla(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFordecla(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFordecla(this);
			else return visitor.visitChildren(this);
		}
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << NUM) | (1L << ID))) != 0) );
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitTermino(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitTermino(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00a6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\6\2\30\n\2\r\2\16\2\31\3\2\3\2\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6@\n\6\r\6\16\6A\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\6\6K\n\6\r\6\16\6L\3\6\3\6\7\6Q\n\6\f\6\16\6T\13\6"+
		"\3\6\3\6\3\6\6\6Y\n\6\r\6\16\6Z\3\6\3\6\5\6_\n\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bl\n\b\3\b\3\b\3\b\6\bq\n\b\r\b\16\br\3\b\3\b"+
		"\3\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\t\3\t\3\t\7\t\u0082\n\t\f\t\16"+
		"\t\u0085\13\t\5\t\u0087\n\t\3\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\n\u0096\n\n\f\n\16\n\u0099\13\n\5\n\u009b\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a4\n\13\3\13\2\2\f\2\4\6\b"+
		"\n\f\16\20\22\24\2\5\3\2\31\35\3\2\36\37\3\2\13\22\2\u00b3\2\27\3\2\2"+
		"\2\4+\3\2\2\2\6-\3\2\2\2\b\65\3\2\2\2\n9\3\2\2\2\f`\3\2\2\2\16d\3\2\2"+
		"\2\20\u0086\3\2\2\2\22\u009a\3\2\2\2\24\u00a3\3\2\2\2\26\30\5\4\3\2\27"+
		"\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33"+
		"\34\7\2\2\3\34\3\3\2\2\2\35\36\7!\2\2\36!\7\7\2\2\37\"\5\20\t\2 \"\5\f"+
		"\7\2!\37\3\2\2\2! \3\2\2\2\"#\3\2\2\2#$\b\3\1\2$,\3\2\2\2%,\5\20\t\2&"+
		",\5\f\7\2\',\5\6\4\2(,\5\n\6\2),\5\16\b\2*,\5\b\5\2+\35\3\2\2\2+%\3\2"+
		"\2\2+&\3\2\2\2+\'\3\2\2\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,\5\3\2\2\2-.\t"+
		"\2\2\2.\61\7!\2\2/\60\7\7\2\2\60\62\5\20\t\2\61/\3\2\2\2\61\62\3\2\2\2"+
		"\62\63\3\2\2\2\63\64\b\4\1\2\64\7\3\2\2\2\65\66\7!\2\2\66\67\b\5\1\2\67"+
		"8\t\3\2\28\t\3\2\2\29:\7\25\2\2:;\7\t\2\2;<\5\f\7\2<=\7\n\2\2=?\7\23\2"+
		"\2>@\5\4\3\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CR\7\24"+
		"\2\2DE\7\27\2\2EF\7\t\2\2FG\5\f\7\2GH\7\n\2\2HJ\7\23\2\2IK\5\4\3\2JI\3"+
		"\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\24\2\2OQ\3\2\2\2PD"+
		"\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S^\3\2\2\2TR\3\2\2\2UV\7\26\2\2"+
		"VX\7\23\2\2WY\5\4\3\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2"+
		"\2\\]\7\24\2\2]_\3\2\2\2^U\3\2\2\2^_\3\2\2\2_\13\3\2\2\2`a\5\20\t\2ab"+
		"\t\4\2\2bc\5\20\t\2c\r\3\2\2\2de\7\30\2\2ef\7\t\2\2fg\5\6\4\2gh\7\b\2"+
		"\2hi\5\f\7\2ik\7\b\2\2jl\5\b\5\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\n\2"+
		"\2np\7\23\2\2oq\5\4\3\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2"+
		"\2\2tu\7\24\2\2u\17\3\2\2\2v{\5\22\n\2wx\7\3\2\2xz\5\22\n\2yw\3\2\2\2"+
		"z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\u0087\3\2\2\2}{\3\2\2\2~\u0083\5\22\n"+
		"\2\177\u0080\7\4\2\2\u0080\u0082\5\22\n\2\u0081\177\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086v\3\2\2\2\u0086~\3\2\2\2\u0087\21\3\2\2\2\u0088\u008d"+
		"\5\24\13\2\u0089\u008a\7\5\2\2\u008a\u008c\5\24\13\2\u008b\u0089\3\2\2"+
		"\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u009b"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0097\5\24\13\2\u0091\u0092\7\6\2\2"+
		"\u0092\u0093\5\24\13\2\u0093\u0094\b\n\1\2\u0094\u0096\3\2\2\2\u0095\u0091"+
		"\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u0088\3\2\2\2\u009a\u0090\3\2"+
		"\2\2\u009b\23\3\2\2\2\u009c\u00a4\7 \2\2\u009d\u009e\7!\2\2\u009e\u00a4"+
		"\b\13\1\2\u009f\u00a0\7\t\2\2\u00a0\u00a1\5\20\t\2\u00a1\u00a2\7\n\2\2"+
		"\u00a2\u00a4\3\2\2\2\u00a3\u009c\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009f"+
		"\3\2\2\2\u00a4\25\3\2\2\2\24\31!+\61ALRZ^kr{\u0083\u0086\u008d\u0097\u009a"+
		"\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}