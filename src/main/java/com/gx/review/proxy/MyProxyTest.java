package com.gx.review.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyTest implements InvocationHandler {

    private Object object;

    public static void main(String[] args) {
        User user = new User();
        MyProxyTest myProxyTest = new MyProxyTest(user);
        UserMapper o = (UserMapper)Proxy.newProxyInstance(myProxyTest.getClass().getClassLoader(), user.getClass().getInterfaces(), myProxyTest);
        o.getUser(123);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("...........................proxy");
        return method.invoke(object, args);
    }

    public MyProxyTest(Object object) {
        this.object = object;
    }
}
