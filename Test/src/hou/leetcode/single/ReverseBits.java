package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao 2015年8月2日 下午1:30:59
 *         https://leetcode.com/problems/reverse-bits/
 */

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits rb = new ReverseBits();
		rb.reverseBits(2147483647);

	}

	public int reverseBits(int n) {
		long number = 0;
		List<Integer> list = new ArrayList<Integer>();
		int tmp = 0;

		while (n > 0) {
			tmp = n % 2;
			list.add(tmp);
			System.out.println(tmp);
			n = n / 2;
		}
		System.out.println();
		int count = 0;
		int bit[] = new int[32];

		for (int a : list) {
			System.out.print(a);
			bit[count] = a;
			count++;
		}
		System.out.println();
		System.out.println("bit[3]:" + bit[3]);

		// for (int i = 31; i >= 0; i--) {
		for (int i = 0; i < 32; i++) {
			System.out.print(bit[i]);
			number = number + bit[i] * (long) (Math.pow(2, (31 - i)));
		}
		System.out.println();
		System.out.print(bit[0]);
		System.out.println();
		System.out.println(number);

		System.out.println((int) (Math.pow(2, 31)));
		if(n==1)
			number++;
		System.out.println(number);
		
		return (int)number;

	}

}
