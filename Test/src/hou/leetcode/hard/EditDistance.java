package hou.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年12月1日 上午12:24:24
 * @wrong 2015年12月1日00:49:54
 * https://leetcode.com/problems/edit-distance/
 */

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		int dis = ed.minDistance("kitten", "sitting");
		System.out.println(dis);
	}

	public int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();

		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		ArrayList<Character> repet = new ArrayList<>();
		int count = 0;

		for (int i = 0; i < word1.length(); i++) {
			if (!hs.containsKey(word1.charAt(i)))
				hs.put(word1.charAt(i), 1);
			else {
				hs.put(word1.charAt(i), hs.get(word1.charAt(i)) + 1);
			}
		}

//		for(Entry<Character, Integer> entry:hs.entrySet()){
//			System.out.println(entry.getKey()+", "+entry.getValue());
//		}

		for (int i = 0; i < word2.length(); i++) {
			if (hs.containsKey(word2.charAt(i))) {
				count++;
				repet.add(word2.charAt(i));
				if (hs.get(word2.charAt(i)) == 1) {
					hs.remove(word2.charAt(i));
				} else {
					hs.put(word2.charAt(i), hs.get(word2.charAt(i)) - 1);
				}
			}
		}

//		int help=0;
//		for(int i=0;i<repet.size();i++)
//		{
//			if(word1.charAt(0)==repet.get(i)&&word2.charAt(0)!=repet.get(i))
//				help++;
//			if(word1.charAt(word1.indexOf(word1.length()-1))==repet.get(i)&&word2.charAt(word1.length()-1)!=repet.get(i))
//				help++;
//		}
		
		int maxLength = word1.length() > word2.length() ? word1.length() : word2.length();
		return maxLength - count;
	}
}
