package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月28日下午5:11:18
 * @end 2016年02月28日17:15:23
 * @source http://www.guolanzhe.com/?p=328
 */

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={3,2,1,0,4};
		JumpGame2 ja=new JumpGame2();
		System.out.println(ja.canJump(nums));
	}

	boolean canJump(int[] nums) {
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > max)
				return false;
			else {
				max = Math.max(i + nums[i], max);
				if (max >= nums.length - 1)
					return true;
			}
		}
		return true;
	}
}
