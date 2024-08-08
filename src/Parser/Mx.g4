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

Inc: '++';
Dec: '--';
Plus: '+';
Minus: '-';
Multi: '*';
Div: '/';
Mod: '%';
Less: '<';
Greater: '>';
LessEqual: '<=';
GreaterEqual: '>=';
Equal: '==';
NotEqual: '!=';
And: '&&';
Or: '||';
Not: '!';
BitNot: '~';
BitAnd: '&';
BitOr: '|';
BitXor: '^';
LeftShift: '<<';
RightShift: '>>';
Dot: '.';

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

type:  array | BasicType | Identifier;

array: (BasicType | Identifier) '[' ']'('[' ']')*;

BasicType: Void | Bool | Int | String;

Void: 'void';
Bool: 'bool';
Int: 'int';
String: 'string';

Identifier:
	[a-zA-Z][a-zA-Z_0-9]* {
  if (getText().length() > 64) {
    throw new RuntimeException("Identifier too long:" + getText());
  }
};

constType: True | False | DemicalConst | StringConst | Null | arrayConst;

arrayConst: '{' (constType(',' constType)*)? '}';

DemicalConst: 
  PositiveConst
  |'0'
;

fragment PositiveConst: [1-9][0-9]*;

varDef: type assign(',' assign)* ';';

assign: Identifier ('=' expression)?;

StringConst: '"' (Printable | EscapeChar)* '"' {
  if (getText().length() > 257) {
    throw new RuntimeException("String Const too long:" + getText());
  }
};

fragment EscapeChar: '\\\\' | '\\n' | '\\"';

expression :
  primary                                             # primaryExp
  | suffix                                            # suffixExp
  |'('expression')'                                   # parenExp
	| <assoc = right> ('!' | '~') expression            # unaryExp
	| <assoc = right> expression Suf = ('++' | '--')   # unaryExp
	| <assoc = right> Pre = ('++' | '--') expression    # unaryExp
	| <assoc = right> ('-') expression                  # unaryExp
  | expression ('*' | '/' | '%') expression           # binaryExp
  | expression ('+' | '-') expression                 # binaryExp
	| expression ('>>' | '<<') expression               # binaryExp
	| expression ('>' | '<' | '>=' | '<=') expression   # binaryExp
	| expression ('!=' | '==') expression               # binaryExp
	| expression ('&') expression                       # binaryExp
  | expression ('^') expression                       # binaryExp
  | expression ('|') expression                       # binaryExp
  | expression ('&&') expression                      # binaryExp
	| expression ('||') expression                      # binaryExp
	| <assoc = right> expression ('?') expression (':') expression                      #ternaryExp
	| <assoc = right> expression ('=') expression       # assignExp
  | fstring                                           # fstringExp
;

primary: Identifier | constType | This | newexp;

suffix: primary suffixcontent*;

suffixcontent: ('.' Identifier | '[' expression ']' | ('('(expression(',' expression)*)')' | '('')'));

// memberVisit: (Identifier | funcCall) '.' (funcCall | Identifier);

funcDef: retType = type funcName = Identifier ('(' (type Identifier (',' type Identifier)*) ')' | '('')') suite;

// funcCall: (Identifier | BuildInFunc) ('(' (expression(',' expression)*)? ')' | '()');

arrayInitialize: ((type '=' arrayConst) | (type ('[' expression ']' | '['']')('[' expression']' | '['']')*));

classInitialize: Identifier '('')';

newexp: 'new' (arrayInitialize | classInitialize);

fstring: FstringHead expression (FstringBody expression)* FstringTail;

FstringHead: 'f"' Fstring '$';

FstringBody: '$' Fstring '$';

FstringTail: '$' Fstring '"';

fragment Fstring: (FPrintable | EscapeChar)*;

	// Statement

suite: '{' statement* '}';

condition: If '(' conditionExp = expression ')' trueStmt = statement (Else falseStmt = statement)?;

whileRule: While '(' conditionExp = expression ')' Stmt = statement;

forRule: For '(' (initExpr = expression)? ';' (condExpr = expression)? ';' (stepExpr = expression)? ')' statement;

breakRule: Break;

continueRule: Continue;

returnRule: Return expression;

statement :
  suite                           # suiteStmt
  | varDef                        # varDefStmt
  | classDef                      # classDefStmt
  | condition                     # conditionStmt
  | breakRule                     # breakStmt
  | continueRule                  # continueStmt
  | returnRule                    # returnStmt
  | whileRule                     # whileStmt
  | forRule                       # forStmt
  | expression ';'                # expressionStmt
  | ';'                           # emptyStmt
;

// Class

classDef: Class classname = Identifier '{' (varDef | funcDef | constructFuncDef)* '}'';';

constructFuncDef: Identifier '('')' suite;

fragment Printable:~[\\"\r\n];

fragment FPrintable:~[\\"\r\n$] | '$$';