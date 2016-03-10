package hou.leetcode.hard;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2016年2月24日 上午9:58:22
 * @source https://leetcode.com/problems/longest-consecutive-sequence/
 * 好棒！
 * @good https://leetcode.com/discuss/18886/my-really-simple-java-o-n-solution-accepted
 * 		 https://leetcode.com/discuss/38619/simple-o-n-with-explanation-just-walk-each-streak
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestConsecutive(int[] nums) {
		int max = 0;
		HashMap<Integer, Integer> record = new HashMap<>();

		for (int n : nums) {
			if (!record.containsKey(n)) {
				int left = record.containsKey(n - 1) ? record.get(n - 1) : 0;
				int right = record.containsKey(n + 1) ? record.get(n - 1) : 0;

				int sum = left + 1 + right;
				max = Math.max(max, sum);

				record.put(n - left, sum);
				record.put(n + right, sum);
			}
		}

		return max;
	}
}
