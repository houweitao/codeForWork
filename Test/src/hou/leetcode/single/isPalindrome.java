package hou.leetcode.single;

/**
 * @author houweitao 2015年7月30日 下午3:49:59
 *         https://leetcode.com/problems/palindrome-number/
 *         https://leetcode.com/discuss/23563/line-accepted-java-code-without-
 *         the-need-handling-overflow
 */

public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(34622643));

		// System.out.println(reverse(361));
	}
	// public static boolean isPalindrome(int x) {
	// if (x<0 || (x!=0 && x%10==0)) return false;
	// int rev = 0;
	// while (x>rev){
	// rev = rev*10 + x%10;
	// x = x/10;
	// }
	// return (x==rev || x==rev/10);
	// }

	public static int reverse(int x) {
		int rev = 0;
		while (x > 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return rev;
	}

	// public static int isPalindrome(int x) {
	//
	// int fast = x;
	// int low = x;
	//
	// int count = 0;
	//
	// while(fast/100 >= 0){
	// fast = fast/100;
	// low = low/10;
	// }
	//
	//
	// return low;
	// }

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;

		int temp = x;

		int count = 1;
		while (x / 10 > 0) {
			x = x / 10;
			count++;
		}

		System.out.println(count);

		if (count % 2 != 0) {
			count = (count - 1) / 2;
			int right = (int) (temp % (Math.pow(10, count)));
			int left = (int) (temp / (Math.pow(10, count + 1)));

			left = reverse(left);

			System.out.println(count);

			System.out.println(right);
			System.out.println(left);

			if (left == right)
				return true;
			else
				return false;

		} else {
			count = count / 2;

			System.out.println(count);
			// System.out.println(temp%10000);

			int chu = (int) Math.pow(10, count);
			System.out.println("chu:" + chu);

			int right = (int) (temp % (Math.pow(10, count)));
			int left = (int) (temp / (Math.pow(10, count)));
			left = reverse(left);

			System.out.println(right);
			System.out.println(left);

			if (left == right)
				return true;
			else
				return false;
		}

	}
}
