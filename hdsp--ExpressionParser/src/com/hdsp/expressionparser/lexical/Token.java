package com.hdsp.expressionparser.lexical;

import java.util.HashMap;
import java.util.Map;

import static com.hdsp.expressionparser.lexical.TokenType.*;

public class Token {
    private TokenType type;
    private Object value;
    private static Map<String, TokenType> tokenTypes = typeCodification();

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

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    private Token(TokenType type, Object value){
        this.type = type;
        this.value = value;
    }

    private static TokenType getTypeOf(String value) {
        return tokenTypes.get(value);
    }

    private static Map<String, TokenType> typeCodification() {
        Map<String, TokenType> stringToType = new HashMap<>();
        stringToType.put("+", PlusSign);
        stringToType.put("-", SubSign);
        stringToType.put("*", MultiplySign);
        stringToType.put("(", LeftParenthesis);
        stringToType.put(")", RightParenthesis);
        return  stringToType;
    }


}
