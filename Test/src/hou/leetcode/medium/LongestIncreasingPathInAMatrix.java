package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年1月28日 下午2:38:32
 * @end 2016年1月28日15:07:11 time out
 * @end 2016年1月28日15:40:33 better
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 注意参数，复制的时候。
 */

public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 6, 64, 94, 3, 37, 67, 35 }, { 91, 48, 44, 18, 82, 67, 44 }, { 19, 63, 38, 36, 84, 18, 5 },
				{ 87, 41, 11, 32, 26, 6, 60 }, { 68, 9, 99, 70, 29, 66, 94 }, { 59, 36, 8, 31, 22, 18, 51 },
				{ 64, 66, 20, 66, 9, 48, 15 } };

		LongestIncreasingPathInAMatrix len = new LongestIncreasingPathInAMatrix();
		System.out.println(len.longestIncreasingPath(matrix));
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length < 1)
			return 0;
		else {
			int[][] matrixLen = new int[matrix.length][matrix[0].length];
			return help(matrix, matrixLen);
		}
	}

	private int help(int[][] matrix, int[][] matrixLen) {
		int len = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int lenCur = 1;
				lenCur = helpCount(matrix, matrixLen, i, j);

				len = Math.max(len, lenCur);
			}
		}

//		System.out.println(len);
//		printMatrix(matrix);

		return len;
	}

	private int helpCount(int[][] matrix, int[][] matrixLen, int i, int j) {
		int left = 0, down = 0, right = 0, up = 0, max = 1;

		if (in(matrix, i, j + 1) && matrix[i][j + 1] < matrix[i][j]) {
			if (matrixLen[i][j + 1] == 0)
				helpCount(matrix, matrixLen, i, j + 1);
			right = 1 + matrixLen[i][j + 1];
			max = Math.max(max, right);
		}
		if (in(matrix, i + 1, j) && matrix[i + 1][j] < matrix[i][j]) {
			if (matrixLen[i + 1][j] == 0)
				helpCount(matrix, matrixLen, i + 1, j);
			down = 1 + matrixLen[i + 1][j];
			max = Math.max(max, down);
		}
		if (in(matrix, i, j - 1) && matrix[i][j - 1] < matrix[i][j]) {
			if (matrixLen[i][j - 1] == 0)
				helpCount(matrix, matrixLen, i, j - 1);
			left = 1 + matrixLen[i][j - 1];
			max = Math.max(max, left);
		}
		if (in(matrix, i - 1, j) && matrix[i - 1][j] < matrix[i][j]) {
			if (matrixLen[i - 1][j] == 0)
				helpCount(matrix, matrixLen, i - 1, j);
			up = 1 + matrixLen[i - 1][j];
			max = Math.max(max, up);
		}

		matrixLen[i][j] = max;
		return max;
	}

	private boolean in(int[][] matrix, int i, int j) {
		int m = matrix.length;
		int n = matrix[0].length;

		if (i >= 0 && i < m && j >= 0 && j < n)
			return true;
		else
			return false;
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
