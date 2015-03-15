package com.hdsp.expressionparser.lexical;

import java.util.HashMap;
import java.util.Map;

import static com.hdsp.expressionparser.lexical.TokenType.*;

public class Token {
    private TokenType type;
    private Object value;
    private static Map<String, TokenType> symbolToTypeMap = getSymbolToTypeMap();

    public Token(Integer value) {
        this(IntegerConstant, value);
    }

    public Token(String value) {
        this(getTypeOf(value), value);
    }

    public Token(Float value) {
        this(FloatConstant, value);
    }

    public Token(Double value) {
        this(DoubleConstant, value);
    }


    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object otherToken) {
        return this == otherToken
                || (otherToken != null || getClass() == otherToken.getClass()) && equals((Token) otherToken);

    }

    private boolean equals(Token otherToken) {
        return this.type == otherToken.type && this.value.equals(otherToken.value);
    }

    private Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }

    private static TokenType getTypeOf(String value) {
        return symbolToTypeMap.get(value);
    }

    private static Map<String, TokenType> getSymbolToTypeMap() {
        return new HashMap<String, TokenType>() {{
            put("+", PlusSign);
            put("-", SubSign);
            put("*", MultiplySign);
            put("(", LeftParenthesis);
            put(")", RightParenthesis);
        }};
    }


}
