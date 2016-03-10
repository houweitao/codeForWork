package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月9日 下午3:31:26
 * @end 2016年3月9日15:46:16
 * http://www.guolanzhe.com/?p=368
 */

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 3, 5, 7, 8 }, { 10, 11, 16, 20, 22 }, { 23, 30, 34, 50, 77 } };
		Search2DMatrix se = new Search2DMatrix();
		System.out.println(se.in(matrix, 14));
	}

	boolean in(int[][] matrix, int tar) {
		int down = -1;
		int begin = 0, end = matrix.length - 1;

		if (matrix[begin][0] > tar)
			return false;
		if (matrix[end][matrix[0].length - 1] < tar)
			return false;

		while (begin < end) {
			if (begin + 1 == end) {
				if (matrix[end][0] < tar) {
					begin++;
				}
				break;
			}

			int mid = (begin + end) / 2;
			if (matrix[begin][0] == tar)
				return true;
			if (matrix[end][0] == tar)
				return true;
			if (matrix[mid][0] == tar)
				return true;

			else if (matrix[mid][0] > tar)
				end = mid - 1;
			else
				begin = mid;
		}

		int pos = begin;
		begin = 0;
		end = matrix[pos].length - 1;

		System.out.println(matrix[pos][0]);

		if (matrix[pos][begin] > tar || matrix[pos][end] < tar)
			return false;

		while (begin < end) {
			if (begin + 1 == end) {
				if (matrix[pos][begin] == tar || matrix[pos][end] == tar)
					return true;
				else
					return false;
			}

			int mid = (begin + end) / 2;
			if (matrix[pos][mid] == tar)
				return true;
			else if (matrix[pos][mid] > tar) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		return false;
	}

}
