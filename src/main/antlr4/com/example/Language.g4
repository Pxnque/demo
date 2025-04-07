grammar Language;

@header {
import java.util.HashMap;
}

@members {
    // Tabla de símbolos para variables declaradas
    private HashMap<String, String> symbolTable = new HashMap<>();
    
    private void checkVariableExists(String varName, Token token) {
        if (!symbolTable.containsKey(varName)) {
            throw new RuntimeException("Variable no declarada '" + varName + "' en línea " + token.getLine());
        }
    }
    
    private void checkDivisionByZero(String divisorValue, Token opToken) {
        try {
            if (Integer.parseInt(divisorValue) == 0) {
                throw new RuntimeException("División por cero detectada en línea " + opToken.getLine());
            }
        } catch (NumberFormatException e) {
            // No es un número entero, validación solo para literales
        }
    }
}

program
    : instruccion+ EOF
    ;

instruccion:
    ID OP_ASIGN (expr | condicional)
    | expr
    | condicional
    | declaracion
    | ifdecla
    | fordecla
    | incdec
    ;

declaracion:
    tipo = (INT | FLOAT | BOOL | STRING | CHAR) ID (OP_ASIGN expr)* {
        // Registrar variable en tabla de símbolos
        if (symbolTable.containsKey($ID.text)) {
            throw new RuntimeException("Variable duplicada '" + $ID.text + "' en línea " + $ID.getLine());
        }
        symbolTable.put($ID.text, $tipo.text.toLowerCase());
    }
    ;

incdec:
    ID { checkVariableExists($ID.text, $ID); } (INC | DEC)
    ;

ifdecla:
    IF LPAREN condicional RPAREN LCURLY instruccion+ RCURLY (ELSEIF LPAREN condicional RPAREN LCURLY instruccion+ RCURLY)* (ELSE LCURLY instruccion+ RCURLY)?
    ;

condicional:
    expr (MAYOR | MENOR | MAYORIGUAL | MENORIGUAL | IGUAL | DIFERENTE | OR | AND) expr
    ;

fordecla:
    FOR LPAREN declaracion SEMI condicional SEMI incdec? RPAREN LCURLY instruccion+ RCURLY
    ;

expr:
    termino (OP_SUMA termino)*
    | termino (OP_RESTA termino)*
    ;

termino:
    factor (OP_MULT factor)*
    | factor (OP_DIV divisor = factor {
        // Validar división por cero en literales
        if ($divisor.ctx.NUM() != null) {
            checkDivisionByZero($divisor.ctx.NUM().getText(), $OP_DIV);
        }
    })*
    ;

factor:
    NUM
    | ID { checkVariableExists($ID.text, $ID); }
    | LPAREN expr RPAREN
    ;

OP_SUMA: '+' ;
OP_RESTA: '-' ;
OP_MULT: '*' ;
OP_DIV: '/' ;
OP_ASIGN : '=' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
MAYOR : '>' ;
MENOR : '<' ;
MAYORIGUAL : '>=' ;
MENORIGUAL : '<=' ;
IGUAL : '==' ;
DIFERENTE : '!=' ;
OR : '||' ;
AND : '&&' ;
LCURLY : '{' ;
RCURLY : '}' ;
IF : 'if' ;
ELSE : 'else' ;
ELSEIF : 'else if' ;
FOR : 'for' ;
INT : 'int' ;
FLOAT : 'float' ;
BOOL : 'bool' ;
STRING : 'string' ;
CHAR : 'char' ;
INC : '++' ;
DEC : '--' ;

NUM : [0-9]+ ;
ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\n\r\f]+ -> skip ;