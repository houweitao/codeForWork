package hou.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月4日 下午5:17:46
 */

public class CollectionShuffleTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(new Integer(i));
		System.out.println("打乱前:");
		System.out.println(list);

		for (int i = 0; i < 5; i++) {
			System.out.println("第" + i + "次打乱：");
			Collections.shuffle(list);
			System.out.println(list);
		}
	}
}
