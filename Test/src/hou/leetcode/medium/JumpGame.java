package hou.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2015年12月16日 下午3:02:56
 * https://leetcode.com/problems/jump-game/
 */

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4,
				2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4,
				9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7,
				9, 6 };
		JumpGame jumpGame = new JumpGame();
		boolean can = jumpGame.canJump(nums);
		System.out.println(can);
		System.out.println(jumpGame.canJumpBFS(nums));
		
		int[] test={0,1};
		System.out.println(jumpGame.canJumpBetter(test));
	}

	boolean judge(int[] nums) {

		return false;
	}

	//https://leetcode.com/discuss/22560/java-solution-easy-to-understand
	//amazing
	//2015年12月24日11:05:40
	boolean canJumpBetter(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(nums[i] + i, max);
		}
		return true;

//		int max = 0;
//		int pos = 0;
//		while (pos >= 0) {
//			max = Math.max(max, nums[pos]);
//			if (max >= nums.length - 1)
//				return true;
//		}
//		return false;
	}

	//广度 好慢..
	public boolean canJumpBFS(int[] nums) {
		if (nums.length == 1)
			return true;
		else {
			return helpJumpBFS(nums);
		}
	}

	//跟better solution 其实已经很接近了。只需多一个max变量记录当前最大的范围..
	private boolean helpJumpBFS(int[] nums) {
		// TODO Auto-generated method stub
		Queue<ArrayPoint> queue = new LinkedList<>();
		queue.offer(new ArrayPoint(0, nums[0]));

		while (!queue.isEmpty()) {
			ArrayPoint point = queue.poll();
			System.out.println(point.begin);
			for (int i = point.begin + 1; i <= point.begin + point.range; i++) {
				if (i >= nums.length)
					return true;
				if (nums[i] > 0 && !queue.contains(new ArrayPoint(i, nums[i])))
					queue.offer(new ArrayPoint(i, nums[i]));
			}
		}

		return false;
	}

	//深度
	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
		else {
			return helpJump(nums, 0);
		}
	}

	private boolean helpJump(int[] nums, int begin) {
		if (begin == nums.length - 1)
			return true;
		if (nums[begin] == 0)
			return false;
		else
			for (int i = begin + 1; i <= begin + nums[begin]; i++) {
				if (i < nums.length) {
					if (helpJump(nums, i))
						return true;
				}
			}

		return false;
	}
}

class ArrayPoint {
	int begin;
	int range;

	ArrayPoint(int begin, int range) {
		this.begin = begin;
		this.range = range;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bres = false;
		if (obj instanceof ArrayPoint) {
			ArrayPoint o = (ArrayPoint) obj;
			bres = (this.begin == o.begin);
		}
		return bres;
	}
}
