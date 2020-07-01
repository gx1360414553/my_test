package com.gx.jump;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int i = jumpFloor2(20);
        long end = System.currentTimeMillis();
        System.out.println("i = " + i + "  耗时:" + (end - begin));
        double ceil = Math.ceil(1.1);
        System.out.println(ceil);
    }

    public static int jumpFloor(int target){
        if(target < 1){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public static int jumpFloor1(int target){
        Map<Integer, Integer> map = new HashMap<>();
        if(target < 1){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        if(map.containsKey(target)){
            return map.get(target);
        }else {
            int i = jumpFloor(target - 1);
            int i1 = jumpFloor(target - 2);
            map.put(target, i + i1);
            return i + i1;
        }
    }

    public static int jumpFloor2(int target){
        if(target < 1){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; target >= i; i++){
            temp = b + a;
            a =b;
            b = temp;
        }
        return temp;
    }

}
