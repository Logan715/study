package com.cmz.study.expression.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class VarOrValue {
    public static Match match(String expression) {
        Match match = new Match();
        Pattern compile = Pattern.compile("^[0-9]+([.][0-9]+){0,1}$");
        Matcher matcher = compile.matcher(expression);
        if(matcher.find()) {
            match.setType(Match.TYPE_VALUE);
            match.setMatchStr(expression);
        } else {
            match.setType(Match.TYPE_VARIABLE);
            match.setMatchStr(expression);
        }
        return match;
    }
}
