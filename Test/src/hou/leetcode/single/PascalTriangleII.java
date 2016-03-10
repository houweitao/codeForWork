package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月20日 下午4:38:24
 * @end 2015年11月20日16:49:57
 * https://leetcode.com/problems/pascals-triangle-ii/
 */

public class PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangleII pt = new PascalTriangleII();
		pt.getRow(10);
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>();
		int n = rowIndex + 1;
		if (rowIndex < 0)
			return null;
		if (rowIndex == 0) {
			ret.add(1);
			return ret;
		} else if (rowIndex == 1) {
			ret.add(1);
			ret.add(1);
			return ret;
		}

		else {
			int[][] nums = new int[n][n];
			nums[0][0] = 1;
			nums[1][1] = 1;
			nums[1][0] = 1;

			for (int i = 2; i < n; i++) {
				nums[i][i] = 1;
				nums[i][0] = 1;
				for (int j = 1; j <= i - 1; j++) {
					nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
				}
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j <= i; j++) {
//					System.out.print(nums[i][j] + ",");
//				}
//				System.out.println();
//			}

			for (int i = 0; i < n; i++) {
				ret.add(nums[n - 1][i]);
//				System.out.println(nums[n - 1][i]);
			}
			return ret;
		}
	}
}
