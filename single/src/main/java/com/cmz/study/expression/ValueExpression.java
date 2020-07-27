package com.cmz.study.expression;

import lombok.Data;

import java.util.Map;
import java.util.Stack;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class ValueExpression implements Expression {
    private Double value;
    public ValueExpression(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public double interpret(Map<String, ? extends Number> params) {
        return value;
    }
}
