package hou.leetcode.single;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2015年10月29日 下午2:32:21
 * https://leetcode.com/problems/contains-duplicate/
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 1, 2, 3, 4, 2, 2 };
//		nums={1,2,3,1};
		ContainsDuplicate cd = new ContainsDuplicate();
		System.out.println(cd.containsDuplicate(nums));

	}

	boolean containsDuplicate(int[] nums) {
		
//		my code
//		if (nums.length < 1)
//			return false;
//
//		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
//
//		for (int n : nums) {
//			if (!hs.containsKey(n))
//				hs.put(n, 1);
//			else {
//				hs.put(n, hs.get(n) + 1);
//			}
//		}
//		for (int i : hs.keySet()) {
//			if (hs.get(i) != 1)
//				return true;
//		}
//		return false;

		Set<Integer> distinct = new HashSet<Integer>();
		for (int num : nums) {
			if (distinct.contains(num)) {
				return true;
			}
			distinct.add(num);
		}
		return false;
	}
}
