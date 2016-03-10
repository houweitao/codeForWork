package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年12月10日 上午10:00:52
 * @end 2015年12月10日10:11:00
 * 练手。。。
 * http://www.1point3acres.com/bbs/thread-158378-1-1.html
 */

public class LongestAddSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 2, 3, 4, 3, 2, 5, 8, 6, 7, 8, 9, 11, 23 };
		LongestAddSubarray lSub = new LongestAddSubarray();
		System.out.println(lSub.getLongest(nums));
	}

	String getLongest(int[] nums) {
		if (nums.length == 0)
			return null;
		else if (nums.length == 1)
			return nums[0] + "";
		else {
			int max = 1;
			int currentL = 1;
			int last = nums[0];
			String ret = nums[0] + ",";
			String currentS = nums[0] + ",";

			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > last) {
					currentL++;
					currentS = currentS + nums[i] + ",";
					if (max < currentL) {
						max = currentL;
						ret = currentS;
					}
					last = nums[i];
				} else {
					currentL = 1;
					last = nums[i];
					currentS = nums[i] + ",";
				}
			}
			return ret;
		}
	}

}
