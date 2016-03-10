package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月3日 下午3:43:27
 */

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(13));
	}

	public int totalNQueens(int n) {
		int k = 0;
		int count = 0;
		boolean judge = true;
		int[] put = new int[n];
		for (int i = 0; i < n; i++)
			put[i] = 0;
		
		while (k >= 0) {
			while (put[k] <= n-1) {
				put[k] = put[k] + 1;
				for (int j = 0; j < k; j++) {
					if (!(put[j] != put[k] && put[j] + k - j != put[k] && put[j] - k + j != put[k])) {
						judge = false;
					}
				}
				if (judge) {
					if (k == n-1) {
						count++;
					} else {
						k = k + 1;
					}
				}
				judge = true;
			}
			put[k] = 0;
			k = k - 1;
		}

		return count;
	}
}
