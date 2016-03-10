package hou.mianjing.me;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年1月20日 下午5:13:57
 * @end 2016年1月20日17:25:43
 * 充分利用条件：有序数组
 * http://www.1point3acres.com/bbs/thread-165630-1-1.html
 * 给一个有序数组， 按顺序输出数组的平方
 */

public class ArraysPingFang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -10, -9, -4, -2, -1, 3, 5, 6, 8, 9 };
		ArraysPingFang test = new ArraysPingFang();
		test.reverse(nums);
	}

	void reverse(int[] nums) {
		int start = 0, end = nums.length - 1;

		Stack<Integer> stack = new Stack<>();

		while (start < end) {
			if (Math.abs(nums[start]) > Math.abs(nums[end])) {
				stack.push(nums[start]);
				start++;
			} else {
				stack.push(nums[end]);
				end--;
			}
		}
		stack.push(nums[start]);

		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + ",");
		}
	}
}
