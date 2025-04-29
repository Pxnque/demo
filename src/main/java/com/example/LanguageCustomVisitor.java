package com.example;

import java.util.HashMap;

import com.example.LanguageParser.*;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {

    public final HashMap<String, Object> tablaSimbolos = new HashMap<>();

    @Override
    public Object visitProgram(ProgramContext ctx) {
        Object result = null;
        for (InstruccionContext instr : ctx.instruccion()) {
            result = visit(instr);
        }
        return result;
    }

    @Override
    public Object visitIfdecla(IfdeclaContext ctx) {
        Object result = null;
        if (ctx.condicional() != null) {
            System.out.println("Condicion: ");
            for (InstruccionContext instr : ctx.instruccion()) {
                result = visit(instr);
            }
        }
        return result;
    }

    @Override
    public Object visitInstruccion(InstruccionContext ctx) {
        if (ctx.OP_ASIGN() != null) {
            String identificador = ctx.ID().getText();
            Object valor = ctx.expr() != null ? visit(ctx.expr()) : visit(ctx.condicional());
            tablaSimbolos.put(identificador, valor);
            System.out.println("Se asignó " + identificador + " = " + valor);
            return valor;
        } else if (ctx.expr() != null) {
            Object result = visit(ctx.expr());
            System.out.println("Resultado expresión: " + result);
            return result;
        } else if (ctx.condicional() != null) {
            Object result = visit(ctx.condicional());
            System.out.println("Resultado condicional: " + result);
            return result;
        } else if (ctx.declaracion() != null) {
            String varName = ctx.declaracion().ID().getText();
            System.out.println("Declaración de variable tipo " + ctx.declaracion().tipo.getText() + " -> " + varName);
            if (ctx.declaracion().expr() != null && !ctx.declaracion().expr().isEmpty()) {
                Object value = visit(ctx.declaracion().expr());
                tablaSimbolos.put(varName, value);
            } else {
                tablaSimbolos.put(varName, 0); // valor por defecto
            }
            return null;
        } else if (ctx.ifdecla() != null) {
            System.out.println("Llegó a la línea de un If: ");
            return visit(ctx.ifdecla());
        } else if (ctx.fordecla() != null) {
            System.out.println("Llegó a la línea de un For: ");
            return visit(ctx.fordecla());
        } else if (ctx.incdec() != null) {
            return visit(ctx.incdec());
        } else if (ctx.print() != null) {
            if (ctx.print().expr() != null) {
                Object result = visit(ctx.print().expr());
                System.out.println(result);
            } else {
                System.out.println("Error: está vacío el print");
            }
        }
        return null;
    }

    @Override
    public Object visitDeclaracion(DeclaracionContext ctx) {
        return super.visitDeclaracion(ctx);
    }

    @Override
    public Object visitIncdec(IncdecContext ctx) {
        String id = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(id) || !(tablaSimbolos.get(id) instanceof Integer)) {
            System.out.println("Error: Variable " + id + " no declarada o no es entera");
            return null;
        }

        int value = (Integer) tablaSimbolos.get(id);
        if (ctx.INC() != null) {
            value++;
            System.out.println("Se incrementó " + id + " = " + value);
        } else if (ctx.DEC() != null) {
            value--;
            System.out.println("Se decrementó " + id + " = " + value);
        }
        tablaSimbolos.put(id, value);
        return value;
    }

    @Override
    public Object visitFordecla(FordeclaContext ctx) {
        Object result = null;
        if (ctx.declaracion() != null) {
            String varName = ctx.declaracion().ID().getText();
            Object initVal = visit(ctx.declaracion().expr(0));
            tablaSimbolos.put(varName, initVal);
            System.out.println("Declaración de variable " + varName + " = " + initVal);
        }

        while ((Integer) visit(ctx.condicional()) == 1) {
            for (InstruccionContext instr : ctx.instruccion()) {
                visit(instr);
            }
            if (ctx.incdec() != null) {
                visit(ctx.incdec());
            }
        }

        System.out.println("Se terminó el for");
        return result;
    }

    @Override
    public Object visitCondicional(CondicionalContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));

        if (!(left instanceof Integer) || !(right instanceof Integer)) {
            throw new RuntimeException("Condicionales solo soportan enteros por ahora");
        }

        int l = (Integer) left;
        int r = (Integer) right;

        if (ctx.MAYOR() != null) return l > r ? 1 : 0;
        if (ctx.MENOR() != null) return l < r ? 1 : 0;
        if (ctx.MAYORIGUAL() != null) return l >= r ? 1 : 0;
        if (ctx.MENORIGUAL() != null) return l <= r ? 1 : 0;
        if (ctx.IGUAL() != null) return l == r ? 1 : 0;
        if (ctx.DIFERENTE() != null) return l != r ? 1 : 0;
        if (ctx.AND() != null) return (l == 1 && r == 1) ? 1 : 0;
        if (ctx.OR() != null) return (l == 1 || r == 1) ? 1 : 0;
        return 0;
    }

    @Override
    public Object visitExpr(ExprContext ctx) {
        Object result = visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            Object right = visit(ctx.termino(i));

            if (result instanceof Integer && right instanceof Integer) {
                if (ctx.OP_SUMA(i - 1) != null) {
                    result = (Integer) result + (Integer) right;
                } else if (ctx.OP_RESTA(i - 1) != null) {
                    result = (Integer) result - (Integer) right;
                }
            } else if (result instanceof String || right instanceof String) {
                if (ctx.OP_SUMA(i - 1) != null) {
                    result = String.valueOf(result) + String.valueOf(right);
                } else {
                    throw new RuntimeException("Solo se permite suma (concatenación) entre strings");
                }
            } else {
                throw new RuntimeException("Tipos incompatibles en expresión");
            }
        }
        return result;
    }

    @Override
    public Object visitTermino(TerminoContext ctx) {
        Object result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            Object right = visit(ctx.factor(i));

            if (result instanceof Integer && right instanceof Integer) {
                if (ctx.OP_MULT(i - 1) != null) {
                    result = (Integer) result * (Integer) right;
                } else if (ctx.OP_DIV(i - 1) != null) {
                    result = (Integer) result / (Integer) right;
                }
            } else {
                throw new RuntimeException("Solo se permiten operaciones aritméticas entre enteros");
            }
        }
        return result;
    }

    @Override
    public Object visitFactor(FactorContext ctx) {
        if (ctx.NUM() != null) {
            return Integer.parseInt(ctx.NUM().getText());
        } else if (ctx.STRING_LITERAL() != null) {
            String raw = ctx.STRING_LITERAL().getText();
            return raw.substring(1, raw.length() - 1); // quitar comillas
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (tablaSimbolos.containsKey(id)) {
                return tablaSimbolos.get(id);
            } else {
                System.out.println("Error: Variable " + id + " no declarada");
                return null;
            }
        } else {
            return visit(ctx.expr());
        }
    }
}
