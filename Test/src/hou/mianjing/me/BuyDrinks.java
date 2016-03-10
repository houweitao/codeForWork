package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年3月4日 上午10:53:31
 * 
 * 饮料卖两块钱一瓶，两个空瓶子或者四个瓶盖均可以换一瓶新的饮料。10块钱可以喝多少瓶饮料？
 */

public class BuyDrinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyDrinks buy = new BuyDrinks();
		System.out.println(buy.useMoney(10));
	}

	int useMoney(int money) {
		return getNum(money, 0, 0);
	}

	int getNum(int money, int pingZi, int gaiZi) {
		System.out.println("now: " + money + "," + pingZi + "," + gaiZi);
		int curNum = money / 2 + pingZi / 4 + gaiZi / 4;
		money = money % 2;
		pingZi = pingZi % 4;
		gaiZi = gaiZi % 4;
		
		System.out.println(" buy " + curNum);
		
		if (curNum == 0)
			return 0;
		else
			return curNum + getNum(money, pingZi + curNum, gaiZi + curNum);
	}
}
