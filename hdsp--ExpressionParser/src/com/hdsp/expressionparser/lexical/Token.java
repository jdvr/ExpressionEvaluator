package com.hdsp.expressionparser.lexical;

public class Token {
    private TokenType type;
    private Object value;

    public Token(int value) {
        this.type = TokenType.Constant;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
