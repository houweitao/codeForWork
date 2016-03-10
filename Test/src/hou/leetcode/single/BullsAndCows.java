package hou.leetcode.single;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2015年12月2日 上午12:38:08
 * https://leetcode.com/problems/bulls-and-cows/
 * @end 2015年12月2日01:05:58 我击败了百分之0.16的人..
 * 稀疏矩阵的使用！
 * https://leetcode.com/discuss/67031/one-pass-java-solution
 */

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BullsAndCows bc = new BullsAndCows();
		String secret = "1807";
		String guess = "7810";
		String ret = bc.getHint(secret, guess);
		System.out.println(ret);

		for (int i = 0; i < 4; i++)
			System.out.println(secret.charAt(i) - '0');
	}

	public String getHint(String secret, String guess) {
		int same = 0;
		int almostSame = 0;
		ArrayList<Integer> al = new ArrayList<>();
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				same++;
				al.add(i);
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			if (!al.contains(i)) {
				if (!hs.containsKey(guess.charAt(i)))
					hs.put(guess.charAt(i), 1);
				else
					hs.put(guess.charAt(i), hs.get(guess.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			if (!al.contains(i)) {
				System.out.println("char: " + secret.charAt(i));
				if (hs.containsKey(secret.charAt(i))) {
					almostSame++;
					System.out.println(almostSame + ", " + i + ": " + secret.charAt(i));
					if (hs.get(secret.charAt(i)) == 1)
						hs.remove(secret.charAt(i));
					else
						hs.put(secret.charAt(i), hs.get(secret.charAt(i)) - 1);
				} else
					System.out.println("不包含： " + secret.charAt(i));
			}
		}

		String ret = same + "A" + almostSame + "B";
		return ret;
	}
}
