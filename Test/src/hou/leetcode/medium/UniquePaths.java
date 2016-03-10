package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午10:55:40
 * https://leetcode.com/problems/unique-paths/
 * end 2015年11月16日11:25:18
 */

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long first = System.currentTimeMillis();
		UniquePaths up = new UniquePaths();
		int num = up.uniquePaths(23, 12);
		System.out.println(num);
		long second = System.currentTimeMillis();
		int num2 = up.uniquePaths2(23, 12);
		System.out.println(num2);
		long end = System.currentTimeMillis();

		System.out.println(second - first);
		System.out.println(end - second);
	}

	//time out
	public int uniquePaths(int m, int n) {
		int count = 0;
		if (m == 0 || n == 0)
			return 0;
		else if (m == 1 || n == 1)
			return 1;

		count = count + uniquePaths(m - 1, n) + uniquePaths(m, n - 1);

		return count;
	}

	//还是写复杂了啊..其实2层循环就行啊！！
	//https://leetcode.com/discuss/38353/0ms-5-lines-dp-solution-in-c-with-explanations
	public int uniquePaths2(int m, int n) {

		if (m == 0 || n == 0)
			return 0;
		else if (m == 1 || n == 1)
			return 1;

		int[][] map = new int[m][n];
		for (int i = 0; i < n; i++)
			map[m - 1][i] = 1;
		for (int i = 0; i < m; i++)
			map[i][n - 1] = 1;

		int p = m - 2, q = n - 2;
		while (p >= 0 && q >= 0) {
			map[p][q] = map[p + 1][q] + map[p][q + 1];
			for (int i = p - 1; i >= 0; i--) {
				map[i][q] = map[i + 1][q] + map[i][q + 1];
			}
			for (int i = q - 1; i >= 0; i--) {
				map[p][i] = map[p + 1][i] + map[p][i + 1];
			}
			p--;
			q--;
		}

		return map[0][0];
	}
}
