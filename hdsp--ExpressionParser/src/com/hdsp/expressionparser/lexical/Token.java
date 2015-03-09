package com.hdsp.expressionparser.lexical;

import java.util.HashMap;
import java.util.Map;

import static com.hdsp.expressionparser.lexical.TokenType.*;

public class Token {
    private TokenType type;
    private Object value;
    private static Map<String, TokenType> stringToType = getStringToTypeMap();

    public Token(Integer value) {
        this(Constant, value);
    }

    public Token(String value) {
        this(getTypeOf(value), value);
    }

    public Token(Float value) {
        this(Constant, value);
    }

    public Token(Double value) {
        this(Constant, value);
    }

    private Token(TokenType type, Object value){
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    private static TokenType getTypeOf(String value) {
        return stringToType.get(value);
    }

    private static Map<String, TokenType> getStringToTypeMap() {
        Map<String, TokenType> stringToType = new HashMap<>();
        stringToType.put("+", Plus);
        stringToType.put("-", Sub);
        return  stringToType;
    }
}
