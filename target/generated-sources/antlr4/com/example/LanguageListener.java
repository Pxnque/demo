// Generated from com\example\Language.g4 by ANTLR 4.9.2
package com.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionDeclaracion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionDeclaracion(LanguageParser.InstruccionDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionDeclaracion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionDeclaracion(LanguageParser.InstruccionDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionAsignacion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionAsignacion(LanguageParser.InstruccionAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionAsignacion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionAsignacion(LanguageParser.InstruccionAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionExpresion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionExpresion(LanguageParser.InstruccionExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionExpresion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionExpresion(LanguageParser.InstruccionExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionCondicional}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionCondicional(LanguageParser.InstruccionCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionCondicional}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionCondicional(LanguageParser.InstruccionCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionIf}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionIf(LanguageParser.InstruccionIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionIf}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionIf(LanguageParser.InstruccionIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instruccionFor}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccionFor(LanguageParser.InstruccionForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instruccionFor}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccionFor(LanguageParser.InstruccionForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionSimple}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSimple(LanguageParser.DeclaracionSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionSimple}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSimple(LanguageParser.DeclaracionSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionConAsignacion}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionConAsignacion(LanguageParser.DeclaracionConAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionConAsignacion}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionConAsignacion(LanguageParser.DeclaracionConAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionConAsignacionCond}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionConAsignacionCond(LanguageParser.DeclaracionConAsignacionCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionConAsignacionCond}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionConAsignacionCond(LanguageParser.DeclaracionConAsignacionCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#asig}.
	 * @param ctx the parse tree
	 */
	void enterAsig(LanguageParser.AsigContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#asig}.
	 * @param ctx the parse tree
	 */
	void exitAsig(LanguageParser.AsigContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifInstr}.
	 * @param ctx the parse tree
	 */
	void enterIfInstr(LanguageParser.IfInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifInstr}.
	 * @param ctx the parse tree
	 */
	void exitIfInstr(LanguageParser.IfInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifbody}.
	 * @param ctx the parse tree
	 */
	void enterIfbody(LanguageParser.IfbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifbody}.
	 * @param ctx the parse tree
	 */
	void exitIfbody(LanguageParser.IfbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elseifbody}.
	 * @param ctx the parse tree
	 */
	void enterElseifbody(LanguageParser.ElseifbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elseifbody}.
	 * @param ctx the parse tree
	 */
	void exitElseifbody(LanguageParser.ElseifbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elsebody}.
	 * @param ctx the parse tree
	 */
	void enterElsebody(LanguageParser.ElsebodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elsebody}.
	 * @param ctx the parse tree
	 */
	void exitElsebody(LanguageParser.ElsebodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forInstr}.
	 * @param ctx the parse tree
	 */
	void enterForInstr(LanguageParser.ForInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forInstr}.
	 * @param ctx the parse tree
	 */
	void exitForInstr(LanguageParser.ForInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forBody}.
	 * @param ctx the parse tree
	 */
	void enterForBody(LanguageParser.ForBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forBody}.
	 * @param ctx the parse tree
	 */
	void exitForBody(LanguageParser.ForBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(LanguageParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(LanguageParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#opComparacion}.
	 * @param ctx the parse tree
	 */
	void enterOpComparacion(LanguageParser.OpComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#opComparacion}.
	 * @param ctx the parse tree
	 */
	void exitOpComparacion(LanguageParser.OpComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(LanguageParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(LanguageParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorNumero}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorNumero(LanguageParser.FactorNumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorNumero}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorNumero(LanguageParser.FactorNumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorFloat}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorFloat(LanguageParser.FactorFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorFloat}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorFloat(LanguageParser.FactorFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorTexto}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorTexto(LanguageParser.FactorTextoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorTexto}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorTexto(LanguageParser.FactorTextoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorBooleano}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorBooleano(LanguageParser.FactorBooleanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorBooleano}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorBooleano(LanguageParser.FactorBooleanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorIncremento}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorIncremento(LanguageParser.FactorIncrementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorIncremento}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorIncremento(LanguageParser.FactorIncrementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorId}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorId(LanguageParser.FactorIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorId}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorId(LanguageParser.FactorIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorParentesis}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorParentesis(LanguageParser.FactorParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorParentesis}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorParentesis(LanguageParser.FactorParentesisContext ctx);
}