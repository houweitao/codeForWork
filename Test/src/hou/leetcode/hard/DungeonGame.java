package hou.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author houweitao
 * @date 2015年11月17日 上午11:02:20
 * https://leetcode.com/problems/dungeon-game/
 */

public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DungeonGame dg = new DungeonGame();
//		ArrayList<ArrayList<Integer>> ret = dg.getList(3, 2);
//
//		for (int i = 0; i < ret.size(); i++) {
//			for (int j = 0; j < ret.get(i).size(); j++)
//				System.out.print(ret.get(i).get(j) + ",");
//			System.out.println();
//		}
//		System.out.println();

		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(dg.calculateMinimumHP(dungeon));

		int[][] testCase = { { -61, -35, -50, -88, 8, -2, 27, -68, 23 }, { -82, -89, -13, 44, -27, 43, 5, -39, 24 },
				{ -65, -4, -75, -32, -58, -96, -5, -2, -98 }, { 3, -92, 27, -78, -92, -16, -93, -60, 10 },
				{ -28, 9, -60, 1, -70, -4, -94, -58, 8 }, { 41, -1, 12, -6, -4, -77, -21, 18, 8 },
				{ -13, -99, -15, -17, -57, 9, 18, 28, 18 }, { -72, 15, 35, 36, -34, -43, 6, -18, 41 },
				{ -72, -49, -18, 35, -48, -23, -71, 9, -1 }, { -49, 17, -97, -61, -25, -13, -59, -35, -72 } };

		System.out.println(dg.calculateMinimumHP(testCase));
	}

	public int calculateMinimumHP(int[][] dungeon) {
//		help(dungeon,0,0);

		int m = dungeon.length - 1;
		int n = dungeon[0].length - 1;

		if (m < 0 || n < 0)
			return 0;
		if (m == 0 || n == 0) {

			return dungeon[0][0];
		} else
			return help(dungeon);
	}

	private int help(int[][] dungeon) {
		// TODO Auto-generated method stub
		// 右转是0，下边是1
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		int m = dungeon.length - 1;//m个0
		int n = dungeon[0].length - 1;//n个1

		ret = getList(m, n);

		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++)
				System.out.print(ret.get(i).get(j) + ",");
			System.out.println();
		}
		System.out.println();

		int min[] = new int[ret.size()];
		int cost;
		for (int i = 0; i < ret.size(); i++) {
			int p = 0, q = 0;
			min[i] = Integer.MAX_VALUE;
			cost = dungeon[0][0];
			for (int j = 0; j < ret.get(i).size(); j++) {
				int dir = ret.get(i).get(j);
				if (dir == 0)
					cost = cost + dungeon[p][++q];//别忘了pq也要修改呀！
				else
					cost = cost + dungeon[++p][q];

//				min = Math.min(min, cost);

				if (min[i] > cost) {
					min[i] = cost;
//					System.out.println("change: " + min[i]);
				}
			}

//			System.out.println("another" + i);
		}

//		for (int i = 0; i < min.length; i++)
//			System.out.println("cost" + i + ": " + min[i]);

		Arrays.sort(min);
		return min[min.length - 1];
	}

	private ArrayList<ArrayList<Integer>> getList(int m, int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		if (m == 0 && n == 0)
			return null;

		if (m == 0) {
			for (int i = 0; i < n; i++) {
				al.add(0);
			}
			ret.add(al);
			return ret;
		}
		if (n == 0) {
			for (int i = 0; i < m; i++) {
				al.add(1);
			}
			ret.add(al);
			return ret;
		}

		ArrayList<ArrayList<Integer>> right = getList(m, n - 1);
		ArrayList<ArrayList<Integer>> down = getList(m - 1, n);

		if (right != null) {
			for (int i = 0; i < right.size(); i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(0);
				tmp.addAll(right.get(i));
				ret.add(tmp);
			}
		}

		if (down != null) {
			for (int i = 0; i < down.size(); i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(1);
				tmp.addAll(down.get(i));
				ret.add(tmp);
			}
		}

		return ret;
	}
}
