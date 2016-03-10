package hou.csdn.me;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2015年11月5日 上午11:17:58
 * http://blog.csdn.net/qianhen123/article/details/49645953
 * 
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
 * 目标是使得最后得到的数尽可能小（注意0不能做首位）。
 * 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 */

public class MakeMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0, 6, 9, 3, 2, 3, 1, 5, 1 };
		MakeMinNumber mmn = new MakeMinNumber();
		mmn.makeTiny(nums);
	}

	void makeTiny(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");

		System.out.println();

		if (nums[0] == 0)
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					nums[0]=nums[i];
					nums[i]=0;
					break;
				}
			}
		
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");

		System.out.println();

	}
}
