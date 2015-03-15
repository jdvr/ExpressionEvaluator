package com.hdsp.expressionevaluator;

import com.hdsp.expressionparser.ExpressionParser;
import com.hdsp.expressionparser.lexical.LexicalParserException;
import com.hdsp.expressionparser.semantical.SemanticParserException;

public class ExpressionEvaluator {
    private ExpressionParser expressionParser;

    public ExpressionEvaluator(ExpressionParser expressionParser) {

        this.expressionParser = expressionParser;
    }

    public Object evaluate(String rawExpression) throws
                                                 SemanticParserException,
                                                 LexicalParserException,
                                                 NoEvaluableExpressionException {
        Expression expression = expressionParser.parser(rawExpression);
        if (! expression.isEvaluable() ) throw  new NoEvaluableExpressionException(rawExpression);
        return expression.getEvaluable().value();
    }
}
