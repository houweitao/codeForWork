package hou.csdn.single;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author houweitao
 * @date 2016年2月24日 上午10:17:33
 * @source http://blog.csdn.net/zjf280441589/article/details/50447533
 */

public class JavaDate {
	@Test
	public void testDate() {
		Date dateBefore = new Date();
		Date dateAfter = new Date(System.currentTimeMillis() + 1);

		System.out.println("before: " + dateBefore.getTime());
		System.out.println("after: " + dateAfter.getTime());
		System.out.println(dateBefore.before(dateAfter));
		System.out.println(dateAfter.after(dateBefore));

		dateBefore.setTime(System.currentTimeMillis());
		System.out.println(dateBefore.getTime());
		System.out.println(dateBefore.before(dateAfter));
	}

	@Test
	public void testCalendar() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(date.getTime());
		Calendar newCalendar = Calendar.getInstance();
		newCalendar.setTime(date);

		System.out.println(calendar.get(Calendar.DATE));
	}

	@Test
	public void testCalendarMore() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2011, Calendar.JULY, 31);
		calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
		// 将下面注释放开, 再测试
//		 System.out.println(calendar.get(Calendar.MONTH) + 1 + "月" + calendar.get(Calendar.DATE) + "日");
		calendar.set(Calendar.DATE, 5);
		System.out.println(calendar.get(Calendar.MONTH) + 1 + "月" + calendar.get(Calendar.DATE) + "日");
	}

	@Test
	public void client() throws ParseException {

		DateFormat format = new SimpleDateFormat("yy年MM月dd日 hh时mm分ss秒");

		// Date -> String
		Date date = new Date(System.currentTimeMillis());
		System.out.println(format.format(date));

		// String -> Date
		String timeString = "15年12月30日 09时00分29秒";
		Date newDate = format.parse(timeString);
		System.out.println(newDate);
	}
}
