package com.example;

public class LanguageToPythonVisitor extends LanguageBaseVisitor<String> {
    private final StringBuilder sb = new StringBuilder();
    private int indentLevel = 0;

    private void appendLine(String line) {
        for (int i = 0; i < indentLevel; i++) sb.append("    ");
        sb.append(line).append("\n");
    }

    @Override
    public String visitProgram(LanguageParser.ProgramContext ctx) {
        for (LanguageParser.InstruccionContext var : ctx.instruccion()) {
            String code = visit(var);
            if (code != null && !code.isEmpty()) sb.append(code);
        }
        return sb.toString();
    }

    @Override
    public String visitDeclaracion(LanguageParser.DeclaracionContext ctx) {
        String varName = ctx.ID().getText();
        String value = ctx.expr() != null ? visit(ctx.expr()) : "None";
        appendLine(varName + " = " + value);
        return "";
    }

    @Override
    public String visitIfdecla(LanguageParser.IfdeclaContext ctx) {
        // Manejo del if principal
        appendLine("if " + visit(ctx.condicional(0)) + ":");
        indentLevel++;
        for (int i = 0; i < ctx.instruccion(0).getChildCount(); i++) {
            visit(ctx.instruccion(0));
        }
        indentLevel--;

        // Manejo de elif
        for (int i = 0; i < ctx.ELSEIF().size(); i++) {
            appendLine("elif " + visit(ctx.condicional(i + 1)) + ":");
            indentLevel++;
            visit(ctx.instruccion(i + 1));
            indentLevel--;
        }

        // Manejo del else
        if (ctx.ELSE() != null) {
            appendLine("else:");
            indentLevel++;
            visit(ctx.instruccion(ctx.instruccion().size() - 1));
            indentLevel--;
        }
        return "";
    }

    @Override
    public String visitWhiledecla(LanguageParser.WhiledeclaContext ctx) {
        appendLine("while " + visit(ctx.condicional()) + ":");
        indentLevel++;
        for (LanguageParser.InstruccionContext instr : ctx.instruccion()) {
            visit(instr);
        }
        indentLevel--;
        return "";
    }

    @Override
    public String visitFordecla(LanguageParser.FordeclaContext ctx) {
        String init = visit(ctx.declaracion());
        String cond = visit(ctx.condicional());
        String inc = ctx.incdec() != null ? visit(ctx.incdec()) : "";
        
        // Convertir a formato de for de Python
        appendLine("for " + ctx.declaracion().ID().getText() + " in range(" + cond + "):");
        indentLevel++;
        for (LanguageParser.InstruccionContext instr : ctx.instruccion()) {
            visit(instr);
        }
        indentLevel--;
        return "";
    }

    @Override
    public String visitCondicional(LanguageParser.CondicionalContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));
        String op = "";

        if (ctx.MAYOR() != null) op = ">";
        else if (ctx.MENOR() != null) op = "<";
        else if (ctx.MAYORIGUAL() != null) op = ">=";
        else if (ctx.MENORIGUAL() != null) op = "<=";
        else if (ctx.IGUAL() != null) op = "==";
        else if (ctx.DIFERENTE() != null) op = "!=";
        else if (ctx.OR() != null) op = "or";
        else if (ctx.AND() != null) op = "and";

        return left + " " + op + " " + right;
    }

    @Override
    public String visitExpr(LanguageParser.ExprContext ctx) {
        String result = visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            String op = ctx.OP_SUMA(i-1) != null ? "+" : "-";
            result += " " + op + " " + visit(ctx.termino(i));
        }
        return result;
    }

    @Override
    public String visitTermino(LanguageParser.TerminoContext ctx) {
        String result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.OP_MULT(i-1) != null ? "*" : "/";
            result += " " + op + " " + visit(ctx.factor(i));
        }
        return result;
    }

    @Override 
    public String visitFactor(LanguageParser.FactorContext ctx) {
        if (ctx.NUM() != null) return ctx.NUM().getText();
        if (ctx.FLOAT_NUM() != null) return ctx.FLOAT_NUM().getText();
        if (ctx.TRUE() != null) return "True";
        if (ctx.FALSE() != null) return "False";
        if (ctx.STRING_LITERAL() != null) return ctx.STRING_LITERAL().getText();
        if (ctx.CHAR_LITERAL() != null) return ctx.CHAR_LITERAL().getText();
        if (ctx.ID() != null) return ctx.ID().getText();
        if (ctx.expr() != null) return "(" + visit(ctx.expr()) + ")";
        return "";
    }

    @Override
    public String visitPrint(LanguageParser.PrintContext ctx) {
        String expr = visit(ctx.expr());
        appendLine("print(" + expr + ")");
        return "";
    }

    @Override
    public String visitIncdec(LanguageParser.IncdecContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.INC() != null) {
            appendLine(id + " += 1");
        } else if (ctx.DEC() != null) {
            appendLine(id + " -= 1");
        }
        return "";
    }
}