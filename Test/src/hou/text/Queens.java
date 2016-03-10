package hou.text;

/**
 * @author houweitao
 * @date 2016年2月29日下午6:22:28
 * @end 2016年02月29日18:49:26
 * @tips 别忘记了状态返回原状
 */

public class Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queens q = new Queens();
		q.queen();
	}

	void queen() {
		int[] queens = new int[8];
		for (int i = 0; i < queens.length; i++)
			queens[i] = -1;

		boolean find = false;
		int k = 0;
		int solutionNum=0;
		while (k >= 0 && k < 8) {
//			System.out.print(k);
//			System.out.println(" " + queens[k]);
			while (k < 8 && queens[k] < 7) {
				queens[k] = queens[k] + 1;
				
//				print(queens);
				
				if (canPut(queens, k)) {
					find = true;
				}

				if (find) {
					if (k == 7) {
						print(queens);
						solutionNum++;
						// queens[k] = queens[k] + 1;

					} else
						k++;
				}

				find = false;
			}
			queens[k]=-1;
			k--;
		}
		
		System.out.println("方案个数： "+solutionNum);
	}

	private void print(int[] queens) {
		// TODO Auto-generated method stub
		for (int i : queens) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == queens[i])
					System.out.print("* ");
				else
					System.out.print("# ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private boolean canPut(int[] queens, int k) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			if (queens[i] == queens[k] || (Math.abs(queens[i] - queens[k]) == Math.abs(i - k)))
				return false;
		}

		return true;
	}

}
