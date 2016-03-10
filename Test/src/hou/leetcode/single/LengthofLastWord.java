package hou.leetcode.single;

/**
 * @author houweitao 2015年7月30日 下午4:46:24
 */

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LengthofLastWord test = new LengthofLastWord();

		// String s = "Hello World";
		String s = "  ";

		System.out.println(test.lengthOfLastWord(s));
	}

	// public int lengthOfLastWord(String s) {
	// int count = 0;
	// int jilu = 0;
	//
	// for (int i = 0; i < s.length(); i++) {
	// // System.out.println(s.charAt(i));
	// String tmp = String.valueOf(s.charAt(i));
	// if (tmp.equals(" "))
	// count = 0;
	// else {
	// count++;
	// jilu = count;
	// }
	// }
	//
	// if (count == 0)
	// return jilu;
	// else
	// return count;
	// }

	public int lengthOfLastWord(String s) {

		String[] website = s.split(" ");
		if (website.length != 0) {
			for (int i = 0; i < website.length; i++)
				System.out.println(i + ":" + website[i]);
			return website[website.length - 1].length();
		}
		else
			return 0;
	}
}
