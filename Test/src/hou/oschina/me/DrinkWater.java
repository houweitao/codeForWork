package hou.oschina.me;

/**
 * @author houweitao 2015年8月20日 下午12:45:53
 *         http://blog.csdn.net/mn960mn/article/details/47777009
 */

public class DrinkWater {

	int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrinkWater dw = new DrinkWater();
		dw.findNum(50);
		System.out.println(dw.count);
	}

	private void findNum(int num) {
		// TODO Auto-generated method stub
		while (num > 1) {
			count = count + num / 2;
			num = num / 2 + num % 2;
		}
	}

}
