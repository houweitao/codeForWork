package hou.offerWrite;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月2日 上午11:35:40
 * @end 2016年3月2日11:48:01
 */

public class MaxK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 4, 666, 2, 0, 45, 16, 7, 8, 9, 3, 2, 4, 55 };
		MaxK mk = new MaxK();
		System.out.println(mk.getMaxK(nums, 5));
	}

	List<Integer> getMaxK(int[] nums, int k) {
		return quickSort(nums, 0, nums.length - 1, k);
	}

	List<Integer> quickSort(int[] nums, int begin, int end, int k) {
		if (begin >= end)
			return null;
		else {
			List<Integer> ret = new LinkedList<>();
			int stand = nums[begin];
			int left = begin, right = end;
			while (begin < end) {
				while (begin < end && nums[end] >= stand) {
					end--;
				}
				nums[begin] = nums[end];

				while (begin < end && nums[begin] < stand) {
					begin++;
				}
				nums[end] = nums[begin];
			}
			nums[begin] = stand;

			if (right - begin == k) {
				for (int i = begin + 1; i <= right; i++)
					ret.add(nums[i]);
			} else if (right - begin + 1 == k) {
				for (int i = begin; i <= right; i++)
					ret.add(nums[i]);
			} else if (right - begin > k) {
				List<Integer> next = quickSort(nums, begin + 1, right, k);
				ret.addAll(next);
			} else {
				for (int i = begin; i <= right; i++)
					ret.add(nums[i]);
				List<Integer> next = quickSort(nums, left, begin, k - (right - begin + 1));
				ret.addAll(next);
			}
			return ret;
		}
	}
}
