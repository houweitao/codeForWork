package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月3日 下午12:21:12
 * @end 2015年12月3日12:55:22
 * https://leetcode.com/problems/game-of-life/
 */

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] board = { { 1, 0, 1, 0 }, { 1, 1, 0, 0, }, { 0, 0, 1, 0 }, { 0, 1, 0, 1 } };
		int [][] board={{0,0}};
		GameOfLife gl = new GameOfLife();
		gl.print(board);
		gl.gameOfLife(board);
		gl.print(board);
	}

	public void gameOfLife(int[][] board) {

		if (!(board.length == 1 && board[0].length == 1)) {

			int[][] map = new int[board.length + 2][board[0].length + 2];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					map[i + 1][j + 1] = board[i][j];
				}
			}

			print(map);

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					int liveNum = countLive(map, i + 1, j + 1);
					if (liveNum < 2 && map[i + 1][j + 1] == 1)
						board[i][j] = 0;
					if ((liveNum == 2 || liveNum == 3) && map[i + 1][j + 1] == 1)
						board[i][j] = 1;
					if (liveNum > 3 && map[i + 1][j + 1] == 1)
						board[i][j] = 0;
					if (liveNum == 3 && map[i + 1][j + 1] == 0)
						board[i][j] = 1;
				}
			}
		} else {
			board[0][0] = 0;
		}

	}

	private void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private int countLive(int[][] board, int i, int j) {
		// TODO Auto-generated method stub
		int chang = board.length;
		int kuan = board[0].length;

		int num = 0;
		if (i - 1 >= 0 && j - 1 >= 0)
			num = num + board[i - 1][j - 1];
		if (i - 1 >= 0)
			num = num + board[i - 1][j];
		if (i - 1 >= 0 && j + 1 < kuan)
			num = num + board[i - 1][j + 1];
		if (j + 1 < kuan)
			num = num + board[i][j + 1];
		if (i + 1 < chang && j + 1 < kuan)
			num = num + board[i + 1][j + 1];
		if (i + 1 < chang)
			num = num + board[i + 1][j];
		if (i + 1 < chang && j - 1 >= 0)
			num = num + board[i + 1][j - 1];
		if (j - 1 >= 0)
			num = num + board[i][j - 1];

		return num;
	}
}
