package hou.leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月10日 下午2:28:58
 * @end 2015年12月10日15:46:41
 * 超时了	。。
 * https://leetcode.com/problems/word-search/
 * https://leetcode.com/discuss/23165/accepted-very-short-java-solution-no-additional-space
 */

public class WordSearch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		WordSearch3 ws = new WordSearch3();
		System.out.println(ws.exist(board, "CEDFBA"));

		for (int i = 0; i < 30; i++) {
			System.out.println("第 " + i + "次循环");
			while (i < 100) {
				i++;
				if (i == 50) {
					System.out.println("jump out");
					break;
				}
			}
		}
	}

	//https://leetcode.com/discuss/60857/simple-solution
	public boolean existBetter(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int x, int y, String word, int start) {
		if (start >= word.length())
			return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;
		if (board[x][y] == word.charAt(start++)) {
			char c = board[x][y];
			board[x][y] = '#';
			boolean res = exist(board, x + 1, y, word, start) || exist(board, x - 1, y, word, start)
					|| exist(board, x, y + 1, word, start) || exist(board, x, y - 1, word, start);
			board[x][y] = c;
			return res;
		}
		return false;
	}

	// me
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return false;

		for (int m = 0; m < board.length; m++) {
			for (int n = 0; n < board[0].length; n++) {
				if (board[m][n] == word.charAt(0)) {
					Stack<Dot> stack = new Stack<>();
					stack.push(new Dot(m, n, board[m][n]));
					board[m][n] = '#';
					while (!stack.isEmpty()) {
						System.out.println("..");
						if (stack.size() == word.length())
							return true;

						Dot dot = stack.peek();
						int nextDir = dot.dir + 1;
						while (nextDir <= 5) {
							if (stack.isEmpty())
								break;

							int i = stack.peek().i;
							int j = stack.peek().j;

							System.out.println("当前位置： " + i + "," + j);

							System.out.println(nextDir + ", " + stack.size());
							print(stack);
							switch (nextDir) {
							case 1:
								if (inMap(board, i + 1, j)) {

									if (board[i + 1][j] == word.charAt(stack.size())) {
										System.out
												.println("yes, " + board[i + 1][j] + ", " + word.charAt(stack.size()));
										stack.get(stack.size() - 1).dir = 1;
										stack.push(new Dot(i + 1, j, board[i + 1][j]));
										nextDir = stack.peek().dir;

										if (stack.size() == word.length())
											return true;

										board[i + 1][j] = '#';
										printMap(board);
									} else
										System.out.println("no, " + board[i + 1][j] + ", " + word.charAt(stack.size()));
								}
								nextDir++;
								break;

							case 2:
								if (inMap(board, i, j - 1)) {
									if (board[i][j - 1] == word.charAt(stack.size())) {
										stack.get(stack.size() - 1).dir = 2;
										stack.push(new Dot(i, j - 1, board[i][j - 1]));
										nextDir = stack.peek().dir;
										if (stack.size() == word.length())
											return true;

										board[i][j - 1] = '#';
									}
								}
								nextDir++;
								break;
							case 3:
								if (inMap(board, i - 1, j)) {
									if (board[i - 1][j] == word.charAt(stack.size())) {
										stack.get(stack.size() - 1).dir = 3;
										stack.push(new Dot(i - 1, j, board[i - 1][j]));
										nextDir = stack.peek().dir;
										if (stack.size() == word.length())
											return true;

										board[i - 1][j] = '#';
									}
								}
								nextDir++;
								break;
							case 4:
								if (inMap(board, i, j + 1)) {
									if (board[i][j + 1] == word.charAt(stack.size())) {
//										System.out.println("yes, "+board[i][j + 1]+", "+word.charAt(stack.size()));
										stack.get(stack.size() - 1).dir = 4;
										stack.push(new Dot(i, j + 1, board[i][j + 1]));
										nextDir = stack.peek().dir;
										if (stack.size() == word.length())
											return true;

										board[i][j + 1] = '#';
									}
//									else
//										System.out.println("no, "+board[i][j + 1]+", "+word.charAt(stack.size()));
								}
								nextDir++;
								break;
							case 5:
								Dot tmp = stack.pop();
								board[tmp.i][tmp.j] = tmp.val;
								break;
							}
						}
					}
				}
			}
		}

		return false;
	}

	private void printMap(char[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void print(Stack<Dot> stack) {
		// TODO Auto-generated method stub
		System.out.print("stack print:");
		for (int i = 0; i < stack.size(); i++)
			System.out.print(stack.get(i).val + ",");
		System.out.println();
	}

	private boolean inMap(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		else
			return false;
	}
}

class Dot {
	int i;
	int j;
	int dir;
	char val;

	Dot(int i, int j, char val) {
		this.i = i;
		this.j = j;
		this.val = val;
		this.dir = 0;
	}
}