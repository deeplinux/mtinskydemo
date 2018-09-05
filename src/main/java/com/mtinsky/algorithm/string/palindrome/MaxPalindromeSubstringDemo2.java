package com.mtinsky.algorithm.string.palindrome;

/**
 * 最长回文子串
 * manachar算法 时间复杂度0(n),空间复杂度O(n)
 * if mx-i>p[j]  p[i]==p[j]
 *  字符串处理时增加
 */
public class MaxPalindromeSubstringDemo2 {
    public static void main(String[] args) {
        //初始化字符串
        char[] str = {'1','2','2','1','2','3','2','1'};
        char[] str1 = new char[str.length*2+3];
        str1[0] = '$';
        str1[str1.length-1] = '*';
        for(int i=1;i<str1.length-1;i++) {
            if(i%2==0) {
                str1[i] = str[(i-1)/2];
            } else {
                str1[i] = '#';
            }
        }
        int[] p = new int[str1.length];
        p[0] = 1;
        int mx = 1;
        int id = 0;
        for(int i=1;i<str1.length-1;i++) {
            if(mx>i) {
                p[i] = min(p[2*id-i],mx-i);
                for(;str1[i-p[i]]==str1[p[i]+i];p[i]++);
            } else {
                p[i] = 1;
            }
            for(;str1[i-p[i]]==str1[p[i]+i];p[i]++);
            if(p[i]+i>mx) {
                mx = p[i] + i;
                id = i;
            }
        }

        System.out.println("回文串最大长度为："+(p[id]-1));
        System.out.print("回文串为");
        for(int i=id-p[id]+1;i<p[id]+id;i++) {
            if(str1[i]!='#') {
                System.out.print(str1[i]);
            }
        }

    }

    public static int min(int a,int b) {
        if(a<b) {
            return a;
        } else {
            return b;
        }
    }
}
