package com.hdsp.expressionparser.lexical;

@FunctionalInterface
public interface TokenBuilder {
    public Token build(String value);
}
