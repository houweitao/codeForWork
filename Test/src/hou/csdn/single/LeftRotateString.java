package hou.csdn.single;

/**
 * @author houweitao 2015年9月16日 上午9:51:59
 *         http://blog.csdn.net/libin1105/article/details/48402739
 */

public class LeftRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeftRotateString lrs = new LeftRotateString();
		lrs.reverseStrint("abcde", 1, 4);

		System.out.println();

		String str = "abcXYZdef";
		lrs.leftRotateString(str, 3);
	}

	void leftRotateString(String str, int n) {
		str = reverseStrint(str, 0, n - 1);
		System.out.println();
		str = reverseStrint(str, n, str.length() - 1);
		System.out.println();
		str = reverseStrint(str, 0, str.length() - 1);
	}

	String reverseStrint(String str, int begin, int end) {
		while (begin < end) {
			char tmp;
			char[] s = str.toCharArray();
			tmp = s[begin];
			s[begin] = s[end];
			s[end] = tmp;
			str = String.valueOf(s);
			System.out.println(str);

			begin++;
			end--;
		}
		return str;
	}
}
