package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月17日 上午9:56:49
 * @end 2015年11月17日10:26:15
 * https://leetcode.com/problems/number-of-island
 */

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
//				{ '0', '0', '0', '1', '1' } };

		char[][] grid = { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' }, { '1', '1', '1', '0', '1' } };

		NumberOfIslands ni = new NumberOfIslands();
		ni.printMap(grid);
		System.out.println(ni.numIslands(grid));
		
//		ni.dealMap(grid, 1, 2);
//		ni.printMap(grid);
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dealMap(grid, i, j);
				}
			}
		}

		return count;

	}

	void dealMap(char[][] grid, int m, int n) {
		if (m >= grid.length || n >= grid[0].length)
			return;
		grid[m][n] = '0';

		if (n + 1 < grid[0].length && grid[m][n + 1] == '1') {
			dealMap(grid, m, n + 1);
		}
		if (m + 1 < grid.length && grid[m + 1][n] == '1') {
			dealMap(grid, m + 1, n);
		}
		if (n - 1 >= 0 && grid[m][n - 1] == '1') {
			dealMap(grid, m, n - 1);
		}
		if (m - 1 >= 0 && grid[m - 1][n] == '1') {
			dealMap(grid, m - 1, n);
		}
		
		printMap(grid);
		System.out.println("***************");
		
//		System.out.println(count);
	}

	void printMap(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + ",");
			}
			System.out.println();
		}
	}
}
