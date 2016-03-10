package hou.leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年2月23日 下午4:04:13
 * @source https://leetcode.com/problems/increasing-triplet-subsequence/
 * @ps 虽然一点都不beautiful，但好歹是成功了..
 * @end 2016年2月23日16:52:17
 * @pps 算法的力量：https://leetcode.com/discuss/86891/concise-java-solution-with-comments
 */

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 10, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 };
		IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
		System.out.println(its.increasingTripletRight(nums));
		System.out.println(its.increasingTripletOther(nums));
	}

	//naive
	public boolean increasingTriplet(int[] nums) {
		int count = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] > nums[i]) {
				count++;
				if (count == 3)
					return true;
			} else
				count = 1;
		}
		return false;
	}

	// 思想：因为总共只有3个元素，所以如果当前只是一个元素的时候，碰到比他小的，就用小的去替换他。
	//如果当前有2个元素，如果当前的是介于2个元素之间，那么用当前去替换stack中的第二个元素；
	//如果当前元素比stack的第一个元素都要小，那么用backup来记录当前的元素值。
	//之后如果再遇到比stack的第一个元素还要小的元素，就来和backup的元素值进行比较。
	//写到这里backup好像没有必要用stack啊！如果当前比backup的元素大，ok，这2个元素替换stack，backup清空，
	//如果比backup元素要小，替换backup，否则不进行活动。
	//已经把backup改为一个int
	public boolean increasingTripletRight(int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		int backup = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (stack.isEmpty())
				stack.push(nums[i]);
			else {
				if (nums[i] > stack.peek()) {
					stack.push(nums[i]);
					if (stack.size() == 3) {
						System.out.println(stack);
						return true;
					}
				} else {
					if (stack.size() == 1) {
						if (nums[i] < stack.peek()) {
							stack.pop();
							stack.push(nums[i]);
						}
					} else if (stack.size() == 2) {
						if (nums[i] > stack.get(0) && nums[i] < stack.peek()) {
							stack.pop();
							stack.push(nums[i]);
						} else if (nums[i] < stack.get(0)) {
							if (backup == Integer.MIN_VALUE)
								backup = nums[i];
							else if (nums[i] > backup) {
								stack.clear();
								stack.push(backup);
								stack.push(nums[i]);
								backup = Integer.MIN_VALUE;
							} else if (nums[i] < backup) {
								backup = nums[i];
							}
						}
					}
				}
			}

			System.out.println(i + " : " + stack);
		}
		return false;
	}

	//https://leetcode.com/discuss/86891/concise-java-solution-with-comments
	//思想的光辉
	public boolean increasingTripletOther(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else {
				System.out.println(small + "," + big + "," + n);
				return true; // return if you find a number bigger than both
			}System.out.println(small + "," + big + "," + n);
		}
		return false;
	}
}
