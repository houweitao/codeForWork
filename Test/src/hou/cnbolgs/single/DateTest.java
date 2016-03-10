package hou.cnbolgs.single;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

/**
 * @author houweitao
 * @date 2016年1月26日 下午4:46:05
 * http://www.cnblogs.com/lcngu/p/5154834.html
 */

public class DateTest {

	@Test
	public void testDate() {
		/**
		 * 获取系统当前时间 
		 * System.currentTimeMillis()返回系统当前时间，结果为1970年1月1日0时0分0秒开始，到程序执行取得系统时间为止所经过的毫秒数 
		 * 1秒＝1000毫秒 
		 */
		System.out.println("---获取系统当前时间---");
		System.out.println(System.currentTimeMillis());

		System.out.println("---获取系统当前时间---");
		//创建并初始化一个日期（初始值为当前日期） 
		Date date = new Date();
		System.out.println("现在的日期是 = " + date.toString());
		System.out.println("自1970年1月1日0时0分0秒开始至今所经历的毫秒数 = " + date.getTime());
	}

	@Test
	public void testDateFormat() throws ParseException {
		/**
		 * 对SimpleDateFormat类进行测试
		 * @throws ParseException 
		 */
		//创建日期 
		Date date = new Date();

		//创建不同的日期格式 
		DateFormat df1 = DateFormat.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA); //产生一个指定国家指定长度的日期格式，长度不同，显示的日期完整性也不同 
		DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);
		DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEEEEE", Locale.US);
		DateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");

		//将日期按照不同格式进行输出 
		System.out.println("-------将日期按照不同格式进行输出------");
		System.out.println("按照Java默认的日期格式，默认的区域                      : " + df1.format(date));
		System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，系统默认区域      :" + df2.format(date));
		System.out.println("按照日期的FULL模式，区域设置为中文                      : " + df3.format(date));
		System.out.println("按照指定格式 yyyy年MM月dd日 hh时mm分ss秒 EE ，区域为中文 : " + df4.format(date));
		System.out.println("按照指定格式 yyyy-MM-dd hh:mm:ss EE ，区域为美国        : " + df5.format(date));
		System.out.println("按照指定格式 yyyy-MM-dd ，系统默认区域                  : " + df6.format(date));

		//将符合该格式的字符串转换为日期，若格式不相配，则会出错 
		Date date1 = df1.parse("16-01-24 下午2:32");
		Date date2 = df2.parse("2016-01-24 02:51:07 星期日");
		Date date3 = df3.parse("2016年01月24日 星期五");
		Date date4 = df4.parse("2016年01月24日 02时51分18秒 星期日");
		Date date5 = df5.parse("2016-01-24 02:51:18 Sunday");
		Date date6 = df6.parse("2016-01-24");

		System.out.println("-------输出将字符串转换为日期的结果------");
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(date4);
		System.out.println(date5);
		System.out.println(date6);
	}

	@Test
	public void testCalendar1() {
		//创建Calendar的方式 
		Calendar now1 = Calendar.getInstance();
		Calendar now2 = new GregorianCalendar();
		Calendar now3 = new GregorianCalendar(2016, 01, 24);
		Calendar now4 = new GregorianCalendar(2016, 01, 24, 15, 55); //陷阱:Calendar的月份是0~11 
		Calendar now5 = new GregorianCalendar(2016, 01, 24, 15, 55, 44);
		Calendar now6 = new GregorianCalendar(Locale.US);
		Calendar now7 = new GregorianCalendar(TimeZone.getTimeZone("GMT-8:00"));

		//通过日期和毫秒数设置Calendar 
		now2.setTime(new Date());
		System.out.println(now2);

		now2.setTimeInMillis(new Date().getTime());
		System.out.println(now2);

		//定义日期的中文输出格式,并输出日期 
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 E", Locale.CHINA);
		System.out.println("获取日期中文格式化化输出：" + df.format(now5.getTime()));
		System.out.println();

		System.out.println("--------通过Calendar获取日期中年月日等相关信息--------");
		System.out.println("获取年：" + now5.get(Calendar.YEAR));
		System.out.println("获取月(月份是从0开始的)：" + now5.get(Calendar.MONTH));
		System.out.println("获取日：" + now5.get(Calendar.DAY_OF_MONTH));
		System.out.println("获取时：" + now5.get(Calendar.HOUR));
		System.out.println("获取分：" + now5.get(Calendar.MINUTE));
		System.out.println("获取秒：" + now5.get(Calendar.SECOND));
		System.out.println("获取上午、下午：" + now5.get(Calendar.AM_PM));
		System.out.println("获取星期数值(星期是从周日开始的)：" + now5.get(Calendar.DAY_OF_WEEK));
		System.out.println();

		System.out.println("---------通用星期中文化转换---------");
		String dayOfWeek[] = { "", "日", "一", "二", "三", "四", "五", "六" };
		System.out.println("now5对象的星期是:" + dayOfWeek[now5.get(Calendar.DAY_OF_WEEK)]);
		System.out.println();

		System.out.println("---------通用月份中文化转换---------");
		String months[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
		System.out.println("now5对象的月份是: " + months[now5.get(Calendar.MONTH)]);

	}

	@Test
	public void testCalendar2() throws ParseException {
		//获取当前月份的最大天数
		Calendar cal = Calendar.getInstance();
		int maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int minday = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		System.out.println(maxday);
		//取当月的最后一天  
		DateFormat formatter3 = new SimpleDateFormat("yyyy-MM-" + maxday);
		System.out.println(formatter3.format(cal.getTime()));
		//取当月的最后一天  
		DateFormat formatter4 = new SimpleDateFormat("yyyy-MM-" + minday);
		System.out.println(formatter4.format(cal.getTime()));
		//求两个日期之间相隔的天数
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = format.parse("2007-12-24");
		java.util.Date endDate = format.parse("2007-12-25");
		long day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		System.out.println("相隔的天数=" + day);
		//一年前的日期
		java.text.Format formatter5 = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date todayDate = new java.util.Date();
		long beforeTime = (todayDate.getTime() / 1000) - 60 * 60 * 24 * 365;
		todayDate.setTime(beforeTime * 1000);
		String beforeDate = formatter5.format(todayDate);
		System.out.println(beforeDate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		System.out.println(formatter5.format(calendar.getTime()));
		//当前星期的星期一和星期日
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int dayInWeek = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
		int offset = 0;
		if (dayInWeek == 1) {
			// 星期天
			offset = 6;
		} else {
			// 星期一至星期六
			offset = dayInWeek - 2;
		}
		gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, -offset);
		String sday = dateFormat.format(gregorianCalendar.getTime());
		gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, 6);
		String eday = dateFormat.format(gregorianCalendar.getTime());

		System.out.println("这个星期的星期一:" + sday);
		System.out.println("这个星期的星期天:" + eday);
	}
}
