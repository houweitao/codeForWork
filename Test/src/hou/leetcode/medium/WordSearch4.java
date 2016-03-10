package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月29日 上午11:17:38
 * @end 2016年2月29日11:34:45
 * @source https://leetcode.com/problems/word-search/
 * @nice https://leetcode.com/discuss/51379/my-java-solution
 */

public class WordSearch4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (help(board, i, j, word, 0))
					return true;
			}
		}

		return false;
	}

	private boolean help(char[][] board, int i, int j, String str, int pos) {
		// TODO Auto-generated method stub
		if (pos >= str.length())
			return true;
		if (i < 0 || i > board.length - 1 || j < -0 || j > board[0].length - 1)
			return false;
		boolean ret = false;

		if (board[i][j] == str.charAt(pos)) {
			char[][] next = copy(board);
			next[i][j] = '#';

			boolean up = help(next, i - 1, j, str, pos + 1);
			if (up)
				return true;
			boolean right = help(next, i, j + 1, str, pos + 1);
			if (right)
				return true;
			boolean down = help(next, i + 1, j, str, pos + 1);
			if (down)
				return true;
			boolean left = help(next, i, j - 1, str, pos + 1);
			if (left)
				return true;

			ret = up || right || down || left;
		}
		return ret;

	}

	char[][] copy(char[][] board) {
		char[][] ret = new char[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				ret[i][j] = board[i][j];
		}

		return ret;
	}
}
