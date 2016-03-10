//package hou.mianjing.me;
//
//import java.util.ArrayList;
//
///**
// * @author houweitao
// * @date 2015年12月7日 下午6:41:21
// * http://www.1point3acres.com/bbs/thread-155907-1-1.html
// */
//
//public class MinDistanceToGym {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}
//
//	Dot find(char[][] map) {
//		ArrayList<Dot> al = new ArrayList<>();
//
//		char[][][] help = new char[al.size()][map.length][map[0].length];
//
//		for (int i = 0; i < al.size(); i++) {
//			help[i] = map.clone();
//			dealMap(help[i], al.get(i));
//		}
//		return null;
//	}
//
//	private void dealMap(char[][] cs, Dot dot) {
//		int chang = cs.length;
//		int kuan = cs[0].length;
//
//		int x = dot.x;
//		int y = dot.y;
//
//		// 上
//		if (x - 1 >= 0) {
//			if (cs[x - 1][y] != '#' && cs[x - 1][y] != '@') {
//				cs[x - 1][y] = 1;
//			}
//			dealDot(cs, x - 1, y);
//		}
//		// 下
//		if (x + 1 <= chang) {
//			if (cs[x + 1][y] != '#' && cs[x - 1][y] != '@') {
//				cs[x + 1][y] = 1;
//			}
//			dealDot(cs, x + 1, y);
//		}
//		// 左
//		if (y - 1 >= 0) {
//			if (cs[x][y - 1] != '#' && cs[x - 1][y] != '@') {
//				cs[x][y - 1] = 1;
//			}
//			dealDot(cs, x, y - 1);
//		}
//		// 右
//		if (y + 1 <= kuan) {
//			if (cs[x][y + 1] != '#' && cs[x - 1][y] != '@') {
//				cs[x][y + 1] = 1;
//			}
//			dealDot(cs, x, y + 1);
//		}
//
//	}
//
//	private void dealDot(char[][] cs, int x, int y) {
//		// TODO Auto-generated method stub
//		int chang = cs.length;
//		int kuan = cs[0].length;
//		if (x - 1 >= 0) {
//			if (cs[x - 1][y] != '#' && cs[x - 1][y] != '@') {
//				
//				if(cs[x - 1][y] )
//			}
//			dealDot(cs, x - 1, y);
//		}
//		// 下
//		if (x + 1 <= chang) {
//			if (cs[x + 1][y] != '#' && cs[x - 1][y] != '@') {
//				cs[x + 1][y] = 1;
//			}
//			dealDot(cs, x + 1, y);
//		}
//		// 左
//		if (y - 1 >= 0) {
//			if (cs[x][y - 1] != '#' && cs[x - 1][y] != '@') {
//				cs[x][y - 1] = 1;
//			}
//			dealDot(cs, x, y - 1);
//		}
//		// 右
//		if (y + 1 <= kuan) {
//			if (cs[x][y + 1] != '#' && cs[x - 1][y] != '@') {
//				cs[x][y + 1] = 1;
//			}
//			dealDot(cs, x, y + 1);
//		}
//	}
//
//}
//
//class Dot {
//	int x;
//	int y;
//	int val;
//}