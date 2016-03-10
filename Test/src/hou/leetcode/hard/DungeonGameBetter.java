package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年11月17日 下午1:06:27
 * 这个好诡异啊！！！
 * almost finished..2015年11月17日15:11:21
 */

public class DungeonGameBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testCase = { { -61, -35, -50, -88, 8, -2, 27, -68, 23 }, { -82, -89, -13, 44, -27, 43, 5, -39, 24 },
				{ -65, -4, -75, -32, -58, -96, -5, -2, -98 }, { 3, -92, 27, -78, -92, -16, -93, -60, 10 },
				{ -28, 9, -60, 1, -70, -4, -94, -58, 8 }, { 41, -1, 12, -6, -4, -77, -21, 18, 8 },
				{ -13, -99, -15, -17, -57, 9, 18, 28, 18 }, { -72, 15, 35, 36, -34, -43, 6, -18, 41 },
				{ -72, -49, -18, 35, -48, -23, -71, 9, -1 }, { -49, 17, -97, -61, -25, -13, -59, -35, -72 } };

		int[][] dungeon = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
//			{ { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

//		System.out.println(Math.max(dungeon[0][0],dungeon[0][1]));
//		System.out.println(dungeon[0][0]);
//		System.out.println(dungeon[0][1]);

		DungeonGameBetter dgb = new DungeonGameBetter();
		dgb.calculateMinimumHP(dungeon);
	}

	public int calculateMinimumHP(int[][] dungeon) {
		//如果指向了一个引用！？
		int[][] map = dungeon;
//		int[][] help = dungeon;

		int[][] help = new int[map.length][map[0].length];

		for (int i = 0; i < help.length; i++) {
			for (int j = 0; j < help[0].length; j++)
				System.out.print(help[i][j] + ",");
			System.out.println();
		}

		int init = 1 - dungeon[0][0];

		map[0][0] = 1 - dungeon[0][0];
		help[0][0] = Math.max(1, init);

//		System.out.println(help[0][0]);

		//最左侧的值
		for (int i = 1; i < map.length; i++) {
			map[i][0] = map[i - 1][0] - map[i][0];
//			System.out.println(i+": "+map[i - 1][0]+" - "+map[i][0]+" = "+map[i][0]);
//			System.out.println("out" + map[2][0]);

			//不懂为啥这个语句改变了值。。因为引用！最上面
			help[i][0] = Math.max(help[i - 1][0], map[i][0]);
//			System.out.println("2,0: " + map[2][0]);
		}

//		System.out.println("2,0: " + map[2][0]);

		//最上侧的值
		for (int i = 1; i < map[0].length; i++) {
			map[0][i] = map[0][i - 1] - map[0][i];
			help[0][i] = Math.max(help[0][i - 1], map[0][i]);
		}

		//普通位置的值
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				if (help[i - 1][j] < help[i][j - 1]) {
					map[i][j] = map[i - 1][j] - map[i][j];
					help[i][j] = Math.max(help[i - 1][j], map[i][j]);
				} else {
					map[i][j] = map[i][j - 1] - map[i][j];
					help[i][j] = Math.max(help[i][j - 1], map[i][j]);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				System.out.print(map[i][j] + ",");
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < help.length; i++) {
			for (int j = 0; j < help[0].length; j++)
				System.out.print(help[i][j] + ",");
			System.out.println();
		}

		System.out.println(help[map.length - 1][map[0].length - 1]);
		return help[map.length - 1][map[0].length - 1];
	}
}
