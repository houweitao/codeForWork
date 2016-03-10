package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年12月8日 下午4:07:33
 * http://www.1point3acres.com/bbs/thread-154242-1-1.html
 */

public class LongestRunInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ggggoooglllllle";
		LongestRunInString lrs = new LongestRunInString();
		System.out.println(lrs.longest(str));
	}

	String longest(String str) {
		int maxL = 1;
		int maxBegin = -1;

		int currentL = 1;
		int currentBegin = 0;
		char curChar = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == curChar) {
				currentL++;
				if (currentL > maxL) {
					maxL = currentL;
					maxBegin = currentBegin;
				}
			} else {
				currentL = 1;
				currentBegin = i;
				curChar = str.charAt(i);
			}
		}

		String ret = "";
		for (int i = 0; i < maxL; i++) {
			ret = ret + str.charAt(maxBegin);
		}
		return ret;
	}

}
