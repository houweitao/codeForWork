//package hou.leetcode.medium;
//
//import java.util.Stack;
//
///**
// * @author houweitao
// * @date 2015年12月9日 上午10:26:06
// */
//
//public class WordSearch2 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public boolean exist(char[][] board, String word) {
//		boolean have = false;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == word.charAt(0)) {
//					have = get(board, i, j, word);
//					if (have)
//						return have;
//				}
//			}
//		}
//		return have;
//	}
//
//	private boolean get(char[][] board, int i, int j, String word) {
//		// TODO Auto-generated method stub
//		int chang = board.length;
//		int kuan = board[0].length;
//		Stack<Dot> stack = new Stack<>();
//		stack.push(new Dot(i, j, 1, 0));
//
//		while (!stack.isEmpty()) {
//			for (int k = stack.peek().next; k <= 4; k++) {
//				switch (k) {
//				case 1:
//					if (stack.peek().j + 1 < kuan)
//						if (board[stack.peek().i][stack.peek().j + 1] == word.charAt(stack.size() - 1)) {
//							stack.push(new Dot(i, j + 1, 1, 1));
//						}
//					break;
//				case 2:
//					if (stack.peek().i + 1 < chang)
//						if (board[stack.peek().i + 1][stack.peek().j] == word.charAt(stack.size() - 1)) {
//							stack.push(new Dot(i + 1, j, 1, 1));
//						}
//					break;
//
//				}
//
//			}
//		}
//
//		return false;
//	}
//}
//
//class Dot {
//	int i;
//	int j;
//	int next;
//	int from;
//
//	Dot(int i, int j, int next, int from) {
//		this.i = i;
//		this.j = j;
//		this.next = next;
//		this.from = from;
//	}
//}
