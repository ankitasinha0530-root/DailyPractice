package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class NGetPermutations {
/**
     Permutaion of a string eg
     for length 3 = 3!= 3 * 2 * 1 = 6
     for length 5 = 5! = 5 * 4 * 3 * 2 * 1 = 120

    The intuition is:
            5 choices for the first position
            4 remaining choices for the second
            3 for the third
            2 for the fourth
            1 for the fifth*/

    public static void main(String[] args){

        System.out.println(getPermutations("abc"));
        System.out.println(getPermutations("abcde"));

    }

    private static List<String> getPermutations(String str) {

        if(str.isEmpty()){
            List<String> words = new ArrayList<>();
            words.add("");
            return words;
        }

        List<String> allWords = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            String restOfString = str.substring(0, i) + str.substring(i+1);
            List<String> recurResult = getPermutations(restOfString);
            for (String res : recurResult){
                allWords.add(ch + res);
            }
        }
        return allWords;
    }
}
