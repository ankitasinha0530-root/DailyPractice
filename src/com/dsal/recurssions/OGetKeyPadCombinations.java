package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class OGetKeyPadCombinations {

    static String[] keyPad = {"?!", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;"};

    public static void main(String[] args){

        System.out.println(getKeyPadCombinations("234"));
        System.out.println();

        System.out.println(getKeyPadCombinations("576"));
        System.out.println();

        System.out.println(getKeyPadCombinations("567"));
        System.out.println();

        System.out.println(getKeyPadCombinations("573"));
    }

    private static List<String> getKeyPadCombinations(String numbers) {

        if(numbers.isEmpty()){
            List<String> startWord = new ArrayList<>();
            startWord.add("");
            return startWord;
        }

        char ch = numbers.charAt(0);
        String restOfString = numbers.substring(1);

        List<String> words = getKeyPadCombinations(restOfString);

        List<String> allWords = new ArrayList<>();

        for (String word : words){
            for (char value : keyPad[(int) ch - '0'].toCharArray()){
                allWords.add(value + word);
            }
        }

        return allWords;
    }
}
