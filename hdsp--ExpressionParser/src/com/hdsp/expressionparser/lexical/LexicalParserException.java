package com.hdsp.expressionparser.lexical;

public class LexicalParserException extends Exception {


    private String rawToken;

    public LexicalParserException(String rawToken) {
        this.rawToken = rawToken;
    }

    @Override
    public synchronized Throwable getCause() {
        return new Throwable("Wrong word: " + rawToken);
    }
}
