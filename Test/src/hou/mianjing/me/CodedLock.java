package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年12月5日 下午7:44:57
 * @cannotfinish 2015年12月5日20:00:08
 * https://www.zhihu.com/question/38027671
 */

public class CodedLock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CodedLock cl = new CodedLock();
		cl.getKey(1234, 2432);
	}

	void getKey(int firstTry, int key) throws InterruptedException {
		int count = 1;
		if (firstTry == key)
			System.out.println(count);
		else {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(firstTry);
			boolean find = false;
			while (!find) {
				firstTry = firstTry / 10;
				for (int i = 0; i < 10; i++) {
					count++;
					firstTry = firstTry + 1000 * i;
					System.out.println(firstTry);
					if (firstTry == key)
						System.out.println(count);
//					else if (al.contains(firstTry))
//						i++;
					if (i != 9)
						firstTry = firstTry - 1000 * i;

					Thread.sleep(1000);
				}
			}
		}
	}
}
