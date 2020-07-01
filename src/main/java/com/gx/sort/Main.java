package com.gx.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println( 151 % 15);
        System.out.println(151 & 15);
//        new ThreadLocal<Integer>() {
//            @Override
//            protected Integer initialValue() {
//                return super.initialValue();
//            }
//        };
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return null;
//            }
//        }, new ThreadPoolExecutor.AbortPolicy());
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        threadPoolExecutor.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return null;
//            }
//        });

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute();
//        threadPoolExecutor.submit()

        int [] a = {12,13,15,21,11,42,18,14,23,15,1};
//        maoPaoSort(a);
//        selectionSort(a);
//        insertSort(a);
//        shellSort(a);
//        guiBing();
//        huaFen(0, a.length - 1, a);
//        huaFenSort(0, a.length - 1, a);
        guiBingSort(0, a.length -1, a, new int[a.length]);
        System.out.println(Arrays.toString(a));
    }

    public static void maoPaoSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
//            for(int j = i + 1; j < arr.length; j ++){
//                if(arr[j] < arr[i]){
//                    swap(arr, i , j);
//                }
//            }
            for(int j = 0; j < arr.length - 1 -i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int [] arr){
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(arr, min, i);
            }
        }
    }

    //5 6 1 3 9 4
    //
    public static void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j >= 1 ; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j , j - 1);
                }else {
                    break;
                }
            }
        }
    }

    public static void shellSort(int [] arr){
        int length = arr.length;
        int h = 1;
        while (h <= length / 3){
            h = h * 3 + 1;
        }
        while (h >=1){
            for (int i = h; i < arr.length; i= i + h) {
                for (int j = i ; j >= h ; j = j -h){
                    if(arr[j] < arr[j - h]){
                        swap(arr, j , j - h);
                    }else {
                        break;
                    }
                }
            }
            h = (h - 1)/ 3;
        }
    }

    // 1,2,3,3,1
    public static void guiBingSort(int begin, int end ,int [] a, int [] arr){
        if(begin == end){
            return;
        }
        int mid = (begin + end) / 2;
        guiBingSort(begin, mid, a, arr);
        guiBingSort(mid + 1, end, a, arr);

        for (int x = begin ,y = mid + 1 ,z = begin; z <= end ; z++) {
            System.out.println("x:" + x + "  y:" +y);
            if(y == end + 1 || (x <= mid && a[x] < a[y])){
                arr[z] = a[x];
                x++;
            }else {
                arr[z] = a[y];
                y++;
            }
        }
        for(int x =begin, y = end, z = begin; z <= end; z++){
            a[z] =  arr[z];
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void guiBing(){
        int [] a ={2,6,12,15,16,18,20};
        int [] b ={1,3,4,12,16,44};
        int [] arr = new int [a.length + b.length];

//        for (int x = 0 ,y =0 ,z = 0; z < arr.length ; z++) {
//            if(x < a.length && (y == b.length  || a[x] <= b[y])){
//                arr[z] = a[x];
//                x++;
//            }else if(x == a.length || a[x] > b[y]){
//                arr[z] = b[y];
//                y++;
//            }
//        }

        for (int x = 0, y =0, z = 0; z < arr.length ; z++) {
            if(y == b.length || (x < a.length && a[x] <= b[y])){
                arr[z] = a[x];
                x++;
            }else {
                arr[z] = b[y];
                y++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static int huaFen(int begin, int end, int [] arr){

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

    public static void huaFenSort(int begin, int end, int [] arr){
        if(begin >= end){
            return;
        }

        int index = huaFen(begin, end, arr);
        huaFen(begin, index - 1, arr);
        huaFen(index + 1, end, arr);
    }


    public static void swap(int [] arr, int x , int y){
        int i = arr[x];
        arr[x] = arr[y];
        arr[y] = i;
    }
}
