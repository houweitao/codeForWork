package hou.oschina.me;

/**
 * @author houweitao 2015年7月16日 下午3:08:30
 */

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 90000; i++) {
			long test = System.currentTimeMillis();
			System.out.println(test);
			
			try {
				Thread.sleep(3000);// 括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
