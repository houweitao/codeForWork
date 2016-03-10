package hou.mianjing.me;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2016年2月24日 下午4:53:41
 * @end 2016年2月24日17:02:52 简陋版本
 * http://www.1point3acres.com/bbs/thread-160484-1-1.html
 */

public class RainyStreet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RainyStreet rs = new RainyStreet();
		rs.howMany(100);
	}

	int howMany(int length) {
		int time = 0;
		HashMap<Integer, Integer> record = new HashMap<>();
		boolean end = false;

		while (!end) {
			int cur = (int) (Math.random() * length);

			if (!record.containsKey(cur)) {
				record.put(cur, 1);
				if (record.size() == length)
					return time;
			} else
				record.put(cur, record.get(cur)+1);

			System.out.println(++time + ": " + cur + " , " + record.get(cur));
		}
		return time;
	}

}
