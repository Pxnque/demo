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
		INT=23, FLOAT=24, BOOL=25, STRING=26, CHAR=27, INC=28, DEC=29, PRINT=30, 
		TRUE=31, FALSE=32, FLOAT_NUM=33, NUM=34, ID=35, STRING_LITERAL=36, WS=37;
	public static final int
		RULE_program = 0, RULE_instruccion = 1, RULE_print = 2, RULE_declaracion = 3, 
		RULE_incdec = 4, RULE_ifdecla = 5, RULE_condicional = 6, RULE_fordecla = 7, 
		RULE_expr = 8, RULE_termino = 9, RULE_factor = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruccion", "print", "declaracion", "incdec", "ifdecla", 
			"condicional", "fordecla", "expr", "termino", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'('", "')'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'||'", "'&&'", "'{'", "'}'", 
			"'if'", "'else'", "'else if'", "'for'", "'int'", "'float'", "'bool'", 
			"'string'", "'char'", "'++'", "'--'", "'print'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_SUMA", "OP_RESTA", "OP_MULT", "OP_DIV", "OP_ASIGN", "SEMI", 
			"LPAREN", "RPAREN", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", "IGUAL", 
			"DIFERENTE", "OR", "AND", "LCURLY", "RCURLY", "IF", "ELSE", "ELSEIF", 
			"FOR", "INT", "FLOAT", "BOOL", "STRING", "CHAR", "INC", "DEC", "PRINT", 
			"TRUE", "FALSE", "FLOAT_NUM", "NUM", "ID", "STRING_LITERAL", "WS"
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				instruccion();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << FLOAT_NUM) | (1L << NUM) | (1L << ID) | (1L << STRING_LITERAL))) != 0) );
			setState(27);
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
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
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
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				((InstruccionContext)_localctx).ID = match(ID);
				setState(30);
				match(OP_ASIGN);
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(31);
					expr();
					}
					break;
				case 2:
					{
					setState(32);
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
				setState(37);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				condicional();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				declaracion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				ifdecla();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				fordecla();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				incdec();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				print();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(PRINT);
			setState(47);
			match(LPAREN);
			{
			setState(48);
			expr();
			}
			setState(49);
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
		enterRule(_localctx, 6, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
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
			setState(52);
			((DeclaracionContext)_localctx).ID = match(ID);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASIGN) {
				{
				setState(53);
				((DeclaracionContext)_localctx).OP_ASIGN = match(OP_ASIGN);
				setState(54);
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
		enterRule(_localctx, 8, RULE_incdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			((IncdecContext)_localctx).ID = match(ID);
			 
			        checkVariableExists((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			        VariableInfo info = symbolTable.get((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null));
			        checkVariableInitialized((((IncdecContext)_localctx).ID!=null?((IncdecContext)_localctx).ID.getText():null), ((IncdecContext)_localctx).ID);
			    
			setState(61);
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
		enterRule(_localctx, 10, RULE_ifdecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(IF);
			setState(64);
			match(LPAREN);
			setState(65);
			condicional();
			setState(66);
			match(RPAREN);
			setState(67);
			match(LCURLY);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				instruccion();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << FLOAT_NUM) | (1L << NUM) | (1L << ID) | (1L << STRING_LITERAL))) != 0) );
			setState(73);
			match(RCURLY);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(74);
				match(ELSEIF);
				setState(75);
				match(LPAREN);
				setState(76);
				condicional();
				setState(77);
				match(RPAREN);
				setState(78);
				match(LCURLY);
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					instruccion();
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << FLOAT_NUM) | (1L << NUM) | (1L << ID) | (1L << STRING_LITERAL))) != 0) );
				setState(84);
				match(RCURLY);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(91);
				match(ELSE);
				setState(92);
				match(LCURLY);
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					instruccion();
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << FLOAT_NUM) | (1L << NUM) | (1L << ID) | (1L << STRING_LITERAL))) != 0) );
				setState(98);
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
		enterRule(_localctx, 12, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			expr();
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR) | (1L << MENOR) | (1L << MAYORIGUAL) | (1L << MENORIGUAL) | (1L << IGUAL) | (1L << DIFERENTE) | (1L << OR) | (1L << AND))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
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
		enterRule(_localctx, 14, RULE_fordecla);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(FOR);
			setState(107);
			match(LPAREN);
			setState(108);
			declaracion();
			setState(109);
			match(SEMI);
			setState(110);
			condicional();
			setState(111);
			match(SEMI);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(112);
				incdec();
				}
			}

			setState(115);
			match(RPAREN);
			setState(116);
			match(LCURLY);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				instruccion();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << IF) | (1L << FOR) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << FLOAT_NUM) | (1L << NUM) | (1L << ID) | (1L << STRING_LITERAL))) != 0) );
			setState(122);
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
		enterRule(_localctx, 16, RULE_expr);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				termino();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_SUMA) {
					{
					{
					setState(125);
					match(OP_SUMA);
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				termino();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_RESTA) {
					{
					{
					setState(133);
					match(OP_RESTA);
					setState(134);
					termino();
					}
					}
					setState(139);
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
		enterRule(_localctx, 18, RULE_termino);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				factor();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_MULT) {
					{
					{
					setState(143);
					match(OP_MULT);
					setState(144);
					factor();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				factor();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_DIV) {
					{
					{
					setState(151);
					((TerminoContext)_localctx).OP_DIV = match(OP_DIV);
					setState(152);
					((TerminoContext)_localctx).divisor = factor();

					        // Validar división por cero en literales
					        if (((TerminoContext)_localctx).divisor.NUM() != null) {
					            checkDivisionByZero(((TerminoContext)_localctx).divisor.NUM().getText(), ((TerminoContext)_localctx).OP_DIV);
					        }
					    
					}
					}
					setState(159);
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
		public TerminalNode FLOAT_NUM() { return getToken(LanguageParser.FLOAT_NUM, 0); }
		public TerminalNode TRUE() { return getToken(LanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LanguageParser.FALSE, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(LanguageParser.STRING_LITERAL, 0); }
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
		enterRule(_localctx, 20, RULE_factor);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(NUM);
				}
				break;
			case FLOAT_NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(FLOAT_NUM);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				match(FALSE);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				match(STRING_LITERAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				((FactorContext)_localctx).ID = match(ID);
				 
				        checkVariableExists((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID);
				        checkVariableInitialized((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null), ((FactorContext)_localctx).ID); 
				    
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(169);
				match(LPAREN);
				setState(170);
				expr();
				setState(171);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\3\3\3\3\5\3$\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\5:\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\6\7H\n\7\r\7\16\7I\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7S\n\7\r\7\16\7T\3"+
		"\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\3\7\3\7\6\7a\n\7\r\7\16\7b\3\7\3\7"+
		"\5\7g\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tt\n\t\3\t\3\t"+
		"\3\t\6\ty\n\t\r\t\16\tz\3\t\3\t\3\n\3\n\3\n\7\n\u0082\n\n\f\n\16\n\u0085"+
		"\13\n\3\n\3\n\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\5\n\u008f\n\n\3\13"+
		"\3\13\3\13\7\13\u0094\n\13\f\13\16\13\u0097\13\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u009e\n\13\f\13\16\13\u00a1\13\13\5\13\u00a3\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b0\n\f\3\f\2\2\r\2\4\6\b\n\f"+
		"\16\20\22\24\26\2\5\3\2\31\35\3\2\36\37\3\2\13\22\2\u00c3\2\31\3\2\2\2"+
		"\4.\3\2\2\2\6\60\3\2\2\2\b\65\3\2\2\2\n=\3\2\2\2\fA\3\2\2\2\16h\3\2\2"+
		"\2\20l\3\2\2\2\22\u008e\3\2\2\2\24\u00a2\3\2\2\2\26\u00af\3\2\2\2\30\32"+
		"\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35"+
		"\3\2\2\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \7%\2\2 #\7\7\2\2!$\5\22\n\2\""+
		"$\5\16\b\2#!\3\2\2\2#\"\3\2\2\2$%\3\2\2\2%&\b\3\1\2&/\3\2\2\2\'/\5\22"+
		"\n\2(/\5\16\b\2)/\5\b\5\2*/\5\f\7\2+/\5\20\t\2,/\5\n\6\2-/\5\6\4\2.\37"+
		"\3\2\2\2.\'\3\2\2\2.(\3\2\2\2.)\3\2\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2"+
		".-\3\2\2\2/\5\3\2\2\2\60\61\7 \2\2\61\62\7\t\2\2\62\63\5\22\n\2\63\64"+
		"\7\n\2\2\64\7\3\2\2\2\65\66\t\2\2\2\669\7%\2\2\678\7\7\2\28:\5\22\n\2"+
		"9\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\b\5\1\2<\t\3\2\2\2=>\7%\2\2>?\b\6\1"+
		"\2?@\t\3\2\2@\13\3\2\2\2AB\7\25\2\2BC\7\t\2\2CD\5\16\b\2DE\7\n\2\2EG\7"+
		"\23\2\2FH\5\4\3\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KZ"+
		"\7\24\2\2LM\7\27\2\2MN\7\t\2\2NO\5\16\b\2OP\7\n\2\2PR\7\23\2\2QS\5\4\3"+
		"\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\24\2\2WY\3\2"+
		"\2\2XL\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[f\3\2\2\2\\Z\3\2\2\2]^\7"+
		"\26\2\2^`\7\23\2\2_a\5\4\3\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c"+
		"d\3\2\2\2de\7\24\2\2eg\3\2\2\2f]\3\2\2\2fg\3\2\2\2g\r\3\2\2\2hi\5\22\n"+
		"\2ij\t\4\2\2jk\5\22\n\2k\17\3\2\2\2lm\7\30\2\2mn\7\t\2\2no\5\b\5\2op\7"+
		"\b\2\2pq\5\16\b\2qs\7\b\2\2rt\5\n\6\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv"+
		"\7\n\2\2vx\7\23\2\2wy\5\4\3\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{|\3\2\2\2|}\7\24\2\2}\21\3\2\2\2~\u0083\5\24\13\2\177\u0080\7\3\2\2\u0080"+
		"\u0082\5\24\13\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u008f\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u008b\5\24\13\2\u0087\u0088\7\4\2\2\u0088\u008a\5\24\13\2\u0089\u0087"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e~\3\2\2\2\u008e\u0086\3\2\2\2"+
		"\u008f\23\3\2\2\2\u0090\u0095\5\26\f\2\u0091\u0092\7\5\2\2\u0092\u0094"+
		"\5\26\f\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\u00a3\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009f"+
		"\5\26\f\2\u0099\u009a\7\6\2\2\u009a\u009b\5\26\f\2\u009b\u009c\b\13\1"+
		"\2\u009c\u009e\3\2\2\2\u009d\u0099\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u0090\3\2\2\2\u00a2\u0098\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00b0\7$\2\2"+
		"\u00a5\u00b0\7#\2\2\u00a6\u00b0\7!\2\2\u00a7\u00b0\7\"\2\2\u00a8\u00b0"+
		"\7&\2\2\u00a9\u00aa\7%\2\2\u00aa\u00b0\b\f\1\2\u00ab\u00ac\7\t\2\2\u00ac"+
		"\u00ad\5\22\n\2\u00ad\u00ae\7\n\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a4\3"+
		"\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00a6\3\2\2\2\u00af\u00a7\3\2\2\2\u00af"+
		"\u00a8\3\2\2\2\u00af\u00a9\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\27\3\2\2"+
		"\2\24\33#.9ITZbfsz\u0083\u008b\u008e\u0095\u009f\u00a2\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}