package com.cmz.study.ams;


import java.util.List;

/**
 * Created by lsj on 2018/5/23.
 */
public class AmsParamBean {
    private int sort;
    private String name;
    private String className;
    private String parentName;
    private Class parentClazz;
    private String type;
    private Class clazz;
    private List<AmsParamBean> childParam;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AmsParamBean> getChildParam() {
        return childParam;
    }

    public void setChildParam(List<AmsParamBean> childParam) {
        this.childParam = childParam;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Class getParentClazz() {
        return parentClazz;
    }

    public void setParentClazz(Class parentClazz) {
        this.parentClazz = parentClazz;
    }
}
