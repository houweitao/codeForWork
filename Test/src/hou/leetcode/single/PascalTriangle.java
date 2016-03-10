package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月10日 下午3:02:35
 */

public class PascalTriangle {

//	private static final List<List<Integer>> list = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<List<Integer>> list = new List();

		PascalTriangle pt = new PascalTriangle();
		pt.generate(10);
	}

	void generate(int n) {
		int[][] nums = new int[n][n];
		nums[0][0] = 1;
		nums[1][1] = 1;
		nums[1][0] = 1;

		for (int i = 2; i < n; i++) {
			nums[i][i] = 1;
			nums[i][0] = 1;
			for (int j = 1; j <= i - 1; j++) {
				nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
//				System.out.print(nums[i][j]+",");
			}
//			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(nums[i][j] + ",");
			}
			System.out.println();
		}
	}
}
