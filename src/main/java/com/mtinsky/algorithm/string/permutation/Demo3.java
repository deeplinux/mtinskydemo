package com.mtinsky.algorithm.string.permutation;

/**
 * 字符串全排列：可重复非递归
 */
public class Demo3 {
    public static void main(String[] args) {
        //原字符串排序，此步先跳过
        String num = "123489";
        while(num!=null) {
            System.out.println(num);
            num = nextPermutation(num);
        }
    }

    public static String nextPermutation(String tNum) {

        return null;
    }
}
