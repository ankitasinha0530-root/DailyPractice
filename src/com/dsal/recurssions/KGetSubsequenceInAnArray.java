package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class KGetSubsequenceInAnArray {

    public static void main (String[] args) {

        String str = "abc";

        System.out.println(getSubsequence(str));
    }

    private static List<String> getSubsequence(String str) {

        if(str.isEmpty()){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        List<String> recursionResult = getSubsequence(restOfString);

        List<String> mainResult = new ArrayList<>();

        for (String result : recursionResult) {
            mainResult.add(result);
        }
        for (String result : recursionResult) {
            mainResult.add(ch + result);
        }
        return mainResult;
    }
}
