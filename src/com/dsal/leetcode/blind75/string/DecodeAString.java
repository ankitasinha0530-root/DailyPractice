package com.dsal.leetcode.blind75.string;

// LeetCode link - https://leetcode.com/problems/decode-string/description/
// Solution link - https://www.youtube.com/watch?v=E9qHRcQXmDk&t=23s

import java.util.Stack;

public class DecodeAString {

    public static void main(String[] args) {

        String str = "3[a]2[bc]";
        System.out.println(decodeAString(str));
        String str1 = "3[a2[c]]";
        System.out.println(decodeAString(str1));
        String str2 = "2[abc]3[cd]ef";
        System.out.println(decodeAString(str2));

    }

    private static String decodeAString(String str) {

        // Create a number stack and String Stack
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char ch : str.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
/**             When we see ']'
                    save the current string so far
                    save the repeat count
                    intilialize num with 0 and crrentstr with new StringBuilder()*/
            } else if (ch == '[') {
                numberStack.push(num);
                stringStack.push(currentStr);
                num = 0; // intialize number;
                currentStr = new StringBuilder();
/**
                When you see ]:
                    extract the repeat count from Stack
                    take the current decoded part from stack
                    repeat it
                    attach it back to the previous string
                    and currentStr = prev*/
            } else if (ch == ']') {
                StringBuilder prev = stringStack.pop();
                int repeat = numberStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(currentStr);
                }
                currentStr = prev;

            } else {
                currentStr.append(ch);
            }
        }
        return currentStr.toString();
    }

}
