package com.dihmed.www.rxtest.model.entity;

/**
 * Created by admin on 2018/3/23.
 */

public class LoginEntity {

    /**
     * name : 张三
     * age : 12
     * sex : 男
     * identity : student
     */

    private String name;
    private String age;
    private String sex;
    private String identity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
