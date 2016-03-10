package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月24日 下午1:13:48
 * @end 2015年12月24日13:30:58
 * https://leetcode.com/problems/unique-binary-search-trees
 */

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees2 res = new UniqueBinarySearchTrees2();
		System.out.println(res.numTrees(19));
	}

	public int numTrees(int n) {
		if (n < 1)
			return 0;
		else {
			int[][] record = new int[n][n];
			return help(0, n - 1, record);
		}
	}

	private int help(int begin, int end, int[][] record) {
		if (begin > end)
			return 1;
		if (begin == end)
			return 1;
		else {
			if (record[begin][end] != 0)
				return record[begin][end];
			else {
				int sum = 0;
				for (int i = begin; i <= end; i++) {
					
					sum = sum + help(begin, i - 1, record) * help(i + 1, end, record);
				}
				record[begin][end] = sum;
				System.out.println(begin + "," + end + ":" + sum);
				return sum;
			}
		}
	}
}
