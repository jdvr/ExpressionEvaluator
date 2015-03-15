# Expression Evaluator
__________________________

Evaluate arithmetic expression given by string, the expression is read as tokens so, is important put space between
different token.

## Usage:
    1. Import code to your project
    2. create ExpressionEvaluator
    3. Give a string to evaluate() method.

## Grammar:
    + "+" Addition
    + "-" Subtraction
    + "*" Multiply
    + "(" LeftParenthesis
    + ")" RightParenthesis
    + "[0-9]+" IntegerConstant
    + "[0-9]+.[0-9]+f" FloatConstant
    + "[0-9]+.[0-9]+" DoubleConstant

## Examples:
    * Add
        + "2 + 5"
        + "2.6f + 3.0"
    * Sub
        + "2 - 5"
        + "2 - 5f"
        + "2.6f - 3.0"
    * Multiply (Just integer supported)
        + "5 * 2"
        + "7 * -2"
    * Complex Expression
        + "( 2 - 5 ) * 2"
        + "( 2 * ( 5 + 1 ) ) + 2"
