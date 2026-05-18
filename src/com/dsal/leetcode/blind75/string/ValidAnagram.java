package com.dsal.leetcode.blind75.string;

public class ValidAnagram {

    // Anagram means both the string contains all the same letters or alphabets

    public static void main(String[] args) {

        String str = "anagram", target = "nagaram";
        System.out.println(validAnagram(str, target));

        String str1 = "a", target1 = "aa";
        System.out.println(validAnagram(str1, target1));

    }

    private static boolean validAnagram(String str, String target) {

        int[] freqCountS = new int[256];
        int[] freqCountT = new int[256];

        for (char ch : str.toCharArray()) {
            freqCountS[ch]++;
        }

        for (char ch : target.toCharArray()) {
            freqCountT[ch]++;
        }

        for (int i = 0; i < 256; i++) {
            if(freqCountS[i] != freqCountT[i]){
                return false;
            }
        }
        return true;
    }
}
