package com.jj.demo.springmvc.db.entity;

/**
 * Created by panjunjie on 2016/07/29.
 */
public class User {
    private String name="jj";
    private Integer age=25;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public Integer getAge(){
        return this.age;
    }
}
