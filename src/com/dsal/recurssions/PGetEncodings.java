package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class PGetEncodings {

    static String[] map = {
            "",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    public static void main(String[] args){

        System.out.println(getEncodings("12103"));

        System.out.println(getEncodings("236145"));
    }

    private static List<String> getEncodings(String str) {

        if(str.isEmpty()){
            return List.of("");
//            OR
//            List<String> ans = new ArrayList<>();
//            ans.add("");
//            return ans;

        } else if(str.length() == 1){
            char ch = str.charAt(0);
            if(ch == '0'){
                return new ArrayList<>();
            } else {
                String code = map[ch - '0'];
                List<String> ans = new ArrayList<>();
                ans.add(code);
                return ans;
            }
        } else { // if the length of String 2 or more

            List<String> recurResult1;
            char ch = str.charAt(0);
            String restOfQues1 = str.substring(1);

            if(ch == '0'){
                return new ArrayList<>();
            } else {
                recurResult1 = getEncodings(restOfQues1); // 1st call left
            }

            List<String> recurResult12 = List.of();
            String ch12 = str.substring(0, 2);
            String restOfQues12 = str.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if(ch12v < 26){
                recurResult12 = getEncodings(restOfQues12); // 2nd call right
            }

            List<String> mainResult = new ArrayList<>();

            for (String s : recurResult1){
                String chs = map[ch - '0'];
                mainResult.add(chs + s);
            }

            for (String s12 : recurResult12){
                String chs12 = map[ch12v];
                mainResult.add(chs12 + s12);
            }
            return mainResult;
        }
    }

}
