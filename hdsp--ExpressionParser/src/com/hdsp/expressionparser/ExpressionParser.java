package com.hdsp.expressionparser;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionparser.lexical.LexicalParser;
import com.hdsp.expressionparser.lexical.LexicalParserException;
import com.hdsp.expressionparser.semantical.SemanticParser;
import com.hdsp.expressionparser.semantical.SemanticParserException;

public class ExpressionParser {

    private LexicalParser lexicalParser;
    private SemanticParser semanticParser;

    public ExpressionParser() {
        this.lexicalParser = new LexicalParser();
        this.semanticParser = new SemanticParser();
    }


    public Expression parser(String rawExpression) throws SemanticParserException, LexicalParserException{
        return semanticParser.parser(lexicalParser.parser(rawExpression));
    }
}
