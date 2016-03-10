//package hou.leetcode.medium;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2016年1月1日 上午1:23:18
// * @mafan 2016年1月1日01:46:10
// * https://leetcode.com/problems/permutation-sequence/
// */
//
//public class PermutationSequence {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PermutationSequence ps = new PermutationSequence();
//		for (int i = 1; i <= 6; i++) {
//			String s = ps.getPermutation(3, i);
//			System.out.println(s);
//		}
//	}
//
//	public String getPermutation(int n, int k) {
//		Struc struc = new Struc(k);
//		String str = "";
//		for (int i = 1; i <= n; i++)
//			str = str + i;
//
//		List<String> ret = help(str, struc);
//		System.out.println(ret == null);
//		return ret.get(ret.size() - 1);
//	}
//
//	private List<String> help(String str, Struc struc) {
//		// TODO Auto-generated method stub
//		List<String> ret = new LinkedList<>();
//		if (str.length() == 1) {
//
//			if (struc.getK() == 0) {
//				System.out.println("最后一次运算！");
//				return ret;
//			}
//
//			if (struc.getK() != 1) {
//				struc.setK(struc.getK() - 1);
////				System.out.println(str + "  ,   " + struc.getK());
//			}
//			ret.add(str);
//			return ret;
//		} else {
//			boolean last = false;
//			if (struc.getK() == 0) {
//				last = true;
//				List<String> next = help(str.substring(1), struc);
//				ret.add(str.charAt(0) + next.get(0));
//				return ret;
//			}
//			for (int i = 0; i < str.length(); i++) {
//				if (struc.getK() != 0) {
//					String newStr = str.charAt(i) + str.substring(0, i) + str.substring(i + 1);
//					List<String> next = help(newStr.substring(1), struc);
//
//					if (next != null)
//						for (int j = 0; j < next.size(); j++) {
//							ret.add(newStr.charAt(0) + next.get(j));
//						}
//
//				} else {
//					String newStr = str.charAt(i) + str.substring(0, i) + str.substring(i + 1);
//					List<String> next = help(newStr.substring(1), struc);
//
//					if (next != null)
//						ret.add(newStr.charAt(0) + next.get(0));
//
//					return ret;
//				}
//			}
//			return ret;
//		}
//	}
//}
//
//class Struc {
//	private int k;
//
//	public int getK() {
//		return k;
//	}
//
//	public void setK(int k) {
//		this.k = k;
//	}
//
//	Struc(int k) {
//		this.k = k;
//	}
//}
