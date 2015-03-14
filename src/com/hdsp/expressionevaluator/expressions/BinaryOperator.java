package com.hdsp.expressionevaluator.expressions;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.hdsp.expressionevaluator.model.BinaryOperation;
import com.hdsp.expressionevaluator.Evaluable;
import com.hdsp.expressionevaluator.Expression;

public abstract class BinaryOperator extends Operator {

    private final Expression leftExpression;
    private final Expression rightExpression;
    private final String OperationsPackage = "com.hdsp.expressionevaluator.model.";

    public BinaryOperator(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }


    public Expression getLeft() {
        return leftExpression;
    }

    public Expression getRight() {
        return rightExpression;
    }

    protected Object evaluate(String operation) {
        return getEvaluable(getLeft(), getRight(), operation).value();
    }

    protected Evaluable getEvaluable(Expression left, Expression right, String operation) {
        try {
            return createEvaluable(left, right, getBinaryOperationClass(left, right, operation));
        } catch (ClassNotFoundException e) {
            return nullEvaluable();
        }
    }

    private Evaluable createEvaluable(Expression left, Expression right, Class<BinaryOperation> binaryOperationClass) {
        try {
            Constructor<BinaryOperation> constructor = binaryOperationClass.getConstructor(left.getClass(), right.getClass());
            return constructor.newInstance(left, right);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return nullEvaluable();
        }
    }

    @SuppressWarnings("unchecked")
    protected Class<BinaryOperation> getBinaryOperationClass(Expression left, Expression right, String operation) throws ClassNotFoundException {
        return (Class<BinaryOperation>) loadClass(left, right, operation);
    }

    private Class loadClass(Expression left, Expression right, String operation) throws ClassNotFoundException {
        return ClassLoader.getSystemClassLoader().loadClass(getBinaryOperationClassName(left, right, operation));
    }

    private String getBinaryOperationClassName(Expression left, Expression right, String operation) {
        return OperationsPackage + typeOf(left) + typeOf(right) + operation;
    }
}
