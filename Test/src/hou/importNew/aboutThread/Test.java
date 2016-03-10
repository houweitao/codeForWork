package hou.importNew.aboutThread;

/**
 * @author houweitao
 * @date 2016年2月23日 上午9:51:16
 * @source http://www.cnblogs.com/dolphin0520/p/3913517.html
 */

public class Test {
	public static void main(String[] args) {
		System.out.println("主线程ID:" + Thread.currentThread().getId());
		MyThread thread1 = new MyThread("thread1");
		thread1.start();
		MyThread thread2 = new MyThread("thread2");
		thread2.run();
	}
}

class MyThread extends Thread {
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("name:" + name + " 子线程ID:" + Thread.currentThread().getId());
	}
}