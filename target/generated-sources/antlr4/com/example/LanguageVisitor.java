// Generated from com/example/Language.g4 by ANTLR 4.9.2
package com.example;

import java.util.HashMap;

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
	 * Visit a parse tree produced by {@link LanguageParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(LanguageParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(LanguageParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(LanguageParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#incdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncdec(LanguageParser.IncdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifdecla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfdecla(LanguageParser.IfdeclaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(LanguageParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#fordecla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFordecla(LanguageParser.FordeclaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#whiledecla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhiledecla(LanguageParser.WhiledeclaContext ctx);
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
	 * Visit a parse tree produced by {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LanguageParser.FactorContext ctx);
}