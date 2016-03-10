package hou.leetcode.single;

/**
 * @author houweitao 2015年9月2日 上午9:46:45
 *         http://blog.csdn.net/xuguoli_beyondboy/article/details/48162405
 */


/**
 * 每次找出最大的，把它修改成一个小数。然后再找最大的。
 * 
 */

public class KMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 100, 2000, 45, 68, 5, 700, 9, 50, 45, 89, 87 };
		KMaxNumber kmn = new KMaxNumber();
		kmn.findK(a, 8);
	}

	void findK(int a[], int k) {
		for (int i = 0; i < k; i++) {
			dealArray(a, findMax(a));
		}
	}

	int findMax(int a[]) {
		int tmp = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > tmp)
				tmp = a[i];
		}
		System.out.println(tmp);
		return tmp;
	}

	
	//只需要修改最大的数变成个小的数就可以了。
	int[] dealArray(int a[], int n) {
		int b[] = new int[a.length - 1];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != n) {
				b[j] = a[i];
				j++;
			} else
				a[i] = -1;
		}

		return b;
	}
}
