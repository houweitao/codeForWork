//package hou.leetcode.hard;
//
//import java.util.HashMap;
//
///**
// * @author houweitao
// * @date 2015年11月24日 上午10:37:45
// * https://leetcode.com/problems/candy/
// * 每一个最高点都是一个分水岭。从前到后从后到前扫描2遍。可以一战...
// */
//
//public class Candy {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public int candy(int[] ratings) {
//		int[] give = new int[ratings.length];
//		give[0] = 1;
//		if (ratings[1] > ratings[0])
//			give[1] = give[0] + 1;
//
//		int finishPlace = 0;
//		for (int i = 1; i < ratings.length; i++) {
//			if (ratings[i] > ratings[i - 1])
//				give[i] = give[i - 1]++;
//			else if (ratings[i] < ratings[i - 1]) {
//				finishPlace = i;
////				for (int j = 0; j < i; j++)
////					give[j]++;
//				give[i] = 1;
//			} else
//				give[i] = 1;
//		}
//	}
//}
