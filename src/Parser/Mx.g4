grammar Mx;

// Program

program: (funcDef | varDef | classDef)* (mainDef suite)(funcDef | varDef | classDef)*;

mainDef: 'int main()';

BuildInFunc:
	'print'
	| 'println'
	| 'printInt'
	| 'printlnInt'
	| 'getString'
	| 'getInt'
	| 'toString'
  | 'length'
  | 'substring'
  | 'parseInt'
  | 'ord'
;

If: 'if';
Else: 'else';

Return: 'return';
Break: 'break';
Continue: 'continue';

New: 'new';

Class: 'class';

Null: 'null';

fragment True: 'true';
fragment False: 'false';

This: 'this';

For: 'for';
While: 'while';

LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';

Whitespace: [ \t]+ -> skip;

Newline: ( '\r' '\n'? | '\n') -> skip;

BlockComment: '/*' .*? '*/' -> skip;

LineComment: '//' ~[\r\n]* -> skip;

Semi: ';';

fragment Void: 'void';
fragment Bool: 'bool';
fragment Int: 'int';
fragment String: 'string';

BasicType: Void | Bool | Int | String;

Identifier:
	[a-zA-Z][a-zA-Z_0-9]* {
  if (getText().length() > 64) {
    throw new RuntimeException("Identifier too long:" + getText());
  }
};

type:  BasicType | Array | Classname;

Array: (BasicType | Classname) '[]'('[]')*;

Classname: Identifier;

// Variable

varDef: type Identifier ('=' expression)?(',' Identifier ('=' expression)?)* ';';

// Constant

Const: True | False | DemicalConst | StringConst | Null | ArrayConst;

// DemicalConstant

fragment DemicalConst: 
  PositiveConst
  |'0'
;

PositiveConst: [1-9][0-9]*;

// Array

ArrayConst: '{' (Const(',' Const)*)? '}';

arrayInitialize: ((type '[]' '=' ArrayConst) | (type '[' Const ']'));

arrayVisit: (Identifier | Const | This | funcCall | newexp) '[' expression ']'('[' expression ']')*;

// StringImmidate

StringConst: '"' (Printable | EscapeChar)* '"' {
  if (getText().length() > 257) {
    throw new RuntimeException("String Const too long:" + getText());
  }
};

EscapeChar: '\\\\' | '\\n' | '\\"';

parameterList: (type Identifier (',' type Identifier)*)?;

expression :
  primary
  | '('expression')'
  | ('!' | '~') expression
  | expression ('++' | '--')
  | ('++' | '--') expression
	| ('+' | '-') expression
  | expression ('*' | '/' | '%') expression
  | expression ('+' | '-') expression
	| expression ('>>' | '<<') expression
	| expression ('>' | '<' | '>=' | '<=') expression
	| expression ('!=' | '==') expression
	| expression ('&') expression
  | expression ('^') expression
  | expression ('|') expression
  | expression ('&&') expression
	| expression ('||') expression
  | expression ('?') expression (':') expression
	| expression ('=') expression
  | fstring
;

primary: Const | Identifier | This | funcCall | memberVisit | arrayVisit | newexp;

memberVisit: Identifier '.' (funcCall | Identifier);

funcDef: type Identifier '(' parameterList ')' suite;

funcCall: (Identifier | BuildInFunc) ('(' argumentList? ')' | '()');

argumentList: expression(',' expression)*;

newexp: 'new' (arrayInitialize | classInitialize);

fstring: FstringHead expression (FstringBody expression)* FstringTail;

FstringHead: 'f"' (FPrintable | EscapeChar)* '$';

FstringBody: '$' (FPrintable | EscapeChar) '$';

FstringTail: '$' (FPrintable | EscapeChar)*? '"';

// Statement

suite: '{' statement* '}';

condition: If '(' expression ')' trueStmt = statement (Else falseStmt = statement)?;

whileStmt: While '(' expression ')' statement;

forStmt: For '(' (expression)? ';' (expression)? ';' (expression)? ')' statement;

loop: whileStmt | forStmt;

breakStmt: Break;

continueStmt: Continue;

returnStmt: Return expression;

jump: breakStmt | continueStmt | returnStmt;

statement :
  suite
  | condition
  | jump
  | loop
  | varDef
  | classDef
  | expression ';'
  | ';'
;

// Class

classDef: Class classname = Identifier classBody;

classBody: '{' member* '}';

member: memberVarDef | funcDef | constructFuncDef;

memberVarDef: varDef;

memberFuncDef: funcDef;

constructFuncDef: Identifier '()' suite;

classInitialize: type '()';

fragment Printable:~[\\"\r\n];

fragment FPrintable:~[\\"\r\n$] | '$$';