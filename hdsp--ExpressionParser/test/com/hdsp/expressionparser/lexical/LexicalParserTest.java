package com.hdsp.expressionparser.lexical;

import org.hamcrest.Matchers;
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
        assertEquals(Constant, lexicalParser.parser("89")[0].getType());
        assertEquals(89, lexicalParser.parser("89")[0].getValue());

    }

    @Test
    public void should_return_two_constant_tokens_when_receive_two_numbers_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("89 96");
        assertThat(parserResult.length, is(2));
        assertThat(parserResult[0].getType(), is(Constant));
        assertThat(parserResult[0].getValue(), is(integer(89)));
        assertThat(parserResult[1].getType(), is(Constant));
        assertThat(parserResult[1].getValue(), is(integer(96)));
    }



    @Test
    public void should_return_plus_operation_token_when_receive_plus_sign_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("+");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(Plus));
        assertThat(parserResult[0].getValue(), is(string("+")));
    }

    @Test
    public void should_return_sub_operation_token_when_receive_sub_sign_by_string() throws Exception {
        LexicalParser lexicalParser = new LexicalParser();
        Token[] parserResult = lexicalParser.parser("-");
        assertThat(parserResult.length, is(1));
        assertThat(parserResult[0].getType(), is(Sub));
        assertThat(parserResult[0].getValue(), is(string("-")));
    }

    private Object string(String string) {
        return new String(string);
    }


    private Object integer(int i) {
        return new Integer(i);
    }


}
