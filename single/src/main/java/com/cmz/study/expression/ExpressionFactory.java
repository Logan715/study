package com.cmz.study.expression;

import com.cmz.study.expression.utils.*;
import lombok.Data;

import java.util.Stack;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class ExpressionFactory {

    public static Expression create(String expression) {
        Match match = Parentheses.match(expression);
        if (match.getIndex() >= 0) {
            return new ParenthesesExpression(expression, match);
        }
        match = AddOrSub.match(expression);

        if (match.getIndex() >= 0) {
            if (match.getType().equals(Match.TYPE_ADD)) {
                return new AddExpression(expression, match);
            } else {
                return new SubExpression(expression, match);
            }
        }

        match = MulOrDivision.match(expression);
        if (match.getIndex() >= 0) {
            if (match.getType().equals(Match.TYPE_MUL)) {
                return new MulExpression(expression, match);
            } else {
                return new DivisionExpression(expression, match);
            }
        }

        match = VarOrValue.match(expression);
        if (match.getType().equals(Match.TYPE_VALUE)) {
            return new ValueExpression(expression);
        } else {
            return new VariableExpression(expression);
        }
    }

}


