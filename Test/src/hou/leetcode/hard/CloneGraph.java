//package hou.leetcode.hard;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2015年11月24日 上午11:18:28
// */
//
//public class CloneGraph {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//		if (node == null)
//			return null;
//		
//		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
//		HashMap<UndirectedGraphNode,Integer> hs=new HashMap<>();
//		
//		for (UndirectedGraphNode n : node.neighbors) {
////			if (!copy.neighbors.contains(n)) {
//			if(!hs.containsKey(n)){
//				hs.put(cloneGraph(n), 1);
//				if (n != copy)
//					copy.neighbors.add(cloneGraph(n));
//				else
//					copy.neighbors.add(new UndirectedGraphNode(copy.label));
//			}
//			else{
//				copy.neighbors.add(cloneGraph(n));
//			}
//		}
//
//		return copy;
//	}
//}
//
//class UndirectedGraphNode {
//	int label;
//	List<UndirectedGraphNode> neighbors;
//
//	UndirectedGraphNode(int x) {
//		label = x;
//		neighbors = new ArrayList<UndirectedGraphNode>();
//	}
//};