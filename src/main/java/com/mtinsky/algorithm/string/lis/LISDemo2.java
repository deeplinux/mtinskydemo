package com.mtinsky.algorithm.string.lis;

/**
 * 动态规划，时间复杂度O(n2)
 * bi=max{bj}+1 ai>aj,i>j>=0(如果想到考虑的话ai>=aj即可)
 * pre数组
 * b数组
 */
public class LISDemo2 {
    public static void main(String[] args) {
        String str = "123788912349";
        int size = str.length();
        int[] pre = new int[size];
        int[] b = new int[size];
        int i,j = 0;
        for(i=0 ;i<size;i++) {
            pre[i] = -1;
            b[i] = 1;
        }
        int nIndex = 0;
        int maxLength = 0;

        for(i = 1;i<size;i++) {
            for(j=i-1;j>=0;j--) {
                if(str.charAt(j)<str.charAt(i)) {
                    if(b[i]<b[j] + 1) {
                        b[i] = b[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(b[i]>maxLength) {
                maxLength = b[i];
                nIndex = i;
            }
        }
        String longStr = "";
        System.out.println("最大长度为:" + maxLength);
        while(nIndex>=0) {
            longStr = longStr + str.charAt(nIndex);
            nIndex = pre[nIndex];
        }
        System.out.print("该字符串为：");
        for(i=longStr.length()-1;i>=0;i--) {
            System.out.print(longStr.charAt(i));
        }
        System.out.println();
    }


}
