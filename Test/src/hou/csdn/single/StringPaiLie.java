package hou.csdn.single;

/**
 * @author houweitao 2015年9月8日 上午11:48:14
 *         http://blog.csdn.net/qq112928/article/details/23847695
 *         未完成
 */

public class StringPaiLie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPaiLie sp = new StringPaiLie();
		sp.paiLie("abc", 0);

	}

	void paiLie(String s, int i) {
		if (i > s.length() - 1)
			return;
		else if (i == s.length() - 1) {
			System.out.print(s.charAt(i));
			return;
		} else {
			for (int j = i; j < s.length(); j++) {
				String tmp = null;

				for (int k = 0; k < s.length(); k++) {
					if (k == i)
						tmp = tmp + s.charAt(j);
					else if (k == j)
						tmp = tmp + s.charAt(i);
					else
						tmp = tmp + s.charAt(k);
					System.out.println(tmp);
				}

				System.out.println(tmp);

				paiLie(tmp, i + 1);
				// s=tmp;
			}
		}
	}

}
