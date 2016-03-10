package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月29日 下午2:55:27
 * @timeout 2015年12月29日15:08:39
 * @坑爹 2015年12月29日15:47:22
 */

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3 };
		BurstBalloons bb = new BurstBalloons();
		System.out.println(bb.maxCoinsBetter(coins));
		System.out.println(bb.maxCoins(coins));
	}

	public int maxCoinsBetter(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[][] dp = new int[nums.length][nums.length];
		for (int len = 1; len <= nums.length; len++) {
			for (int start = 0; start <= nums.length - len; start++) {
				int end = start + len - 1;
				for (int i = start; i <= end; i++) {
					int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
//					coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.

					coins = coins + (i != start ? dp[start][i - 1] : 0);

					coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
					dp[start][end] = Math.max(dp[start][end], coins);
				}
			}
		}
		return dp[0][nums.length - 1];
	}

	private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
		if (i < 0 || i >= nums.length) {
			return 1;
		}
		return nums[i];
	}

	public int maxCoins(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2) {
			return nums[0] * nums[1] + Math.max(nums[0], nums[1]);
		} else {
			int ret = 0;
			for (int i = 0; i < nums.length; i++) {
				ret = Math.max(ret, countOut(nums, i) + maxCoins(afterNum(nums, i)));
			}
			return ret;
		}
	}

	private int[] afterNum(int[] nums, int pos) {
		int[] ret = new int[nums.length - 1];
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (i != pos)
				ret[j++] = nums[i];
		}

		return ret;
	}

	private int countOut(int[] nums, int i) {
		if (i == 0)
			return nums[1] * nums[2];
		else if (i == nums.length - 1)
			return nums[nums.length - 1] * nums[nums.length - 2];
		else
			return nums[i - 1] * nums[i] * nums[i + 1];
	}
}
