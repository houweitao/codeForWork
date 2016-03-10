package hou.offerWrite;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author houweitao
 * @date 2016年3月7日 上午10:35:05
 */

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.getTime());

		Date d = new Date(date.getTime());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sd.format(d));

		java.util.Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
		System.out.println(utilDate);
	}

}
