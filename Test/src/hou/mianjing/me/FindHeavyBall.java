package hou.mianjing.me;

/**
 * @author houweitao 2015年9月18日 上午10:49:13
 *         http://www.1point3acres.com/bbs/thread-141804-1-1.html
 */

public class FindHeavyBall {

	public int findHeavy(int[] balls_array) {
		// return index of the heavier ball
		return getIndex(balls_array, 0, balls_array.length - 1);
	}

	public int getIndex(int[] array, int start, int end) {
		// the function to get index
		// Time complexity: O(log3(N))
		if (start == end) {
			return start;
		}
		double len = (double) (end - start + 1) / 3;
		int size = (int) Math.ceil(len);
		
//		System.out.println(size);
		
		int oneThird = start + size;
		int twoThird = start + size + size;
		// suppose the time complexity of weighing is O(1)
		if (getWeight(array, start, oneThird - 1) == getWeight(array, oneThird, twoThird - 1)) {
			return getIndex(array, twoThird, end);
		} else if (getWeight(array, start, oneThird - 1) > getWeight(array, oneThird, twoThird - 1)) {
			return getIndex(array, start, oneThird - 1);
		} else {
			return getIndex(array, oneThird, twoThird - 1);
		}
	}

	public int getWeight(int[] array, int start, int end) {
		// a function return the total weight
		int totalWeight = 0;
		for (int i = start; i <= end; i++) {
			totalWeight += array[i];
		}
		return totalWeight;
	}

	public static void main(String[] args) {
		int[] array = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 ,1};
		FindHeavyBall fhb = new FindHeavyBall();
		System.out.println(fhb.findHeavy(array));
	}
}
