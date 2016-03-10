package hou.text;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年11月29日 下午12:00:52
 */

public class HorseTravel2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = new int[6][6];

		long start =System.currentTimeMillis();
		HorseTravel2 ht = new HorseTravel2();
		ht.travelStack(map, 0, 0);
		long end=System.currentTimeMillis();
		System.out.println((end-start)/1000+" 秒");
	}

	void travelStack(int[][] map, int beginI, int beginJ) {
		int count = 1;
		Stack<Point> stack = new Stack<Point>();
		stack.add(new Point(beginI, beginJ));
		int chang = map.length;
		int kuan = map[0].length;

		while (!stack.isEmpty()) {
//			System.out.println("size:" + stack.size());
//			print(stack);
//			print(map);
			Point point = stack.peek();
			int nextDir = 0;
			boolean find = false;
			while (nextDir <= 8 && !find) {
				map[point.x][point.y]++;
				nextDir = map[point.x][point.y];
				switch (nextDir) {
				case 1:
					if (point.x + 1 < chang && point.y + 2 < kuan) {
						if (map[point.x + 1][point.y + 2] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x + 1, point.y + 2));
							find = true;
						}
					}
					break;
				case 2:
					if (point.x + 2 < chang && point.y + 1 < kuan)
						if (map[point.x + 2][point.y + 1] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x + 2, point.y + 1));
							find = true;
						}
					break;
				case 3:
					if (point.x + 2 < chang && point.y - 1 >= 0)
						if (map[point.x + 2][point.y - 1] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x + 2, point.y - 1));
							find = true;
						}
					break;
				case 4:
					if (point.x + 1 < chang && point.y - 2 >= 0)
						if (map[point.x + 1][point.y - 2] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x + 1, point.y - 2));
							find = true;
						}
					break;
				case 5:
					if (point.x - 1 >= 0 && point.y - 2 >= 0)
						if (map[point.x - 1][point.y - 2] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x - 1, point.y - 2));
							find = true;
						}
					break;
				case 6:
					if (beginI - 2 >= 0 && point.y - 1 >= 0)
						if (map[point.x - 2][point.y - 1] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x - 2, point.y - 1));
							find = true;
//							}
						}
					break;
				case 7:
					if (point.x - 2 >= 0 && point.y + 1 < kuan)
						if (map[point.x - 2][point.y + 1] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x - 2, point.y + 1));
							find = true;
//							}
						}
					break;
				case 8:
					if (point.x - 1 >= 0 && point.y + 2 < kuan)
						if (map[point.x - 1][point.y + 2] == 0) {
							map[point.x][point.y] = nextDir;
							stack.push(new Point(point.x - 1, point.y + 2));
							find = true;
//							}
						}
					break;
				case 9:
					if (stack.size() == chang * kuan) {
						System.out.println(count++);
						print(stack);
						print(map);
					} else {
//						System.out.println("走投无路！");
//						print(map);
					}
					map[point.x][point.y] = 0;
					stack.pop();
				}
			}

//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	private void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	private void print(Stack<Point> stack) {
		// TODO Auto-generated method stub
		for (int i = 0; i < stack.size(); i++)
			System.out.print("(" + stack.get(i).x + "," + stack.get(i).y + ")" + "->");
		System.out.println();
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

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}