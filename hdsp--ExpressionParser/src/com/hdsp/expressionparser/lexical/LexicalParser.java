package com.hdsp.expressionparser.lexical;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicalParser {

    public Token[] parser(String expression) {
        if(expression.isEmpty()) return new Token[0];
        List<Token> tokens = new ArrayList<>();
        for (String token : expression.split(" ")) {
            tokens.add(buildTokenFor(token));

        }
        return tokens.toArray(new Token[0]);
    }

    private Token buildTokenFor(String token) {
        Map<String, TokenBuilder> idToConstructor = new HashMap<>();
        idToConstructor.put("+", value -> new Token((String)value));
        idToConstructor.put("-", value -> new Token((String)value));
        idToConstructor.put(".", value -> new Token((Double)value));
        idToConstructor.put("f", value -> new Token((Float)value));
        

    }


    private interface TokenBuilder {
        public Token buildWith(Object value);
    }
}
