package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月1日 下午11:42:32
 * @复杂度太高 2015年12月2日00:12:24
 * https://leetcode.com/problems/burst-balloons/
 * https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
 */

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BurstBalloons bb = new BurstBalloons();
		int[] nums = { 7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 1, 3 };
		System.out.println(bb.maxCoins2(nums));
		System.out.println(bb.maxCoins(nums));
//		System.out.println(bb.maxCoins3(nums));
	}

	// 动态规划。自顶向下，时间复杂度太高。
	public int maxCoins(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else {
			int max = Integer.MIN_VALUE;
			int[] every = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				if (i == 0) {
					int[] tmp = new int[nums.length - 1];
					for (int j = 1; j < nums.length; j++) {
						tmp[j - 1] = nums[j];
					}
					every[0] = nums[1] * nums[0] + maxCoins(tmp);
				} else if (i == nums.length - 1) {
					int[] tmp = new int[nums.length - 1];
					for (int j = 0; j < nums.length - 1; j++) {
						tmp[j] = nums[j];
					}
					every[nums.length - 1] = nums[nums.length - 2] * nums[nums.length - 1] + maxCoins(tmp);
				} else {
					int[] tmp = new int[nums.length - 1];
					int k = 0;
					for (int j = 0; j < nums.length; j++) {
						if (j != i)
							tmp[k++] = nums[j];
					}
					every[i] = nums[i - 1] * nums[i + 1] * nums[i] + maxCoins(tmp);
				}
			}

			for (int i = 0; i < nums.length; i++) {
				if (max < every[i])
					max = every[i];
			}

			return max;
		}
	}

	public int maxCoins2(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		nums[0] = nums[n++] = 1;

		int[][] dp = new int[n][n];
		for (int k = 2; k < n; ++k)
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i)
					dp[left][right] = Math.max(dp[left][right],
							nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
			}

		return dp[0][n - 1];
	}

//	public int maxCoins3(int[] nums) {
//		return help(nums, 0, nums.length - 1);
//	}
//
//	int help(int[] nums, int begin, int end) {
//		if (begin < end)
//			return 0;
//		else if (begin == end)
//			return nums[begin];
//		else {
//			int max = Integer.MIN_VALUE;
//
//			for (int i = begin; i <= end; i++) {
//				if (i == begin)
//					max = Math.max(max, nums[begin] * nums[begin + 1] + help(nums, begin + 1, end));
//				else if (i == end)
//					max = Math.max(max, nums[end] * nums[end - 1] + help(nums, begin, end - 1));
//				else
//					max = Math.max(max, nums[begin] * nums[begin + 1] * nums[begin - 1] + help(nums, begin, i)
//							+ help(nums, i, end));
//			}
//			return max;
//		}
//	}
}
