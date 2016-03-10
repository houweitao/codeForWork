package hou.mianjing.me;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月23日 上午9:22:08
 * 建个文件需要5分钟醉了。2015年11月23日09:28:14
 * http://www.1point3acres.com/bbs/thread-148865-1-1.html
 * 先做个K房子，3颜色的版本吧...
 * @end 2015年11月23日10:37:39
 */

public class PaintHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintHouse ph = new PaintHouse();
		
		long first=System.currentTimeMillis();
		
		List<List<Integer>> ret = ph.paint(10,3);
//		ph.printDoubleList(ret);
		System.out.println(ret.size());
		
		long second=System.currentTimeMillis();
		System.out.println((second-first));
		
		List<List<Integer>> ret2 = ph.paintSaveTime(10, 3);
//		ph.printDoubleList(ret2);
		System.out.println(ret2.size());
		
		long third=System.currentTimeMillis();
		System.out.println((third-second));
	}

	//finish 2015年11月23日09:47:23
	//如果要修改成颜色是输入，只需要修改少量部分即可。
	List<List<Integer>> paint(int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (k < 1)
			return null;
		else if (k == 1) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			ret.add(tmp);
			tmp.clear();
			tmp.add(2);
			ret.add(tmp);
			tmp.clear();
			tmp.add(3);
			ret.add(tmp);
			return ret;
		} else {
			List<List<Integer>> next = new ArrayList<List<Integer>>();
			next = paint(k - 1);
			if (next.size() > 0) {
				for (int i = 0; i < next.size(); i++) {//i: nextIndex
					int notPrint = next.get(i).get(0);
					for (int color = 1; color < 4; color++) {
						ArrayList<Integer> tmp = new ArrayList<>();
						if (color != notPrint) {
							tmp.add(color);
							tmp.addAll(next.get(i));
							ret.add(tmp);
						}
					}
				}
			}

			return ret;
		}
	}
	
	//2015年11月23日10:42:21
	List<List<Integer>> paint(int k,int colorNum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (k < 1)
			return null;
		else if (k == 1) {
			for (int i = 1; i <= colorNum; i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				ret.add(tmp);
			}
			return ret;
		} else {
			List<List<Integer>> next = new ArrayList<List<Integer>>();
			next = paint(k - 1);
			if (next.size() > 0) {
				for (int i = 0; i < next.size(); i++) {//i: nextIndex
					int notPrint = next.get(i).get(0);
					for (int color = 1; color <= colorNum; color++) {
						ArrayList<Integer> tmp = new ArrayList<>();
						if (color != notPrint) {
							tmp.add(color);
							tmp.addAll(next.get(i));
							ret.add(tmp);
						}
					}
				}
			}

			return ret;
		}
	}

	//事实证明并没有节省时间...囧。不过也算是另外一种解法了...
	//2015年11月23日10:37:29
	List<List<Integer>> paintSaveTime(int houseNum, int colorNum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (houseNum < 1)
			return null;
		else if (houseNum == 1) {
			for (int i = 1; i <= colorNum; i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				ret.add(tmp);
			}
			return ret;
		} else {
			List<List<Integer>> aList = new ArrayList<List<Integer>>();
			for (int j = 1; j <= colorNum; j++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(j);
				aList.add(tmp);
			}

			//这个循环很赞~
			for (int i = 2; i <= houseNum; i++) {
				List<List<Integer>> bList = new ArrayList<List<Integer>>();
				for (int k = 0; k < aList.size(); k++) {
					for (int j = 1; j <= colorNum; j++) {
						if (j != aList.get(k).get(aList.get(k).size() - 1)) {//在后面加房子貌似更方便写一些。
							ArrayList<Integer> tmp = new ArrayList<>();
							tmp.addAll(aList.get(k));
							tmp.add(j);
							bList.add(tmp);
						}
					}
				}
//				System.out.println("改变前");
//				printDoubleList(aList);
				aList = new ArrayList<List<Integer>>();
				aList = bList;
//				System.out.println("改变后");
//				printDoubleList(bList);
			}
			return aList;
		}
	}

	void printDoubleList(List<List<Integer>> List) {
		for (int i = 0; i < List.size(); i++) {
			for (int j = 0; j < List.get(i).size(); j++)
				System.out.print(List.get(i).get(j) + ",");
			System.out.println();
		}
		System.out.println(List.size());
	}
}
