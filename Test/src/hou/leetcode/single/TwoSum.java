package hou.leetcode.single;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao 2015年8月5日 下午3:50:10
 */

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 5, 2, 3, 11, 3, 7, 15 };

		TwoSum ts = new TwoSum();
//		int[] result = ts.twoSum(nums, 9);
//		System.out.println(result[0]);
//		System.out.println(result[1]);

		ts.twoSumMe(nums, 14);
	}

	// not good 2015年11月12日09:57:19
	void twoSumMe(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		for (; i < nums.length; i++)
			while (i < j) {
				if (nums[i] + nums[j] > target) {
					j--;
				}
				if (nums[i] + nums[j] == target) {
					System.out.println(nums[i] + "," + nums[j]);
					j--;
				} else {
					j = nums.length - 1;
//				i++;
					break;
				}
			}
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i + 1;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i + 1);
			System.out.println("add:" + i + " " + nums[i]);
		}
		return result;
	}
}
