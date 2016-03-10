package hou.leetcode.single;

/**
 * @author houweitao
 * @date again 2015年11月19日 下午2:37:54
 * @
 */

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeroes mz = new MoveZeroes();
		int nums[] = { 1, 0, 2, 3, 4, 0, 5 };
		mz.moveZeroes(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
	}

	public void moveZeroes(int[] nums) {
		if (nums.length > 1) {
			int i = 0;
			for (i = 0; i < nums.length; i++) {
				if (nums[i] == 0)
					break;
			}
			if (i != nums.length - 1)
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						i++;
					}
				}
		}
	}
}
