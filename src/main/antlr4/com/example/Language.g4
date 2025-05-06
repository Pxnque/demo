grammar Language;

@header {
import java.util.HashMap;
}

@members {
    class VariableInfo {
        String type;
        boolean initialized;

        VariableInfo(String type, boolean initialized) {
            this.type = type;
            this.initialized = initialized;
        }
    }

    private HashMap<String, VariableInfo> symbolTable = new HashMap<>();
    
    private void checkVariableExists(String varName, Token token) {
        if (!symbolTable.containsKey(varName)) {
            throw new RuntimeException("Variable no declarada '" + varName + "' en línea " + token.getLine());
        }
    }
    
    private void checkVariableInitialized(String varName, Token token) {
        VariableInfo info = symbolTable.get(varName);
        if (info != null && !info.initialized) {
            throw new RuntimeException("Variable no inicializada '" + varName + "' en línea " + token.getLine());
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

program: instruccion+ EOF;

instruccion:
	ID OP_ASIGN (expr | condicional) {
        String varName = $ID.text;
        checkVariableExists(varName, $ID);
        VariableInfo info = symbolTable.get(varName);
        info.initialized = true;
    }
	| expr
	| condicional
	| declaracion
	| ifdecla
	| fordecla
	| incdec
	| print;

print: PRINT LPAREN (expr) RPAREN;

declaracion:
	tipo = (INT | FLOAT | BOOL | STRING | CHAR) ID (
		OP_ASIGN expr
	)? {
        String varName = $ID.text;
        if (symbolTable.containsKey(varName)) {
            throw new RuntimeException("Variable duplicada '" + varName + "' en línea " + $ID.getLine());
        }
        boolean isInitialized = $OP_ASIGN != null;
        symbolTable.put(varName, new VariableInfo($tipo.text.toLowerCase(), isInitialized));
    };

incdec:
	ID { 
        checkVariableExists($ID.text, $ID);
        VariableInfo info = symbolTable.get($ID.text);
        checkVariableInitialized($ID.text, $ID);
    } (INC | DEC);

ifdecla:
	IF LPAREN condicional RPAREN LCURLY instruccion+ RCURLY (
		ELSEIF LPAREN condicional RPAREN LCURLY instruccion+ RCURLY
	)* (ELSE LCURLY instruccion+ RCURLY)?;

condicional:
	expr (
		MAYOR
		| MENOR
		| MAYORIGUAL
		| MENORIGUAL
		| IGUAL
		| DIFERENTE
		| OR
		| AND
	) expr;

fordecla:
	FOR LPAREN declaracion SEMI condicional SEMI incdec? RPAREN LCURLY instruccion+ RCURLY;

expr: termino (OP_SUMA termino)* | termino (OP_RESTA termino)*;

termino:
	factor (OP_MULT factor)*
	| factor (
		OP_DIV divisor = factor {
        // Validar división por cero en literales
        if ($divisor.ctx.NUM() != null) {
            checkDivisionByZero($divisor.ctx.NUM().getText(), $OP_DIV);
        }
    }
	)*;

factor:
	NUM
	| FLOAT_NUM
	| TRUE 
	| FALSE
	| STRING_LITERAL
	| ID { 
        checkVariableExists($ID.text, $ID);
        checkVariableInitialized($ID.text, $ID); 
    }
	| LPAREN expr RPAREN;

OP_SUMA: 'pony+';
OP_RESTA: 'pony-';
OP_MULT: 'pony*';
OP_DIV: 'pony/';
OP_ASIGN: 'pony=';
SEMI: ';';
LPAREN: '(';
RPAREN: ')';
MAYOR: '>';
MENOR: '<';
MAYORIGUAL: '>=';
MENORIGUAL: '<=';
IGUAL: '==';
DIFERENTE: '!=';
OR: '||';
AND: '&&';
LCURLY: '{';
RCURLY: '}';
IF: 'if';
ELSE: 'else';
ELSEIF: 'else if';
FOR: 'for';
INT: 'ponyint';
FLOAT: 'ponyfloat';
BOOL: 'ponybool';
STRING: 'ponystring';
CHAR: 'ponychar';
INC: '++';
DEC: '--';
PRINT: 'ponyprint';
TRUE: 'ponytrue';
FALSE: 'ponyfalse';

// Definimos los números de manera que permita enteros y flotantes
FLOAT_NUM: [0-9]+ '.' [0-9]+;
NUM: [0-9]+;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
STRING_LITERAL: '"' (~["\r\n])* '"';
// ON WORK ++ COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\n\r\f]+ -> skip;