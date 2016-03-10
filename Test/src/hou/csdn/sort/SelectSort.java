package hou.csdn.sort;

/**
 * @author houweitao 2015年8月10日 下午2:42:08
 */

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectSort ss = new SelectSort();
		ss.selectSort();
	}

	public void selectSort() {
		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
		int position = 0;
		for (int i = 0; i < a.length; i++) {
			int j = i + 1;
			position = i;
			int temp = a[i];
			for (; j < a.length; j++) {
				if (a[j] < temp) {
					temp = a[j];
					position = j;
				}
			}
			a[position] = a[i];
			a[i] = temp;
		}

		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
