grammar Language;

// Programa principal
program: instruccion+ EOF;

// Instrucciones
instruccion: 
    declaracion PUNTO_COMA  #instruccionDeclaracion
    | asig PUNTO_COMA       #instruccionAsignacion
    | expr PUNTO_COMA       #instruccionExpresion
    | condicional PUNTO_COMA #instruccionCondicional
    | ifInstr               #instruccionIf
    | forInstr              #instruccionFor
    ;

// Declaración de variables
declaracion: 
    TIPO ID                     #declaracionSimple
    | TIPO ID '=' expr          #declaracionConAsignacion
    | TIPO ID '=' condicional   #declaracionConAsignacionCond
    ;

// Asignación
asig: 
    ID '=' expr
    | ID '=' condicional
    ;

// Estructuras de control
ifInstr: 
    IF '(' condicional ')' '{' ifbody '}' 
    (ELSEIF '(' condicional ')' '{' elseifbody '}')* 
    (ELSE '{' elsebody '}')?
    ;

ifbody: instruccion*;
elseifbody: instruccion*;
elsebody: instruccion*;

forInstr: 
    FOR '(' declaracion PUNTO_COMA condicional PUNTO_COMA expr? ')' '{' forBody '}'
    ;

forBody: instruccion*;

// Condicionales
condicional: expr opComparacion expr;

opComparacion: 
    '>' | '<' | '==' 
    ;

// Expresiones aritméticas
expr: 
    termino (OP_SUMA termino | OP_RESTA termino)*
    ;

termino: 
    factor (OP_MULT factor | OP_DIV factor)*
    ;

factor: 
    NUM                       #factorNumero
    | FLOAT                    #factorFloat
    | LITERAL                  #factorTexto
    | BOOL                     #factorBooleano
    | ID OP_INCREMENTO         #factorIncremento
    | ID                       #factorId
    | '(' expr ')'             #factorParentesis
    ;

// Tokens
// Tipos de datos correspondientes a Variable.Tipo
TIPO: 'int'   // Variable.Tipo.INT
    | 'float' // Variable.Tipo.FLOAT
    | 'str'   // Variable.Tipo.STRING
    | 'bool'  // Variable.Tipo.BOOLEAN
    ;
IF: 'if';
ELSEIF: 'elseif';  
ELSE: 'else';
FOR: 'for';
BOOL: 'true' | 'false';
// Identificadores - deben tener menor prioridad que las palabras clave
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUM: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
LITERAL: '"' (~["\r\n])* '"';
OP_SUMA: '+';
OP_RESTA: '-';
OP_MULT: '*';
OP_DIV: '/';
OP_INCREMENTO: '++';
PUNTO_COMA: ';';

// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip;

// Comentarios
COMENTARIO: '//' ~[\r\n]* -> skip;
COMENTARIO_MULTI: '/*' .*? '*/' -> skip;