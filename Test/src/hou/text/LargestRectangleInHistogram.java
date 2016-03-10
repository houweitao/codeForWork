package hou.text;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月3日 下午11:52:40
 */

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 2, 1, 7, 66, 2, 3 };
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		l.largestRectangleArea(height);
	}

	int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		System.out.println(maxArea);
		return maxArea;
	}
}
