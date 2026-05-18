package com.dsal.leetcode.blind75.string;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(isAValidPalindrome(str));
        System.out.println(isAValidPalindrome(str2));
    }

    private static boolean isAValidPalindrome(String str) {

        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(str);

        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;

    }

}
