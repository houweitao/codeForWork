package hou.oschina.me.test;

import java.util.ArrayList;

/**
 * @author houweitao
 * 2015年7月16日 下午4:39:08
 */

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> web = new ArrayList<Integer>();
		web.add(1);
		web.add(2);
		web.add(5);
		
		for(int i:web){
			System.out.println(i);
		}
		
		System.out.println(web.get(0));
	}

}
