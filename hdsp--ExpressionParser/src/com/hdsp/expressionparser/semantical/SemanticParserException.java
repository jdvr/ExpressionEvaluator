package com.hdsp.expressionparser.semantical;

public class SemanticParserException extends Exception{
    private String message;

    public SemanticParserException(String message) {

        this.message = message;
    }


    @Override
    public synchronized Throwable getCause() {
        return new Throwable(message);
    }
}
