package com.cmz.study.expression.utils;

import lombok.Data;

/**
 * @Description: ${todo}
 * @author: Logan
 * @date: ${date} ${time}
 */
public class Parentheses {

    public static Match match(String str) {
        Match match = new Match();
        int matchCount = Integer.MIN_VALUE;
        int leftIndex = -1;
        int rightIndex = -1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '(') {
                if(matchCount == Integer.MIN_VALUE) {
                    leftIndex = i;
                    matchCount=1;
                } else {
                    matchCount++;
                }


            } else if(c == ')') {
                if(matchCount == Integer.MIN_VALUE) {
                    throw new RuntimeException("括号不匹配");
                } else {
                    matchCount --;
                }

            }
            if(matchCount == 0) {
                rightIndex = i;
                break;
            }
        }
        if(matchCount == Integer.MIN_VALUE) {
            match.setIndex(-1);
        } else if(matchCount == 0) {
            match.setIndex(leftIndex);
            match.setMatchStr(String.copyValueOf(chars, leftIndex, rightIndex - leftIndex+1));
        } else {
            throw new RuntimeException("括号不匹配");
        }

        return match;
    }
}
