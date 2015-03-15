package com.hdsp.expressionparser;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.hdsp.expressionevaluator.Expression;
import com.hdsp.expressionparser.lexical.LexicalParser;
import com.hdsp.expressionparser.lexical.Token;
import com.hdsp.expressionparser.semantical.SemanticParser;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AcceptedExpressionParser {

    private ExpressionParser expressionParser;
    @Mock private LexicalParser lexicalParser;
    @Mock private SemanticParser semanticParser;

    @Before
    public void setUp() throws Exception {
        expressionParser = new ExpressionParser();
    }

    @Test
    public void should_create_the_list_of_tokens_and_give_then_to_semantic_parser() throws Exception{
        setMockLexicalParser();
        setMockSemanticParser();
        when(lexicalParser.parser("1 + 2")).thenReturn(new Token[]{new Token(1), new Token("+"), new Token(2)});
        Expression expression = expressionParser.parser("1 + 2");
        verify(lexicalParser).parser("1 + 2");
        verifyNoMoreInteractions(lexicalParser);
        verify(semanticParser).buildEvaluableExpression(new Token(1), new Token("+"), new Token(2));
        verifyNoMoreInteractions(semanticParser);
    }

    private void setMockLexicalParser() throws NoSuchFieldException, IllegalAccessException {
        Field lexical = expressionParser.getClass().getDeclaredField("lexicalParser");
        lexical.setAccessible(true);
        lexical.set(expressionParser, lexicalParser);
    }

    private void setMockSemanticParser() throws NoSuchFieldException, IllegalAccessException {
        Field semantic = expressionParser.getClass().getDeclaredField("semanticParser");
        semantic.setAccessible(true);
        semantic.set(expressionParser, semanticParser);
    }


}
