grammar mathexpression;

options{
    output = AST;
    language = Java;
}



Plus : '+';
Minus: '-';
Times: '*';
Slash: '/';

LeftParen: '(';
RightParen: ')';
LeftBrakect: '[';
RightBracket: ']';


fragment Number: '0'..'9';


Contanst: Number+ ('.' DIGIT+)? | '.' DIGIT+;


WHITESPACE: (' ' | '\t' | '\r' | '\n')-> skip;

Add: LeftBrakect? LeftParen? (Contanst | EXP)+ Plus (Contanst | EXP)+ RightParen? RightBracket?;
Sub: LeftBrakect? LeftParen? (Contanst | EXP)+ Minus (Contanst | EXP)+ RightParen? RightBracket?;
Multiply: LeftBrakect? LeftParen? (Contanst | EXP)+ Times (Contanst | EXP)+ RightParen? RightBracket?;
Div: LeftBrakect? LeftParen? (Contanst | EXP)+ Slash (Contanst | EXP)+ RightParen? RightBracket?;

EXP: Add | Sub | Multiply | Div;





