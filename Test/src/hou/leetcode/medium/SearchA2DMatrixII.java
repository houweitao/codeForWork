package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月26日 上午10:46:04
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int right = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] > target)
				break;

			int range = Math.min(right, matrix[0].length);
			for (int j = 0; j < range; j++) {
				if (matrix[i][j] == target)
					return true;
				else if (matrix[i][j] > target) {
					right = Math.min(right, j);
				}
			}
		}
		return false;
	}
}
