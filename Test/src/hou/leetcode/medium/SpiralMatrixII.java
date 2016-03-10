package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月30日 下午10:53:35
 * @end 2015年11月30日23:21:16
 * 做出来了不过做了好多次测试。没有bugfree...
 * https://leetcode.com/problems/spiral-matrix-ii/
 */

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII sm = new SpiralMatrixII();
		int[][] ret = sm.generateMatrix(3);
		sm.print(ret);
	}

	private void print(int[][] ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.length; i++) {
			for (int j = 0; j < ret[i].length; j++)
				System.out.print(ret[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];

		if (n == 1) {
			ret[0][0] = 1;
			return ret;
		}

		print(ret);

		int count = 1;
		int i = 0, j = n - 1;

		while (i <= j) {
			for (int k = i; k <= j; k++) {
				ret[i][k] = count++;
//				print(ret);
			}
			for (int k = i + 1; k <= n - i - 1; k++) {
				ret[k][j] = count++;
//				print(ret);
			}
			for (int k = j - 1; k >= n - 1 - j; k--) {
				ret[n - i - 1][k] = count++;
//				print(ret);
			}
			for (int k = n - i - 2; k > i; k--) {
				ret[k][n - j - 1] = count++;
//				print(ret);
			}
			i++;
			j--;
		}
		return ret;
	}
}
