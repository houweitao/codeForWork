package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年11月11日 下午3:10:11
 * @notEnd 2015年11月11日16:01:41
 * fucked
 */

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] queens = new int[8][8], queensAsist = new int[8][8];
//		System.out.println(queens[1][1]);
		NQueens nQueen = new NQueens();
		nQueen.solveNQueens(queens, queensAsist);

		System.out.println();
//		nQueen.arrayPrint(queens);
	}

	void solveNQueens(int[][] queens, int[][] queensAssist) {
		int queenNum = 0;
		boolean canPut = false;

		for (int k = 0; k < 8; k++) {
			for (int i = 0; i < 8; i++) {
				//error!! 这里j=k不对，k应该是上次写入的那个位置才行
				for (int j = k; j < 8; j++) {
					if (canPut(queensAssist, i, j)) {
						System.out.println("put: " + i + "," + j);
						queens[i][j] = 1;
						queenNum++;
						queensAssist = updateMap(queensAssist, i, j);
						canPut = true;
					}
					if(!canPut)
						i++;

				}
				System.out.println("第 " + k + "次，第" + i + "行完结..");
			}
			System.out.println(queenNum);
//			if (queenNum == 8)
			arrayPrint(queens);
//			queensAssist = new int[8][8];
//			queens = new int[8][8];

			araysClear(queensAssist);
			araysClear(queens);
			queenNum = 0;
		}
	}

	void araysClear(int[][] nums) {
		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j < nums[i].length; j++)
				nums[i][j] = 0;
	}

	int[][] updateMap(int[][] queensAsist, int m, int n) {

		for (int i = 0; i < 8; i++) {
			queensAsist[m][i] = 1;
			queensAsist[i][n] = 1;
		}
		for (int i = 0; i < 8; i++) {
			if (i != m)
				for (int j = 0; j < 8; j++) {
					if (Math.abs(j - n) == Math.abs(i - m))
						queensAsist[i][j] = 1;
				}
		}
//		arrayPrint(queensAsist);
		return queensAsist;
	}

	boolean canPut(int[][] queensAsist, int m, int n) {
		if (queensAsist[m][n] == 0)
			return true;
		else
			return false;
	}

	void arrayPrint(int[][] nums) {
		System.out.println("###########");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++)
				System.out.print(nums[i][j] + ",");
			System.out.println();
		}
		System.out.println("###########");
	}
}
