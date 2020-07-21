package com.gx.review.proxy;

public class User implements UserMapper{

    @Override
    public void getUser(int userId) {
        System.out.println(userId + "=====================");
    }
}