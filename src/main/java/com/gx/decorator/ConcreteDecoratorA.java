package com.gx.decorator;

public class ConcreteDecoratorA extends Decorator{

    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "New State";
        System.out.println("ConcreteDecoratorA 操作");
    }
}
