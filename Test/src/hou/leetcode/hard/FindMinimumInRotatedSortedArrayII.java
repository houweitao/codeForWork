//package hou.leetcode.hard;
//
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//
///**
// * @author houweitao
// * @date 2015年12月7日 下午4:38:14
// * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// */
//
//public class FindMinimumInRotatedSortedArrayII {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nums = { 3, 3, 1 };
//		FindMinimumInRotatedSortedArrayII fm = new FindMinimumInRotatedSortedArrayII();
//		System.out.println(fm.findMin(nums));
//	}
//
//	public int findMin(int[] nums) {
//		LinkedHashMap<Integer,Integer> hs=new LinkedHashMap<>();
//		for (int i = 0; i < nums.length; i++)
//			if (!hs.containsKey(nums[i]))
//				hs.put(nums[i], 1);
//
//		int[] tmp = new int[hs.size()];
//		for (int i = 0; i < hs.size(); i++)
//			tmp[i] = hs.get(i);
//
//		if (tmp.length == 0)
//			return -1;
//		else if (tmp.length == 1)
//			return tmp[0];
//		else {
//			if (tmp[0] < tmp[tmp.length - 1])
//				return tmp[0];
//			else {
//				return help(tmp, 0, tmp.length - 1);
//			}
//		}
//	}
//
//	private int help(int[] nums, int i, int j) {
//		// TODO Auto-generated method stub
//		if (i == j)
//			return nums[j];
//		else if (nums[i] < nums[j])
//			return nums[i];
//		else {
//			if (i + 1 == j)
//				return nums[j];
//			else {
//				int mid = (i + j) / 2;
//				if (nums[mid] > nums[i])
//					return help(nums, mid + 1, j);
//				else
//					return help(nums, i, mid);
//			}
//		}
//	}
//}
