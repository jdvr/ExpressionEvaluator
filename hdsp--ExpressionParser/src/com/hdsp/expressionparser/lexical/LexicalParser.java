package com.hdsp.expressionparser.lexical;

import java.util.ArrayList;
import java.util.List;

public class LexicalParser {

    private ArrayList<Token> tokens;

    public LexicalParser() {
        tokens = new ArrayList<>();
    }

    public Token[] parser(String expression) throws LexicalParserException {
        if(expression.isEmpty()) return new Token[0];
        for (String token : expression.split(" "))
            tokens.add(buildTokenFor(token));
        return tokens.toArray(new Token[0]);
    }

    private Token buildTokenFor(String rawToken) throws LexicalParserException{
        try {
            for (TokenIdentifier symbol : TokenIdentifier.values())
                if (rawToken.contains(symbol.id()))
                    return symbol.builder().build(rawToken);
            return new Token(Integer.valueOf(rawToken));
        }catch (NumberFormatException e){
            throw new LexicalParserException(rawToken);
        }
    }



}
