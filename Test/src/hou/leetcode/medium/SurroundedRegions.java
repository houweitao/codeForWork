package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月8日 下午4:38:31
 * @stackOverflow 2015年12月8日17:00:07
 * zui le
 * https://leetcode.com/problems/surrounded-regions/
 */

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		
		sr.print(board);
		sr.solve(board);
		sr.print(board);
	}

	private void print(char[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public void solve(char[][] board) {
		if (board.length == 0 || (board.length == 1 && board[0].length == 1))
			return;

		int chang = board.length;
		int kuan = board[0].length;

		for (int i = 0; i < chang; i++) {
			if (board[i][0] == 'O')
				deal(board, i, 0);
			if (board[i][kuan - 1] == 'O')
				deal(board, i, kuan - 1);
		}

		for (int i = 0; i < kuan; i++) {
			if (board[0][i] == 'O')
				deal(board, 0, i);
			if (board[chang - 1][i] == 'O')
				deal(board, chang - 1, i);
		}

		for (int i = 0; i < chang; i++)
			for (int j = 0; j < kuan; j++)
				if (board[i][j] != 'Y')
					board[i][j] = 'X';
				else
					board[i][j] = 'O';
	}

	private void deal(char[][] board, int m, int n) {
		int chang = board.length;
		int kuan = board[0].length;
		board[m][n] = 'Y';

		if (m - 1 >= 0 && board[m - 1][n] == 'O')
			deal(board, m - 1, n);
		if (m + 1 < chang && board[m + 1][n] == 'O')
			deal(board, m + 1, n);
		if (n - 1 >= 0 && board[m][n - 1] == 'O')
			deal(board, m, n - 1);
		if (n + 1 < kuan && board[m][n + 1] == 'O')
			deal(board, m, n + 1);
	}
}
