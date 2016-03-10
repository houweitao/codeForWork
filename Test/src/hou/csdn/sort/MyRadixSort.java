package hou.csdn.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月7日 上午11:59:37
 */

public class MyRadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 101, 56, 17, 18, 23, 34, 15,
				35, 25, 53, 51 };

		MyRadixSort rs = new MyRadixSort();
		rs.sort(a);
	}

	public void sort(int[] array) {
		// 根据最大值的位数来确定排序的趟数;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}

		List<List<Integer>> queue = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}

		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第time+1位数;
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				queue.get(x).add(array[j]);
			}

			System.out.println("第" + (i + 1) + "次排序后 队列： ");
			System.out.println(queue);

			int count = 0;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					array[count++] = queue.get(k).get(0);
					queue.get(k).remove(0);
				}
			}

			System.out.println("第" + (i + 1) + "次排序后 数组： ");
			for (int p = 0; p < array.length; p++) {
				System.out.print(array[p] + "->");
			}
			System.out.println();
		}
	}
}
