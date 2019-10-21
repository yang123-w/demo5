package com.example.test;

import org.springframework.stereotype.Component;

@Component
public class TestUser {

    public TestUser(){
        this.userName="==============qwe==========";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String userName;

}
