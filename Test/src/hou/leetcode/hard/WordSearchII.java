package hou.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2016年2月29日 上午10:46:08
 * @TimeOut 2016年2月29日11:10:09
 * https://leetcode.com/problems/word-search-ii/
 */

public class WordSearchII {
	boolean[][] visted;
	HashMap<String, Integer> not;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'p', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain", "iif","aaaa","aaaaa","aaab","aaaac","aaaabc" };

		WordSearchII ws = new WordSearchII();
		System.out.println(ws.findWords(board, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		visted = new boolean[board.length][board[0].length];
		not = new HashMap<>();
		List<String> ret = new LinkedList<>();
		List<String> bad = new LinkedList<>();

		for (String str : words) {
			boolean needDo = true;
			for (Entry<String, Integer> entry : not.entrySet()) {
				if (!entry.getKey().equals(str)) {
					if (str.contains(entry.getKey().substring(0, entry.getValue() + 1))) {
						System.out.println("包含："+entry.getKey().substring(0, entry.getValue() + 1));
						needDo = false;
						break;
					}
				}
			}

			if (needDo) {
				not.put(str, 0);
				if (inBoard(board, str))
					ret.add(str);
				else
					bad.add(str);
			}
		}

		for (Entry<String, Integer> entry : not.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		return ret;
	}

	private boolean inBoard(char[][] board, String str) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (help(board, i, j, str, 0))
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
		if (visted[i][j])
			return false;

		visted[i][j] = true;

		boolean ret = false;

		if (board[i][j] == str.charAt(pos)) {
//			char[][] next = copy(board);
//			next[i][j] = '#';

			boolean up = help(board, i - 1, j, str, pos + 1);
			boolean right = help(board, i, j + 1, str, pos + 1);
			boolean down = help(board, i + 1, j, str, pos + 1);
			boolean left = help(board, i, j - 1, str, pos + 1);

			ret = up || right || down || left;

		}

		visted[i][j] = false;

		if (pos > not.get(str))
			not.put(str, pos);
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
