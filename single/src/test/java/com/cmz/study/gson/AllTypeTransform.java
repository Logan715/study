package com.cmz.study.gson;

import com.cmz.study.gson.beans.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 所有类型的数据转化成json 和json转化成该类型数据
 */

public class AllTypeTransform {

    @Test
    public void testSimple() {
        Person p = new Person("logan", "male", 30);
        Gson gson = new Gson();
        String json = gson.toJson(p);
        Person target = gson.fromJson(json, Person.class);

        System.out.println("===testSimple");
        System.out.println("json:"+json);
        System.out.println("target:"+target);
    }

    @Test
    public void testPersonType() {
        Type type = new TypeToken<Person>(){}.getType();
        Gson gson = new Gson();
        Person person = new Person("Logan", "male", 30);
        String json = gson.toJson(person, type);
        Person target = gson.fromJson(json, type);


        System.out.println("=== testPersonType");
        System.out.println("json:" + json);
        System.out.println("target:" + target);
    }
    @Test
    public void testListType() {
        Gson gson = new Gson();
        List<String> list = new ArrayList<String >(){{
            add("张三");
            add("李四");
            add("王五");
        }};
        Type type = new TypeToken<List<String>>(){}.getType();
        String json = gson.toJson(list, type);
        List<String> target = gson.fromJson(json, type);


        System.out.println("=== testPersonType");
        System.out.println("json:" + json);
        System.out.println("target:" + target);
    }

    @Test
    public void testListType2() {
        Gson gson = new Gson();
        List<Person> list = new ArrayList<Person>(){{
            add(new Person("Logan", "male", 30));
            add(new Person("Logan2", "female", 301));
            add(new Person("Logan3", "male", 302));
        }};
        Type type = new TypeToken<List<Person>>(){}.getType();
        String json = gson.toJson(list, type);



        System.out.println("=== testPersonType");
        System.out.println("json:" + json);
        Type type2 = new TypeToken<List<HashMap>>(){}.getType();
        List<HashMap> target = gson.fromJson(json, type2);
        System.out.println("target:" + target);

        for (int i = 0; i < target.size(); i++) {
            System.out.println(target.get(i) +"|是否是HashMap｜" +Boolean.toString(target.get(i) instanceof HashMap));
        }
    }








}



