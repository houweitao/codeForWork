//package hou.leetcode.hard;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * @author houweitao
// * @date 2015年12月14日 下午2:56:47
// * @danteng 2015年12月14日15:52:36
// */
//
//public class CountofSmallerNumbersAfterSelf {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CountofSmallerNumbersAfterSelf count = new CountofSmallerNumbersAfterSelf();
//		int[] nums = { 5, 2, 6, 1 };
//		count.countSmaller(nums);
//	}
//
//	public List<Integer> countSmaller(int[] nums) {
//		int record[] = new int[100000];
//		List<Integer> ret = new LinkedList<>();
//		
//		if(nums.length==0){
//			return ret;
//		}
//		
//		Stack<Integer> stack = new Stack<>();
//		int max = nums[nums.length - 1];
//		ret.add(0);
//		for (int i = nums.length - 2; i >= 0; i--) {
//			if (nums[i] > max) {
//				ret.add(0, record[max] + 1);
////				System.out.println("大于max时： ");
////				print(ret);
//				for (int j = max + 1; j <= nums[i]; j++) {
//					record[j] = record[max] + 1;
//				}
////				printRecord(record);
//				max = nums[i];
//			} else {
//				ret.add(0, record[nums[i]]);
////				print(ret);
//				stack.push(record[nums[i]]);
//				for (int j = nums[i] + 1; j <= max; j++) {
//					record[j]++;
//				}
////				printRecord(record);
//			}
//		}
//
////		print(ret);
//
//		return ret;
//	}
//
//	private void printRecord(int[] record) {
//		// TODO Auto-generated method stub
//		System.out.print("record: ");
//		for (int i = 0; i < record.length; i++) {
//			System.out.print(record[i] + ",");
//		}
//		System.out.println();
//	}
//
//	private void print(List<Integer> ret) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < ret.size(); i++) {
//			System.out.print(ret.get(i) + ",");
//		}
//		System.out.println();
//	}
//}
