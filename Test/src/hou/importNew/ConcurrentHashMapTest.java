package hou.importNew;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author houweitao
 * @date 2016年1月19日 下午12:12:20
 * http://www.importnew.com/17481.html
 */

//都会中途退出啊！
public class ConcurrentHashMapTest {

	//因为多线程环境下，使用Hashmap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。
	@Test
	public void testHashMap() throws InterruptedException {//一个线程里面包含着10000个线程？？
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			int count = 0;

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							while (true) {
								String str = UUID.randomUUID().toString();
								System.out.println(count++ + "  " + Thread.currentThread().getName() + " : " + str);
								map.put(str, "");
							}
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
	}

	@Test
	public void testConcurrentHashMap() throws InterruptedException {//一个线程里面包含着10000个线程？？
		final ConcurrentHashMap<String, String> ConcurrentHashMap = new ConcurrentHashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			int count = 0;

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							while (true) {
								String str = UUID.randomUUID().toString();
								System.out.println(count++ + " : " + str);
								ConcurrentHashMap.put(str, "");
							}
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
	}
}
