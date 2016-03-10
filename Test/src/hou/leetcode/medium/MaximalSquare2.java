package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年1月3日 上午1:31:49
 * @end 2016年1月3日02:20:49
 * https://leetcode.com/problems/maximal-square/
 * 结果出乎意料的好啊。。超过了88%。。我以为都超时了呢！
 */

public class MaximalSquare2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare2 ms = new MaximalSquare2();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1' } };

		System.out.println("get: " + ms.maximalSquare(matrix));

		char[][] test = new char[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				test[i][j] = Math.random() > 0.5 ? '1' : '0';
			}
		}
		System.out.println("get: " + ms.maximalSquare(test));
	}

	public int maximalSquare(char[][] matrix) {

		if (matrix.length == 0)
			return 0;

		int max = 0;
		int chang = matrix.length;
		int kuan = matrix[0].length;
		for (int i = 0; i < chang; i++) {
			for (int j = 0; j < kuan; j++) {
				if (matrix[i][j] == '1') {
					max = Math.max(max, getMax(matrix, i, j));
				}
			}
		}
		return max;
	}

	private int getMax(char[][] matrix, int x, int y) {
		int chang = matrix.length;
		int kuan = matrix[0].length;
		int bianchang = 1;
		boolean bad = false;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
//			System.out.println("i; " + i);
			if (x + i < chang && y + i < kuan && !bad) {
				for (int j = 0; j < i; j++) {
//					System.out.println((x + i) + "," + (y + j) + ": " + matrix[x + i][y + j]);
//					System.out.println((x + j) + "," + (y + i) + ": " + matrix[x + j][y + i]);
//					System.out.println(matrix[x + i][y + i]);
					if (matrix[x + i][y + j] != '1' || matrix[x + j][y + i] != '1' || matrix[x + i][y + i] != '1') {
//						System.out.println("bad,,,,");
//						System.out.println(matrix[x + i][y + j]);
//						System.out.println(matrix[x + j][y + i]);
//						System.out.println(matrix[x + i][y + i]);
						bad = true;
						break;
					}
				}
				if (!bad)
					bianchang++;
			} else {
//				System.out.println("break");
				break;
			}
		}

		return bianchang * bianchang;
	}
}
