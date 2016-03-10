package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月14日 上午11:12:06
 * http://www.1point3acres.com/bbs/thread-165380-1-1.html
 */

public class MoveZero2Right {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, 3, 0, 2, 0, 2, 2, 2, 0 };
		MoveZero2Right m = new MoveZero2Right();
		m.move(nums);

		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	void move(int[] nums) {
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
			if (i == nums.length - 1) {
				while (j < nums.length)
					nums[j++] = 0;
			}
		}
	}
}
