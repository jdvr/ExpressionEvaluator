package com.hdsp.expressionparser.semantical;

import java.util.HashMap;
import java.util.Map;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionevaluator.expressions.Add;
import com.hdsp.expressionevaluator.expressions.Multiply;
import com.hdsp.expressionevaluator.expressions.Sub;
import com.hdsp.expressionparser.lexical.TokenType;

import static com.hdsp.expressionparser.lexical.TokenType.MultiplySign;
import static com.hdsp.expressionparser.lexical.TokenType.PlusSign;
import static com.hdsp.expressionparser.lexical.TokenType.SubSign;

/**
* Created by JuanDavid on 15/03/2015.
*/
public class OperatorBuilder {
    private static Map<TokenType, OperationBuilder> operationBuilder = buildOperatorsMap();

    private static Map<TokenType, OperationBuilder> buildOperatorsMap() {
        return new HashMap<TokenType, OperationBuilder>() {{
            put(PlusSign, Add::new);
            put(SubSign, Sub::new);
            put(MultiplySign, Multiply::new);
        }};
    }

    public static OperationBuilder getBuilderFor(TokenType operator) {
        return operationBuilder.get(operator);
    }

    @FunctionalInterface
    public interface OperationBuilder {
        public Expression build(Expression left, Expression right);
    }
}
