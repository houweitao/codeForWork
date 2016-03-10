package hou.HappyAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月14日 下午11:16:50
 * @almost 基本实现但有些小问题 2015年12月15日00:45:22
 * @finished 2015年12月15日01:35:26
 * @一点小改进 可以用一个hashmap存下可以找到出口的点，以及他的路径，这样如果当前的moment是map的一员，那么就直接拼接路径即可。
 * 			 可以消除一点重复计算 2015年12月23日11:22:58
 */

public class PourWater {
	static int time = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PourWater pourWater = new PourWater();
		pourWater.getMethod();
		System.out.println(time);
//		HashMap<Moment, Boolean> hashMap = new HashMap<>();
//		ArrayList<Moment> list = new ArrayList<>();
//		hashMap.put(new Moment(8, 0, 0), true);
//		System.out.println(hashMap.containsKey(new Moment(8, 0, 0)));
//
//		list.add(new Moment(8, 0, 0));
//		System.out.println(list.contains(new Moment(8, 0, 0)));

//		Moment m = new Moment(8, 0, 0);
//		List<Direction> list = m.getNextDir();
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
	}

	void getMethod() {
		Stack<Moment> stack = new Stack<>();
//		HashMap<Moment, Boolean> hashMap = new HashMap<>();
//		ArrayList<Moment> list = new ArrayList<>();
		int count = 0;
		Moment moment = new Moment();
		stack.push(moment);
//		list.add(moment);

		while (!stack.isEmpty()) {
			Moment now = stack.peek();
			System.out.println("栈顶元素： " + now.getTryNum() + ", " + now.getNextDir().size());
			System.out.println(now.toString());
			printPath(stack);
			System.out.println("-----------");
			if (now.getTryNum() >= now.getNextDir().size() - 1) {
				stack.pop();

				if (stack.size() > 0) {
					Moment tmp = stack.pop();
					tmp.setTryNum(tmp.getTryNum() + 1);
					stack.push(tmp);
//				stack.peek().setTryNum(stack.peek().getTryNum() + 1);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println(count + " 种解法！");
					return;
				}
			} else {
				ArrayList<Direction> nextDir = now.getNextDir();
				for (int i = now.getTryNum() + 1; i < nextDir.size(); i++) {
//					now.tryNum++;
//					System.out.println("执行了？");

					time++;

					Direction dir = nextDir.get(i);
					Moment next = null;
					if (dir.getFrom() == 1 && dir.getTo() == 2)
						next = new Moment(now.getCupA() - dir.getWaterNum(), now.getCupB() + dir.getWaterNum(),
								now.getCupC());
					else if (dir.getFrom() == 1 && dir.getTo() == 3)
						next = new Moment(now.getCupA() - dir.getWaterNum(), now.getCupB(),
								now.getCupC() + dir.getWaterNum());
					else if (dir.getFrom() == 2 && dir.getTo() == 1)
						next = new Moment(now.getCupA() + dir.getWaterNum(), now.getCupB() - dir.getWaterNum(),
								now.getCupC());
					else if (dir.getFrom() == 2 && dir.getTo() == 3)
						next = new Moment(now.getCupA(), now.getCupB() - dir.getWaterNum(),
								now.getCupC() + dir.getWaterNum());
					else if (dir.getFrom() == 3 && dir.getTo() == 1)
						next = new Moment(now.getCupA() + dir.getWaterNum(), now.getCupB(),
								now.getCupC() - dir.getWaterNum());
					else if (dir.getFrom() == 3 && dir.getTo() == 2)
						next = new Moment(now.getCupA(), now.getCupB() + dir.getWaterNum(),
								now.getCupC() - dir.getWaterNum());

					if (next.getCupA() == 4 || next.getCupB() == 4) {
						System.out.println("find!!!!");
						System.out.println("第 " + ++count + " 解法");
						stack.push(next);
						printPath(stack);

//						hashset.put(stack.get[0],stack);//避免重复计算的一个小tips
//						return;

						stack.pop();
//						i++;
					} else if (!stack.contains(next)) {
//						list.add(next);
						stack.push(next);
						System.out.println(next.toString());
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;//key point!!
					} else {
						System.out.println("循环路径！！");
//						Moment tmp = stack.pop();
//						tmp.setTryNum(tmp.getTryNum() + 1);
//						stack.push(tmp);
					}

					now.tryNum++;

					if (now.equals(new Moment(1, 7, 0))) {
						System.out.println("已经尝试了： " + now.tryNum);
					}
				}

//				stack.pop();
			}

		}

	}

	private void printPath(Stack<Moment> stack) {
		// TODO Auto-generated method stub
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i).toString() + " -> ");
		}
		System.out.println();
	}
}

/**
 * @author Elvis
 * 2015年12月14日 下午11:45:17
 */
class Moment {
	int cupA;
	int cupB;
	int cupC;

	ArrayList<Direction> nextDir = new ArrayList<>();
	int tryNum;

	public int getTryNum() {
		return tryNum;
	}

	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}

	public void setNextDir(ArrayList<Direction> nextDir) {
		this.nextDir = nextDir;
	}

	public int getCupA() {
		return cupA;
	}

	public void setCupA(int cupA) {
		this.cupA = cupA;
	}

	public int getCupB() {
		return cupB;
	}

	public void setCupB(int cupB) {
		this.cupB = cupB;
	}

	public int getCupC() {
		return cupC;
	}

	public void setCupC(int cupC) {
		this.cupC = cupC;
	}

	public ArrayList<Direction> getNextDir() {
		return nextDir;
	}

//	public void setNextDir(ArrayList<Direction> nextDir) {
//		this.nextDir = nextDir;
//	}

	Moment() {
		this.cupA = 8;
		this.cupB = 0;
		this.cupC = 0;
		this.tryNum = -1;
		setNextDir();
	}

	Moment(int cupA, int cupB, int cupC) {
		this.cupA = cupA;
		this.cupB = cupB;
		this.cupC = cupC;
		this.tryNum = -1;
		setNextDir();
	}

	void setNextDir() {
		if (cupA > 0) {
			if (cupB < 5) {
				nextDir.add(new Direction(1, 2, Math.min(cupA, 5 - cupB)));
			}
			if (cupC < 3) {
				nextDir.add(new Direction(1, 3, Math.min(cupA, 3 - cupC)));
			}
		}

		if (cupB > 0) {
			if (cupA < 8) {
				nextDir.add(new Direction(2, 1, Math.min(cupB, 8 - cupA)));
			}
			if (cupC < 3) {
				nextDir.add(new Direction(2, 3, Math.min(cupB, 3 - cupC)));
			}
		}

		if (cupC > 0) {
			if (cupA < 8) {
				nextDir.add(new Direction(3, 1, Math.min(cupC, 8 - cupA)));
			}
			if (cupB < 5) {
				nextDir.add(new Direction(3, 2, Math.min(cupC, 5 - cupB)));
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";
		ret = "(" + cupA + ", " + cupB + ", " + cupC + ")";
		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bres = false;
		if (obj instanceof Moment) {
			Moment o = (Moment) obj;
			bres = (this.cupA == o.cupA) & (this.cupB == (o.cupB)) & (this.cupC == (o.cupC));
		}
		return bres;
	}
}

class Direction {
	int from;
	int to;
	int waterNum;

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getWaterNum() {
		return waterNum;
	}

	public void setWaterNum(int waterNum) {
		this.waterNum = waterNum;
	}

	Direction(int from, int to, int waterNum) {
		this.from = from;
		this.to = to;
		this.waterNum = waterNum;
	}

	@Override
	public String toString() {
		String ret = "";
		ret = "(" + from + ", " + to + ", " + waterNum + ")";
		return ret;
	}

}