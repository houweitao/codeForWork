package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月9日 下午3:09:26
 * @end 2016年3月9日15:14:33
 * http://www.guolanzhe.com/?p=361
 */

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs cs = new ClimbingStairs();

		for (int n = 2; n < 100; n++) {
			System.out.println(cs.good(n));
			System.out.println(cs.bad(n));
		}
	}

	int bad(int n) {
		if (n < 1)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else
			return bad(n - 1) + bad(n - 2);
	}

	int good(int n) {
		if (n < 1)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			int[] record = new int[n + 1];
			record[1] = 1;
			record[2] = 2;

			for (int i = 3; i <= n; i++)
				record[i] = record[i - 1] + record[i - 2];

			return record[n];
		}
	}
}
