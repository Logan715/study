package com.cmz.study.expression.utils;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class AddOrSub {
    public static Match match(String expression) {
        Match match = new Match();
        int subIndex = expression.indexOf("-");
        int addIndex = expression.indexOf("+");
        if(subIndex <0 && addIndex <0) {
            match.setIndex(-1);
        } else if(subIndex >=0 && addIndex >=0) {
            if(subIndex<addIndex) {
                match.setIndex(subIndex);
                match.setType(Match.TYPE_SUB);
            } else {
                match.setIndex(addIndex);
                match.setType(Match.TYPE_ADD);
            }
        } else if(subIndex >=0) {
            match.setIndex(subIndex);
            match.setType(Match.TYPE_SUB);
        } else {
            match.setIndex(addIndex);
            match.setType(Match.TYPE_ADD);
        }
        return match;
    }
}
