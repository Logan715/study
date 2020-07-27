package com.cmz.study.expression;

import java.util.Map;
import java.util.Stack;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public interface Expression {

    double interpret(Map<String, ?extends Number> params);
}
