package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月14日 下午4:26:05
 * @end 2015年12月14日16:44:16
 * https://leetcode.com/problems/house-robber-ii/
 */

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1 };
		HouseRobberII hr = new HouseRobberII();
		System.out.println(hr.rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		else {
			int[] first = new int[nums.length - 3];
			int[] second = new int[nums.length - 1];

			int m = 0, n = 0;

			for (int i = 0; i < nums.length; i++) {
				if (i != 0)
					second[n++] = nums[i];
				if (i != nums.length - 1 && i != 1 && i != 0)
					first[m++] = nums[i];
			}

			return Math.max(nums[0] + robHelp(first), robHelp(second));
		}
	}

	public int robHelp(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		else if (nums.length == 3)
			return Math.max(nums[0] + nums[2], nums[1]);
		else {
			int best[] = new int[nums.length];
			best[0] = nums[0];
			best[1] = Math.max(nums[0], nums[1]);
			best[2] = Math.max(nums[0] + nums[2], nums[1]);

			for (int i = 3; i < nums.length; i++) {
				best[i] = Math.max(nums[i] + best[i - 2], nums[i - 1] + best[i - 3]);
				System.out.println((i + 1) + ": " + best[i]);
			}

			return best[nums.length - 1];
		}
	}
}
