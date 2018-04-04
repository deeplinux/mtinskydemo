package com.mtinsky.algorithm.string.lcs;

/**
 * 求解最长公共子序列
 * 动态规划，递推公式
 * LCS(Xm,Yn)=LCS(Xm-1,Yn-1) + xm(xm=yn)
 * LCS(Xm,Yn)=max{LCS(Xm-1,Yn),LCS(Xm,Yn-1)}
 * 时间复杂度：O(n*m),空间复杂度：O(m+n)
 */
public class LCSDemo {
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        int str1Length = str1.length() + 1;
        int str2Length = str2.length() + 1;
        int[][] c = new int[str1Length][str2Length];
        int i = 0;
        int j = 0;
        //初始赋值
        for(i = 0;i<str1Length;i++) {
            c[i][0] = 0;
        }
        for(j = 0;j<str2Length;j++) {
            c[0][j] = 0;
        }
        //求解数组
        for(i=1;i<str1Length;i++) {
            for(j=1;j<str2Length;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    if(c[i-1][j]>c[i][j-1]) {
                        c[i][j] = c[i-1][j];
                    } else {
                        c[i][j] = c[i][j-1];
                    }
                }
            }
        }

        i = str1Length -1;
        j = str2Length -1;
        StringBuffer longStr = new StringBuffer(4);
        //求解最长公共子序列
        while (i>0&&j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1) ) {
                longStr.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(c[i-1][j]>c[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        for(i=longStr.length()-1;i>=0;i--) {
            System.out.print(longStr.charAt(i));
        }
    }
}
