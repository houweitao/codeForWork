package hou.mianjing.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import hou.mianjing.me.IslandNumber.dui;

/**
 * @author houweitao
 * begin:2015年9月9日 上午10:24:32
 * end:2015年9月9日11:26:13
 */

public class IslandNumber {

	static int count = 0;
	static int landArea = 0;
	Stack<dui> s = new Stack<dui>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] map = { { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, };

//		for(int i=0;i<10;i++)
//			for(int j=0;j<10;j++)
//				map[i][j]=1;

//		Stack<dui> s = new Stack<dui>();

		IslandNumber in = new IslandNumber();
		in.countIsland(map);
		System.out.println("isLand number: " + count + "  land's area:" + landArea);
	}

	void countIsland(int[][] map) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (map[i][j] != 0) {
					count++;
					dealMap(map, i, j, s);
				}
			}
	}
//	这样子不用那个栈也可以
	void dealMap(int[][] map, int i, int j) {
		dui d = new dui(i, j);
		System.out.println(d.i + " " + d.j);
		map[i][j] = 0;
		if (i + 1 < 10)
			if (map[i + 1][j] != 0)
				dealMap(map, i + 1, j, s);
		if (j + 1 < 10)
			if (map[i][j + 1] != 0)
				dealMap(map, i, j + 1, s);
		if (i - 1 >= 0 && j >= 0)
			if (map[i - 1][j] != 0)
				dealMap(map, i - 1, j, s);
		if (j - 1 >= 0)
			if (map[i][j - 1] != 0)
				dealMap(map, i, j - 1, s);
		landArea++;
	}

	void dealMap(int[][] map, int i, int j, Stack<dui> s) {
//		Stack<dui> s = new Stack();
		dui d = new dui(i, j);
		System.out.println(d.i + " " + d.j);
//		System.out.println(d.j);

//		s.add(d);
		s.push(d);

		map[i][j] = 0;
		if (i + 1 < 10)
			if (map[i + 1][j] != 0)
				dealMap(map, i + 1, j, s);
		if (j + 1 < 10)
			if (map[i][j + 1] != 0)
				dealMap(map, i, j + 1, s);
		if (i - 1 >= 0 && j >= 0)
			if (map[i - 1][j] != 0)
				dealMap(map, i - 1, j, s);
		if (j - 1 >= 0)
			if (map[i][j - 1] != 0)
				dealMap(map, i, j - 1, s);

		s.pop();
		landArea++;

//		map[i][j]=0;

		if (s.size() == 0)
			s.clear();
	}

	class dui {
		int i;
		int j;

		dui(int m, int n) {
			this.i = m;
			this.j = n;
		}
	}
}
