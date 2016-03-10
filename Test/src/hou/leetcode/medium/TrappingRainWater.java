package hou.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月4日 下午4:53:34
 * @bad 2016年3月4日17:22:15
 * @succeed 2016年3月4日17:32:47 还不够满意。继续..
 * https://leetcode.com/submissions/detail/55310408/
 */

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		TrappingRainWater rain = new TrappingRainWater();

		List<Integer> help = rain.findPeek(nums);
		System.out.println(help);

		System.out.println(rain.waterNum(nums, help));
		System.out.println(rain.trap(nums));
	}

	public int trap(int[] height) {
		List<Integer> help = findPeek(height);
		return waterNum(height, help);
	}

	int waterNum(int[] nums, List<Integer> help) {
		int sum = 0;

		int[] newNums = new int[nums.length + 1];
		for (int i = 1; i < nums.length + 1; i++) {
			newNums[i] = nums[i - 1];
		}

		for (int i = 0; i < help.size() - 1; i++) {
			sum = sum + count(newNums, help.get(i), help.get(i + 1));
		}
		return sum;
	}

	List<Integer> findPeek(int[] nums) {
		List<Integer> ret = new LinkedList<>();
		int[] newNums = new int[nums.length + 1];
		for (int i = 1; i < nums.length + 1; i++) {
			newNums[i] = nums[i - 1];
		}

		int stand = 0;
		for (int i = 0; i < newNums.length; i++) {
			if (newNums[i] >= stand) {
				ret.add(i);
				stand = newNums[i];
			}

		}

		int beginDown = ret.get(ret.size() - 1);
		int size = ret.size();
		stand = 0;

		for (int i = newNums.length - 1; i > beginDown; i--) {
			if (newNums[i] >= stand) {
				ret.add(size, i);
				stand = newNums[i];
			}
		}

		return ret;
	}

	int count(int[] nums, int begin, int end) {
		if (begin + 1 == end)
			return 0;
		else {
			int sum = 0;
			int height = Math.min(nums[begin], nums[end]);

			for (int i = begin + 1; i < end; i++) {
				sum = sum + height - nums[i];
			}
			return sum;
		}
	}

}
