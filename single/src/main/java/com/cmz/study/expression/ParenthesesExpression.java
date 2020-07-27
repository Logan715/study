package com.cmz.study.expression;

import com.cmz.study.expression.utils.Match;
import com.cmz.study.expression.utils.Parentheses;
import lombok.Data;

import java.util.Map;
import java.util.Stack;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
@Data
public class ParenthesesExpression implements Expression {
    private Expression leftExpression;
    private String leftOperation;
    private Expression rightExpression;
    private String rightOperation;
    private Expression parenthesesExpression;
    public ParenthesesExpression(String expression, Match match) {
        String newExpression = match.getMatchStr().substring(1,match.getMatchStr().length()-1);
        parenthesesExpression = ExpressionFactory.create(newExpression);

        String leftExpressionAndOp = expression.substring(0, match.getIndex());
        leftExpressionAndOp.trim();


        String rightExpressionAndOp = expression.substring(match.getIndex()+match.getMatchStr().length());

//        String left
    }


    @Override
    public double interpret(Map<String, ? extends Number> params) {
        return 0;
    }
}
