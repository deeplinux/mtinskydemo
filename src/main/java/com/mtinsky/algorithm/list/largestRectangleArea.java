package com.mtinsky.algorithm.list;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * 利用栈转换为递增矩阵
 */
public class largestRectangleArea {
    public static void main(String[] args) {
        int[] heights = new int[]{2,5,6,2,3};
        System.out.println(new largestRectangleArea().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> tStack = new Stack<Integer>();
        int result = 0;
        int count = 0;
        for(int tValue : heights) {
            if(!tStack.empty() && tStack.peek()>tValue) {
                while (!tStack.empty()&&tStack.peek()>tValue) {
                    count++;
                    result = max(tStack.pop()*count,result);
                }
                count++;
                while (count>0) {
                    count--;
                    tStack.push(tValue);
                }
            } else {
                tStack.push(tValue);
            }
        }

        while (!tStack.empty()) {
            count++;
            result = max(result,tStack.pop() * count);
        }
        return result;
    }

    public int max(int value1,int value2) {
        if(value1>value2) {
            return value1;
        } else {
            return value2;
        }
    }
}
