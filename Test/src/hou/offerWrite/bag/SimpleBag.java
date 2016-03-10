package hou.offerWrite.bag;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2016年3月10日 上午11:11:41
 * @fuck 2016年3月10日12:21:45
 * 一定大小的背包，物品只能放一次。最重多少？
 */

public class SimpleBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 9, 12, 3, 2, 4, 5, 6, 5, 3, 23, 56, 6, 33, 3, 23, 5, 33, 4, 5, 66, 324, 54, 23 };
		SimpleBag sb = new SimpleBag();
		int n = 500;
		long start = System.currentTimeMillis();
		System.out.println(sb.max(nums, n));
		long mid = System.currentTimeMillis();
		System.out.println(sb.max(nums, 0, n));
		long end = System.currentTimeMillis();

		System.out.println(mid - start);
		System.out.println(end - mid);
	}

	int max(int[] nums, int pos, int weight) {
		if (pos >= nums.length || weight < 0)
			return 0;
		int max = Math.max(max(nums, pos + 1, weight), nums[pos] + max(nums, pos + 1, weight - nums[pos]));
		if (max > weight)
			max = 0;
		return max;
	}

	int max(int[] nums, int weight) {
		Arrays.sort(nums);
		int[][] record = new int[weight + 1][nums.length + 1];
		for (int i = 0; i < record.length; i++)
			record[i][0] = 0;
		for (int i = 0; i < record[0].length; i++)
			record[0][i] = 0;

		for (int i = 1; i < record.length; i++) {//纵轴。背包大小
			for (int j = 1; j < record[0].length; j++) {//横轴。背包内物品的数组
//				for (int k = 0; k < j; k++) {//挨个试试。减去一个背包的重量，求剩下最多放多少。
				record[i][j] = Math.max(record[i - 1][j], record[i][j - 1]);
				if (i >= nums[j - 1]) {
					record[i][j] = Math.max(record[i][j], nums[j - 1] + record[i - nums[j - 1]][j]);
					//最后的参数是j-1则是只放一个，是j则方多个可以。
				}
//				}

			}
		}
//
//		for (int i = 1; i < record.length; i++) {
//			for (int j = 1; j < record[0].length; j++) {
//				System.out.print(record[i][j] + "    ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		return record[weight][nums.length];
	}
}
