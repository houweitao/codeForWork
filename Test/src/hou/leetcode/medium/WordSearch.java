package hou.leetcode.medium;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年11月12日 下午10:31:09
 * @error 2015年11月12日22:48:05
 */

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(ws.exist(board, "AAA"));
	}

	public boolean exist(char[][] board, String word) {
		HashMap<Character, Integer> hs = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!hs.containsKey(word.charAt(i)))
				hs.put(word.charAt(i), 1);
			else
				hs.put(word.charAt(i), hs.get(word.charAt(i)) + 1);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (hs.containsKey(board[i][j])) {
					if (hs.get(board[i][j]) == 1)
						hs.remove(board[i][j]);
					else
						hs.put(board[i][j], hs.get(board[i][j]) - 1);
				}
				if (hs.size() == 0)
					return true;
			}
		}

		if (hs.size() == 0)
			return true;
		else
			return false;
	}
}
