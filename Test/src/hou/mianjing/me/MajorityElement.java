package hou.mianjing.me;

/**
 * @author houweitao 2015年9月18日 上午11:01:20
 *         http://www.1point3acres.com/bbs/thread-141783-1-1.html
 *         https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 */

public class MajorityElement {

	public int majorityElement(int[] num) {
		int n = num.length;
		int candidate = num[0], counter = 0;
		// num中的数
		for (int i : num) {
			if (counter == 0) {
				candidate = i;
				counter = 1;
			} else {
				if (i == candidate)
					counter++;
				else
					counter--;
			}
		}

		System.out.println(candidate);

		counter = 0;
		for (int i : num) {
			if (i == candidate)
				counter++;
		}

		if (counter < (n + 1) / 2)
			return -1;
		return candidate;
	}

	public static void main(String[] args) {
		MajorityElement s = new MajorityElement();
		System.out.format("%d\n", s.majorityElement(new int[] { 1, 2, 3 }));
		System.out.format("%d\n", s.majorityElement(new int[] { 2, 2, 3 }));
	}
}
