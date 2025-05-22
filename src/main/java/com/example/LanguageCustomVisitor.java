package com.example;

import java.util.HashMap;

import com.example.LanguageParser.*;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {
    private final StringBuilder output = new StringBuilder();
    public final HashMap<String, Object> tablaSimbolos = new HashMap<>();

   

    @Override
public Object visitProgram(ProgramContext ctx) {
    output.setLength(0); // Clear any previous output
    Object lastResult = null;
    for (InstruccionContext instr : ctx.instruccion()) {
        lastResult = visit(instr);
    }
    return lastResult;
}

@Override
public Object visitPrint(PrintContext ctx) {
    Object value = visit(ctx.expr());
    if (value != null) {
        String outputStr = value.toString();
        output.append(outputStr).append("\n");
        System.out.println("Debug - Print: " + outputStr); // Debug line
    }
    return null;
}

    public String getOutput() {
    String result = output.toString();
    System.out.println("Debug - Final output: " + result); // Debug line
    return result;
}

    // Clear output buffer if needed
    public void clearOutput() {
        output.setLength(0);
    }

    @Override
    public Object visitIfdecla(LanguageParser.IfdeclaContext ctx) {
        Object result = null;

        int instruccionIndex = 0;

        // IF principal
        if (evaluarCondicion(visit(ctx.condicional(0)))) {
            int ifInstrCount = ctx.instruccion().size() - ctx.ELSEIF().size() - (ctx.ELSE() != null ? 1 : 0);
            for (int i = 0; i < ifInstrCount; i++) {
                visit(ctx.instruccion(instruccionIndex++));
            }
            return result;
        }

        // ELSE IF (si hay)
        for (int i = 0; i < ctx.ELSEIF().size(); i++) {
            System.out.println("Entró a un elseif");
            if (evaluarCondicion(visit(ctx.condicional(i + 1)))) {
                System.out.println("Entró a un elseif verdadero");
                int elseifInstrCount = 1; // Asume una instrucción por bloque, o ajusta según necesidad
                for (int j = 0; j < elseifInstrCount; j++) {
                    visit(ctx.instruccion(instruccionIndex++));
                }
                return result;
            } else {
                // Aunque no se ejecuten, se deben saltar esas instrucciones en el índice
                instruccionIndex++; // Asume 1 instrucción por bloque
            }
        }

        // ELSE (si hay)
        if (ctx.ELSE() != null) {
            while (instruccionIndex < ctx.instruccion().size()) {
                visit(ctx.instruccion(instruccionIndex++));
            }
        }

        return result;
    }

    @Override
    public Object visitWhiledecla(WhiledeclaContext ctx) {
        Object result = null;
        while (evaluarCondicion(visit(ctx.condicional()))) {
            for (InstruccionContext instr : ctx.instruccion()) {
                visit(instr);
            }
        }
        System.out.println("Se terminó el while");
        return result;
    }

    @Override
    public Object visitInstruccion(InstruccionContext ctx) {
        if (ctx.print() != null) {
        return visit(ctx.print());
    }
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
                // Valores por defecto según el tipo
                String tipo = ctx.declaracion().tipo.getText();
                if (tipo.equals("num")) {
                    tablaSimbolos.put(varName, 0);
                } else if (tipo.equals("dec")) {
                    tablaSimbolos.put(varName, 0.0f);
                } else if (tipo.equals("bin")) {
                    tablaSimbolos.put(varName, false);
                } else if (tipo.equals("txt")) {
                    tablaSimbolos.put(varName, "");
                } else if (tipo.equals("ch")) {
                    tablaSimbolos.put(varName, '\0');
                }
            }
            return null;
        } else if (ctx.ifdecla() != null) {
            System.out.println("Llegó a la línea de un If: ");
            return visit(ctx.ifdecla());
        } else if (ctx.fordecla() != null) {
            System.out.println("Llegó a la línea de un For: ");
            return visit(ctx.fordecla());
        } else if (ctx.whiledecla() != null) {
            System.out.println("Llegó a la línea de un While: ");
            return visit(ctx.whiledecla());
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
        if (!tablaSimbolos.containsKey(id)) {
            System.out.println("Error: Variable " + id + " no declarada");
            return null;
        }

        Object value = tablaSimbolos.get(id);
        if (value instanceof Integer) {
            Integer intVal = (Integer) value;
            if (ctx.INC() != null) {
                intVal++;
                System.out.println("Se incrementó " + id + " = " + intVal);
            } else if (ctx.DEC() != null) {
                intVal--;
                System.out.println("Se decrementó " + id + " = " + intVal);
            }
            tablaSimbolos.put(id, intVal);
            return intVal;
        } else if (value instanceof Float) {
            Float floatVal = (Float) value;
            if (ctx.INC() != null) {
                floatVal++;
                System.out.println("Se incrementó " + id + " = " + floatVal);
            } else if (ctx.DEC() != null) {
                floatVal--;
                System.out.println("Se decrementó " + id + " = " + floatVal);
            }
            tablaSimbolos.put(id, floatVal);
            return floatVal;
        } else {
            System.out.println("Error: Incremento/decremento solo aplicable a números");
            return null;
        }
    }

    @Override
    public Object visitFordecla(FordeclaContext ctx) {
        Object result = null;
        if (ctx.declaracion() != null) {
            String varName = ctx.declaracion().ID().getText();
            Object initVal = visit(ctx.declaracion().expr());
            tablaSimbolos.put(varName, initVal);
            System.out.println("Declaración de variable " + varName + " = " + initVal);
        }

        while (evaluarCondicion(visit(ctx.condicional()))) {
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

    private boolean evaluarCondicion(Object condicion) {
        if (condicion instanceof Integer) {
            return ((Integer) condicion) == 1;
        } else if (condicion instanceof Boolean) {
            return (Boolean) condicion;
        }
        return false;
    }

    @Override
    public Object visitCondicional(CondicionalContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));

        // Si ambos son números, realizar comparación numérica
        if ((left instanceof Number) && (right instanceof Number)) {
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();

            if (ctx.MAYOR() != null)
                return l > r ? 1 : 0;
            if (ctx.MENOR() != null)
                return l < r ? 1 : 0;
            if (ctx.MAYORIGUAL() != null)
                return l >= r ? 1 : 0;
            if (ctx.MENORIGUAL() != null)
                return l <= r ? 1 : 0;
            if (ctx.IGUAL() != null)
                return l == r ? 1 : 0;
            if (ctx.DIFERENTE() != null)
                return l != r ? 1 : 0;
        }
        // Para tipos booleanos
        else if ((left instanceof Boolean) && (right instanceof Boolean)) {
            boolean l = (Boolean) left;
            boolean r = (Boolean) right;

            if (ctx.IGUAL() != null)
                return l == r ? 1 : 0;
            if (ctx.DIFERENTE() != null)
                return l != r ? 1 : 0;
            if (ctx.AND() != null)
                return (l && r) ? 1 : 0;
            if (ctx.OR() != null)
                return (l || r) ? 1 : 0;
        }
        // Para comparación de strings
        else if ((left instanceof String) && (right instanceof String)) {
            String l = (String) left;
            String r = (String) right;

            if (ctx.IGUAL() != null)
                return l.equals(r) ? 1 : 0;
            if (ctx.DIFERENTE() != null)
                return !l.equals(r) ? 1 : 0;
        }
        // Operadores lógicos cuando left y right son valores condicionales (0 o 1)
        else if (left instanceof Integer && right instanceof Integer) {
            boolean l = ((Integer) left) == 1;
            boolean r = ((Integer) right) == 1;

            if (ctx.AND() != null)
                return (l && r) ? 1 : 0;
            if (ctx.OR() != null)
                return (l || r) ? 1 : 0;
        }

        throw new RuntimeException("Tipos incompatibles en condicional: " + left.getClass() + " y " + right.getClass());
    }

    @Override
    public Object visitExpr(ExprContext ctx) {
        Object result = visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            Object right = visit(ctx.termino(i));

            if ((result instanceof Integer) && (right instanceof Integer)) {
                if (ctx.OP_SUMA(i - 1) != null) {
                    result = (Integer) result + (Integer) right;
                } else if (ctx.OP_RESTA(i - 1) != null) {
                    result = (Integer) result - (Integer) right;
                }
            } else if ((result instanceof Float) || (right instanceof Float)) {
                // Convertir a float si alguno es float
                float leftVal = (result instanceof Integer) ? ((Integer) result).floatValue() : (Float) result;
                float rightVal = (right instanceof Integer) ? ((Integer) right).floatValue() : (Float) right;

                if (ctx.OP_SUMA(i - 1) != null) {
                    result = leftVal + rightVal;
                } else if (ctx.OP_RESTA(i - 1) != null) {
                    result = leftVal - rightVal;
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

            if ((result instanceof Integer) && (right instanceof Integer)) {
                if (ctx.OP_MULT(i - 1) != null) {
                    result = (Integer) result * (Integer) right;
                } else if (ctx.OP_DIV(i - 1) != null) {
                    if ((Integer) right == 0) {
                        throw new RuntimeException("División por cero");
                    }
                    result = (Integer) result / (Integer) right;
                }
            } else if ((result instanceof Float) || (right instanceof Float)) {
                // Convertir a float si alguno es float
                float leftVal = (result instanceof Integer) ? ((Integer) result).floatValue() : (Float) result;
                float rightVal = (right instanceof Integer) ? ((Integer) right).floatValue() : (Float) right;

                if (ctx.OP_MULT(i - 1) != null) {
                    result = leftVal * rightVal;
                } else if (ctx.OP_DIV(i - 1) != null) {
                    if (rightVal == 0.0f) {
                        throw new RuntimeException("División por cero");
                    }
                    result = leftVal / rightVal;
                }
            } else {
                throw new RuntimeException("Solo se permiten operaciones aritméticas entre números");
            }
        }
        return result;
    }

    @Override
    public Object visitFactor(FactorContext ctx) {
        if (ctx.NUM() != null) {
            return Integer.parseInt(ctx.NUM().getText());
        } else if (ctx.FLOAT_NUM() != null) {
            return Float.parseFloat(ctx.FLOAT_NUM().getText());
        } else if (ctx.TRUE() != null) {
            return Boolean.TRUE;
        } else if (ctx.FALSE() != null) {
            return Boolean.FALSE;
        } else if (ctx.STRING_LITERAL() != null) {
            String raw = ctx.STRING_LITERAL().getText();
            return raw.substring(1, raw.length() - 1); // quitar comillas
        } else if (ctx.CHAR_LITERAL() != null) {
            String raw = ctx.CHAR_LITERAL().getText();
            return raw.charAt(1); // quitar comillas
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
