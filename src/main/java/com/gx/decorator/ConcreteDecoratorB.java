package com.gx.decorator;

public class ConcreteDecoratorB extends Decorator{

    @Override
    public void operation() {
        super.operation();
        addBehavior();
        System.out.println("ConcreteDecoratorB 操作");
    }

    private void addBehavior(){

    }
}
