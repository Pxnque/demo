// Generated from com/example/Language.g4 by ANTLR 4.9.2
package com.example;

import java.util.HashMap;

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
	 * Enter a parse tree produced by {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(LanguageParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(LanguageParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LanguageParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LanguageParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(LanguageParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(LanguageParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#incdec}.
	 * @param ctx the parse tree
	 */
	void enterIncdec(LanguageParser.IncdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#incdec}.
	 * @param ctx the parse tree
	 */
	void exitIncdec(LanguageParser.IncdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifdecla}.
	 * @param ctx the parse tree
	 */
	void enterIfdecla(LanguageParser.IfdeclaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifdecla}.
	 * @param ctx the parse tree
	 */
	void exitIfdecla(LanguageParser.IfdeclaContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#fordecla}.
	 * @param ctx the parse tree
	 */
	void enterFordecla(LanguageParser.FordeclaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#fordecla}.
	 * @param ctx the parse tree
	 */
	void exitFordecla(LanguageParser.FordeclaContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LanguageParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LanguageParser.FactorContext ctx);
}