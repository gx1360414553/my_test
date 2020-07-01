package com.gx.test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.stream().filter(integer -> {
            if(integer == 1){
                return false;
            }
            return true;
        });

        System.out.println("objects = " + Arrays.toString(objects.toArray()));

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
