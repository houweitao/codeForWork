package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月1日 下午2:12:40
 * @end 2016年3月1日14:26:48
 */

public class Queens {

	int solution = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queens q = new Queens();
		q.queen(12);
	}

	void queen(int n) {
		int k = 0;
		int[] queens = new int[n];
		for (int i = 0; i < n; i++) {
			queens[i] = -1;
		}

		while (k >= 0) {
			while (queens[k] < n-1) {
				queens[k]++;

				if (canPut(queens, k)) {
					if (k == n-1) {
						System.out.println(++solution);
						print(queens);
					} else {
						k++;
					}
				}

			}
			queens[k] = -1;
			k--;
		}

	}


	private void print(int[] queens) {
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens.length; j++) {
				if (j == queens[i])
					System.out.print("# ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean canPut(int[] queens, int k) {
		for (int i = 0; i < k; i++) {
			if (queens[i] == queens[k] || (Math.abs(i - k) == Math.abs(queens[i] - queens[k])))
				return false;
		}
		return true;
	}

}
