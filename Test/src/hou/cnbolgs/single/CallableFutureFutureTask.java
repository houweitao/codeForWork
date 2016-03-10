package hou.cnbolgs.single;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author houweitao
 * @date 2016年2月24日 下午12:01:53
 * http://www.cnblogs.com/dolphin0520/p/3949310.html
 * 关于线程池
 * http://blog.csdn.net/coding_or_coded/article/details/6856014
 */

public class CallableFutureFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//第一种方式
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		executor.submit(futureTask);
		executor.shutdown();

		//第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
		Task taskThread = new Task();
		FutureTask<Integer> futureTaskThread = new FutureTask<Integer>(taskThread);
		Thread thread = new Thread(futureTaskThread);
		thread.start();

		System.out.println("任务完成？：" + futureTask.isDone());
//		System.out.println("get: " + futureTask.get());//need wait

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("主线程在执行任务");

		try {
			System.out.println("task运行结果" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("所有任务执行完毕");

		System.out.println("任务完成？：" + futureTask.isDone());

		System.out.println(futureTaskThread.get());
	}
}

class Task implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}