package com.cmz.study;

import com.cmz.study.expression.Expression;
import com.cmz.study.expression.ExpressionFactory;
import com.cmz.study.expression.utils.AddOrSub;
import com.cmz.study.expression.utils.Match;
import com.cmz.study.expression.utils.MulOrDivision;
import com.cmz.study.expression.utils.Parentheses;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {


    @org.junit.Test
    public void test()  throws Exception{
        String expression = "a+b/c";
        Expression expression1 = ExpressionFactory.create(expression);
        Map<String, Integer> params = new HashMap<>();
        params.put("a",10);
        params.put("b",20);
        params.put("c",3);
        System.out.println(expression1.interpret(params));


    }




}





