package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月9日 下午3:46:55
 * @end 2016年3月9日15:51:47
 * @end 2016年3月9日16:03:20
 * http://www.guolanzhe.com/?p=370
 */

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors sc = new SortColors();
		int[] nums = sc.build(20);
		sc.print(nums);
		sc.sortColors(nums);
		sc.print(nums);
	}

	private int[] build(int n) {
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			double p = Math.random();
			if (p < 0.33)
				nums[i] = 0;
			else if (p > 0.67)
				nums[i] = 2;
			else
				nums[i] = 1;
		}
		return nums;
	}

	void sortColors(int[] nums) {
		int i = 0, begin = 0, end = nums.length - 1;
		while (i <= end) {
			if (nums[i] == 0)
				swap(i++, begin++, nums);
			else if (nums[i] == 2)
				swap(i, end--, nums);
			else
				i++;

			print(nums);
		}
	}

	private void swap(int i, int j, int[] nums) {
		// TODO Auto-generated method stub
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
