package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月30日 下午1:56:32
 * https://leetcode.com/problems/house-robber/
 */

//超时了..

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245, };
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(nums));
	}

	int rob(int nums[]) {
		int max = 0;
		if (nums == null) {
			System.out.println("输入为空!");
			return 0;
		}
		if (nums.length == 1) {
//			System.out.println("return:" + nums[0]);
			return nums[0];
		}
		if (nums.length == 2) {
//			System.out.println("return:" + bigger(nums[0], nums[1]));
			return bigger(nums[0], nums[1]);
		}
		if (nums.length == 3) {
//			System.out.println("return:" + bigger(nums[1], nums[0] + nums[2]));
			return bigger(nums[1], nums[0] + nums[2]);
		}

		max = bigger(nums[0] + rob(dealNums(nums, 1)), nums[1] + rob(dealNums(nums, 2)));

		return max;
	}

	int bigger(int a, int b) {
		if (a >= b)
			return a;
		else
			return b;
	}

	int[] dealNums(int[] nums, int n) {
		int[] re = new int[nums.length - n - 1];

		for (int i = 0, j = 0; i < nums.length; i++) {
			if (i > n) {
				re[j] = nums[i];
				j++;
			}
		}

		return re;

	}
}
