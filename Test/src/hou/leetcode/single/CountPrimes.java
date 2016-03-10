package hou.leetcode.single;

/**
 * @author houweitao 2015年8月5日 下午2:56:45
 */

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountPrimes cp = new CountPrimes();
		System.out.println(cp.isPrime(101));

		cp.countPrimes(5);
		System.out.println(cp.countPrimes(499979));
		System.out.println(cp.countPrimes2(499979));

	}

	public int countPrimes2(int n) {
		int res = 0;
		boolean[] used = new boolean[n];
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!used[i - 1]) {
				int temp = i * i;
				while (temp < n) {
					used[temp - 1] = true;
					temp += i;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (!used[i - 1]) {
				res++;
			}
		}
		return res;
	}

	public int countPrimes(int n) {
		int count = 0;
		if (n == 1)
			return 0;
		else {
			for (int i = 1; i < n; i++) {
				if (isPrime(i)) {
					count++;
					System.out.println(i);
				}
			}
		}

		return count;
	}

	boolean isPrime(int n) {
		if (n <= 1 || n == 4)
			return false;
		else if (n == 2 || n == 3 || n == 5)
			return true;
		else {
			for (int i = 2; i < n / 2; i++) {
				int judge = n % i;
				if (judge == 0)
					return false;
			}
		}

		return true;
	}
}
