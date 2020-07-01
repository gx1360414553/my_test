package com.gx.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gx.entity.User;

public class MyTest5 {
    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("123456");
//        String entity1= JSON.toJSONString(user);
//        System.out.println(entity1);
//
//        String entity2 = JSON.toJSONString(user,SerializerFeature.WriteClassName);
//        System.out.println(entity2);

        String json1="{\"Username\":\"root\",\"password\":\"123456\"}";
        String json2="{\"@type\":\"com.gx.entity.User\",\"Username\":\"root\",\"password\":\"123456\"}";
        Object obj = JSON.parseObject(json1,User.class);
        System.out.println(obj);
        Object obj1 = JSON.parseObject(json2,User.class);
        System.out.println(obj1);

        int[] num1 = {1,3};
        int[] num2 = {2};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);


    }

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length =nums1.length + nums2.length;
            int [] num3 = new int[length];
            guiBingSort(nums1, nums2, num3);
            double midNum = 0;
            int mid = (length - 1) / 2;
            if( (length & 1) == 0){
                midNum = (num3[mid] + num3[mid + 1]) / 2.0;
            } else {
                midNum = num3[mid];
            }
            return midNum;
        }


        public static void guiBingSort(int [] a, int [] b, int [] c ){
            int z = 0;
            int x = 0;
            int y = 0;
            while(c.length > z){
                if((y <= b.length - 1) && (x == a.length || a[x] > b[y])){
                    c[z] = b [y];
                    y++;
                } else if(y == b.length || a[x] <= b[y]){
                    c[z] = a[x];
                    x++;
                }
                z++;
            }
            System.out.println("ok");
        }
}
