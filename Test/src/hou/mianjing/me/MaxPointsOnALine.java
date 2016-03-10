package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年11月5日 上午10:24:30
 */

public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = { new Point(4, 2), new Point(2, 6), new Point(0, 0), new Point(1, 3),new Point(3,9),new Point(4,11) };

		MaxPointsOnALine mpol = new MaxPointsOnALine();
		mpol.maxPoints(points);

//		mpol.isLine(3, 2, points);
	}

	public int maxPoints(Point[] points) {
		// Write your code here
		int num = 0;

		for (int i = 0; i < points.length; i++) {
			for (int j = i+1; j < points.length; j++) {
				if (i != j) {
					int tmp = isLine(i, j, points);
					if (num < tmp)
						num = tmp;
				}
			}
		}
		System.out.println(num);
		return num;

	}

	private int isLine(int m, int n, Point[] points) {
		// TODO Auto-generated method stub
		int number = 2;
		for (int i = 0; i < points.length; i++) {
			if (i != m && i != n)
				if ((double)(points[i].y - points[m].y) / (double)(points[i].x - points[m].x) == (double)(points[i].y - points[n].y)
						/ (double)(points[i].x - points[n].x))
					number++;
		}

		System.out.println("m:" + m + " n: " + n + " number: " + number);
		return number;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
