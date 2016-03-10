package hou.mutiThread;

/**
 * @author houweitao
 * 2015年10月19日 上午10:04:29
 * http://www.open-open.com/lib/view/open1335829640968.html
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class singleThreadExecutorTest {
	public static void main(String[] args) throws Exception {
		ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();
		//这里如果是cached是并行。是newSingleThreadExecutor则为单线程
		for (int i = 0; i < 3; i++) {
			final int index = i;
			WebCrawler crawler = new WebCrawler(i);
			singleThreadExecutor.submit(crawler);

			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							System.out.println(index);
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}

		testDemo3();
	}

	public static void testDemo3() throws Exception {

		//声明一个线程池
		ExecutorService ex = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			final int a = i;
			//每一次execute方法，都是向池中放入一个对象
			ex.execute(new Runnable() {
				public void run() {
					while (true) {
						System.err.println("测试...." + a + ">" + Thread.currentThread().getName() + ","
								+ Thread.currentThread().isDaemon());
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		Thread.sleep(1000 * 60 * 60);
	}
}

class WebCrawler implements Runnable {
	int name;

	public WebCrawler(int i) {
		this.name = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name);
		try {
			Thread.sleep(2000);
			System.out.println(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}