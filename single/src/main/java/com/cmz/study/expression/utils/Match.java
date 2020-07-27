package com.cmz.study.expression.utils;

import lombok.Data;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
@Data
public class Match {
    public static final String TYPE_ADD = "add";
    public static final String TYPE_SUB = "sub";
    public static final String TYPE_MUL = "mul";
    public static final String TYPE_DIV = "div";
    public static final String TYPE_PARENTHESES = "parentheses";
    public static final String TYPE_VALUE = "value";
    public static final String TYPE_VARIABLE = "variable";
    private int index;
    private String type;
    private String matchStr;

    @Override
    public String toString() {
        return "Match{" +
                "index=" + index +
                ", matchStr='" + matchStr + '\'' +
                '}';
    }
}
