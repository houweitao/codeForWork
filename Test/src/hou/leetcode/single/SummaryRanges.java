package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao 2015年7月31日 下午4:17:05
 *         https://leetcode.com/problems/summary-ranges/
 */

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges sr = new SummaryRanges();

		int nums[] = { 1, 2, 3, 5, 7, 8, 9, 11 };
//		int nums[] = {};
		sr.summaryRanges(nums);
	}

	public List<String> summaryRanges(int[] nums) {
		if (nums == null || nums.length==0)
			return null;
		else if(nums.length==1){
			List<String> out = new ArrayList<String>();
			out.add(String.valueOf(nums[nums.length - 1]));
			return out;
		}
		else {
			List<String> out = new ArrayList<String>();
			int left = 0, right = 0;
			String add = null;
			while (right < nums.length - 1) {
				right++;

				if (nums[right] - nums[right - 1] != 1) {
					if (right != nums.length - 2) {
						if (left != right - 1)
							add = nums[left] + "->" + nums[right - 1];
						else
							add = String.valueOf(nums[left]);
					}
					// else {
					// if (nums[right + 1] - nums[right] == 1) {
					// add = nums[left] + "->" + nums[right];
					// } else {
					// add = nums[left] + "->" + nums[right - 1];
					// out.add(add);
					// add = String.valueOf(nums[nums.length - 1]);
					// }
					// }

					out.add(add);

					left = right;
				}

			}
			if (left != nums.length - 1)
				add = nums[left] + "->" + nums[nums.length - 1];
			else
				add = String.valueOf(nums[nums.length - 1]);
			out.add(add);
			for (String s : out) {
				System.out.println(s);
			}

			return out;
		}
	}
}
