package hou.csdn.single;

import java.util.Arrays;

/**
 * @author houweitao 2015年8月10日 上午11:24:15
 *         http://blog.csdn.net/wei_chong_chong/article/details/47359411
 */

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySort as = new ArraySort();
		as.sortIntArray();
	}

	public void sortIntArray() {
		int[] array = new int[] { 8, 5, 9, 0, 6, 3, 4, 7, 2, 1 };
		System.out.println("整数排序前");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		Arrays.sort(array);
		System.out.println("整数排序后");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		
		String[] array2 = new String[] { "a", "c", "e", "d", "b" };

		System.out.println("字符串排序后");
		Arrays.sort(array2);
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
	}
}
