package com.dsal.leetcode.blind75.string;

public class MaxLengthPalindromicSubstring {
    // https://www.youtube.com/watch?v=uX0-xyPkR2w
    public static void main(String[] args) {

        String str = "EBBABAD";
        String str1 = "EBBABABD";
        System.out.println(maxLengthPalindromeSubstr(str));
        System.out.println(maxLengthPalindromeSubstr(str1));
    }

    private static String maxLengthPalindromeSubstr(String str) {

        String ans = "";

        for (int i = 1; i < str.length(); i++) {
            //For Odd 1st find for odd digits
            int left = i;
            int right = i;
            String potAns = findPalindrome(str, left, right);
            if (ans.length() < potAns.length()) {
                ans = potAns;
            }

            // For Even then find for even letters in string
            left = i - 1;
            right = i;
            potAns = findPalindrome(str, left, right);
            if (ans.length() < potAns.length()) {
                ans = potAns;
            }
        }

        return ans;
    }

    private static String findPalindrome(String str, int left, int right) {

        while (str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
            if (left < 0 || right > str.length() - 1) {
                break;
            }
        }
        return str.substring(left + 1, right);
    }


}
