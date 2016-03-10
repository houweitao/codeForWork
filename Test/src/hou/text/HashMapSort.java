package hou.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2015年12月3日 下午4:36:33
 * http://www.cnblogs.com/lovebread/archive/2009/11/23/1609121.html
 */

public class HashMapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapSort hms=new HashMapSort();
		hms.sort();
	}

	void sort() {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("d", 2);
		map.put("c", 1);
		map.put("b", 1);
		map.put("a", 3);

		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		//排序前
		for (int i = 0; i < infoIds.size(); i++) {
			String id = infoIds.get(i).toString();
			System.out.println(id);
		}
		//d 2
		//c 1
		//b 1
		//a 3

		//排序
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				//return (o2.getValue() - o1.getValue()); 
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});

		//排序后
		for (int i = 0; i < infoIds.size(); i++) {
			String id = infoIds.get(i).toString();
			System.out.println(id);
		}

	}

}
