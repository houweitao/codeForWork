package hou.csdn.single;

/**
 * @author houweitao 2015年9月18日 下午2:49:53
 *         http://blog.csdn.net/xiaofengcanyuexj/article/details/22993179
 */

public class ReferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "init";
		System.out.println("before: " + str);
		change(str);
		System.out.println("after: " + str);
		str = change2(str);
		System.out.println("after: " + str);
	}

	static void change(String str) {
		str = "change!";
		System.out.println("change: " + str);
	}

	static String change2(String str) {
		str = "change";
		System.out.println("change2: " + str);
		return str;
	}
}
