package com.hdsp.expressionparser.lexical;

public enum TokenIdentifier {
    Plus("+", value -> new Token(value)),
    Sub("-", value -> new Token(value)),
    F("f", value -> new Token(Float.valueOf(value))),
    Point(".", value -> new Token(Double.valueOf(value)));

    private final String id;
    private final TokenBuilder builder;

    TokenIdentifier(String id, TokenBuilder builder) {
        this.id = id;
        this.builder = builder;
    }

    public String id() {
        return id;
    }

    public TokenBuilder builder() {
        return builder;
    }
}
