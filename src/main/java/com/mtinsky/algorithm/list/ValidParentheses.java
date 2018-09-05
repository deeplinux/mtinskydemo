package com.mtinsky.algorithm.list;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(new ValidParentheses().isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> tStack = new Stack<Character>();
        char tChar;
        for(int i=0;i<s.length();i++) {
            if('(' == s.charAt(i) || '[' == s.charAt(i) || '{' == s.charAt(i)) {
                tStack.push(s.charAt(i));
            } else {
                if(tStack.empty()) {
                    return false;
                }
                tChar = tStack.pop();
                if(tChar == '('&&s.charAt(i) != ')') {
                    return false;
                }
                if(tChar == '['&&s.charAt(i) != ']') {
                    return false;
                }
                if(tChar == '{'&&s.charAt(i) != '}') {
                    return false;
                }
            }
        }
        if(!tStack.empty()) {
            return false;
        }
        return true;
    }
}
