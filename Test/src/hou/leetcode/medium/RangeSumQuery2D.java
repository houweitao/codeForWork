package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月14日 上午12:47:05
 */

public class RangeSumQuery2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumMatrix {
	int[][] map;

	public NumMatrix(int[][] matrix) {
		if (matrix.length > 0 && matrix[0].length > 0)
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (i == 0) {
						if (j == 0)
							map[0] = matrix[0];
						else
							map[0][j] = map[0][j - 1] + matrix[0][j];
					} else if (j == 0) {
						map[i][0] = map[i - 1][0] + matrix[i][0];
					} else {
						map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + matrix[i][j];
					}
				}
			}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int iMin = Math.min(row1, row2);
		int iMax = Math.max(row1, row2);

		int jMin = Math.min(col1, col2);
		int jMax = Math.max(col1, col2);

		return map[iMax + 1][jMax + 1] - map[iMax + 1][jMin] - map[iMin][jMax + 1] + map[iMin][jMin];
	}
}