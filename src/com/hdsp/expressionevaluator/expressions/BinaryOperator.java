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
        return getEvaluable(evaluateOperand(getLeft()), evaluateOperand(getRight()), operation).value();
    }

    private Evaluable getEvaluable(Object left, Object right, String operation) {
        try {
            return createEvaluable(left, right, getBinaryOperationClass(left, right, operation));
        } catch (ClassNotFoundException e) {
            return nullEvaluable();
        }
    }

    private Evaluable createEvaluable(Object left, Object right, Class<BinaryOperation> binaryOperationClass) {
        try {
            Constructor<BinaryOperation> constructor = binaryOperationClass.getConstructor(Object.class, Object.class);
            return constructor.newInstance(left, right);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return nullEvaluable();
        }
    }

    @SuppressWarnings("unchecked")
    protected Class<BinaryOperation> getBinaryOperationClass(Object left, Object right, String operation) throws ClassNotFoundException {
        return (Class<BinaryOperation>) loadClass(left, right, operation);
    }

    private String getBinaryOperationClassName(Object left, Object right, String operation) {
        return OperationsPackage + typeOf(left) + typeOf(right) + operation;
    }

    private Class loadClass(Object left, Object right, String operation) throws ClassNotFoundException {
        return ClassLoader.getSystemClassLoader().loadClass(getBinaryOperationClassName(left, right, operation));
    }
}
