package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月14日 下午4:07:46
 */

public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206,
				23, 225, 82, 54, 118, 111, 46, 80, 49, 245, };
		HouseRobber2 hr = new HouseRobber2();
		int rob = hr.rob(nums);
		System.out.println(rob);
	}

	public int rob(int[] nums) {
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
