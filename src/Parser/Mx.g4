grammar Mx;

// Program

program: (funcDef | varDef | classDef)* EOF;

// mainDef: 'int main()';

// BuildInFunc:
// 	'print'
// 	| 'println'
// 	| 'printInt'
// 	| 'printlnInt'
// 	| 'getString'
// 	| 'getInt'
// 	| 'toString'
//   | 'length'
//   | 'substring'
//   | 'parseInt'
//   | 'ord'
// ;

If: 'if';
Else: 'else';

Return: 'return';
Break: 'break';
Continue: 'continue';

New: 'new';

Class: 'class';

Null: 'null';

True: 'true';
False: 'false';

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

ArrayConst: '{' (Const(',' Const)*)? '}';

Type:  BasicType | Array;

Array: (BasicType | Classname) '[]'('[]')*;

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

Classname: Identifier;

Const: True | False | DemicalConst | StringConst | Null | ArrayConst;

DemicalConst: 
  PositiveConst
  |'0'
;

fragment PositiveConst: [1-9][0-9]*;

varDef: (Type  | Classname) Identifier ('=' expression)?(',' Identifier ('=' expression)?)* ';';

StringConst: '"' (Printable | EscapeChar)* '"' {
  if (getText().length() > 257) {
    throw new RuntimeException("String Const too long:" + getText());
  }
};

fragment EscapeChar: '\\\\' | '\\n' | '\\"';

expression :
  primary
  | '('expression')'
  | ('!' | '~') expression
  | expression ('++' | '--')
  | ('++' | '--') expression
	| ('-') expression
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
  | suffix
  | fstring
;

primary: Const | Identifier | This | newexp;

suffix: primary ('.' expression | '[' expression ']' | ('('(expression(',' expression)*)')' | '()'))*;

// memberVisit: (Identifier | funcCall) '.' (funcCall | Identifier);

funcDef: (Type | Classname) Identifier ('(' ((Type | Classname) Identifier (',' (Type | Classname) Identifier)*) ')' | '()') suite;

// funcCall: (Identifier | BuildInFunc) ('(' (expression(',' expression)*)? ')' | '()');

arrayInitialize: (((Type  | Classname) ('[]')('[]')* '=' ArrayConst) | ((Type  | Classname) ('[' expression ']' | '[]')('[' expression']' | '[]')*));

classInitialize: (Type | Classname) '()';

newexp: 'new' (arrayInitialize | classInitialize);

fstring: FstringHead expression (FstringBody expression)* FstringTail;

FstringHead: 'f"' (FPrintable | EscapeChar)* '$';

FstringBody: '$' (FPrintable | EscapeChar) '$';

FstringTail: '$' (FPrintable | EscapeChar)*? '"';

// Statement

suite: '{' statement* '}';

condition: If '(' conditionExp = expression ')' trueStmt = statement (Else falseStmt = statement)?;

whileStmt: While '(' conditionExp = expression ')' Stmt = statement;

forStmt: For '(' (conditionEpx = expression)? ';' (expression)? ';' (expression)? ')' statement;

breakStmt: Break;

continueStmt: Continue;

returnStmt: Return expression;

statement :
  suite
  | varDef
  | condition
  | breakStmt
  | continueStmt
  | returnStmt
  | whileStmt
  | forStmt
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

fragment Printable:~[\\"\r\n];

fragment FPrintable:~[\\"\r\n$] | '$$';