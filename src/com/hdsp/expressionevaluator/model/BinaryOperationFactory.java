package com.hdsp.expressionevaluator.model;

import java.lang.reflect.Constructor;

/**
 * Created by JuanDavid on 25/02/2015.
 */
public class BinaryOperationFactory {

    private final Expression left;
    private final Expression right;

    public BinaryOperationFactory(Expression left, Expression right){

        this.left = left;
        this.right = right;
    }

    public Expression create(String binaryOperationType) throws Exception{
        Class<?> additionClass = ClassLoader.getSystemClassLoader().loadClass("com.hdsp.expressionevaluator.model." + left.getType().getSimpleName() + right.getType().getSimpleName() + binaryOperationType);
        Constructor<?> constructor = additionClass.getConstructor(Expression.class, Expression.class);
        return (Expression) constructor.newInstance(left, right);

    }
}
