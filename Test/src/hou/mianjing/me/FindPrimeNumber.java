package hou.mianjing.me;

/**
 * @author houweitao 2015年9月23日 下午4:54:29 
 * 求解1-10000区间内的素数
 */

public class FindPrimeNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPrimeNumber fpn = new FindPrimeNumber();
		long start = System.currentTimeMillis();
		// fpn.findPrimeNumber(300000);
		fpn.findPrimeNumber2(100000000);
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000 + "秒");
	}

	void findPrimeNumber(int k) {
		for (int i = 3; i <= k; i++) {
			boolean judge = true;
			for (int j = 2; j < i; j++) {
				if (!judge)
					break;
				if (i % j == 0) {
					judge = false;
					break;
				}
			}

			if (judge)
				System.out.println(i);
		}
	}

	void findPrimeNumber2(int k) {
		int[] num = new int[k + 1];
		for (int i = 1; i < k + 1; i = i + 2) {
			num[i] = 1;
			num[i + 1] = 0;
		}

		int gen = (int) Math.sqrt(k);

		for (int j = 3; j <= gen; j++) {
			for (int m = 2; m < k / j + 1; m++) {
				num[j * m] = 0;
			}
		}

		for (int i = 1; i < k + 1; i++) {
			if (num[i] == 1)
				System.out.println(i);
		}
	}
}
