package com.gx.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        String str = "……^1dsf  の  adS   DFASFSADF阿德斯防守对方asdfsadf37《？：？@%#￥%#￥%@#$%#@$%^><?1234";
        String regEx="[a-zA-Z\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m  =  p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            sb.append(m.group());
        }
        System.out.println(sb);
    }

}
