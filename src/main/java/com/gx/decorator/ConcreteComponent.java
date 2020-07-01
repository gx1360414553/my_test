package com.gx.decorator;

public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent 操作");
    }
}
