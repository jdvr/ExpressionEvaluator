package com.hdsp.expressionparser.lexical;

public enum TokenIdentifier {
    Plus("+", new TokenBuilder() {
        @Override
        public Token build(String value) {
            return new Token(value);
        }
    }),
    Sub("-", new TokenBuilder() {
        @Override
        public Token build(String value) {
            return new Token(value);
        }
    }),
    F("f", new TokenBuilder() {
        @Override
        public Token build(String value) {
            return new Token(Float.valueOf(value));
        }
    }),
    Point(".", new TokenBuilder() {
        @Override
        public Token build(String value) {
            return new Token(Double.valueOf(value));
        }
    });

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
