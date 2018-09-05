package com.mtinsky.algorithm.string.permutation;

/**
 * 字符串全排列：可重复非递归
 */
public class Demo3 {
    public static void main(String[] args) {
        char[] str = {'a','b','b','d'};
        //1.原字符串排序，此步先跳过
        char[] t = str;
        int i = str.length-1;
        while(t!=null) {
            System.out.println(t);
            t = nextPermutation(t,i);
        }

    }

    public static char[] nextPermutation(char[] str,int i) {
        //后找
        while(i>0) {
            //小大
            if(str[i-1]<str[i]) {
                int k  = i ;
                while(k+1<str.length&&str[k + 1]>str[i-1]) {
                    k++;
                }
                //对换
                exchange(str,i-1,k);
                //反之
                reverse(str,i,str.length-1);
                return str;
            }
            i--;
        }
        return null;
    }

    private static void reverse(char[] str, int i, int i1) {
        char t;
        while(i1>i) {
            t = str[i];
            str[i] = str[i1];
            str[i1] = t;
            i++;
            i1--;
        }
    }

    private static void exchange(char[] str, int i, int k) {
        char t = str[i];
        str[i] = str[k];
        str[k] = t;
    }
}
