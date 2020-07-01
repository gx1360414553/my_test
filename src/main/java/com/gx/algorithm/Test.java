package com.gx.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        int buf[]={1,2,3,4};
        List<Integer> numLsit = new ArrayList<>();
        perm(buf,0,buf.length-1, numLsit);
        Integer[] integers = numLsit.toArray(new Integer[numLsit.size()]);
        huaFenSort(0, integers.length - 1 ,integers);
        List<Integer> integers1 = Arrays.asList(integers);
        int i = integers1.indexOf(1234);
        Integer integer = integers1.get(i + 1);
        System.out.println("integer = " + integer);

        System.out.println(Arrays.toString(integers1.toArray()));
    }
    public static void perm(int[] buf,int start,int end, List<Integer> numLsit){
        if(start==end){
            String numStr = "";
            for (int i = 0; i < buf.length; i++) {
                numStr += buf[i];
            }
            numLsit.add(Integer.parseInt(numStr));
        }
        else{
            for(int i=start;i<=end;i++){
                int temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
                perm(buf,start+1,end, numLsit);
                temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
            }
        }
    }

    public static int huaFen(int begin, int end, Integer [] arr){

        int key = arr[begin];
        int i = begin;
        int j = end;

        while (i < j){
            while(i < j && arr[j] >= key) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= key) i++;
            arr[j] = arr[i];
        }

        arr[i] = key;
        return i;
    }

    public static void huaFenSort(int begin, int end, Integer[] arr){
        if(begin >= end){
            return;
        }

        int index = huaFen(begin, end, arr);
        huaFen(begin, index - 1, arr);
        huaFen(index + 1, end, arr);
    }

}
