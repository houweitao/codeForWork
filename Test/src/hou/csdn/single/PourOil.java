package hou.csdn.single;

/**
 * @author houweitao 2015年9月8日 上午11:26:35
 *         http://blog.csdn.net/u011479875/article/details/47256309
 */

public class PourOil {

	public static int[] a = { 12, 8, 5 };// 三个桶的容量
	public static int count = 0;// 记录到处方法的个数

	public static void main(String[] args) {
		int[][] f = new int[100][3];// 记录三个桶内容量的变化
		f[0][0] = 12;// 三个桶初始容量为 12 0 0
		f[0][1] = 0;
		f[0][2] = 0;
		DFS(f, 1);// 通过深搜寻找下一桶内容量
	}

	// 深搜
	private static void DFS(int[][] f, int x) {
		if (x > 100) {// 控制最多倒油的次数
			return;
		}
		if (f[x - 1][0] == 6 || f[x - 1][1] == 6 || f[x - 1][2] == 6) {// 只要三个桶中，任意一个桶容量出现6，表示达到目的，退出递归
			count++;
			System.out.print("方法" + count + ":");
			print(f, x);// 输出倒油的过程
			return;
		}
		for (int i = 0; i < 3; i++) {// 三个桶之间互相倒油
			for (int j = 0; j < 3; j++) {
				if (isTrue(f, x, i, j)) {// 能倒油的条件
					DFS(f, x + 1);// 倒油成功，寻找下一个倒油方法
				}
			}
		}
	}

	private static boolean isTrue(int[][] f, int x, int i, int j) {
		if (f[x - 1][i] == 0) {// 要倒油的桶容量为0，则不能倒油
			return false;
		}
		if (f[x - 1][j] == a[j]) {// 接收油的桶已满，则不能倒油
			return false;
		}
		if (i == j) {// 自己不能与自己互相倒油
			return false;
		}
		pourOil(f, x, i, j);// 倒油
		for (int t = 0; t < x; t++) {// 判断在前面是否出现了这种状态，若出现，则不必再倒成这种状态，防止死循环（开始就遗漏了这个，进入死循环了呜呜呜呜）
			if (f[t][0] == f[x][0] && f[t][1] == f[x][1] && f[t][2] == f[x][2]) {
				return false;
			}
		}
		return true;
	}

	private static void pourOil(int[][] f, int x, int i, int j) {
		f[x][0] = f[x - 1][0];
		f[x][1] = f[x - 1][1];
		f[x][2] = f[x - 1][2];
		if (f[x - 1][i] > a[j] - f[x - 1][j]) {// 倒油的桶中的容量，大于被倒桶中剩余的容量
			f[x][i] = f[x - 1][i] - (a[j] - f[x - 1][j]);
			f[x][j] = a[j];
		} else {// 被倒的桶能装下倒油桶内的所有油
			f[x][j] += f[x][i];
			f[x][i] = 0;
		}
	}

	private static void print(int[][] f, int x) {
		for (int i = 0; i < x - 1; i++) {
			System.out.print(f[i][0] + "," + f[i][1] + "," + f[i][2] + " ---> ");
		}
		System.out.println(f[x - 1][0] + "," + f[x - 1][1] + "," + f[x - 1][2]);
	}

}