// Generated from com\example\Language.g4 by ANTLR 4.9.2
package com.example;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, TIPO=9, 
		IF=10, ELSEIF=11, ELSE=12, FOR=13, BOOL=14, ID=15, NUM=16, FLOAT=17, LITERAL=18, 
		OP_SUMA=19, OP_RESTA=20, OP_MULT=21, OP_DIV=22, OP_INCREMENTO=23, PUNTO_COMA=24, 
		WS=25, COMENTARIO=26, COMENTARIO_MULTI=27;
	public static final int
		RULE_program = 0, RULE_instruccion = 1, RULE_declaracion = 2, RULE_asig = 3, 
		RULE_ifInstr = 4, RULE_ifbody = 5, RULE_elseifbody = 6, RULE_elsebody = 7, 
		RULE_forInstr = 8, RULE_forBody = 9, RULE_condicional = 10, RULE_opComparacion = 11, 
		RULE_expr = 12, RULE_termino = 13, RULE_factor = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruccion", "declaracion", "asig", "ifInstr", "ifbody", 
			"elseifbody", "elsebody", "forInstr", "forBody", "condicional", "opComparacion", 
			"expr", "termino", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'{'", "'}'", "'>'", "'<'", "'=='", null, 
			"'if'", "'elseif'", "'else'", "'for'", null, null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'++'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "TIPO", "IF", "ELSEIF", 
			"ELSE", "FOR", "BOOL", "ID", "NUM", "FLOAT", "LITERAL", "OP_SUMA", "OP_RESTA", 
			"OP_MULT", "OP_DIV", "OP_INCREMENTO", "PUNTO_COMA", "WS", "COMENTARIO", 
			"COMENTARIO_MULTI"
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
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				instruccion();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TIPO) | (1L << IF) | (1L << FOR) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0) );
			setState(35);
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
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InstruccionDeclaracionContext extends InstruccionContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(LanguageParser.PUNTO_COMA, 0); }
		public InstruccionDeclaracionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstruccionIfContext extends InstruccionContext {
		public IfInstrContext ifInstr() {
			return getRuleContext(IfInstrContext.class,0);
		}
		public InstruccionIfContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstruccionCondicionalContext extends InstruccionContext {
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(LanguageParser.PUNTO_COMA, 0); }
		public InstruccionCondicionalContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionCondicional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstruccionExpresionContext extends InstruccionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(LanguageParser.PUNTO_COMA, 0); }
		public InstruccionExpresionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionExpresion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstruccionAsignacionContext extends InstruccionContext {
		public AsigContext asig() {
			return getRuleContext(AsigContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(LanguageParser.PUNTO_COMA, 0); }
		public InstruccionAsignacionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstruccionForContext extends InstruccionContext {
		public ForInstrContext forInstr() {
			return getRuleContext(ForInstrContext.class,0);
		}
		public InstruccionForContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInstruccionFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInstruccionFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInstruccionFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruccion);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new InstruccionDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				declaracion();
				setState(38);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				_localctx = new InstruccionAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				asig();
				setState(41);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				_localctx = new InstruccionExpresionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				expr();
				setState(44);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				_localctx = new InstruccionCondicionalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				condicional();
				setState(47);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				_localctx = new InstruccionIfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				ifInstr();
				}
				break;
			case 6:
				_localctx = new InstruccionForContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				forInstr();
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
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclaracionConAsignacionContext extends DeclaracionContext {
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracionConAsignacionContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracionConAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracionConAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclaracionConAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionSimpleContext extends DeclaracionContext {
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public DeclaracionSimpleContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracionSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracionSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclaracionSimple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclaracionConAsignacionCondContext extends DeclaracionContext {
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public DeclaracionConAsignacionCondContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaracionConAsignacionCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaracionConAsignacionCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclaracionConAsignacionCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DeclaracionSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(TIPO);
				setState(54);
				match(ID);
				}
				break;
			case 2:
				_localctx = new DeclaracionConAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(TIPO);
				setState(56);
				match(ID);
				setState(57);
				match(T__0);
				setState(58);
				expr();
				}
				break;
			case 3:
				_localctx = new DeclaracionConAsignacionCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(TIPO);
				setState(60);
				match(ID);
				setState(61);
				match(T__0);
				setState(62);
				condicional();
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

	public static class AsigContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public AsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAsig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAsig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsigContext asig() throws RecognitionException {
		AsigContext _localctx = new AsigContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_asig);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(ID);
				setState(66);
				match(T__0);
				setState(67);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(ID);
				setState(69);
				match(T__0);
				setState(70);
				condicional();
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

	public static class IfInstrContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public List<CondicionalContext> condicional() {
			return getRuleContexts(CondicionalContext.class);
		}
		public CondicionalContext condicional(int i) {
			return getRuleContext(CondicionalContext.class,i);
		}
		public IfbodyContext ifbody() {
			return getRuleContext(IfbodyContext.class,0);
		}
		public List<TerminalNode> ELSEIF() { return getTokens(LanguageParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(LanguageParser.ELSEIF, i);
		}
		public List<ElseifbodyContext> elseifbody() {
			return getRuleContexts(ElseifbodyContext.class);
		}
		public ElseifbodyContext elseifbody(int i) {
			return getRuleContext(ElseifbodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public ElsebodyContext elsebody() {
			return getRuleContext(ElsebodyContext.class,0);
		}
		public IfInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfInstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfInstrContext ifInstr() throws RecognitionException {
		IfInstrContext _localctx = new IfInstrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifInstr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(IF);
			setState(74);
			match(T__1);
			setState(75);
			condicional();
			setState(76);
			match(T__2);
			setState(77);
			match(T__3);
			setState(78);
			ifbody();
			setState(79);
			match(T__4);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(80);
				match(ELSEIF);
				setState(81);
				match(T__1);
				setState(82);
				condicional();
				setState(83);
				match(T__2);
				setState(84);
				match(T__3);
				setState(85);
				elseifbody();
				setState(86);
				match(T__4);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(93);
				match(ELSE);
				setState(94);
				match(T__3);
				setState(95);
				elsebody();
				setState(96);
				match(T__4);
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

	public static class IfbodyContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public IfbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfbodyContext ifbody() throws RecognitionException {
		IfbodyContext _localctx = new IfbodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TIPO) | (1L << IF) | (1L << FOR) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(100);
				instruccion();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ElseifbodyContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ElseifbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterElseifbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitElseifbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitElseifbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifbodyContext elseifbody() throws RecognitionException {
		ElseifbodyContext _localctx = new ElseifbodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseifbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TIPO) | (1L << IF) | (1L << FOR) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(106);
				instruccion();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ElsebodyContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ElsebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsebody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterElsebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitElsebody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitElsebody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsebodyContext elsebody() throws RecognitionException {
		ElsebodyContext _localctx = new ElsebodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elsebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TIPO) | (1L << IF) | (1L << FOR) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(112);
				instruccion();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ForInstrContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<TerminalNode> PUNTO_COMA() { return getTokens(LanguageParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(LanguageParser.PUNTO_COMA, i);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public ForBodyContext forBody() {
			return getRuleContext(ForBodyContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterForInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitForInstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitForInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInstrContext forInstr() throws RecognitionException {
		ForInstrContext _localctx = new ForInstrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forInstr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(FOR);
			setState(119);
			match(T__1);
			setState(120);
			declaracion();
			setState(121);
			match(PUNTO_COMA);
			setState(122);
			condicional();
			setState(123);
			match(PUNTO_COMA);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0)) {
				{
				setState(124);
				expr();
				}
			}

			setState(127);
			match(T__2);
			setState(128);
			match(T__3);
			setState(129);
			forBody();
			setState(130);
			match(T__4);
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

	public static class ForBodyContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ForBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterForBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitForBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitForBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBodyContext forBody() throws RecognitionException {
		ForBodyContext _localctx = new ForBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << TIPO) | (1L << IF) | (1L << FOR) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << FLOAT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(132);
				instruccion();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public OpComparacionContext opComparacion() {
			return getRuleContext(OpComparacionContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_condicional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			expr();
			setState(139);
			opComparacion();
			setState(140);
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

	public static class OpComparacionContext extends ParserRuleContext {
		public OpComparacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opComparacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterOpComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitOpComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitOpComparacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpComparacionContext opComparacion() throws RecognitionException {
		OpComparacionContext _localctx = new OpComparacionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opComparacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			termino();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUMA || _la==OP_RESTA) {
				{
				setState(149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OP_SUMA:
					{
					setState(145);
					match(OP_SUMA);
					setState(146);
					termino();
					}
					break;
				case OP_RESTA:
					{
					setState(147);
					match(OP_RESTA);
					setState(148);
					termino();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TerminoContext extends ParserRuleContext {
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
		enterRule(_localctx, 26, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			factor();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULT || _la==OP_DIV) {
				{
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OP_MULT:
					{
					setState(155);
					match(OP_MULT);
					setState(156);
					factor();
					}
					break;
				case OP_DIV:
					{
					setState(157);
					match(OP_DIV);
					setState(158);
					factor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
        public RuleContext ID() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'ID'");
        }
	}
	public static class FactorIdContext extends FactorContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public FactorIdContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorBooleanoContext extends FactorContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public FactorBooleanoContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorBooleano(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorBooleano(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorNumeroContext extends FactorContext {
		public TerminalNode NUM() { return getToken(LanguageParser.NUM, 0); }
		public FactorNumeroContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorNumero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorNumero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorFloatContext extends FactorContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FactorFloatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorParentesisContext extends FactorContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorParentesisContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorTextoContext extends FactorContext {
		public TerminalNode LITERAL() { return getToken(LanguageParser.LITERAL, 0); }
		public FactorTextoContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorTexto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorTexto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorTexto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorIncrementoContext extends FactorContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode OP_INCREMENTO() { return getToken(LanguageParser.OP_INCREMENTO, 0); }
		public FactorIncrementoContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFactorIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFactorIncremento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFactorIncremento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FactorNumeroContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(NUM);
				}
				break;
			case 2:
				_localctx = new FactorFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(FLOAT);
				}
				break;
			case 3:
				_localctx = new FactorTextoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(LITERAL);
				}
				break;
			case 4:
				_localctx = new FactorBooleanoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(BOOL);
				}
				break;
			case 5:
				_localctx = new FactorIncrementoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(168);
				match(ID);
				setState(169);
				match(OP_INCREMENTO);
				}
				break;
			case 6:
				_localctx = new FactorIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(ID);
				}
				break;
			case 7:
				_localctx = new FactorParentesisContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(T__1);
				setState(172);
				expr();
				setState(173);
				match(T__2);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00b4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2"+
		"\16\2#\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\6\3\6\3\6\3\6\3\6\5\6e\n\6\3"+
		"\7\7\7h\n\7\f\7\16\7k\13\7\3\b\7\bn\n\b\f\b\16\bq\13\b\3\t\7\tt\n\t\f"+
		"\t\16\tw\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0080\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\7\13\u0088\n\13\f\13\16\13\u008b\13\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u0098\n\16\f\16\16\16\u009b\13\16\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u00a2\n\17\f\17\16\17\u00a5\13\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b2\n\20\3\20"+
		"\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\b\n\2\u00be\2!"+
		"\3\2\2\2\4\65\3\2\2\2\6A\3\2\2\2\bI\3\2\2\2\nK\3\2\2\2\fi\3\2\2\2\16o"+
		"\3\2\2\2\20u\3\2\2\2\22x\3\2\2\2\24\u0089\3\2\2\2\26\u008c\3\2\2\2\30"+
		"\u0090\3\2\2\2\32\u0092\3\2\2\2\34\u009c\3\2\2\2\36\u00b1\3\2\2\2 \"\5"+
		"\4\3\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\2\2\3&\3"+
		"\3\2\2\2\'(\5\6\4\2()\7\32\2\2)\66\3\2\2\2*+\5\b\5\2+,\7\32\2\2,\66\3"+
		"\2\2\2-.\5\32\16\2./\7\32\2\2/\66\3\2\2\2\60\61\5\26\f\2\61\62\7\32\2"+
		"\2\62\66\3\2\2\2\63\66\5\n\6\2\64\66\5\22\n\2\65\'\3\2\2\2\65*\3\2\2\2"+
		"\65-\3\2\2\2\65\60\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\67"+
		"8\7\13\2\28B\7\21\2\29:\7\13\2\2:;\7\21\2\2;<\7\3\2\2<B\5\32\16\2=>\7"+
		"\13\2\2>?\7\21\2\2?@\7\3\2\2@B\5\26\f\2A\67\3\2\2\2A9\3\2\2\2A=\3\2\2"+
		"\2B\7\3\2\2\2CD\7\21\2\2DE\7\3\2\2EJ\5\32\16\2FG\7\21\2\2GH\7\3\2\2HJ"+
		"\5\26\f\2IC\3\2\2\2IF\3\2\2\2J\t\3\2\2\2KL\7\f\2\2LM\7\4\2\2MN\5\26\f"+
		"\2NO\7\5\2\2OP\7\6\2\2PQ\5\f\7\2Q\\\7\7\2\2RS\7\r\2\2ST\7\4\2\2TU\5\26"+
		"\f\2UV\7\5\2\2VW\7\6\2\2WX\5\16\b\2XY\7\7\2\2Y[\3\2\2\2ZR\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]d\3\2\2\2^\\\3\2\2\2_`\7\16\2\2`a\7\6\2\2"+
		"ab\5\20\t\2bc\7\7\2\2ce\3\2\2\2d_\3\2\2\2de\3\2\2\2e\13\3\2\2\2fh\5\4"+
		"\3\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\r\3\2\2\2ki\3\2\2\2ln\5"+
		"\4\3\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\17\3\2\2\2qo\3\2\2\2r"+
		"t\5\4\3\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\21\3\2\2\2wu\3\2\2"+
		"\2xy\7\17\2\2yz\7\4\2\2z{\5\6\4\2{|\7\32\2\2|}\5\26\f\2}\177\7\32\2\2"+
		"~\u0080\5\32\16\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\7\5\2\2\u0082\u0083\7\6\2\2\u0083\u0084\5\24\13\2\u0084\u0085\7"+
		"\7\2\2\u0085\23\3\2\2\2\u0086\u0088\5\4\3\2\u0087\u0086\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\25\3\2\2"+
		"\2\u008b\u0089\3\2\2\2\u008c\u008d\5\32\16\2\u008d\u008e\5\30\r\2\u008e"+
		"\u008f\5\32\16\2\u008f\27\3\2\2\2\u0090\u0091\t\2\2\2\u0091\31\3\2\2\2"+
		"\u0092\u0099\5\34\17\2\u0093\u0094\7\25\2\2\u0094\u0098\5\34\17\2\u0095"+
		"\u0096\7\26\2\2\u0096\u0098\5\34\17\2\u0097\u0093\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\33\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a3\5\36\20\2\u009d\u009e\7\27"+
		"\2\2\u009e\u00a2\5\36\20\2\u009f\u00a0\7\30\2\2\u00a0\u00a2\5\36\20\2"+
		"\u00a1\u009d\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\35\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00b2\7\22\2\2\u00a7\u00b2\7\23\2\2\u00a8\u00b2\7\24\2\2\u00a9\u00b2"+
		"\7\20\2\2\u00aa\u00ab\7\21\2\2\u00ab\u00b2\7\31\2\2\u00ac\u00b2\7\21\2"+
		"\2\u00ad\u00ae\7\4\2\2\u00ae\u00af\5\32\16\2\u00af\u00b0\7\5\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00a6\3\2\2\2\u00b1\u00a7\3\2\2\2\u00b1\u00a8\3\2"+
		"\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b2\37\3\2\2\2\22#\65AI\\diou\177\u0089\u0097\u0099\u00a1"+
		"\u00a3\u00b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}