package hou.importNew;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao 2015年9月25日 上午11:26:29 http://www.importnew.com/16599.html
 * 
 *         如果你需要存储大量数据，你应该在创建HashMap时指定一个初始的容量，这个容量应该接近你期望的大小。
 *         你需要针对键找到一种哈希函数，可以将键扩散到最可能的桶上。为此，你需要避免哈希冲突。
 *         String对象是一个非常好的键，因为它有很好的哈希函数。Integer也很好，因为它的哈希值就是它自身的值。
 */

public class AboutHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AboutHashMap ahm = new AboutHashMap();
		ahm.doWork();
	}

	void doWork() {
		Date begin = new Date();
		Map<MyKey, String> myMap = new HashMap<>(2_500_000, 1);
		for (int i = 0; i < 2_000_000; i++) {
			myMap.put(new MyKey(i), "test " + i);
			System.out.println("add: " + "test " + i);
		}

		Date end = new Date();
		System.out.println("Duration (ms) " + (end.getTime() - begin.getTime()));
	}

	class MyKey {
		Integer i;

		public MyKey(Integer i) {
			this.i = i;
		}

		// @Override
		// public int hashCode() {
		// return 1;
		// }

		@Override
		public int hashCode() {
			// int key = 2097152 - 1;
			// return key + 2097152 * i;

			int key = 2048 - 1;
			return key + 2047 * i;
		}

		// @Override
		// public int hashCode() {
		// return i;
		// }

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MyKey) {
				return i.equals(((MyKey) obj).i);
			} else
				return false;
		}
	}

}
