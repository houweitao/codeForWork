package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月16日 上午11:05:00
 * https://leetcode.com/problems/unique-paths-ii/
 */

public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid={
				{0,0,0,0},
				{0,1,0,0},
				{0,0,0,0},
				{0,0,1,0},
		};
		UniquePathsII up=new UniquePathsII();
		System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];

		boolean wall = false;
		for (int i = obstacleGrid.length - 1; i >= 0; i--) {
			if (!wall) {
				if (obstacleGrid[i][map[0].length - 1] == 1)
					wall = true;
				else
					map[i][map[0].length - 1] = 1;
			}
		}
		wall = false;
		for (int i = map[0].length - 1; i >= 0; i--) {
			if (!wall) {
				if (obstacleGrid[map.length - 1][i] == 1)
					wall = true;
				else
					map[map.length - 1][i] = 1;
			}
		}

		for (int i = map.length - 2; i >= 0; i--) {
			for (int j = map[0].length - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1)
					map[i][j] = 0;
				else
					map[i][j] = map[i + 1][j] + map[i][j + 1];
			}
		}
		return map[0][0];
	}
}
