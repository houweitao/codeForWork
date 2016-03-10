//package hou.leetcode.single;
//
///**
// * @author houweitao
// * @date 2015年12月15日 下午2:35:19
// * https://leetcode.com/problems/rectangle-area/
// */
//
//public class RectangleArea {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
//		if (D <= F || B >= H || C <= E || A >= G)
//			return 0;
//		else {
//			int kuan = 0;
//			int chang = 0;
//
//			if (B > F && D < H) {
//				chang = C - E;
//				kuan = H - B;
//			}else if(B>F&&D<F)
//
//			return (C - A) * (D - B) + (G - E) * (H - F) - kuan * chang;
//		}
//	}
//}
