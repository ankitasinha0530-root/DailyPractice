package com.dsal.leetcode.blind75.string;

import java.util.HashMap;
import java.util.Map;

public class StringCanBeAPalindrome {

    public static void main(String[] args) {

        String s = "aabbcccdd";
        String s1 = "aabbbc";
        String s2 = "c";
        String s3 = "caac";
        System.out.println(canBeAPalindromicStr(s));
        System.out.println(canBeAPalindromicStr(s1));
        System.out.println(canBeAPalindromicStr(s2));
        System.out.println(canBeAPalindromicStr(s3));
    }

    private static boolean canBeAPalindromicStr(String str) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int countOne = 0;
        for (int count : freqMap.values()){
            if(count % 2 == 1){ // if there are more than two characters with odd count in string then false
                countOne++;
                if(countOne > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
