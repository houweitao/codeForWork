package hou.leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2015年12月15日 上午10:31:16
 * @end 2015年12月15日11:02:46
 */

public class MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElementII me = new MajorityElementII();
		int[] nums = { 1, 2, 3, 4, 1, 2, 2 };
		me.majorityElement(nums);
	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> major = new LinkedList<>();

		if (nums.length == 0)
			return major;

		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			count++;
			if (hm.containsKey(nums[i]))
				hm.put(nums[i], hm.get(nums[i]) + 1);
			else
				hm.put(nums[i], 1);

			Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = iterator.next();

				if (entry.getValue() * 3 > count) {
					if (!major.contains(entry.getKey()))
						major.add(entry.getKey());
				} else {
					if (major.contains(entry.getKey()))
						major.remove(entry.getKey());
				}
			
			}

//			for (Entry<Integer, Integer> entry : hm.entrySet()) {
//				if (entry.getValue() * 3 > count) {
//					if (!major.contains(entry.getKey()))
//						major.add(entry.getKey());
//				} else {
//					if (major.contains(entry.getKey()))
//						major.remove(entry.getKey());
//				}
//			}
		}

		printList(major);
		return major;
	}

	private void printList(List<Integer> major) {
		// TODO Auto-generated method stub
		for (int i = 0; i < major.size(); i++) {
			System.out.print(major.get(i) + ", ");
		}
		System.out.println();
	}

}
