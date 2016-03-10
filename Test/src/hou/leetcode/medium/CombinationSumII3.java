//package hou.leetcode.medium;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2016年1月6日 上午11:54:39
// */
//
//public class CombinationSumII3 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CombinationSumII3 cs = new CombinationSumII3();
//		int[] candidates = { 3, 1, 3, 5, 1, 1 };
//		List<List<Integer>> ret = cs.combinationSum2(candidates, 8);
//		System.out.println();
//		cs.printList(ret);
//	}
//
//	private void printList(List<List<Integer>> list) {
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.get(i).size(); j++) {
//				System.out.print(list.get(i).get(j) + ",");
//			}
//			System.out.println();
//		}
//	}
//
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		Arrays.sort(candidates);
//		HashMap<Integer, Integer> hm = new HashMap<>();
//		for (int i = 0; i < candidates.length; i++) {
//			if (hm.containsKey(candidates[i]))
//				hm.put(candidates[i], hm.get(candidates[i]) + 1);
//			else
//				hm.put(candidates[i], 1);
//		}
//		return help(candidates, target, hm, 0);
//	}
//
//	List<List<Integer>> help(int[] candidates, int target, HashMap<Integer, Integer> hm, int pos) {
//		List<List<Integer>> ret = new LinkedList<>();
//
//		if (pos == candidates.length || target <= 0)
//			return ret;
//
//		for (int i = pos; i < hm.size(); i++) {
//			for (int j = 0; j <= hm.get(candidates[i]); j++) {
//				int num = hm.get(candidates[i]);
//				if (j != 0) {
//					List<Integer> tmp = new LinkedList<>();
//					for (int k = 1; k <= j; k++) {
//						tmp.add(candidates[j]);
//					}
////					hm.remove(candidates[i]);
//					List<List<Integer>> next = help(candidates, target - j * candidates[i], hm, i + 1);
//					if (next != null) {
//						for (int k = 0; k < next.size(); k++) {
//							tmp.addAll(next.get(k));
//						}
//					}
//					ret.add(tmp);
////					hm.put(candidates[i], num);
//				}else{
//					List<List<Integer>> next = help(candidates, target, hm, i + 1);
//					if (next != null) {
//						for (int k = 0; k < next.size(); k++) {
//							ret.add(next.get(k));
//						}
//					}
//				}
//
//			}
//
//		}
//		return ret;
//	}
//
//}
