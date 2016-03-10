//package hou.leetcode.hard;
//
///**
// * @author houweitao
// * @date 2015年12月24日 下午1:45:40
// * https://leetcode.com/problems/trapping-rain-water/
// */
//
//public class TrappingRainWater {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public int trap(int[] height) {
//		for (int left = 0; left < height.length - 2; left++) {
//			if (height[left + 1] < height[left])
//				for (int right = left + 1; right < height.length; right++) {
//					if (right >= left) {
//
//						break;
//					}
//				}
//		}
//	}
//}
