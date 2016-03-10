package hou.oschina.me.test;

import java.util.HashMap;

/**
 * @author houweitao
 * 2015年8月6日 上午11:21:56
 */

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Integer> test = new HashMap<String,Integer>();
		
		test.put("a", 1);
		test.put("c", 2);
		test.put("c", 3);
		test.put("d", 1);
		
		System.out.println(test.get("c"));
	}

}
