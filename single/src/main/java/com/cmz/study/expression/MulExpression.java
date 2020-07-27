package com.cmz.study.expression;

import com.cmz.study.expression.utils.Match;

import java.util.Map;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class MulExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;
    public MulExpression(String expression, Match match) {
        String leftExpressionStr = expression.substring(0, match.getIndex());
        leftExpression = ExpressionFactory.create(leftExpressionStr);
        String rightExpressionStr = expression.substring(match.getIndex()+1);
        rightExpression = ExpressionFactory.create(rightExpressionStr);
    }



    @Override
    public double interpret(Map<String, ? extends Number> params) {
        return leftExpression.interpret(params)* rightExpression.interpret(params);
    }
}
