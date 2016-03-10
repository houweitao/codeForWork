package hou.csdn.me;

/**
 * @author houweitao
 * @date 2015年11月8日 下午10:25:08
 * @source 编程珠玑 第七章
 */

public class Law72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Law72 law72 = new Law72();
//		law72.law(6);
		for(double i=1;i<40;i=i+0.5){
			law72.law(i);
		}
	}

	void law(double rate) {
		double time = 72 / rate;
//		System.out.println(time);
		int i = 2;
		double money = 1;
		while (i < time) {
			money = money * (1 + rate / 100);
			i++;
		}
		System.out.println(rate + " , " + money);
	}
}
