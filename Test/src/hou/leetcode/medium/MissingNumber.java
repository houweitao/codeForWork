package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月11日 下午4:44:20
 * https://leetcode.com/discuss/56174/3-different-ideas-xor-sum-binary-search-java-code
 */

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber mn = new MissingNumber();
		int[] nums = { 0, 1 };
		System.out.println(mn.missingNumber(nums));
	}

//	https://leetcode.com/discuss/58647/line-simple-java-bit-manipulate-solution-with-explaination
	public int missingNumber2(int[] nums) {

		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}

	public int missingNumber(int[] nums) {
		boolean judge = false;
		if (nums[0] == 0)
			judge = true;

		if (nums.length == 1 || nums.length == 0)
			if (nums[0] == 0)
				return 1;
			else
				return 0;
		else {
			int i = 0, j = 1;
			while (j < nums.length) {
				if (nums[j] - nums[i] == 1) {
					i++;
					j++;
				} else
					return nums[j];

				if (j == nums.length)
					if (judge)
						return nums[nums.length - 1] + 1;
					else
						return 0;
			}
		}
		return 0;

	}

	public int sum(int[] nums) {
		int len = nums.length;
		int sum = len * (len + 1) / 2;
		for (int i = 0; i < len; i++)
			sum = sum - nums[i];
		return sum;
	}

	public int missingNumberXOR(int[] nums) { //xor
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}
