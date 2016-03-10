package hou.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import hou.leetcode.structure.GraphNode;

/**
 * @author houweitao
 * @date 2016年3月2日 下午4:11:41 https://leetcode.com/problems/word-ladder/
 * @canNotFinish 2016年3月2日16:28:55
 * @almost 2016年03月02日22:51:26 有偏差。在修改
 *         初步想法：先根据begin，end找出两个graph的集合。分别是开始时queue的元素，以及如果终结集合，如果queue遇到停止添加，
 *         记下距离。比较。
 */

/*
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"] As one shortest transformation is "hit" ->
 * "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 */

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "hot", "dot", "dog", "lot", "log", "hit", "cog", };
		Set<String> wordList = new HashSet<>();
		for (String s : words)
			wordList.add(s);

		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength("hit", "cog", wordList));
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == endWord)
			return 0;
		else {
			HashMap<GraphNode, Integer> depth = same(wordList, beginWord);
			HashMap<GraphNode, List<GraphNode>> neighbor = getNeibhor(depth);
			int min = Integer.MAX_VALUE;
			Queue<GraphNode> queue = new LinkedList<>();

			queue.offer(new GraphNode(beginWord));

			while (!queue.isEmpty()) {
				GraphNode cur = queue.poll();
				List<GraphNode> next = neighbor.get(cur);

				for (GraphNode g : next) {
					int curDep = depth.get(cur);
					int gDep = depth.get(g);
					if (curDep < gDep - 1) {
						depth.put(g, curDep + 1);
						if (g.equals(new GraphNode(endWord)))
							min = Math.min(min, curDep + 1);
						else
							queue.offer(g);
						System.out.println(g.val);
					}
				}

			}

			return min+1;
		}
	}

	HashMap<GraphNode, List<GraphNode>> getNeibhor(HashMap<GraphNode, Integer> hs) {
		HashMap<GraphNode, List<GraphNode>> ret = new HashMap<>();

		for (Entry<GraphNode, Integer> e1 : hs.entrySet()) {
			for (Entry<GraphNode, Integer> e2 : hs.entrySet()) {
				if (yes(e1.getKey().val, e2.getKey().val)) {
					if (ret.get(e1.getKey()) == null) {
						List<GraphNode> list = new LinkedList<>();
						list.add(e2.getKey());
						ret.put(e1.getKey(), list);
					} else
						ret.get(e1.getKey()).add(e2.getKey());
				}
			}
		}
		return ret;
	}

	HashMap<GraphNode, Integer> same(Set<String> wordList, String beginWord) {
		HashMap<GraphNode, Integer> ret = new HashMap<>();
		for (String s : wordList) {
			if (s.equals(beginWord))
				ret.put(new GraphNode(s), 0);
			else
				ret.put(new GraphNode(s), Integer.MAX_VALUE);
		}

		for (Entry<GraphNode, Integer> e1 : ret.entrySet()) {
			for (Entry<GraphNode, Integer> e2 : ret.entrySet()) {
				if (yes(e1.getKey().val, e2.getKey().val)) {
					e1.getKey().neighbor.add(e2.getKey());
				}
			}
		}
		return ret;
	}

	// xiangcha yi ge
	private boolean yes(String s1, String s2) {
		if (s1.equals(s2) || s1.length() != s2.length())
			return false;
		else {
			int sameNum = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i))
					sameNum++;
			}

			if (sameNum + 1 == s1.length())
				return true;
			else
				return false;
		}

	}
}
