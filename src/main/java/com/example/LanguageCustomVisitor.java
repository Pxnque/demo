package com.example;

import java.util.HashMap;

import com.example.LanguageParser.*;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Variable> {

    public final HashMap<String, Variable> tablaSimbolos = new HashMap<>();

    @Override
    public Variable visitProgram(ProgramContext ctx) {
        Variable result = null;
        for(InstruccionContext instr: ctx.instruccion()){
            result = visit(instr);
        }

        return result;
    }

    @Override
    public Variable visitInstruccion(InstruccionContext ctx) {
        if(ctx.declaracion() != null){
            return visit(ctx.declaracion());
        } else if(ctx.asig() != null){
            return visit(ctx.asig());
        } else if(ctx.expr() != null){
            return(visit(ctx.expr()));
        } else if(ctx.condicional() != null){
            return(visit(ctx.condicional()));
        } else if(ctx.ifInstr() != null){
            return(visit(ctx.ifInstr()));
        } else if(ctx.forInstr() != null){
            return(visit(ctx.forInstr()));
        }
        return null;
    }

    @Override
    public Variable visitDeclaracionConAsignacion(DeclaracionConAsignacionContext ctx) {
        String tipoString = ctx.TIPO().getText();
        Variable.Tipo tipo;

        switch (tipoString) {
            case "int": tipo = Variable.Tipo.INT; break;
            case "float": tipo = Variable.Tipo.FLOAT; break;
            case "bool": tipo = Variable.Tipo.BOOLEAN; break;
            case "str": tipo = Variable.Tipo.STRING; break;
            default: throw new RuntimeException("Error: Tipo de variable desconocido: " + tipoString + ". (Line:"+ctx.getStart().getLine()+")");
        }

        tablaSimbolos.put(ctx.asig().ID().getText(), new Variable(tipo, null));
        System.out.println("Declaración: " + ctx.asig().ID().getText() + " de tipo " + tipo);

        Variable asignada = visit(ctx.asig());
        if (tipo != asignada.tipo) {
            throw new RuntimeException("Error: Tipo en asignación: se esperaba " + tipo + " y se recibió " + asignada.tipo +". (Line:"+ctx.getStart().getLine()+")");
        }

        tablaSimbolos.put(ctx.asig().ID().getText(), asignada);
        System.out.println("Declaración con asignación: " + ctx.asig().ID().getText() + " = " + asignada.valor);
        return null;
    }

    @Override
    public Variable visitDeclaracionSimple(DeclaracionSimpleContext ctx) {
        String tipoString = ctx.TIPO().getText();
        String id = ctx.ID().getText();

        if(tablaSimbolos.get(id) != null){
            throw new RuntimeException("Error: La variable "+ id +" ya ha sido declarada.(Line:"+ctx.getStart().getLine()+")");
        }

        Variable.Tipo tipo;

        switch (tipoString) {
            case "int": tipo = Variable.Tipo.INT; break;
            case "float": tipo = Variable.Tipo.FLOAT; break;
            case "bool": tipo = Variable.Tipo.BOOLEAN; break;
            case "str": tipo = Variable.Tipo.STRING; break;
            default: throw new RuntimeException("Tipo de variable desconocido: " + tipoString +". (Line:"+ctx.getStart().getLine()+")");
        }

        tablaSimbolos.put(id, new Variable(tipo, null));
        System.out.println("Declaración: " + id + " de tipo " + tipo);
        return null;
    }

    @Override
    public Variable visitAsig(AsigContext ctx) {
        String id = ctx.ID().getText();
        Variable valor;

        if(ctx.expr() != null){
            valor = visit(ctx.expr());
        } else if(ctx.condicional() != null){
            valor = visit(ctx.condicional());
        } else {
            throw new RuntimeException("Error: Asignación inválida. (Line:"+ctx.getStart().getLine()+")");
        }

        Variable varDeclarada = tablaSimbolos.get(id);

        if (varDeclarada == null) {
            throw new RuntimeException("Error: Variable " + id + " no declarada. (Line:"+ctx.getStart().getLine()+")");
        }

        if (varDeclarada.tipo != valor.tipo) {
            throw new RuntimeException("Error: No se puede asignar " + valor.tipo + " a " + varDeclarada.tipo +". (Line:"+ctx.getStart().getLine()+")");
        }

        System.out.println("Se asignó "+ id + " = " + valor);

        tablaSimbolos.put(id, valor);
        return valor;
    }

    @Override
    public Variable visitCondicional(CondicionalContext ctx) {
        Variable exp1 = visit(ctx.expr(0));
        Variable exp2 = visit(ctx.expr(1));
        String operador = ctx.opComparacion().getText();

        if(exp1.tipo != exp2.tipo){
            throw new RuntimeException("Error: Tipos incompatibles en comparación: " + exp1.tipo + " y " + exp2.tipo +". (Line:"+ctx.getStart().getLine()+")");
        }

        boolean result;
        switch (operador) {
            case ">":
                if(exp1.tipo == Variable.Tipo.INT){
                    result = (Integer) exp1.valor > (Integer) exp2.valor ? true : false;
                } else if(exp1.tipo == Variable.Tipo.FLOAT){
                    result = (Float) exp1.valor > (Float) exp2.valor ? true : false;
                } else {
                    throw new RuntimeException("Error: El operador > no es compatible con " + exp1.tipo + ". (Line:"+ctx.getStart().getLine()+")");
                }
                break;
            case "<":
                if(exp1.tipo == Variable.Tipo.INT){
                    result = (Integer) exp1.valor < (Integer) exp2.valor ? true : false;
                } else if(exp1.tipo == Variable.Tipo.FLOAT){
                    result = (Float) exp1.valor < (Float) exp2.valor ? true : false;
                } else {
                    throw new RuntimeException("Error: El operador < no es compatible con " + exp1.tipo + ". (Line:"+ctx.getStart().getLine()+")");
                }
                break;
            case "==":
                result = exp1.valor.equals(exp2.valor);
                break;
            default:
                throw new RuntimeException("Error: Operador desconocido: " + operador +". (Line:"+ctx.getStart().getLine()+")");
        }

        return new Variable(Variable.Tipo.BOOLEAN, result);
    }

    @Override
    public Variable visitIfInstr(LanguageParser.IfInstrContext ctx) {
        Variable condResult = visit(ctx.condicional(0));  // Evalúa la condición del if

        if (condResult.tipo != Variable.Tipo.BOOLEAN) {
            throw new RuntimeException("Error: La condición del if debe ser de tipo booleano. (Line:"+ctx.getStart().getLine()+")");
        }

        if (ctx.IF() != null && (boolean) condResult.valor) {
            System.out.println("Entro al if");
            visit(ctx.ifbody());
        } else {
            boolean elseifEjecutado = false;
            for (int i = 0; i < ctx.ELSEIF().size(); i++) {
                Variable elseifCondResult = visit(ctx.condicional(i + 1));  // Evalúa el elseif correspondiente

                if (elseifCondResult.tipo != Variable.Tipo.BOOLEAN) {
                    throw new RuntimeException("Error: La condición del elseif debe ser de tipo booleano. (Line:"+ctx.getStart().getLine()+")");
                }

                if ((boolean) elseifCondResult.valor) {
                    System.out.println("Entro al elseif");
                    visit(ctx.elseifbody(i));
                    elseifEjecutado = true;
                    break; // Evita que siga evaluando más elseif
                }
            }
            if (!elseifEjecutado && ctx.ELSE() != null) {
                System.out.println("Entro al else");
                visit(ctx.elsebody());
            }
        }

        return new Variable(Variable.Tipo.BOOLEAN, true);
    }

    @Override
    public Variable visitForInstr(ForInstrContext ctx) {
        // Evaluar la inicialización (int i = 0)
        visit(ctx.declaracion());
        System.out.println("Entro al for");
        // Extraer la condición
        // Condición y actualización
        while ((boolean) visit(ctx.condicional()).valor) {
            visit(ctx.forBody());

            // Validar si hay expresión de actualización
            if (ctx.expr() != null) {
                visit(ctx.expr());
            }
        }
        return null;

    }

    @Override
    public Variable visitElsebody(ElsebodyContext ctx) {
        for(InstruccionContext intr: ctx.instruccion()){
            visit(intr);
        }

        return null;
    }

    @Override
    public Variable visitIfbody(IfbodyContext ctx) {
        for(InstruccionContext intr: ctx.instruccion()){
            visit(intr);
        }

        return null;
    }

    @Override
    public Variable visitElseifbody(ElseifbodyContext ctx) {
        for(InstruccionContext intr: ctx.instruccion()){
            visit(intr);
        }

        return null;
    }


    @Override
    public Variable visitForBody(ForBodyContext ctx) {
        for(InstruccionContext intr: ctx.instruccion()){
            visit(intr);
        }

        return null;
    }

    @Override
    public Variable visitExpr(ExprContext ctx) {
        Variable result = visit(ctx.termino(0));
        for(int i=1;i<ctx.termino().size();i++){
            Variable sigTermino = visit(ctx.termino(i));

            if (result.tipo != sigTermino.tipo){
                throw new RuntimeException("Error: Tipos incompatibles entre terminos en expresión aritmética. (Line:"+ctx.getStart().getLine()+")");
            }

            if (sigTermino.tipo == Variable.Tipo.STRING) {
                String resultado = String.valueOf(result.valor);
                String sigOperando = String.valueOf(sigTermino.valor);
                result = new Variable(Variable.Tipo.STRING,  resultado + sigOperando);
            } else if(result.tipo == Variable.Tipo.INT){
                int resultado = (Integer) result.valor;
                int sigOperando = (Integer) sigTermino.valor;
                if(ctx.OP_SUMA(i-1) != null){
                    result = new Variable(Variable.Tipo.INT, resultado + sigOperando);
                } else if(ctx.OP_RESTA(i-1) != null){
                    result = new Variable(Variable.Tipo.INT, resultado - sigOperando);
                }
            } else if(result.tipo == Variable.Tipo.FLOAT){
                float resultado = (Float) result.valor;
                float sigOperando = (Float) sigTermino.valor;
                if(ctx.OP_SUMA(i-1) != null){
                    result = new Variable(Variable.Tipo.FLOAT, resultado + sigOperando);
                } else if(ctx.OP_RESTA(i-1) != null){
                    result = new Variable(Variable.Tipo.FLOAT, resultado - sigOperando);
                }
            } else {
                throw new RuntimeException("Error: Tipo no soportado para operaciones aritméticas entre terminos: " + result.tipo +". (Line:"+ctx.getStart().getLine()+")");
            }
        }

        return result;
    }

    @Override
    public Variable visitTermino(TerminoContext ctx) {
        Variable result = visit(ctx.factor(0));
        for(int i=1;i<ctx.factor().size();i++){
            Variable sigFactor = visit(ctx.factor(i));

            if(result.tipo != sigFactor.tipo){
                throw new RuntimeException("Error: Tipos incompatibles entre factores en expresión aritmética. (Line:"+ctx.getStart().getLine()+")");
            }

            if(result.tipo == Variable.Tipo.INT){
                if(ctx.OP_MULT(i-1) != null){
                    int resultado = (Integer) result.valor;
                    int sigOperando = (Integer) sigFactor.valor;
                    result = new Variable(Variable.Tipo.INT, resultado * sigOperando);
                } else if(ctx.OP_DIV(i-1) != null){
                    int resultado = (Integer) result.valor;
                    int sigOperando = (Integer) sigFactor.valor;

                    if(sigOperando == 0){
                        throw new RuntimeException("Error: División por Cero no soportado. (Line:"+ctx.getStart().getLine()+")");
                    }

                    result = new Variable(Variable.Tipo.INT, resultado / sigOperando);
                } else {
                    throw new RuntimeException("Error: Tipo no soportado para operaciones aritméticas entre factores: " + result.tipo + ". (Line:"+ctx.getStart().getLine()+")");
                }

            }
        }

        return result;
    }

    @Override
    public Variable visitFactor(FactorContext ctx) {
        if (ctx.FLOAT() != null) {
            return new Variable(Variable.Tipo.FLOAT, Float.parseFloat(ctx.FLOAT().getText()));
        } else if (ctx.NUM() != null) {
            return new Variable(Variable.Tipo.INT, Integer.parseInt(ctx.NUM().getText()));
        } else if (ctx.LITERAL() != null) {
            String texto = ctx.LITERAL().getText();
            // Quitar comillas
            texto = texto.substring(1, texto.length() - 1);
            return new Variable(Variable.Tipo.STRING, texto);
        } else if (ctx.BOOL() != null) {
            return new Variable(Variable.Tipo.BOOLEAN, Boolean.parseBoolean(ctx.BOOL().getText()));
        } else if (ctx.ID() != null && ctx.OP_INCREMENTO() != null) {
            // Operación tipo: i++
            String id = ctx.ID().getText();
            Variable valorActual = tablaSimbolos.get(id);

            if (valorActual == null){
                throw new RuntimeException("Error: Variable '" + id + "' no declarada. (Line:"+ctx.getStart().getLine()+")");
            }

            if(valorActual.tipo != Variable.Tipo.INT && valorActual.tipo != Variable.Tipo.FLOAT){
                throw new RuntimeException("Error: El operador ++ solo es válido para valores Enteros o Flotantes. (Line:"+ctx.getStart().getLine()+")");
            }

            Object valorAnterior = valorActual.valor;

            // Se incrementa
            if(valorActual.tipo == Variable.Tipo.INT){
                valorActual.valor = (Integer) valorActual.valor + 1;
            } else {
                valorActual.valor = (Float) valorActual.valor + 1.0f;
            }

            // Actualizar en la tabla de simbolos
            tablaSimbolos.put(id, valorActual);
                System.out.println("Incremento: " + id + " = " + (valorActual.valor));

            // Retornamos el valor anterior (como post-incremento)
            return new Variable(valorActual.tipo, valorAnterior);
        } else if(ctx.ID() != null){
            // Acceder a una variable existente
            String id = ctx.ID().getText();
            Variable variable = tablaSimbolos.get(id);
            if (variable == null){
                throw new RuntimeException("Error: Variable '" + id + "' no declarada. (Line:"+ctx.getStart().getLine()+")");
            }
            if (variable.valor == null) {
                throw new RuntimeException("Error: La variable '" + id + "' fue declarada pero no inicializada. (Line:"+ctx.getStart().getLine()+")");
            }
            return variable;
        } else if(ctx.expr() != null){
            return visit(ctx.expr());
        }

         // Default en caso de error
        throw new RuntimeException("Error: Factor inválido. (Line:"+ctx.getStart().getLine()+")");
    }
}
