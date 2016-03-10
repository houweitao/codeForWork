//package hou.leetcode.medium;
//
///**
// * @author houweitao
// * @date 2015年11月20日 下午3:08:39
// * @give up..
// * https://leetcode.com/problems/additive-number/
// */
//
//public class AdditiveNumber {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String num = "1991001992991300";
//		AdditiveNumber an = new AdditiveNumber();
//		System.out.println(an.isAdditiveNumber(num));
//	}
//
//	public boolean isAdditiveNumber(String num) {
//		//find first
//		int length = num.length();
//		int add = 0;
//		for (int i = 1; i < length / 2; i++) {
//			System.out.println(i);
//			for (int j = i + 1; j < length / 2 + 1; j++) {
//				add = Integer.valueOf(num.substring(0, i)) + Integer.valueOf(num.substring(i, j));
//				System.out.println("add: " + add);
//				int numLength = String.valueOf(add).length();
//				if (num.substring(j, j + numLength).equals(String.valueOf(add))) {
//
//					System.out.println(num.substring(j, j + numLength));
//					System.out.println(String.valueOf(add));
//
//					System.out.println("yes");
//
//					System.out.println(num.substring(i) + "," + numLength);
//					num=num.substring(i);
//					return help(num, numLength);
//				}
//			}
//		}
//
//		return false;
//	}
//
//	private boolean help(String s, int numLength) {
//		System.out.println("out; " + s + "," + numLength);
//		for (int i = numLength; i < s.length() / 2 + 1; i++) {
//			System.out.println("help,i: " + i);
//			int add = Integer.valueOf(s.substring(0, numLength))
//					+ Integer.valueOf(s.substring(numLength, numLength + i));
//
//			System.out.print("$$ " + Integer.valueOf(s.substring(0, numLength)) + " + ");
//			System.out.println("$$ " + Integer.valueOf(s.substring(numLength, numLength + i)));
//
//			if (s.substring(numLength + i, numLength + i + String.valueOf(add).length()).equals(String.valueOf(add))) {
//				int l = i - numLength;
//				l = i;
//				int right = String.valueOf(add).length();
//				System.out.println("add " + add + ",length: " + l);
//
//				if (s.substring(numLength + i).length() == String.valueOf(add).length())
//					return true;
//				else
//					return help(s.substring(numLength), right);
//			}
//		}
//
//		return false;
//	}
//
////	int getNum()
//}
