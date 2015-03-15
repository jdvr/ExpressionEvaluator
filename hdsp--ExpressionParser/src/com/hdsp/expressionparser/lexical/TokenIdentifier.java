package com.hdsp.expressionparser.lexical;

public enum TokenIdentifier {
    Plus("+", Token::new),
    Sub("-", Token::new),
    F("f", value -> new Token(Float.valueOf(value))),
    Point(".", value -> new Token(Double.valueOf(value))),
    Times("*", Token::new),
    LeftParenthesis("(", Token::new),
    RightParenthesis(")", Token::new);

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
