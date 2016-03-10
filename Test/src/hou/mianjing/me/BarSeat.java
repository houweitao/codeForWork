package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月15日 下午2:43:28
 * @end 2016年1月15日15:38:12
 * http://group.jobbole.com/12836/
 * 最好第一遍细心点，不然修改bug的话真是痛苦呀。。
 */

public class BarSeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BarSeat bs = new BarSeat();
		System.out.println("...");
		int[] seats = new int[25];
		bs.seatMost(seats);
	}

	int seatMost(int[] seats) {
		int[] count = new int[seats.length];
		int maxPeople = 0;
		int maxPos = -1;
		for (int i = 0; i < seats.length; i++) {
			seats[i] = 1;
			while (canSeat(seats)) {
				int next = getNextPos(seats);
				System.out.println(i + "  " + next);
				seats[next] = 1;
				print(seats);
				count[i]++;
			}

			if (count[i] > maxPeople) {
				maxPeople = count[i];
				maxPos = i;
			}

			for (int j = 0; j < seats.length; j++)
				seats[j] = 0;
		}

		System.out.println("最佳位置： " + (maxPos + 1));
		System.out.println("最大人数： " + maxPeople);

		return maxPeople;

	}

	private void print(int[] seats) {
		// TODO Auto-generated method stub
		for (int i = 0; i < seats.length; i++)
			System.out.print(seats[i] + " ");
		System.out.println();
	}

	private int getNextPos(int[] seats) {
		// TODO Auto-generated method stub
		int bestPos = -1;
		int posScore = 0;
		for (int i = 0; i < seats.length; i++) {
			if (judgePos(seats, i)) {
				if (getScore(seats, i) >= posScore) {
					posScore = getScore(seats, i);
					bestPos = i;
				}
			}
		}

		return bestPos;
	}

	private int getScore(int[] seats, int pos) {
		int left = pos, right = seats.length - pos;

		boolean lHavePeople = false;
		for (int i = pos - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				left = pos - i;
				lHavePeople = true;
				break;
			}
		}

		boolean rHavePeople = false;
		for (int i = pos + 1; i < seats.length; i++) {
			if (seats[i] == 1) {
				right = i - pos;
				rHavePeople = true;
				break;
			}
		}

		if (!lHavePeople)
			left = Integer.MAX_VALUE;
		if (!rHavePeople)
			right = Integer.MAX_VALUE;

		System.out.println(pos + "得分： " + Math.min(left, right));

		return Math.min(left, right);
	}

	private boolean canSeat(int[] seats) {
		// TODO Auto-generated method stub
		for (int i = 0; i < seats.length; i++) {
			if (judgePos(seats, i))
				return true;
		}

		return false;
	}

	private boolean judgePos(int[] seats, int i) {
		// TODO Auto-generated method stub
		if (seats[i] == 1)
			return false;
		if (i - 1 >= 0 && seats[i - 1] == 1)
			return false;
		if (i + 1 < seats.length && seats[i + 1] == 1)
			return false;
		return true;
	}

	int seatMost(int seatNum) {
		if (seatNum <= 0)
			return 0;
		else if (seatNum == 1 || seatNum == 2)
			return 1;
		else {
			int max = 1;
			for (int i = 1; i <= seatNum; i++) {
				max = Math.max(seatMost(seatNum - 1), seatMost(seatNum - 2) + 1);
			}

			return max;
		}

	}
}
