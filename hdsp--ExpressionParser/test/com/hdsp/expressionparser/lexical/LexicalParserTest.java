package com.hdsp.expressionparser.lexical;

import org.junit.Test;


import static com.hdsp.expressionparser.lexical.TokenType.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LexicalParserTest {
    @Test
    public void should_return_a_empty_token_array_when_receive_a_empty_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        assertThat(lexicalParser.parser("").length, is(0));

    }

    @Test
    public void should_return_a_constant_token_when_receive_a_digit_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        assertEquals(IntegerConstant, lexicalParser.parser("89")[0].getType());
        assertEquals(89, lexicalParser.parser("89")[0].getValue());

    }

    @Test
    public void should_return_two_constant_tokens_when_receive_two_numbers_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("89 96");
        assertThat(parserResult.length, is(2));
        assertThat(parserResult[0].getType(), is(IntegerConstant));
        assertThat(parserResult[0].getValue(), is(integerNumber(89)));
        assertThat(parserResult[1].getType(), is(IntegerConstant));
        assertThat(parserResult[1].getValue(), is(integerNumber(96)));
    }


    @Test
    public void should_return_one_constant_tokens_when_receive_float_number_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("89.69f");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(FloatConstant));
        assertThat(parserResult[0].getValue(), is(floatNumber(89.69f)));
    }


    @Test
    public void should_return_one_constant_tokens_when_receive_double_number_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("89.69");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(DoubleConstant));
        assertThat(parserResult[0].getValue(), is(doubleNumber(89.69)));
    }

    @Test
    public void should_return_plus_operation_token_when_receive_plus_sign_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("+");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(PlusSign));
        assertThat(parserResult[0].getValue(), is(string("+")));
    }

    @Test
    public void should_return_sub_operation_token_when_receive_sub_sign_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("-");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(SubSign));
        assertThat(parserResult[0].getValue(), is(string("-")));
    }

    @Test
    public void should_return_left_and_right_parenthesis_token_when_receive_two_parenthesis_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("( )");
        assertThat(parserResult.length, is(2));
        assertThat(parserResult[0].getType(), is(LeftParenthesis));
        assertThat(parserResult[0].getValue(), is(string("(")));
        assertThat(parserResult[1].getType(), is(RightParenthesis));
        assertThat(parserResult[1].getValue(), is(string(")")));
    }

    @Test(expected=LexicalParserException.class)
    public void should_throw_a_lexical_exception_when_receive_a_wrong_sign_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        lexicalParser.parser("6h.5");
    }

    @Test
    public void should_return_tokens_when_receive_an_operation_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("3 + 4f - 3.567 + 1 - 9.45");
        assertThat(parserResult.length, is(9));
        assertThat(parserResult[0].getType(), is(IntegerConstant));
        assertThat(parserResult[0].getValue(), is(integerNumber(3)));
        assertThat(parserResult[1].getType(), is(PlusSign));
        assertThat(parserResult[1].getValue(), is(string("+")));
        assertThat(parserResult[2].getType(), is(FloatConstant));
        assertThat(parserResult[2].getValue(), is(floatNumber(4f)));
        assertThat(parserResult[3].getType(), is(SubSign));
        assertThat(parserResult[3].getValue(), is(string("-")));
        assertThat(parserResult[4].getType(), is(DoubleConstant));
        assertThat(parserResult[4].getValue(), is(doubleNumber(3.567)));
    }


    private Object doubleNumber(double number) {
        return new Double(number);
    }

    private Object string(String string) {
        return new String(string);
    }

    private Object floatNumber(float number) {
        return new Float(number);
    }


    private Object integerNumber(int i) {
        return new Integer(i);
    }


}
