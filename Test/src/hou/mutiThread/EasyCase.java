package hou.mutiThread;

/**
 * @author houweitao 2015年9月25日 上午12:37:41
 *         http://www.cnblogs.com/BaiYiShaoNian/p/4835027.html
 */

public class EasyCase {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				int i = 1;
				while (i <= 20) {
					System.out.println(Thread.currentThread().getName() + ": " + i++);
				}
			}
		}).start();

		int i = 20;
		while (i > 0) {
			System.out.println(Thread.currentThread().getName() + ": " + i--);
		}
	}
}
