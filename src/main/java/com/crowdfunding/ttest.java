package com.crowdfunding;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;


public class ttest extends tt {


    static int count = 0;
    static final String str8 = "b";
    public static void main(String[] args) {
        t t1 = new t();
        String s = "b"+str8;
        String b = "bb";
        System.out.println(s==b);

    }
    public static int get(int num){
        if(num==1 || num == 2){
            return 1;
        }
        count =get(num-1)+get(num-2);
        return count;
    }
}
class t{
    String s = "b";
}
