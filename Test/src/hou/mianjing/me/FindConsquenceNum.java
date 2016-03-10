package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年11月28日 上午12:35:15
 * http://www.1point3acres.com/bbs/thread-154552-1-1.html
 */

public class FindConsquenceNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 2, 5, 4, 9, 6, 7, 8 };
		FindConsquenceNum fcn = new FindConsquenceNum();
		boolean exist = fcn.isExist(nums, 14);
		System.out.println(exist);
	}

	boolean isExist(int[] nums, int target) {
		int i = 0, j = 0;
		while (i <= j && j < nums.length) {
			if (i == j) {
				if (nums[i] == target) {
					System.out.println(i);
					return true;
				} else
					j++;
			} else {
				int sum = 0;
				for (int m = i; m <= j; m++) {
					sum = sum + nums[m];
				}
				if (sum > target)
					i++;
				else if (sum == target) {
					System.out.println(i + "-" + j);
					return true;
				} else
					j++;
			}
		}
		return false;
	}

}
