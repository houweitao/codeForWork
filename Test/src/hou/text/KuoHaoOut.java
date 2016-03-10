package hou.text;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月30日 下午2:55:19
 * @end 2015年12月30日15:07:41
 * @fuck 2015年12月30日17:25:23 notfinished
 * @tips 2015年12月30日18:23:51
 * 回到寝室后，5分钟就解决了。当然功劳不是这5分钟，而是吃饭以及回来路上的思考。
 * 有的时候要想清楚再动手，get hands dirty啊
 * 
 * 但是一个问题，为什么自底向上并没有提高效率？？因为遍历list的时候太耗时？？
 */

public class KuoHaoOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KuoHaoOut kuohao = new KuoHaoOut();
//		kuohao.printList(kuohao.out(10, 10));
//		System.out.println(kuohao.retResult(10, 10));
//		kuohao.printList(kuohao.getRes(10, 10));

		for (int i = 1; i <= 10; i++) {
			long start = System.currentTimeMillis();
			kuohao.out(i, i);
			long mid = System.currentTimeMillis();
			System.out.print(i + ",  first: " + (mid - start));
			kuohao.getRes(i, i);
			long end = System.currentTimeMillis();
			System.out.print("  second: " + (+end - mid));
			kuohao.retResult(10, 10);
			System.out.println("  last: " + (System.currentTimeMillis() - end));
		}
	}

	private void printList(List<String> out) {
		// TODO Auto-generated method stub
		for (int i = 0; i < out.size(); i++)
			System.out.println(out.get(i));

		System.out.println(out.size());
	}

	// 自顶向下
	List<String> out(int left, int right) {
		if (left == 0 && right == 0) {
			List<String> ret = new LinkedList<>();
			ret.add("");
			return ret;
		} else if (left > right)
			return null;
		else if (left == 0) {
			List<String> ret = new LinkedList<>();
			List<String> next = out(0, right - 1);
			for (int i = 0; i < next.size(); i++) {
				String now = ")";
				now = now + next.get(i);
				ret.add(now);
			}
			return ret;
		} else if (left == right) {
			List<String> ret = new LinkedList<>();
			List<String> next = out(left - 1, right);

			for (int i = 0; i < next.size(); i++) {
				String now = "(";
				now = now + next.get(i);
				ret.add(now);
			}
			return ret;
		} else {
			List<String> ret = new LinkedList<>();
			List<String> next1 = out(left - 1, right);

			for (int i = 0; i < next1.size(); i++) {
				String now = "(";
				now = now + next1.get(i);
				ret.add(now);
			}

			List<String> next2 = out(left, right - 1);
			for (int i = 0; i < next2.size(); i++) {
				String now = ")";
				now = now + next2.get(i);
				ret.add(now);
			}

			return ret;
		}
	}

	// 自底向上。只是得到数目
	int retResult(int a, int b) {
		int[][] map = new int[a + 1][b + 1];

		for (int i = 0; i < b + 1; i++) {
			for (int j = 0; j <= i; j++)
				map[0][i] = 1;
		}

		for (int i = 1; i <= a; i++) {
			for (int j = i; j <= b; j++) {
				if (j == i)
					map[i][j] = map[i - 1][j];
				else
					map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[a][b];
	}

	List<String> getRes(int a, int b) {
		List<List<List<String>>> ret = new LinkedList<>();// 总
		List<List<String>> firstFirst = new LinkedList<>();// 第一行元素
		List<String> first = new LinkedList<>();
		first.add("");
		firstFirst.add(first);

		// 处理第一行余下的元素
		for (int i = 1; i <= b; i++) {
			List<List<String>> firstFirst2 = new LinkedList<>();
			List<String> first2 = new LinkedList<>();
			String str = "";
			for (int j = 0; j < i; j++) {
				str = str + ")";
			}
			first2.add(str);
			firstFirst2.add(first2);
			firstFirst.addAll(firstFirst2);
		}

		ret.add(firstFirst);// 第一行元素

//		for (int i = 0; i < ret.get(0).size(); i++) {
//			System.out.println(0 + "," + i);
//			printList(ret.get(0).get(i));
//		}

		for (int i = 1; i <= a; i++) {
			List<List<String>> tmp = new LinkedList<>();// 负责第i行的list
			for (int j = i; j <= b; j++) {
//				System.out.println("i: " + i);
				if (j == i) {
					List<String> tmpNow = new LinkedList<>();
					for (int k = 0; k < ret.get(i - 1).get(1).size(); k++) {// 问题出在这里应该是。
						tmpNow.add("(" + ret.get(i - 1).get(j - i + 1).get(k));
					}
					tmp.add(tmpNow);
				} else {
					List<String> tmpNow = new LinkedList<>();
					for (int k = 0; k < ret.get(i - 1).get(j - i + 1).size(); k++) {
						tmpNow.add("(" + ret.get(i - 1).get(j - i + 1).get(k));
					}

					// 求解（1，2）的时候，这里是（1，1）。但是因为第**这里，还没有加上的原因。所以ret里面并没有所需的信息...这些信息还在tmp里面。//已经解决
					for (int k = 0; k < tmp.get(j - i - 1).size(); k++) {
						tmpNow.add(")" + tmp.get(j - i - 1).get(k));
					}

//					System.out.println("size   " + tmpNow.size());

					tmp.add(tmpNow);
				}

//				System.out.println("" + i + "," + tmp.size());
			}
			ret.add(tmp);// **
//			System.out.println("当前的size： " + ret.size());
		}
//		System.out.println();
//		System.out.println();

//		for (int i = 0; i < ret.size(); i++) {
//			System.out.println("第N行");
//			printList(ret.get(i).get(1));
//		}

		return ret.get(a).get(b - a);
	}
}
