package hou.oschina.single;

/**
 * @author houweitao
 * 2015年7月15日 上午9:26:02
 */

import java.util.Scanner;

public class JDRoll {
 
    public static void main(String[] args) {
        System.out.println("单行输入，用空格隔开！");
        System.out.println("双色球最大、最小、蓝色、参与人数、获奖名额：");
        Scanner scan = new Scanner(System.in);
        //双色球最大最小及蓝色球A
        String aStr = scan.next() + scan.next() + scan.next();
        int a = Integer.valueOf(aStr);
        System.out.println("A: " + a);
        //人数N
        String nStr = scan.next();
        int n = Integer.valueOf(nStr);
        System.out.println("N: " + n);
        //名额P
        String pStr = scan.next();
        int p = Integer.valueOf(pStr);
        System.out.println("P: " + p);
        //人数N除以名额P，取商B
        int b = n/p;
        System.out.println("N / P = B: " + b);
 
        //A除以B，余数为首个中奖号X
        int x = a%b;
        System.out.println("A % B = X: " + x);
 
        int[] rs = new int[p];
        rs[0] = x;
 
        //其他中奖号X+B,X+2B,X+3B,......,X+(P-1)B
        int i = 1;
        while(i < p) {
            rs[i] = x + i*b;
            ++i;
        }
 
        for (int j = 0; j < p; ++j) {
            System.out.println("第" + (j+1) + "个中奖号码为：" + rs[j]);
        }
    }
 
}