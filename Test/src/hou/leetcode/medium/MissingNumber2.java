package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月30日 下午10:43:00
 * @end not bad 2015年11月30日22:51:29
 */

public class MissingNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5 };
		MissingNumber2 mn = new MissingNumber2();
		System.out.println(mn.missingNumber(nums));
	}

	public int missingNumber(int[] nums) {
		int sum = 0;
		for (Integer i : nums) {
			sum = sum + i;
		}

		return nums.length * (nums.length + 1) / 2 - sum;
	}
}
