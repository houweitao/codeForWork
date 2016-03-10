package hou.leetcode.medium;

import java.util.Random;

/**
 * @author houweitao
 * @date 2015年11月8日 下午1:32:37
 * @leetcode https://leetcode.com/problems/minimum-path-sum/
 * @betterSolution 2015年11月16日13:32:28
 */

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPathSum mps = new MinimumPathSum();
//		mps.gridTest();

//		int[][] grid = new int[10][5];
//		Random random = new Random();
//		for (int i = 0; i < 10; i++)
//			for (int j = 0; j < 5; j++)
//				grid[i][j] = random.nextInt(100);

		int[][] grid = mps.gridBuild(10, 20);
		mps.gridPrint(grid);

		int out = mps.minPathSum(grid, 0, 0);
		System.out.println(out);

		out = mps.maxPathSum(grid, 0, 0);
		System.out.println(out);

		out = mps.betterSolution(grid);
		System.out.println(out);

		// testcase
		int[][] test = new int[3][3];
		test[0][0] = 0;
		test[0][1] = 0;
		test[0][2] = 2;
		test[1][0] = 0;
		test[0][1] = 1;
		test[2][2] = 1;
		test[0][0] = 1;
		test[1][1] = 1;
		test[2][2] = 0;

		out = mps.minPathSum(test, 0, 0);
		System.out.println(out);
		out = mps.maxPathSum(test, 0, 0);
		System.out.println(out);
		out = mps.betterSolution(test);
		System.out.println(out);
	}

	int minPathSum(int[][] grid, int m, int n) {
//		int length = 0;
		int l = grid.length - 1;
		int w = grid[0].length - 1;

		if (m == l && n == w - 1) {
			return grid[m][n + 1];
		}

		if (m == l - 1 && n == w) {
			return grid[m + 1][n];
		}
		if (m == l) {
			int restLength = 0;
			for (int i = n + 1; i <= w; i++)
				restLength = restLength + grid[m][i];
			return restLength;
		} else if (n == w) {
			int restLength = 0;
			for (int i = m + 1; i <= l; i++)
				restLength = restLength + grid[i][n];
			return restLength;
		} else
			return smaller(grid[m + 1][n] + minPathSum(grid, m + 1, n), grid[m][n + 1] + minPathSum(grid, m, n + 1));
	}

	int maxPathSum(int[][] grid, int m, int n) {
//		int length = 0;
		int l = grid.length - 1;
		int w = grid[0].length - 1;

		if (m == l && n == w - 1) {
			return grid[m][n + 1];
		}

		if (m == l - 1 && n == w) {
			return grid[m + 1][n];
		}
		if (m == l) {
			int restLength = 0;
			for (int i = n + 1; i <= w; i++)
				restLength = restLength + grid[m][i];
			return restLength;
		} else if (n == w) {
			int restLength = 0;
			for (int i = m + 1; i <= l; i++)
				restLength = restLength + grid[i][n];
			return restLength;
		} else
			return bigger(grid[m + 1][n] + maxPathSum(grid, m + 1, n), grid[m][n + 1] + maxPathSum(grid, m, n + 1));
	}

	// 返回最小的
	int bigger(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	int smaller(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	void gridPrint(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	int[][] gridBuild(int m, int n) {
		int[][] grid = new int[m][n];
		Random random = new Random();

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = random.nextInt(100);
		return grid;
	}

	void gridTest() {
		int[][] grid = new int[10][5];
		System.out.println(grid.length);
	}

	//2015年11月16日13:20:38
	int betterSolution(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = n - 2; i >= 0; i--) {
			grid[m - 1][i] = grid[m - 1][i + 1] + grid[m - 1][i];
		}

		for (int i = m - 2; i >= 0; i--) {
			grid[i][n - 1] = grid[i + 1][n - 1] + grid[i][n - 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}

		return grid[0][0];
	}
}
