package com.hdsp.expressionparser.lexical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicalParser {
    public Token[] parser(String expression) {
        if(expression.isEmpty()) return new Token[0];
        List<Token> tokens = new ArrayList<>();
        for (String token : expression.split(" ")) {
            tokens.add(new Token(Integer.valueOf(token)));
        }
        return tokens.toArray(new Token[0]);
    }
}
