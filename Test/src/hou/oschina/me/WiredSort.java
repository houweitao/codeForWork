package hou.oschina.me;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author houweitao
 * @date 2015年11月5日 上午9:50:21
 * http://www.oschina.net/code/snippet_190769_14566
 */

//描述：有一组数（43,14,6,9,3,27,38,19,5等） 
//排序：将最大的放在第一位，最小放在第二位，剩下的最大的放在第三位，最小的放在第四位，以此类推 
//输出排序结果 

public class WiredSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		other();
		another();
	}

	void wiredSort(int[] nums) {

	}
//  两个指针往中间走，知道遇见。
	static void other() {
		int[] a = new int[] { 43, 14, 6, 9, 3, 27, 38, 19, 5,100 };
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

		System.out.println();

		for (int i = 0, j = a.length - 1; i <= j;) {
			System.out.println("j-- " + a[j--]);
			if (j >= i) {
//				System.out.println(i+","+j);
				System.out.println("a++ " + a[i++]);
			}
		}
	}

//	队列，从头出，从尾出
	static void another() {
		int[] a = new int[] { 43, 14, 6, 9, 3, 27, 38, 19, 5 };
		Arrays.sort(a);
		Deque<Integer> al = new ArrayDeque<Integer>();
		for (int e : a) {
			al.addFirst(e);
		}
		do {
			System.out.println(al.pollFirst());
			if (!al.isEmpty())
				System.out.println(al.pollLast());
		} while (al.size() > 0);
	}
}
