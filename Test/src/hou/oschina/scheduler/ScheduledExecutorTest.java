package hou.oschina.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author houweitao
 * @date 2015年12月25日 上午11:16:57
 * http://www.oschina.net/question/129540_28053
 */

/*Timer 的优点在于简单易用，但由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，
 同一时间只能有一个任务在执行，前一个任务的延迟或异常都将会影响到之后的任务。

鉴于 Timer 的上述缺陷，Java 5 推出了基于线程池设计的 ScheduledExecutor。
其设计思想是，每一个被调度的任务都会由线程池中一个线程去执行，因此任务是并发执行的，相互之间不会受到干扰。
需 要注意的是，只有当任务的执行时间到来时，ScheduedExecutor 才会真正启动一个线程，
其余时间 ScheduledExecutor 都是在轮询任务的状态。

代码展示了 ScheduledExecutorService 中两种最常用的调度方法 ScheduleAtFixedRate 和 ScheduleWithFixedDelay。
ScheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔，
即每次执行时间为 :initialDelay, initialDelay+period, initialDelay+2*period, …；ScheduleWithFixedDelay 
每次执行时间为上一次任务结束起向后推一个时间间隔，即每次执行时间为：initialDelay, initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delay。
由此可见，ScheduleAtFixedRate 是基于固定时间间隔进行任务调度，ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度。  

*/

public class ScheduledExecutorTest implements Runnable {
	private String jobName = "";

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		// my test
//		for (int i = 1; i < 20; i++) {
//			long initialDelay1 = 1;
//			long period1 = (long)i;
//			service.scheduleAtFixedRate(new ScheduledExecutorTest("job" + i), initialDelay1, period1, TimeUnit.SECONDS);
//
//		}

		//attention!
		//ScheduleAtFixedRate 是基于固定时间间隔进行任务调度，
		//ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度。
		
		long initialDelay1 = 1;
		long period1 = 1;
		// 从现在开始1秒钟之后，每隔1秒钟执行一次job1
		service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"), initialDelay1, period1, TimeUnit.SECONDS);

		long initialDelay2 = 2;
		long delay2 = 2;
		// 从现在开始2秒钟之后，每隔2秒钟执行一次job2
		service.scheduleWithFixedDelay(new ScheduledExecutorTest("job2"), initialDelay2, delay2, TimeUnit.SECONDS);
	}

	public ScheduledExecutorTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("execute " + jobName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}