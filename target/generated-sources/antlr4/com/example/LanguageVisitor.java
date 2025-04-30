// Generated from com\example\Language.g4 by ANTLR 4.9.2
package com.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionDeclaracion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionDeclaracion(LanguageParser.InstruccionDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionAsignacion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionAsignacion(LanguageParser.InstruccionAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionExpresion}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionExpresion(LanguageParser.InstruccionExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionCondicional}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionCondicional(LanguageParser.InstruccionCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionIf}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionIf(LanguageParser.InstruccionIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instruccionFor}
	 * labeled alternative in {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccionFor(LanguageParser.InstruccionForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionSimple}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionSimple(LanguageParser.DeclaracionSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionConAsignacion}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionConAsignacion(LanguageParser.DeclaracionConAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionConAsignacionCond}
	 * labeled alternative in {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionConAsignacionCond(LanguageParser.DeclaracionConAsignacionCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#asig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsig(LanguageParser.AsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfInstr(LanguageParser.IfInstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfbody(LanguageParser.IfbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#elseifbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifbody(LanguageParser.ElseifbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#elsebody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsebody(LanguageParser.ElsebodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#forInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInstr(LanguageParser.ForInstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#forBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBody(LanguageParser.ForBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(LanguageParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#opComparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpComparacion(LanguageParser.OpComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(LanguageParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorNumero}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorNumero(LanguageParser.FactorNumeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorFloat}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorFloat(LanguageParser.FactorFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorTexto}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorTexto(LanguageParser.FactorTextoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorBooleano}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorBooleano(LanguageParser.FactorBooleanoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorIncremento}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorIncremento(LanguageParser.FactorIncrementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorId}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorId(LanguageParser.FactorIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorParentesis}
	 * labeled alternative in {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorParentesis(LanguageParser.FactorParentesisContext ctx);
}