package hou.mianjing.me;

/**
 * @author houweitao
 * 2015年9月9日 上午10:00:21
 * 找leading number。就是给个数组找出那些比其后出现数要大的数。
 * 比如2 4 12 5 3 4，leading number就是12 5。
 * O(n)从右往左扫一遍出来。
 * http://www.1point3acres.com/bbs/thread-134484-1-1.html
 */

public class LeadingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 4, 12, 5, 3, 4 };
		LeadingNumber ln = new LeadingNumber();
		ln.findLeadingNumber(a);
	}

	void findLeadingNumber(int[] a) {
		int length = a.length;
		int max = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			// int max=0;
			if (i == a.length - 1)
				max = a[i];
			else {
				if (a[i] > max) {
					max = a[i];
					System.out.println(i + " " + max);
				}
			}
		}
	}
}
