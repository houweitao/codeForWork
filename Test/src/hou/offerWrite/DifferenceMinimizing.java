package hou.offerWrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月10日 上午10:18:05
 * @badSolution 2016年3月10日10:45:19
 */

public class DifferenceMinimizing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 3, 5, 3, 4, 6, 2 };
		DifferenceMinimizing dm = new DifferenceMinimizing();
		System.out.println(dm.split2(nums));
	}

	List<Integer> split2(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		Arrays.sort(nums);

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		double tar = sum / 2;
		System.out.println(tar);

		int begin = 0, end = nums.length - 1;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		if (nums[begin] >= tar) {
			ret.add(nums[begin]);
			return ret;
		}

		double count = nums[begin] + nums[end];

		while (count > tar) {
			end--;
			if (end == begin)
				count = nums[begin];
			else
				count = nums[begin] + nums[end];
		}

		left.add(nums[begin]);
		right.add(nums[end]);

		double min = Integer.MAX_VALUE;

		while (begin <= end) {
			while (end >= begin && count <= tar) {
				end--;
				count = count + nums[end];
				right.add(nums[end]);

				if (tar - count < min) {
					min = tar - count;
					ret.clear();
					for (int i : left)
						ret.add(i);
					for (int i : right)
						ret.add(i);
				}
			}

			
			count = count - right.get(right.size() - 1);
			right.remove(right.size() - 1);

			while (end >= begin && count <= tar) {
				begin++;
				count = count + nums[begin];
				left.add(nums[begin]);

				if (tar - count < min) {
					min = tar - count;
					ret.clear();
					for (int i : left)
						ret.add(i);
					for (int i : right)
						ret.add(i);
				}
			}

		}

		return ret;
	}

	List<List<Integer>> split(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> ret = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		double tar = sum / 2;
		System.out.println(tar);
		List<List<Integer>> next = help(nums, 0, tar);

		ret.addAll(next);
		return ret;
	}

	private List<List<Integer>> help(int[] nums, int pos, double tar) {
		List<List<Integer>> ret = new ArrayList<>();

		if (pos == nums.length) {
			return ret;
		}

		List<List<Integer>> yes = new ArrayList<>();
		List<List<Integer>> no = new ArrayList<>();

		if (tar > 0) {
			yes = help(nums, pos + 1, tar - nums[pos]);
			if (yes.size() > 0) {
				for (int i = 0; i < yes.size(); i++) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[pos]);
					list.addAll(yes.get(i));
					ret.add(list);
				}
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(nums[pos]);
				ret.add(list);
			}
			no = help(nums, pos + 1, tar);
			ret.addAll(no);
		}

		return ret;
	}

}
