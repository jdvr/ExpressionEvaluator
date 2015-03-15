package com.hdsp.expressionparser.semantical;

import java.util.HashMap;
import java.util.Map;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionevaluator.expressions.Constant;
import com.hdsp.expressionparser.lexical.TokenType;

import static com.hdsp.expressionparser.lexical.TokenType.DoubleConstant;
import static com.hdsp.expressionparser.lexical.TokenType.FloatConstant;
import static com.hdsp.expressionparser.lexical.TokenType.IntegerConstant;

public class ConstantBuilder {
    private static Map<TokenType, ValueBuilder> valueBuilder = buildOperatorsMap();

    private static Map<TokenType, ValueBuilder> buildOperatorsMap() {
        return new HashMap<TokenType, ValueBuilder>() {{
            put(IntegerConstant, value -> new Constant((Integer) value));
            put(FloatConstant, value -> new Constant((Float) value));
            put(DoubleConstant, value -> new Constant((Double) value));
        }};
    }

    public static ValueBuilder getBuilderFor(TokenType constant) {
        return valueBuilder.get(constant);
    }

    @FunctionalInterface
    public interface ValueBuilder {
        public Expression build(Object value);
    }
}
