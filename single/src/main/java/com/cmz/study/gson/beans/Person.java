package com.cmz.study.gson.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {
    String name;
    String sex;
    int age;
}
