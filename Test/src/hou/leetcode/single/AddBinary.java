package hou.leetcode.single;

/**
 * @author houweitao 2015年8月27日 上午10:44:59
 */

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addBinary2(String a, String b) {
		
		
		
		return b;
	}

	public String addBinary(String a, String b) {
		String first, second;
		int tmp = 0;
		int result = 0;
		if (a.length() > b.length()) {
			first = a;
			second = b;
		} else {
			first = b;
			second = a;
		}

		int aa = Integer.parseInt(first);
		int bb = Integer.parseInt(second);

		for (int i = 0; i < b.length(); i++) {
			int c = aa / 10 + bb / 10;
			if (c == 0 || c == 1) {
				int t = 10 ^ i;
				result = result + c * t;
			} else if (c == 2) {
				tmp = 1;
			}
		}

		return "s";
	}
}
