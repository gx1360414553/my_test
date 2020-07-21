package com.gx.sort;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int [] arr = {12,13,15,21,11,42,18,14,23,15,1};

//        huaFenSort(0, arr.length - 1, arr);
//        maoPaoSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void maoPaoSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if(arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
                }
            }
        }
    }


    public static void shellSort(int [] arr){
        int h = 1;
        while (h <= arr.length / 3){
            h = (h * 3) + 1;
        }
        while (h >= 1){
            for (int i = h; i < arr.length; i = i + h) {
                for (int j = i; j >= h; j = j - h) {
                    if(arr[j - h] > arr[j]){
                        swap(arr, j - h, j);
                    }else {
                        break;
                    }
                }
            }
            h = (h - 1) / 3;
        }

    }




    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }










    public static void huaFenSort(int begin, int end, int[] arr){
        if(begin >= end){
            return;
        }
        int i = huaFen(begin, end, arr);
        huaFenSort(begin, i - 1, arr);
        huaFenSort(i + 1, end, arr);
    }


    public static int huaFen(int begin, int end, int[] arr){
        int key  = arr[begin];
        int i = begin;
        int j = end;
        while (i < j){
            while (i < j && arr[j] >= key) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= key) i++;
            arr[j] = arr[i];
        }
        arr[i] = key;
        return i;
    }
}
