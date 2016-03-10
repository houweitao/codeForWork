package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月28日 下午3:18:13
 * https://leetcode.com/problems/move-zeroes/
 * https://leetcode.com/discuss/59015/simple-o-n-java-solution-using-insert-index
 */

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0, 3, 12 };
		MoveZeros mz = new MoveZeros();
		mz.printNums(nums);
		System.out.println();
		mz.moveZeroes(nums);
	}
	
	
	public void moveZeroesNice(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}

	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 1;
		while (i < nums.length && j < nums.length) {
			if(nums[j]==0)
				j++;
			else if (nums[j] != 0 && nums[i] != 0) {
				i = i + 2;
				j = j + 2;
			} else if (nums[i] == 0 && nums[j] != 0) {
				swap(nums, i, j);
				printNums(nums);
				i++;
				j++;
			}
			System.out.println();
		}
	}

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	void printNums(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
