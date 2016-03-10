package hou.mianjing.me;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author houweitao 2015年9月10日 下午4:43:50
 */

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> dict = new ArrayList<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		String start = "hit";
		String end = "dug";

		WordLadder wl = new WordLadder();
		wl.wordLadder(start, end, dict);
//		int count = wl.ladderLength(start, end, dict);
//		System.out.println(count);
	}

	void wordLadder(String start, String end, ArrayList<String> dict) {

		Stack<String> road = new Stack<String>();
		ArrayList<String> visited=new ArrayList<String>();
		// =new Stack();

		road.push(start);
		visited.add(start);
		
//		System.out.println(road.peek());
		int num=0;
		int ccc=0;
		while (num<100000) {
			String str = road.peek();
			char[] chars = str.toCharArray();
			for(int i=0;i<str.length();i++){
				for (char c = 'a'; c <= 'z'; c++) {
					
					ccc++;
					
					char bak=chars[i];
					chars[i]=c;
					String word = new String(chars);
					
//					System.out.println(word);
					
					if (word.equals(end)) {
						
						road.push(word);
						System.out.println(road.size());
						System.out.println(ccc);
						
						for(String s:road){
							System.out.println(s);
						}
						
						return;
					}
					
					if(dict.contains(word)&&!visited.contains(word)){
						
//						System.out.println(word);
						
						road.push(word);
						visited.add(word);
					}
					else
						chars[i]=bak;
				}
			}
//			road.pop();
//			visited.clear();
			num++;
		}
		
		System.out.println("no exist");
	}

	public int ladderLength(String start, String end, ArrayList<String> dict) {
		// Use queue to help BFS
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		queue.add(null);

		// Mark visited word
		Set<String> visited = new HashSet<String>();
		visited.add(start);

		int level = 1;

		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str != null) {
				// Modify str's each character (so word distance is 1)
				for (int i = 0; i < str.length(); i++) {
					char[] chars = str.toCharArray();

					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;

						String word = new String(chars);

						// Found the end word
						if (word.equals(end)) {
							// for(String s:visited)
							// System.out.print(s+" ");
							return level + 1;
						}
						// Put it to the queue
						if (dict.contains(word) && !visited.contains(word)) {
							queue.add(word);
							visited.add(word);
						}
					}
				}
			} else {
				level++;

				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}

		return 0;
	}
}
