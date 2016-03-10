package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年2月27日下午9:57:37
 * @end 2016年02月27日22:15:16
 * @source http://www.1point3acres.com/bbs/thread-173890-1-1.html
 */

public class PrintMatrixDiagonally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3},{4,5,6}};
		PrintMatrixDiagonally pmd=new PrintMatrixDiagonally();
		pmd.printDiagonally(matrix);
	}

	void printDiagonally(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = m - 1; i >= -n; i--) {
			int heng=i;
			for (int j = 0; j < n; j++) {
				if (inMatrix(j, heng, matrix)) {
					System.out.print(matrix[j][heng] + ",");
				}
				heng++;
//				System.out.println("heng "+heng);
			}System.out.println();
		}
	}

	boolean inMatrix(int m, int n, int[][] matrix) {
		if (m < 0 || m >= matrix.length || n < 0 || n >= matrix[0].length)
			return false;
		else
			return true;
	}
}
