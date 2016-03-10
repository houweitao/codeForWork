package hou.csdn.single;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author houweitao 2015年8月18日 下午12:16:34
 *         http://blog.csdn.net/qingchunweiliang/article/details/47684455
 */

public class DeleteListItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
			al.add(i);

		for (int i = 0; i < al.size(); i++) {
			System.out.println(i + ": " + al.get(i));
		}

		Iterator it = al.iterator();
		int index = 0;
		while (it.hasNext()) {
			// Object obj = it.next();
			int tmp = (int) it.next();
			if (needDelete(tmp)) // needDelete返回boolean，决定是否要删除
			{
				// todo delete
				it.remove();
			}
			index++;
		}

		for (int i = 0; i < al.size(); i++) {
			System.out.println(i + ": " + al.get(i));
		}

	}

	private static boolean needDelete(int obj) {
		// TODO Auto-generated method stub
		if (obj % 3 == 0)
			return true;
		else
			return false;
	}

}
