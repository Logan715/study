package com.cmz.study.expression.utils;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class MulOrDivision {
    public static Match match(String expression) {
        Match match = new Match();
        int divIndex = expression.indexOf("/");
        int mulIndex = expression.indexOf("*");
        if(divIndex <0 && mulIndex <0) {
            match.setIndex(-1);
        } else if(divIndex >=0 && mulIndex >=0) {
            if(divIndex<mulIndex) {
                match.setIndex(divIndex);
                match.setType(Match.TYPE_SUB);
            } else {
                match.setIndex(mulIndex);
                match.setType(Match.TYPE_ADD);
            }
        } else if(divIndex >=0) {
            match.setIndex(divIndex);
            match.setType(Match.TYPE_SUB);
        } else {
            match.setIndex(mulIndex);
            match.setType(Match.TYPE_ADD);
        }
        return match;
    }
}
