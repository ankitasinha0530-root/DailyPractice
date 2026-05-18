package com.dsal.leetcode.blind75.string;

public class FindAllPossiblePalindrome {

    //	https://www.youtube.com/watch?v=gI1771HyXu0
    public static void main(String[] args) {

        String str = "aaa";
        String str1 = "aaabb";
        System.out.println(findAllPalindromeCountInStr(str));
        System.out.println(findAllPalindromeCountInStr(str1));
    }

    private static int findAllPalindromeCountInStr(String str) {

        if(str.length() == 1){
            return 1;
        }

        int palindromeCount = 0;

        for (int i = 0; i < str.length(); i++) {

            // For odd length Palindrome
            int low = i;
            int high = i;

            palindromeCount = findAllPalindrome(str, low, high, palindromeCount);

            // for Even length Palindrome
            low = i;
            high = i + 1;

            palindromeCount = findAllPalindrome(str, low, high, palindromeCount);
        }
        return palindromeCount;
    }

    private static int findAllPalindrome(String str, int low, int high, int palindromeCount) {
        while(low > -1 && high < str.length() && str.charAt(low) == str.charAt(high)){
            palindromeCount++;
            low--;
            high++;
        }
        return palindromeCount;
    }
}
