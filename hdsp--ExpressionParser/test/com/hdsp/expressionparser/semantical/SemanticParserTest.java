package com.hdsp.expressionparser.semantical;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionparser.lexical.Token;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SemanticParserTest {


    private SemanticParser parser;
    private List<Token> tokenList;

    @Before
    public void setUp() throws Exception {
        parser = new SemanticParser();
        tokenList = new ArrayList<>();
    }

    @Test
    public void should_return_an_evaluable_equals_to_five_when_given_a_single_constant_token_with_the_same_value() throws Exception{
        addTokensToList(new Token(5));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
        assertThat(expression.isEvaluable(), is(true));
        assertThat(expression.getEvaluable().value(), is(5));
        assertThat(expression.getEvaluable().type(), is(Integer.class.getSimpleName()));
    }

    @Test
    public void should_return_an_evaluable_with_value_equals_to_7_and_type_integer_when_given_5_plus_2() throws Exception {
        addTokensToList(new Token(5), new Token("+"), new Token(2));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
        assertThat(expression.isEvaluable(), is(true));
        Evaluable evaluable = expression.getEvaluable();
        assertThat(evaluable.value(), is(7));
        assertThat(evaluable.type(), is(Integer.class.getSimpleName()));
    }


    @Test
    public void should_return_an_evaluable_with_value_equals_to_11_when_given_5_plus_2_multiply_3() throws Exception {
        addTokensToList(new Token(5), new Token("+"), new Token(2), new Token("*"), new Token(3));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
        assertThat(expression.isEvaluable(), is(true));
        Evaluable evaluable = expression.getEvaluable();
        assertThat(evaluable.value(), is(11));
        assertThat(evaluable.type(), is(Integer.class.getSimpleName()));
    }

    @Test
    public void should_return_an_evaluable_with_value_minus_two_when_given_2_multiply_Lbracket_3_sub_4_Rbracket() throws Exception {
        addTokensToList(new Token(2), new Token("*"), new Token("("), new Token(3), new Token("-"), new Token(4), new Token(")"));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
        assertThat(expression.isEvaluable(), is(true));
        Evaluable evaluable = expression.getEvaluable();
        assertThat(evaluable.value(), is(-2));
        assertThat(evaluable.type(), is(Integer.class.getSimpleName()));
    }

    @Test(expected = SemanticParserException.class)
    public void should_return_an_exception_when_given_wrong_formed_expression() throws Exception {
        addTokensToList(new Token(2), new Token(3), new Token("-"), new Token(4), new Token(")"));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
    }


    @Test(expected = SemanticParserException.class)
    public void should_return_an_exception_when_given_left_but_not_rigth_parenthesis_in_expression() throws Exception {
        addTokensToList(new Token(2), new Token("*"), new Token("("), new Token(3), new Token("-"), new Token(4));
        Expression expression = parser.buildEvaluableExpression(tokenList.toArray(new Token[0]));
    }



    private void addTokensToList(Token ... tokens) {
        for (Token token : tokens) {
            tokenList.add(token);
        }
    }



}
