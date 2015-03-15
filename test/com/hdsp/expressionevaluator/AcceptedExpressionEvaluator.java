package com.hdsp.expressionevaluator;

import org.junit.Test;

import com.hdsp.expressionparser.ExpressionParser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AcceptedExpressionEvaluator {



    @Test
    public void should_return_seven_when_given_two_plus_five_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("2 + 5"), is(7));
    }

    @Test
    public void should_return_twelve_when_given_two_plus_five_times_two_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("2 + 5 * 2"), is(12));
    }

    @Test
    public void should_return_fourteen_when_given_LP_two_plus_five_RP_times_two_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("( 2 + 5 ) * 2"), is(14));
    }


    @Test
    public void should_return_minus_six_when_given_LP_two_minus_five_RP_times_two_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("( 2 - 5 ) * 2"), is(-6));
    }

    @Test
    public void should_return_fourteen_when_given_complex_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("( 2 * ( 5 + 1 ) ) + 2"), is(14));
    }


    @Test
    public void should_return_five_point_five_when_given_three_point_five_plus_two_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("3.5f + 2"), is(5.5f));
    }

    @Test
    public void should_return_six_when_given_three_point_five_plus_two_point_five_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("3.5f + 2.5"), is(6.0));
    }



    @Test
    public void should_return_one_point_five_when_given_three_point_five_minus_two_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("3.5f - 2"), is(1.5f));
    }

    @Test
    public void should_return_one_point_zero_when_given_three_point_five_minus_two_point_five_expression() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(new ExpressionParser());
        assertThat(expressionEvaluator.evaluate("3.5f - 2.5"), is(1.0));
    }





}
