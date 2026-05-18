package com.dsal.leetcode.blind75.string;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args){

        String str = "{}{[()]}[]";

        String str1 = "({)}";

        System.out.println(validParanthesis(str));
        System.out.println(validParanthesis(str1));

    }

    private static boolean validParanthesis(String str) {

        if(str.length() < 2){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){

            if(ch == '('){
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
