package hou.mianjing.design;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author houweitao
 * @date 2016年2月12日上午1:23:29
 * @end 2016年02月12日01:37:18 
 * @source http://www.1point3acres.com/bbs/thread-170283-1-1.html
 *         http://www.1point3acres.com/bbs/thread-168090-1-1.html
 */

public class AlarmClint {
	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Alarm alarm = new Alarm();
		String time = format.format(new Date().getTime() + 60 * 1000);
		System.out.println("闹钟：" + time);
		alarm.addAlarm(time);

		Thread thread = new Thread(alarm);
		thread.start();

		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		time = format.format(new Date().getTime() + 60 * 1000);
		System.out.println("闹钟：" + time);
		alarm.addAlarm(time);
		System.out.println(alarm.alarmList);
	}

}
