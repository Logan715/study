package com.cmz.study.expression;

import java.util.Map;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class VariableExpression implements Expression {
    private String variable;
    public VariableExpression(String variable) {
        this.variable = variable;
    }


    @Override
    public double interpret(Map<String, ? extends Number> params) {
        return Double.parseDouble(params.get(variable).toString());
    }
}
