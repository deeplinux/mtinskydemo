package com.mtinsky.algorithm.string.permutation;

/**
 * 字符串全排列：可重复递归，数组内j不与[i,j)内元素交换
 */
public class Demo2 {
    public static char[] str = {'a','b','b','d'};
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
            if(isDuplicate(str,i,k)) {
                continue;
            }
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

    private static boolean isDuplicate(char[] str,int i,int j) {
        for(;i<j;i++) {
            if(str[i]==str[j]) {
                return true;
            }
        }
        return false;
    }
}
