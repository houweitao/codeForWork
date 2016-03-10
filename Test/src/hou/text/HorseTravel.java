package hou.text;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年11月29日 上午1:43:25
 */

public class HorseTravel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = new int[8][8];

//		travel(map, 0, 0, 1);
		HorseTravel ht = new HorseTravel();
		ht.travelStack(map, 0, 0);
	}

	void travelStack(int[][] map, int beginI, int beginJ) {
		Stack<java.awt.Point> stack = new Stack<point>();
		stack.add(new Point(beginI, beginJ));
		int chang = 8;
		int kuan = 8;

		while (!stack.isEmpty()) {
			Point point = stack.peek();
			int nextDir = point.direction;
			boolean find = false;
			while (nextDir <= 8 && !find) {
				point.direction++;
				nextDir = point.direction;
				switch (nextDit) {
				case 1:
					if (map[beginI][beginJ] == 0 && beginI + 1 < chang && beginJ + 2 < kuan) {
						map[point.x][point.y] = nextDir;
						stack.push(new Point(beginI + 1, beginJ + 2));
						find = true;
						if (stack.size() == 64)
							System.out.println("find!!!");
					}
					break;
				case 2:
					if (map[beginI][beginJ] == 2)
						if (map[beginI][beginJ] == 0 && beginI + 2 < chang && beginJ + 1 < kuan) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI + 2, beginJ + 1));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 3:

					if (map[beginI][beginJ] == 3)
						if (map[beginI][beginJ] == 0 && beginI + 2 < chang && beginJ - 1 >= 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI + 2, beginJ - 1));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 4:
					if (map[beginI][beginJ] == 4)
						if (map[beginI][beginJ] == 0 && beginI + 1 < chang && beginJ - 2 >= 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI + 1, beginJ - 2));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 5:
					if (map[beginI][beginJ] == 5)
						if (map[beginI][beginJ] == 0 && beginI - 1 >= 0 && beginJ - 2 >= 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI - 1, beginJ - 2));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 6:
					if (map[beginI][beginJ] == 6)
						if (map[beginI][beginJ] == 0 && beginI - 2 >= 0 && beginJ - 1 >= 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI - 2, beginJ - 1));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 7:
					if (map[beginI][beginJ] == 7)
						if (map[beginI][beginJ] == 0 && beginI - 2 >= 0 && beginJ + 1 < kuan) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI - 2, beginJ + 1));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				case 8:
					if (map[beginI][beginJ] == 1)
						if (map[beginI][beginJ] == 0 && beginI - 1 >= 0 && beginJ + 2 < kuan) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(beginI - 1, beginJ + 2));
							find = true;
							if (stack.size() == 64)
								System.out.println("find!!!");
						}
					break;
				default:
					map[point.x][point.y] = 0;
					stack.pop();

				}
			}
		}

	}

//	static void travel(int[][] map, int beginI, int beginJ, int time) {
//		int chang = map.length;
//		int kuan = map[0].length;
//		int jumpNum = chang * kuan;
//		boolean endMap = false;
//		if (time == jumpNum)
//			System.out.println("yes");
//		else {
//			while (map[beginI][beginJ] < 8) {
//				map[beginI][beginJ]++;
//				if (map[beginI][beginJ] == 1)
//					if (map[beginI][beginJ] == 0 && beginI + 1 < chang && beginJ + 2 < kuan) {
//						travel(map, beginI + 1, beginJ + 2, time++);
//					}
//
//				if (map[beginI][beginJ] == 2)
//					if (map[beginI][beginJ] == 0 && beginI + 2 < chang && beginJ + 1 < kuan) {
//						travel(map, beginI + 2, beginJ + 1, time++);
//					}
//
//				if (map[beginI][beginJ] == 3)
//					if (map[beginI][beginJ] == 0 && beginI + 2 < chang && beginJ - 1 >= 0) {
//						travel(map, beginI + 2, beginJ - 1, time++);
//					}
//				if (map[beginI][beginJ] == 4)
//					if (map[beginI][beginJ] == 0 && beginI + 1 < chang && beginJ - 2 >= 0) {
//						travel(map, beginI + 1, beginJ - 2, time++);
//					}
//				if (map[beginI][beginJ] == 5)
//					if (map[beginI][beginJ] == 0 && beginI - 1 >= 0 && beginJ - 2 >= 0) {
//						travel(map, beginI - 1, beginJ - 2, time++);
//					}
//				if (map[beginI][beginJ] == 6)
//					if (map[beginI][beginJ] == 0 && beginI - 2 >= 0 && beginJ - 1 >= 0) {
//						travel(map, beginI - 2, beginJ - 1, time++);
//					}
//				if (map[beginI][beginJ] == 7)
//					if (map[beginI][beginJ] == 0 && beginI - 2 >= 0 && beginJ + 1 < kuan) {
//						travel(map, beginI - 2, beginJ + 1, time++);
//					}
//				if (map[beginI][beginJ] == 1)
//					if (map[beginI][beginJ] == 0 && beginI - 1 >= 0 && beginJ + 2 < kuan) {
//						travel(map, beginI - 1, beginJ + 2, time++);
//					}
//			}
//			System.out.println("no solution");
//		}
//	}
}

class Point {
	int x;
	int y;
	int direction;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.direction = 0;
	}
}
