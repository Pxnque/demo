package com.example;

public class LanguageToCSharpVisitor extends LanguageBaseVisitor<String> {
    private final StringBuilder sb = new StringBuilder();
    private int indentLevel = 0;

    private void appendLine(String line) {
        for (int i = 0; i < indentLevel; i++) sb.append("    ");
        sb.append(line).append("\n");
    }

    @Override
    public String visitProgram(LanguageParser.ProgramContext ctx) {
        // Agregar el using y la estructura básica de un programa C#
        sb.append("using System;\n\n");
        sb.append("class Program {\n");
        indentLevel++;
        appendLine("static void Main(string[] args) {");
        indentLevel++;
        
        for (LanguageParser.InstruccionContext var : ctx.instruccion()) {
            String code = visit(var);
            if (code != null && !code.isEmpty()) sb.append(code);
        }
        
        indentLevel--;
        appendLine("}");
        indentLevel--;
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String visitDeclaracion(LanguageParser.DeclaracionContext ctx) {
        String tipo = mapTipoCSharp(ctx.tipo.getText());
        String varName = ctx.ID().getText();
        if (ctx.expr() != null) {
            String value = visit(ctx.expr());
            appendLine(tipo + " " + varName + " = " + value + ";");
        } else {
            appendLine(tipo + " " + varName + ";");
        }
        return "";
    }

    private String mapTipoCSharp(String tipo) {
        switch (tipo) {
            case "num": return "int";
            case "dec": return "float";
            case "bin": return "bool";
            case "txt": return "string";
            case "ch": return "char";
            default: return tipo;
        }
    }

    @Override
    public String visitIfdecla(LanguageParser.IfdeclaContext ctx) {
        appendLine("if (" + visit(ctx.condicional(0)) + ")");
        appendLine("{");
        indentLevel++;
        visit(ctx.instruccion(0));
        indentLevel--;
        appendLine("}");

        // Manejo de elif (en C# es else if)
        for (int i = 0; i < ctx.ELSEIF().size(); i++) {
            appendLine("else if (" + visit(ctx.condicional(i + 1)) + ")");
            appendLine("{");
            indentLevel++;
            visit(ctx.instruccion(i + 1));
            indentLevel--;
            appendLine("}");
        }

        // Manejo del else
        if (ctx.ELSE() != null) {
            appendLine("else");
            appendLine("{");
            indentLevel++;
            visit(ctx.instruccion(ctx.instruccion().size() - 1));
            indentLevel--;
            appendLine("}");
        }
        return "";
    }

    @Override
    public String visitWhiledecla(LanguageParser.WhiledeclaContext ctx) {
        appendLine("while (" + visit(ctx.condicional()) + ")");
        appendLine("{");
        indentLevel++;
        for (LanguageParser.InstruccionContext instr : ctx.instruccion()) {
            visit(instr);
        }
        indentLevel--;
        appendLine("}");
        return "";
    }

    @Override
    public String visitFordecla(LanguageParser.FordeclaContext ctx) {
        String init = visit(ctx.declaracion());
        String cond = visit(ctx.condicional());
        String inc = ctx.incdec() != null ? visit(ctx.incdec()) : "";
        
        appendLine("for (" + init.trim() + " " + cond + "; " + 
                  ctx.declaracion().ID().getText() + "++)");
        appendLine("{");
        indentLevel++;
        for (LanguageParser.InstruccionContext instr : ctx.instruccion()) {
            visit(instr);
        }
        indentLevel--;
        appendLine("}");
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
        else if (ctx.OR() != null) op = "||";
        else if (ctx.AND() != null) op = "&&";

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
        if (ctx.FLOAT_NUM() != null) return ctx.FLOAT_NUM().getText() + "f";
        if (ctx.TRUE() != null) return "true";
        if (ctx.FALSE() != null) return "false";
        if (ctx.STRING_LITERAL() != null) return ctx.STRING_LITERAL().getText();
        if (ctx.CHAR_LITERAL() != null) return ctx.CHAR_LITERAL().getText();
        if (ctx.ID() != null) return ctx.ID().getText();
        if (ctx.expr() != null) return "(" + visit(ctx.expr()) + ")";
        return "";
    }

    @Override
    public String visitPrint(LanguageParser.PrintContext ctx) {
        String expr = visit(ctx.expr());
        appendLine("Console.WriteLine(" + expr + ");");
        return "";
    }

    @Override
    public String visitIncdec(LanguageParser.IncdecContext ctx) {
        String id = ctx.ID().getText();
        if (ctx.INC() != null) {
            appendLine(id + "++;");
        } else if (ctx.DEC() != null) {
            appendLine(id + "--;");
        }
        return "";
    }
}
