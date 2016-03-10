package hou.text;

/**
 * @author houweitao
 * @date 2015年11月29日 上午1:07:41
 */

public class EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueens eq = new EightQueens();
		eq.find();
	}

	void find() {
		int[] queens = new int[8];
		boolean judge = true;
		for (int i = 0; i < 8; i++)
			queens[i] = 0;
		int k = 0;
		while (k >= 0) {
			while (queens[k] <= 7) {
				queens[k] = queens[k] + 1;
				// judge can place?
				for (int j = 0; j < k; j++) {
					if (!(queens[j] != queens[k] && queens[j] + k - j != queens[k] && queens[j] - k + j != queens[k])) {
						judge = false;
					}
				}
				if (judge) {
					if (k == 7)
						print(queens);
					else
						k = k + 1;// 如果当前位置可以放皇后的话，摆放下一行的皇后。否则本行下一个位置进行摆放
				}
				judge = true;
			}
			queens[k] = 0;
			k--;
		}
	}

	private void print(int[] queens) {
		// TODO Auto-generated method stub
		for (int i = 0; i < queens.length; i++)
			System.out.print(queens[i] + ",");
		System.out.println();

		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < 8; j++) {
				if (j != queens[i] - 1) {
					System.out.print("0 ");
				} else
					System.out.print("1 ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
