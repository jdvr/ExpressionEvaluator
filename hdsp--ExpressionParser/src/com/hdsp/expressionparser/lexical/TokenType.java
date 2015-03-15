package com.hdsp.expressionparser.lexical;

public enum TokenType {
    IntegerConstant(1),
    FloatConstant(1),
    DoubleConstant(1),
    PlusSign(2),
    SubSign(2),
    MultiplySign(3),
    LeftParenthesis(0),
    RightParenthesis(0);

    private Integer preference;

    TokenType(Integer preference) {

        this.preference = preference;
    }

    public int getPreference() {
        return preference;
    }
}
