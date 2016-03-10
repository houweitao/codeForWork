package hou.mianjing.me;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年2月22日 上午11:31:34
 * @end 2016年2月22日11:43:29
 * @update 2016年2月22日12:24:46
 * http://www.1point3acres.com/bbs/thread-172675-1-1.html
 */

public class PossibleAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PossibleAdd pa = new PossibleAdd();
		List<String> list = pa.getPossibleAdd(10, 1);
		pa.pintList(list);
	}

	// no order
	List<String> getPossibleAdd(int n) {
		List<String> ret = new LinkedList<>();
		if (n < 0)
			return null;
		else if (n == 0)
			return ret;
		else if (n == 1) {
			ret.add(1 + "");
			return ret;
		} else {
			for (int i = 1; i <= n; i++) {
				List<String> next = getPossibleAdd(n - i);
				if (next != null) {
					if (next.size() > 0)
						for (int j = 0; j < next.size(); j++)
							ret.add(i + "," + next.get(j));
					else
						ret.add(i + "");
				}
			}

			return ret;
		}
	}

//	unique
	List<String> getPossibleAdd(int n, int last) {
		List<String> ret = new LinkedList<>();
		if (n < 0)
			return null;
		else if (n == 0)
			return ret;
		else if (n > 0 && n < last) {
//			ret.add(last + "");
			return null;
		} else {
			for (int i = last; i <= n; i++) {
				List<String> next = getPossibleAdd(n - i, i);
				if (next != null) {
					if (next.size() > 0)
						for (int j = 0; j < next.size(); j++)
							ret.add(i + "," + next.get(j));
					else
						ret.add(i + "");
				}
			}

			return ret;
		}
	}

	void pintList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
