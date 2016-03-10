package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月2日 上午12:28:30
 * @improveDataStructure 2015年12月2日00:36:16
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

public class RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumArray {
	int nums[];

	public NumArray(int[] nums) {
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i < 0)
			i = 0;
		if (j >= nums.length)
			j = nums.length - 1;

		int sum = 0;
		for (int k = i; k <= j; k++)
			sum = sum + nums[k];
		return sum;
	}
}