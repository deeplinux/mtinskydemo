package com.mtinsky.algorithm.string.palindrome;

/**
 * 最长回文子串
 * manachar算法 时间复杂度0(n),空间复杂度O(n)
 * if mx-i>p[j]  p[i]==p[j]
 * if mx-i
 */
public class MaxPalindromeSubstringDemo1 {
    public static void main(String[] args) {
        char[] str = {'1','2','2','1','2','3','2','1'};
        char[] str1 = new char[str.length*2+1];
        for(int i=0;i<str1.length;i++) {
            if(i%2==0) {
                str1[i] = '#';
            } else {
                str1[i] = str[i/2];
            }
        }
        int[] p = new int[str1.length];
        int k = 0;
        int max = 0;
        int j;
        for(;k<str1.length;k++) {
            p[k] = 1;
        }
        for(int i=1;i<str1.length;i++) {
            j = 2*max-i;
            if(j<0) {
                //判断
                for(k=1;k+i<str1.length&&i-k>=0;k++) {
                    if(str1[k+i]==str1[i-k]) {
                        p[i] = p[i] + 1;
                    } else {
                        break;
                    }
                }
            } else if(p[max]+max-1-i>p[j]){
                p[i] = p[j];
            } else {
                //判断
                p[i] = p[j];
                for(k=i+p[i];k+i<str1.length&&i-k>=0;k++) {
                    if(str1[k+i]==str1[i-k]) {
                        p[i] = p[i] + 1;
                    } else {
                        break;
                    }
                }
            }
            if(p[i]>p[max]) {
                max = i;
            }
        }

        System.out.println("回文串最大长度为："+(p[max]-1));
        System.out.print("回文串为");
        for(k=max-p[max]+1;k<max+p[max]-1;k++) {
            if(str1[k]!='#') {
                System.out.print(str1[k]);
            }
        }

    }
}
