package hou.mianjing.me;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年1月10日 下午3:13:40
 * @end 2016年1月10日15:47:36
 * http://www.1point3acres.com/bbs/thread-164981-1-1.html
 */

public class LongestPathInMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPathInMap lp = new LongestPathInMap();
//		int[][] map = lp.makeMap(5, 5);

		int[][] map = { { 8, 10, 11, 6, 0 }, { 8, 9, 9, 8, 0 }, { 2, 10, 11, 1, 8 }, { 3, 7, 14, 4, 0 },
				{ 4, 9, 18, 4, 4 } };
		int[][] record = new int[map.length][map[0].length];
		lp.printMap(map);
//		lp.printList(lp.longestPath(map,record,0, 0, -1));
		lp.printList(lp.getLong(map, record));
		lp.printMap(record);

	}

	List<Integer> getLong(int[][] map,int[][] record) {
		List<Integer> ret = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (record[i][j] == 0) {
					List<Integer> may = longestPath(map,record, i, j, -1);
					if (may.size() > ret.size())
						ret = may;
				}
				
				printMap(record);//显示出了轨迹..2016年1月10日16:17:40
			}
		}
		return ret;
	}

	List<Integer> longestPath(int[][] map, int[][] record, int m, int n, int last) {
		List<Integer> ret = new LinkedList<>();
		if (!inMap(map, m, n) || map[m][n] <= last)
			return ret;
		else {
			ret.add(map[m][n]);
			record[m][n]=1;
//			map[m][n] = -1;

			List<Integer> up = longestPath(map, record,m - 1, n, map[m][n]);
			List<Integer> right = longestPath(map,record, m, n + 1, map[m][n]);
			List<Integer> down = longestPath(map,record,m + 1, n, map[m][n]);
			List<Integer> left = longestPath(map,record, m, n - 1, map[m][n]);

			int maxLen = 0;
			List<Integer> next = new LinkedList<>();

			if (up.size() > maxLen) {
				next = up;
				maxLen = up.size();
			}
			if (right.size() > maxLen) {
				next = right;
				maxLen = right.size();
			}
			if (down.size() > maxLen) {
				next = down;
				maxLen = down.size();
			}
			if (left.size() > maxLen) {
				next = left;
				maxLen = left.size();
			}

			if (next.size() != 0)
				ret.addAll(next);

			return ret;
		}

	}

	boolean inMap(int[][] map, int m, int n) {
		if (m > -1 && m < map.length && n > -1 && n < map[0].length)
			return true;
		else
			return false;
	}

	int[][] makeMap(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = (int) (Math.random() * 10);
			}
		}

		return map;
	}

	void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	void printList(List<Integer> list) {
		System.out.println(list);
	}
}
