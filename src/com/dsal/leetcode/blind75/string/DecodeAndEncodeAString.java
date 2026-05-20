package com.dsal.leetcode.blind75.string;

import java.util.ArrayList;
import java.util.List;

// LeetCode Link = https://leetcode.com/problems/encode-and-decode-strings/

// Solution Link = https://www.youtube.com/watch?v=_M5CplcRtzE

public class DecodeAndEncodeAString {

    public static void main(String[] args) {

        List<String> stringList = List.of("Hello","World");
        String decodedString = decodeString(stringList);
        System.out.println(decodedString);

        System.out.println(EncodeString(decodedString));

    }

    private static String decodeString(List<String> stringList) {

        StringBuilder sb = new StringBuilder();

        for (String str : stringList){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    private static List<String> EncodeString(String decodedString) { // 5#Hello5#World

        List<String> result = new ArrayList<>();
        int i = 0;
        for (char ch : decodedString.toCharArray()) {
            while (i < decodedString.length()){
                int j = i;
                while(decodedString.charAt(j) != '#'){
                    j++;
                }
                int length = Integer.parseInt(decodedString.substring(i, j));
                i = (j + 1) + length;
                result.add(decodedString.substring(j + 1, i));
            }
        }
        return result;
    }
}
