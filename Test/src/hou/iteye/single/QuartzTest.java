//package hou.iteye.single;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.quartz.CronScheduleBuilder;
//import org.quartz.CronTrigger;
//import org.quartz.Job;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.JobKey;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerFactory;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.TriggerKey;
//import org.quartz.impl.StdSchedulerFactory;
//
///**
// * @author houweitao
// * @date 2015年12月24日 下午2:45:25
// * http://see-you-again.iteye.com/blog/2265680
// * http://my.oschina.net/SmilePlus/blog/83726
// * not work well
// */
//
//public class QuartzTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	    try {
//	      String job_name = "动态任务调度";
//	      System.out.println("【系统启动】开始(每1秒输出一次)...");  
//	      QuartzManager.addJob(job_name, QuartzJob.class, "0/1 * * * * ?");  
////	      
//	      Thread.sleep(5000);  
//	      System.out.println("【修改时间】开始(每2秒输出一次)...");  
//	      QuartzManager.modifyJobTime(job_name, "10/3 * * * * ?");  
////	      Thread.sleep(6000);  
//	      System.out.println("【移除定时】开始...");  
////	      QuartzManager.removeJob(new TriggerKey(jobName, TRIGGER_GROUP_NAME),new JobKey(jobName, JOB_GROUP_NAME));  
////	      System.out.println("【移除定时】成功");  
//	      QuartzManager.startJobs();
//	      Thread.sleep(6000);  
//	      QuartzManager.shutdownJobs();
////	      System.out.println("【移除定时】成功");
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
//	}
//
//}
//
//class QuartzJob implements Job {
//	@Override
//	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");
//	}
//
//}
//
//class QuartzManager {
//	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//	private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
//	private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";
//
//	/**
//	 * 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
//	 * 
//	 * @param jobName 任务名
//	 * @param cls 任务
//	 * @param time 时间设置，参考quartz说明文档
//	 */
//	public static void addJob(String jobName, Class cls, String time) {
//		try {
//			Scheduler scheduler = schedulerFactory.getScheduler();//创建一个触发器表
//			JobDetail jobDetail = JobBuilder.newJob()//创建一个jobbuilder用来定义一个任务明细。
//					.ofType(cls)//设置类，将被实例化
//					.withIdentity(new JobKey(jobName, JOB_GROUP_NAME))//使用给定的名称和默认组jobkey识别任务明细
//					.build();//产品定义的JobDetail实例这jobbuilder。
//
//			Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(time))//设置schedulebuilder将用于定义触发器的表。
//					.withIdentity(new TriggerKey(jobName, TRIGGER_GROUP_NAME)).build();//创建Trigger
//
//			scheduler.scheduleJob(jobDetail, trigger);//绑定
//
//			// 启动
//			if (!scheduler.isShutdown()) {
//				// scheduler.start();
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
//	 * @param jobName
//	 * @param time
//	 */
//	@SuppressWarnings("unchecked")
//	public static void modifyJobTime(String jobName, String time) {
//		try {
//			Scheduler sched = schedulerFactory.getScheduler();
//
//			Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(time))//设置schedulebuilder将用于定义触发器的表。
//					.withIdentity(new TriggerKey(jobName, TRIGGER_GROUP_NAME)).build();//创建Trigger
//
//			if (trigger == null) {
//				return;
//			}
//			String oldTime = ((CronTrigger) trigger).getCronExpression();
//			if (!oldTime.equalsIgnoreCase(time)) {
//				JobDetail jobDetail = sched.getJobDetail(new JobKey(jobName, JOB_GROUP_NAME));
//				Class objJobClass = jobDetail.getJobClass();
//				removeJob(new TriggerKey(jobName, TRIGGER_GROUP_NAME), new JobKey(jobName, JOB_GROUP_NAME));
//				addJob(jobName, objJobClass, time);
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
//	 * @param triggerKey
//	 * @param jobKey
//	 */
//	public static void removeJob(TriggerKey triggerKey, JobKey jobKey) {
//		try {
//			Scheduler sched = schedulerFactory.getScheduler();
//			sched.pauseTrigger(triggerKey);// 停止触发器
//			sched.unscheduleJob(triggerKey);// 移除触发器
//			sched.deleteJob(jobKey);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 启动所有定时任务
//	 */
//	public static void startJobs() {
//		try {
//			Scheduler sched = schedulerFactory.getScheduler();
//			sched.start();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 关闭所有定时任务
//	 */
//	public static void shutdownJobs() {
//		try {
//			Scheduler sched = schedulerFactory.getScheduler();
//			if (!sched.isShutdown()) {
//				sched.shutdown();
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//}