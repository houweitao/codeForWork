package hou.mianjing.design;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author houweitao
 * @date 2016年2月12日上午12:59:45
 * @end 2016年02月12日01:37:18 
 * @source http://www.1point3acres.com/bbs/thread-170283-1-1.html
 *         http://www.1point3acres.com/bbs/thread-168090-1-1.html
 */

public class Alarm implements Runnable {
	DateFormat format = new SimpleDateFormat("HH:mm");
	boolean work = true;
	ArrayList<String> alarmList = new ArrayList<>();

	void addAlarm(String time) {
		alarmList.add(time);
	}

	void beginAlarm() {

	}

	void stopAlarm() {
		work = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (work) {
			Date date = new Date();
			String time = format.format(date);
			System.out.println(time);
			if (alarmList.contains(time))
				System.out.println("zhi zhi zhi.. " + time);
			else
				System.out.println(alarmList);

			try {
				Thread.sleep(60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class AlarmAdd implements Runnable {
	private Alarm alarm;
	boolean runAlarm = false;
	DateFormat format = new SimpleDateFormat("HH:mm");

	public AlarmAdd(String alarmTime) {
		this.alarm.alarmList.add(alarmTime);
	}

	@Override
	public void run() {
		while (true) {
			Date date = new Date();
			String time = format.format(date);
			System.out.println(time);
			if (alarm.alarmList.contains(time))
				System.out.println("zhi zhi zhi.. " + time);
			else
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}