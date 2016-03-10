package hou.mianjing.me;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2015年12月9日 下午3:26:02
 * @end 2015年12月9日16:49:07
 * finally！！
 * http://www.1point3acres.com/bbs/thread-155907-1-1.html
 */

public class MinDistanceToGym2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinDistanceToGym2 mg = new MinDistanceToGym2();

		int[][] map = new int[10][10];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				map[i][j] = Integer.MAX_VALUE;

		map[5][5] = 0;
		map[1][1] = 0;
		map[8][1] = 0;
		map[5][4] = -1;
//		mg.printMap(map);
//		mg.updateMap(map, 5, 5);
//		mg.printMap(map);

		mg.dealGymPoint(map, 5, 5);
		mg.printMap(map);

		// #:空位置; @:墙壁； *：健身器材
		char[][] gym = { { '#', '#', '*', '#', '#', '#', '#', '#', '#', '*' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', '@', '@', '@', '#', '#', '#', '#', '#', '#' },
				{ '#', '#', '#', '@', '#', '#', '#', '*', '#', '#' },
				{ '#', '#', '#', '#', '#', '#', '@', '#', '#', '#' },
				{ '#', '#', '#', '#', '#', '#', '@', '#', '#', '#' },
				{ '#', '#', '@', '@', '#', '@', '@', '#', '*', '#' },
				{ '*', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '*' }, };

		Dot bestPlace = mg.getBestPos(gym);
		System.out.println(bestPlace.x + "," + bestPlace.y + " : " + bestPlace.val);

	}

	Dot getBestPos(char[][] gym) {
		ArrayList<Dot> equipment = new ArrayList<>();
		ArrayList<Dot> wall = new ArrayList<>();
		int[][] map = new int[gym.length][gym[0].length];

		getEquipPosition(gym, equipment, wall);
		for (int i = 0; i < equipment.size(); i++) {
			map[equipment.get(i).x][equipment.get(i).y] = -2;
		}
		for (int i = 0; i < wall.size(); i++) {
			map[wall.get(i).x][wall.get(i).y] = -1;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				if (map[i][j] == 0)
					map[i][j] = Integer.MAX_VALUE;
				else if (map[i][j] == -2)
					map[i][j] = 0;
		}

		printMap(map);

		int[][][] allMap = new int[equipment.size()][gym.length][gym[0].length];

		for (int i = 0; i < allMap.length; i++) {
//			allMap[i] = map.clone(); 克隆不靠谱啊！！
			for (int k = 0; k < map.length; k++)
				for (int j = 0; j < map[0].length; j++)
					allMap[i][k][j] = map[k][j];
			
			dealGymPoint(allMap[i], equipment.get(i).x, equipment.get(i).y);
		}

		int[][] result = map.clone();

		int minPlace = Integer.MAX_VALUE;
		Dot dotReturn = new Dot(-1, -1, -1);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (result[i][j] > 0) {
					result[i][j] = 0;
					for (int k = 0; k < allMap.length; k++) {
						result[i][j] = result[i][j] + allMap[k][i][j];
					}
					if (minPlace > result[i][j]) {
						minPlace = result[i][j];
						dotReturn = new Dot(i, j, result[i][j]);
					}
				}
			}
		}

		return dotReturn;
	}

	void getEquipPosition(char[][] gym, ArrayList<Dot> g, ArrayList<Dot> wall) {
		for (int i = 0; i < gym.length; i++) {
			for (int j = 0; j < gym[0].length; j++) {
				if (gym[i][j] == '@')
					wall.add(new Dot(i, j, -1));
				else if (gym[i][j] == '*')
					g.add(new Dot(i, j, 0));
			}
		}

	}

	void dealGymPoint(int[][] map, int i, int j) {
		System.out.println(i + "," + j);

		Queue<Dot> queue = new LinkedList<Dot>();
		queue.offer(new Dot(i, j, 0));
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			updateMapByQueue(map, dot.x, dot.y, queue);
		}

//		updateMap(map, i, j);
		printMap(map);
	}

	//用队列实现。广度优先
	void updateMapByQueue(int[][] map, int i, int j, Queue<Dot> queue) {
		if (inMap(map, i, j)) {
			if (inMap(map, i + 1, j) && map[i + 1][j] > map[i][j] + 1) {
				map[i + 1][j] = map[i][j] + 1;
				queue.offer(new Dot(i + 1, j, map[i + 1][j]));
			}
			if (inMap(map, i, j - 1) && map[i][j - 1] > map[i][j] + 1) {
				map[i][j - 1] = map[i][j] + 1;
				queue.offer(new Dot(i, j - 1, map[i][j - 1]));
			}
			if (inMap(map, i - 1, j) && map[i - 1][j] > map[i][j] + 1) {
				map[i - 1][j] = map[i][j] + 1;
				queue.offer(new Dot(i - 1, j, map[i - 1][j]));
			}
			if (inMap(map, i, j + 1) && map[i][j + 1] > map[i][j] + 1) {
				map[i][j + 1] = map[i][j] + 1;
				queue.offer(new Dot(i, j + 1, map[i][j + 1]));
			}
		}
	}

	//深度优先
	void updateMap(int[][] map, int i, int j) {
		if (inMap(map, i, j)) {
			if (inMap(map, i + 1, j) && map[i + 1][j] > map[i][j] + 1) {
				map[i + 1][j] = map[i][j] + 1;
				updateMap(map, i + 1, j);
			}
			if (inMap(map, i, j - 1) && map[i][j - 1] > map[i][j] + 1) {
				map[i][j - 1] = map[i][j] + 1;
				updateMap(map, i, j - 1);
			}
			if (inMap(map, i - 1, j) && map[i - 1][j] > map[i][j] + 1) {
				map[i - 1][j] = map[i][j] + 1;
				updateMap(map, i - 1, j);
			}
			if (inMap(map, i, j + 1) && map[i][j + 1] > map[i][j] + 1) {
				map[i][j + 1] = map[i][j] + 1;
				updateMap(map, i, j + 1);
			}
		}
	}

	//判断给出的点是否在图中。是否越界
	private boolean inMap(int[][] map, int i, int j) {
		// TODO Auto-generated method stub

		if (i >= 0 && i < map.length && j >= 0 && j < map[0].length)
			return true;
		else
			return false;
	}

	void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}

class Dot {
	int x;
	int y;
	int val;

	public Dot(int x, int y, int val) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.val = val;
	}

}