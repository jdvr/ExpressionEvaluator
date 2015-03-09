package com.hdsp.expressionparser.lexical;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private TokenType type;
    private Object value;
    private static Map<String, TokenType> stringToType = getStringToTypeMap();

    public Token(int value) {
        this.type = TokenType.Constant;
        this.value = value;
    }

    public Token(String value) {
        this.type = getTypeOf(value);
        this.value = value;
    }

    private TokenType getTypeOf(String value) {
        return stringToType.get(value);
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    private static Map<String, TokenType> getStringToTypeMap() {
        Map<String, TokenType> stringToType = new HashMap<>();
        stringToType.put("+", TokenType.Plus);
        stringToType.put("-", TokenType.Sub);
        return  stringToType;
    }
}
