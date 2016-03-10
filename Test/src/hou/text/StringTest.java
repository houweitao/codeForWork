package hou.text;

/**
 * @author houweitao
 * @date 2016年1月6日 上午9:53:46
 * http://blog.csdn.net/rainnnbow/article/details/50461303
 */

public class StringTest {

	public static void main(String[] args) {
		StringTest st = new StringTest();
		st.testIntern();
		st.newTest();
	}

	void test1() {
		String a = "计算机软件";
		String b = "计算机软件";
		System.out.println(a == b);
	}

	void test2() {
		String c = "计算机软件";
		String b = "计算机";
		String a = b + "软件";

		System.out.println(a == c);
	}

	void test3() {
		String a = "计算机软件";
		String b = new String("计算机软件");
		System.out.println(a == b);
	}

	void testIntern() {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println((str1.intern() == str1));
		//JDK1.6:false
		//JDK1.7:true
	}

	// add 2016年3月4日12:07:28
	void newTest() {
		String s1 = "china";
		String s2 = "china";
		String s3 = "china";
		String ss1 = new String("china");
		String ss2 = new String("china");
		String ss3 = new String("china");
		
		System.out.println(s1==s2);
		System.out.println(s1==ss1);
		System.out.println(ss1==ss2);
	}
}
