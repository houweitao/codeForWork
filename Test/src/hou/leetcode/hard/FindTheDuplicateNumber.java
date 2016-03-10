package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月7日 下午3:52:39
 * @end 2015年12月7日15:57:12
 * 可能是做过的最简单的hard
 * https://leetcode.com/problems/find-the-duplicate-number/
 */

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1};
		FindTheDuplicateNumber fd=new FindTheDuplicateNumber();
		System.out.println(fd.findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		int[] help = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			help[nums[i]]++;
		}

		for (int i = 1; i < nums.length; i++)
			if (help[i] > 1)
				return i;
		return -1;
	}
}
