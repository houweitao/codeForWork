package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月21日 上午10:48:53
 * @end 2016年1月21日10:58:47
 * http://www.1point3acres.com/bbs/thread-166531-1-1.html
 */

public class CandyNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandyNums num=new CandyNums();
		int candy=num.getCandyNum(10, 3, 3);
		System.out.println(candy);
		
		for(int i=1;i<200;i++)
			System.out.println(i+" : "+num.getCandyNum(i, 3, 3));
	}

	int getCandyNum(int money, int prize, int change) {
		if (money < prize)
			return 0;
		else
			return help(money, prize, change, 0);
	}

	int help(int money, int prize, int change, int candyPieceNum) {
		if (money < prize) {
			if (candyPieceNum < change)
				return 0;
			else
				return candyPieceNum / change + help(0, prize, change, candyPieceNum % change + candyPieceNum / change);
		} else {
			int moneyBuy = money / prize;
			int moneyLeft = money % prize;

			return moneyBuy + help(moneyLeft, prize, change, candyPieceNum + moneyBuy);
		}
	}
}
