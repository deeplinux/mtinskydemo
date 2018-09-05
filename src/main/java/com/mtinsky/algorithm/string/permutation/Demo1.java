package com.mtinsky.algorithm.string.permutation;

/**
 * 字符串全排列：不可重复递归
 */
public class Demo1 {
    public static char[] str = {'a','b','c','d'};
    public static int count = 0;
    public static void main(String[] args) {
        permutation(str,0,str.length);
        System.out.println(count);
    }

    public static void permutation(char[] str,int i,int length) {
        if(i==length) {
            count++;
            System.out.println(str);
            return;
        }
        for(int k=i;k<length;k++) {

            exchange(str,i,k);
            permutation(str,i+1,length);
            exchange(str,i,k);
        }
    }

    private static void exchange(char[] str, int i, int k) {
        char t = str[i];
        str[i] = str[k];
        str[k] = t;
    }


}
