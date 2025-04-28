
package com.example;

import java.util.HashMap;

import com.example.LanguageParser.CondicionalContext;
import com.example.LanguageParser.DeclaracionContext;
import com.example.LanguageParser.ExprContext;
import com.example.LanguageParser.FactorContext;
import com.example.LanguageParser.FordeclaContext;
import com.example.LanguageParser.IfdeclaContext;
import com.example.LanguageParser.IncdecContext;
import com.example.LanguageParser.InstruccionContext;
import com.example.LanguageParser.ProgramContext;
import com.example.LanguageParser.TerminoContext;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Integer> {

    public final HashMap<String, Integer> tablaSimbolos = new HashMap<>();

    
    @Override
    public Integer visitProgram(ProgramContext ctx) {
        int result = 0;
        for(InstruccionContext instr : ctx.instruccion()){
            result = visit(instr);
        }
        return result;
    }

    @Override
    public Integer visitIfdecla(IfdeclaContext ctx) {
        int result = 0;
        
        if(ctx.condicional() != null){
            System.out.println("Condicion: ");
            for(InstruccionContext instr : ctx.instruccion()){
                result = visit(instr);
            }
        }
        return result;
        
       }
    

       @Override
       public Integer visitInstruccion(InstruccionContext ctx) {
           if (ctx.OP_ASIGN() != null) {
               String identificador = ctx.ID().getText();
               int valor = ctx.expr() != null ? visit(ctx.expr()) : visit(ctx.condicional());
               tablaSimbolos.put(identificador, valor);
               System.out.println("Se asignó " + identificador + " = " + valor);
               return valor;
           } else if (ctx.expr() != null) {
               int result = visit(ctx.expr());
               System.out.println("Resultado expresión: " + result);
               return result;
           } else if (ctx.condicional() != null) {
               int result = visit(ctx.condicional());
               System.out.println("Resultado condicional: " + result);
               return result;
           } else if (ctx.declaracion() != null) {
               String varName = ctx.declaracion().ID().getText();
               System.out.println("Declaración de variable tipo " + ctx.declaracion().tipo.getText() + " -> " + varName);
               if (ctx.declaracion().expr() != null && !ctx.declaracion().expr().isEmpty()) {
                   int value = visit(ctx.declaracion().expr());
                   tablaSimbolos.put(varName, value);
               } else {
                   // Asignar un valor por defecto (ej. 0 para int)
                   tablaSimbolos.put(varName, 0);
               }
               return 0;
           } else if (ctx.ifdecla() != null) {
               System.out.println("Llegó a la línea de un If: ");
               return visit(ctx.ifdecla());
           } else if (ctx.fordecla() != null) {
               System.out.println("Llegó a la línea de un For: ");
               return visit(ctx.fordecla());
           } else if (ctx.incdec() != null) {
               return visit(ctx.incdec());
           }
           return 0;
       }



    @Override
    public Integer visitDeclaracion(DeclaracionContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDeclaracion(ctx);
    }

    @Override
    public Integer visitIncdec(IncdecContext ctx) {
        int result = 0;
        if(ctx.INC() != null){
            String id = ctx.ID().getText();
            System.out.println(id);
            System.out.println(tablaSimbolos.toString());
            if(tablaSimbolos.containsKey(id)){
                result = tablaSimbolos.get(id) + 1;
                tablaSimbolos.put(id, result);
                System.out.println("Se incremento " + id + " = " + result);
            }else{
                System.out.println("Error: Variable " + id + " no declarada");
            }
        }else if(ctx.DEC() != null){
            String id = ctx.ID().getText();
            if(tablaSimbolos.containsKey(id)){
                result = tablaSimbolos.get(id) - 1;
                tablaSimbolos.put(id, result);
                System.out.println("Se decremento " + id + " = " + result);
            }else{
                System.out.println("Error: Variable " + id + " no declarada");
            }
        }
        return result;
    }

    @Override
public Integer visitFordecla(FordeclaContext ctx) {
  
    int result = 0;
    if (ctx.declaracion() != null) {
        String varName = ctx.declaracion().ID().getText();
        int valorInicial = visit(ctx.declaracion().expr(0));
        tablaSimbolos.put(varName, valorInicial);
        System.out.println("Declaración de variable " + varName + " = " + valorInicial);
    }

    while (visit(ctx.condicional()) == 1) {
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
    public Integer visitCondicional(CondicionalContext ctx) {
        int expr1 = visit(ctx.expr( 0));
        int expr2 = visit(ctx.expr(1));
        if (ctx.MAYOR() != null) return expr1 > expr2 ? 1 : 0;
        if (ctx.MENOR() != null) return expr1 < expr2 ? 1 : 0;
        if (ctx.MAYORIGUAL() != null) return expr1 >= expr2 ? 1 : 0;
        if (ctx.MENORIGUAL() != null) return expr1 <= expr2 ? 1 : 0;
        if (ctx.IGUAL() != null) return expr1 == expr2 ? 1 : 0;
        if (ctx.DIFERENTE() != null) return expr1 != expr2 ? 1 : 0;
        if (ctx.AND() != null) return expr1 == 1 && expr2 == 1 ? 1 : 0;
        if (ctx.OR() != null) return expr1 == 1 || expr2 == 1 ? 1 : 0;
        return 0;
    }

    @Override
    public Integer visitExpr(ExprContext ctx) {
        int result = visit(ctx.termino(0));
        for(int i=0; i<ctx.termino().size();i++){
            if(ctx.OP_SUMA(i-1) !=  null){
                result += visit(ctx.termino(i));
            }else if(ctx.OP_RESTA(i-1) != null){
                result -= visit(ctx.termino(i));
            }
        }
        return result;
    
    }
    
    @Override
    public Integer visitTermino(TerminoContext ctx) {
        int result = visit(ctx.factor(0));
        for(int i=0; i<ctx.factor().size();i++){
            if(ctx.OP_MULT(i-1) !=  null){
                result *= visit(ctx.factor(i));
            }else if(ctx.OP_DIV(i-1) != null){

                result /= visit(ctx.factor(i));
            }
        }
        return result;
    }  

    @Override
    public Integer visitFactor(FactorContext ctx) {

        int result = 0;
        if (ctx.NUM() != null) {
            result = Integer.parseInt(ctx.NUM().getText());
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (tablaSimbolos.containsKey(id)) {
                result = tablaSimbolos.get(id);
            } else {
                System.out.println("Error: Variable " + id + " no declarada");
            }
        } else {
            result = visit(ctx.expr());
        }
        return result;
    }

    


}


