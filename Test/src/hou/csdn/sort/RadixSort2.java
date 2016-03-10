package hou.csdn.sort;

/**
 * @author houweitao
 * @date 2016年3月7日 上午11:33:51
 */

public class RadixSort2 {
	public static void main(String[] args) {
		RadixSort2 rs = new RadixSort2();
		System.out.println(rs.getNums(12345, 2));

		int[] nums = { 49, 38, 65, 97, 76, 13, 27, 49, 178, 64, 12, 34, 5, 4, 62, 179 };
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		rs.radixSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	int[] radixSort(int[] nums) {
		if (null == nums || nums.length < 2) {
			return nums;
		} else {
			int length = nums.length;
			int[] bucket = new int[length];
			int[] count = new int[10];

			for (int i = 1; i <= 3; i++) {
				for (int j = 0; j < 10; j++) {
					count[j] = 0;
				}

				for (int j = 0; j < length; j++) {
					count[getNums(nums[j], i)]++;
				}

				for (int k = 1; k < 10; k++) {
					count[k] = count[k] + count[k - 1];
				}

				for (int m = length - 1; m >= 0; m--) {
					int num = getNums(nums[m], i);
					bucket[count[num] - 1] = nums[m];
					count[num]--;
				}
				for (int c = 0; c < length; c++)
					nums[c] = bucket[c];

				for (int p = 0; p < nums.length; p++) {
					System.out.print(nums[p] + " ");
				}
				System.out.println();
			}
		}
		return nums;
	}

	private int getNums(int num, int d) {

		int[] a = { 1, 1, 10, 100, 1000 };
		return (num / a[d] % 10);
	}
}
