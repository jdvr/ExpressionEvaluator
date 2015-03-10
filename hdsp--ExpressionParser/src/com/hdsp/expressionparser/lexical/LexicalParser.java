package com.hdsp.expressionparser.lexical;

import java.util.ArrayList;
import java.util.List;

public class LexicalParser {

    public Token[] parser(String expression) throws Exception {
        if(expression.isEmpty()) return new Token[0];
        List<Token> tokens = new ArrayList<>();
        for (String token : expression.split(" ")) {
            tokens.add(buildTokenFor(token));

        }
        return tokens.toArray(new Token[0]);
    }

    private Token buildTokenFor(String rawToken) throws Exception {
        try {
            for (TokenIdentifier symbol : TokenIdentifier.values())
                if (rawToken.contains(symbol.id()))
                    return symbol.builder().build(rawToken);

            return new Token(Integer.valueOf(rawToken));
        }catch (Exception e){
            throw new LexicalParserException(rawToken);
        }
    }



}
