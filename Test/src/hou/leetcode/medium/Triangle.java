package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月13日 下午1:06:20
 * @end 2015年11月13日14:05:18
 * Time Limit Exceeded
 */

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		l1.add(2);
		list.add(l1);
		l2.add(3);
		l2.add(4);
		list.add(l2);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		list.add(l3);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		list.add(l4);

//		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++)
				System.out.print(list.get(i).get(j) + ",");
			System.out.println();
		}

		Triangle t = new Triangle();
		int a = t.minimumTotal(list);
		System.out.println(a);
		a = t.minimumTotalBetter(list);
		System.out.println(a);
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int count = triangle.get(0).get(0);
//		System.out.println("count:" + count);

		if (triangle.size() == 1)
			return count;

		count = count + help(triangle, 1, 0);
		return count;
	}

	int help(List<List<Integer>> triangle, int n, int pos) {
		int dis = 0;
		if (n == triangle.size() - 1) {
//			System.out.println("leaf!");
			int a = triangle.get(n).get(pos);
			int b = triangle.get(n).get(pos + 1);
			if (a < b) {
//				System.out.println(n + ": " + a);
				return a;
			} else {
//				System.out.println(n + ": " + b);
				return b;
			}
		} else {
			dis = Math.min(triangle.get(n).get(pos) + help(triangle, n + 1, pos),
					triangle.get(n).get(pos + 1) + help(triangle, n + 1, pos + 1));
//			System.out.println(n + ": " + dis);
			return dis;
		}
	}

	public int minimumTotalBetter(List<List<Integer>> triangle) {
		//上个方法超时了。解决方法，保存中间变量。
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
}
