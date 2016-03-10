package hou.csdn.single;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author houweitao
 * @date 2015年12月26日 上午10:05:33
 */

public class CheckTimingThreadPool {
	public static void main(String[] args) {
		ThreadPoolExecutor exec = new TimingThreadPool(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		exec.execute(new DoSomething(5));
		exec.execute(new DoSomething(4));
		exec.execute(new DoSomething(3));
		exec.execute(new DoSomething(2));
		exec.execute(new DoSomething(1));
		exec.shutdown();
	}

}

class DoSomething implements Runnable {
	private int sleepTime;

	public DoSomething(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running.");
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class TimingThreadPool extends ThreadPoolExecutor {
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	private final Logger log = Logger.getAnonymousLogger();
	private final AtomicLong numTasks = new AtomicLong();
	private final AtomicLong totalTime = new AtomicLong();

	public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		log.info(String.format("Thread %s: start %s", t, r));
		startTime.set(System.nanoTime());
	}

	protected void afterExecute(Runnable r, Throwable t) {
		try {
			long endTime = System.nanoTime();
			long taskTime = endTime - startTime.get();
			numTasks.incrementAndGet();
			totalTime.addAndGet(taskTime);
			log.info(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
		} finally {
			super.afterExecute(r, t);
		}
	}

	protected void terminated() {
		try {
			log.info(String.format("Terminated: avg time=%dns", totalTime.get() / numTasks.get()));
		} finally {
			super.terminated();
		}
	}
}