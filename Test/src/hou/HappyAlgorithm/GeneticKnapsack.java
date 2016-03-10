package hou.HappyAlgorithm;

/**
 * @author houweitao
 * @date 2015年12月27日 上午10:48:26
 * @notFinished 2015年12月27日13:07:30
 * @success 2015年12月28日11:03:21
 * 好蛋疼。。
 */

public class GeneticKnapsack {

	final int POPULATION = 10;
	final int THINGNUMBER = 7;
	final double P_CROSSOVER = 0.8;
	final double P_MUTATION = 0.15;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneticKnapsack genePack = new GeneticKnapsack();

		Backpack[] pack = genePack.initPack();

		for (int j = 0; j < pack.length; j++) {
			System.out.print(pack[j].toString() + " " + pack[j].cf + "  " + pack[j].getScore() + "  ");
		}
		System.out.println();

		System.out.println(genePack.getScore(pack));

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < 100; i++) {
			genePack.getNextGeneration(pack);//不思其解。这里直接返回值不对，直接操作却对了...
			genePack.crossover(pack);
//			System.out.println("===========");
//			genePack.showStatus(pack);
			genePack.mutation(pack);
			System.out.println(i + "  " + genePack.getScore(pack) / 10);

//			genePack.showStatus(pack);
			max = Math.max(max, genePack.showStatus(pack));
		}
		System.out.println("max: " + max);
	}

	int getScore(Backpack[] packSet) {
		int allScore = 0;
		for (int i = 0; i < packSet.length; i++) {
			allScore = allScore + packSet[i].score;
		}
		return allScore;
	}

	Backpack[] initPack() {
		Backpack[] packSet = new Backpack[POPULATION];
		for (int i = 0; i < POPULATION; i++) {
			packSet[i] = new Backpack();
		}
		setProbability(packSet);
		return packSet;
	}

	private void setProbability(Backpack[] packSet) {
		// TODO Auto-generated method stub
//		setScore(packSet);
		int allScore = 0;
		for (int i = 0; i < packSet.length; i++) {
			allScore = allScore + packSet[i].getScore();
			packSet[i].score = packSet[i].getScore();
		}

//		System.out.println(allScore);

		for (int i = 0; i < packSet.length; i++) {
			packSet[i].rf = (double) packSet[i].getScore() / (double) allScore;
//			packSet[i].cf = 0;
			if (i == 0)
				packSet[0].cf = packSet[0].rf;
			else
				packSet[i].cf = packSet[i - 1].cf + packSet[i].rf;
		}
	}

	private void setScore(Backpack[] packSet) {
		for (int i = 0; i < packSet.length; i++) {
			packSet[i].setScore();
		}
	}

	// 选择算子
	Backpack[] getNextGeneration(Backpack[] packSet) {
		Backpack[] newPack = new Backpack[POPULATION];
		setProbability(packSet);
		for (int i = 0; i < POPULATION; i++) {
			double p = (double) (Math.random());
//			System.out.println(p);
			if (p < packSet[0].cf) {
				newPack[i] = new Backpack(packSet[0].gene);//here
				System.out.print(0 + " ");
			} else if (p > packSet[POPULATION - 2].cf) {
				newPack[i] = new Backpack(packSet[POPULATION - 1].gene);//here
				System.out.print((POPULATION - 1) + " ");
			} else {
				for (int j = 0; j < POPULATION - 1; j++) {
					if (p >= packSet[j].cf && p < packSet[j + 1].cf) {
						//之前是直接==。所以cf rf有问题。现在貌似好了。2015年12月28日01:46:53
						newPack[i] = new Backpack(packSet[j + 1].gene);
						System.out.print((j + 1) + " ");
					}
				}
			}
		}
		System.out.println();
		setProbability(newPack);
		packSet = newPack;
		return newPack;
	}

	// 交叉算子
	void crossover(Backpack[] packSet) {
		for (int i = 0; i < packSet.length; i++) {
			if (Math.random() < P_CROSSOVER) {
//				System.out.println("交配");
				int second = (int) (Math.random() * POPULATION);
				exchangeNeighbor(packSet[i], packSet[second]);
			}
		}
		setProbability(packSet);
	}

	private void exchangeNeighbor(Backpack first, Backpack second) {
		// TODO Auto-generated method stub
		int changeNum = (int) (Math.random() * THINGNUMBER) + 1;
//		System.out.println("num " + changeNum);
		for (int i = 0; i < changeNum; i++) {
			int changePos = (int) (Math.random() * THINGNUMBER);

//			System.out.println(first.gene[changePos]+" "+second.gene[changePos] );

			int tmp = first.gene[changePos];
			first.gene[changePos] = second.gene[changePos];
			second.gene[changePos] = tmp;
//			System.out.println(first.gene[changePos]+" "+second.gene[changePos] );

		}
	}

	// 变异算子
	void mutation(Backpack[] packSet) {
		for (int i = 0; i < packSet.length; i++) {
			if (Math.random() < P_MUTATION) {
				reverseGene(packSet, i);
			}
		}
		setProbability(packSet);//这里如果set了就直接变了？

//		for (int j = 0; j < packSet.length; j++) {
//			System.out.print(packSet[j].toString() + " " + packSet[j].getScore() + "  ");
//		}
//		System.out.println();
	}

	private void reverseGene(Backpack[] packSet, int pos) {
		// TODO Auto-generated method stub
		int mutationNum = (int) (Math.random() * THINGNUMBER) + 1;

		for (int i = 0; i < 1; i++) {
			int mutationPos = (int) (Math.random() * THINGNUMBER);
//			System.out.println(i+" pos: "+mutationPos);
			System.out.println("变异" + pos + " 位置： " + mutationPos);
			System.out.println("before: " + packSet[pos].toString());
			packSet[pos].gene[mutationPos] = 1 - packSet[pos].gene[mutationPos];
			System.out.println("after:  " + packSet[pos].toString());
		}
	}

	private int showStatus(Backpack[] pack) {
		int maxScore = 0;
		for (int i = 0; i < pack.length; i++) {
			System.out.print(pack[i].toString() + " ");
			System.out.print(pack[i].score + " ");
			System.out.print(pack[i].rf + " ");
			System.out.println(pack[i].cf);

			maxScore = Math.max(maxScore, pack[i].score);
		}
		System.out.println("最大值： " + maxScore);
		System.out.println();
		return maxScore;
	}
}

class Backpack {
	int[] gene = new int[7];
	int score;
	double rf;// 选择概率
	double cf;// 累计选择概率
	int[] value = { 35, 30, 60, 60, 40, 10, 25 };

	Backpack(int[] gene) {
		this.gene = gene;
		this.score = getScore();
	}

	Backpack() {
		for (int i = 0; i < value.length; i++) {
			this.gene[i] = Math.random() > 0.5 ? 1 : 0;
		}
		score = getScore();
	}

	public void setScore() {
		int sum = 0;
		for (int i = 0; i < gene.length; i++) {
			if (gene[i] == 1)
				sum = sum + value[i];
		}
		if (sum < 180)
			this.score = sum;
		else
			this.score = 1;
	}

	public int getScore() {
		int sum = 0;
		for (int i = 0; i < gene.length; i++) {
			if (gene[i] == 1)
				sum = sum + value[i];
		}
		if (sum == 0)
			return 1;
		else if (sum < 180)
			return sum;
		else
			return 1;
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < gene.length; i++) {
			ret = ret + gene[i];
		}
		return ret;
	}
}
