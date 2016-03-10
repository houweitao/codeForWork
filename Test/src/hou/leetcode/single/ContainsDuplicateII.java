//package hou.leetcode.single;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.TreeSet;
//
///**
// * @author houweitao
// * @date 2015年11月20日 下午4:49:46
// * https://leetcode.com/problems/contains-duplicate-ii/
// */
//
//public class ContainsDuplicateII {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ContainsDuplicateII cd = new ContainsDuplicateII();
//		int[] nums = { 1, 2, 3, 0, 11, 2, 8 };
//		boolean judge = cd.containsNearbyDuplicate(nums, 5);
//		System.out.println(judge);
//	}
//
//	public boolean containsNearbyDuplicate(int[] nums, int kk) {
//
//		int k = kk - 1;
//		if (nums.length == 0 || nums.length == 1)
//			return false;
//		else if (nums.length <= k) {
//			Arrays.sort(nums);
//			for (int i = 0; i < nums.length - 1; i++) {
//				if (nums[i] == nums[i + 1])
//					return true;
//			}
//			return false;
//		} else {
//			int[] tmp = new int[kk];
//			Queue<Integer> q = new LinkedList<Integer>();
//			for (int j = 0; j < kk; j++) {
//				q.offer(nums[j]);
//				System.out.print(nums[j] + ",");
//			}
//
//			for (int i = 0; i < nums.length - k + 1; i++) {
//				System.out.println(i);
//				q.poll();
//				q.offer(nums[i]);
//				tmp = buildNums(q);
//				Arrays.sort(tmp);
//				for (int j = 0; j < nums.length - 1; j++) {
//					if (nums[j] == nums[j + 1])
//						return true;
//				}
//			}
//			return false;
//		}
//
//	}
//
//	int[] buildNums(Queue<Integer> q) {
//		int[] tmp = new int[q.size()];
//		Queue<Integer> tmpQueue = new LinkedList<>();
//		for (int i = 0; i < q.size(); i++) {
//			tmp[i] = q.peek();
//			tmpQueue.offer(q.poll());
//		}
//		q = tmpQueue;
//		return tmp;
//	}
//}
