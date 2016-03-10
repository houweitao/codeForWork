//package hou.leetcode.medium;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map.Entry;
//import java.util.Stack;
//
///**
// * @author houweitao
// * @date 2015年12月22日 上午10:03:55
// * @notFinish 2015年12月22日11:30:34
// * @source https://leetcode.com/problems/course-schedule/
// */
//
//public class CourseSchedule {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[][] prerequisites = { { 1, 2 }, { 0, 1 }, { 1, 3 } };
//		CourseSchedule cs = new CourseSchedule();
//		System.out.println(cs.canFinish(4, prerequisites));
//
//	}
//
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		if (prerequisites.length < 2)
//			return true;
//		else {
//			HashMap<CourseNode, Boolean> hm = new HashMap<>();
//			Stack<CourseNode> stack = new Stack<>();
//			stack.push(new CourseNode(prerequisites[0][0]));
//			hm.put(new CourseNode(prerequisites[0][0]), true);
////			stack.push(new CourseNode(prerequisites[0][1]));
////			hm.put(new CourseNode(prerequisites[0][1]), true);
//
//			if (hm.size() < numCourses) {
//				System.out.println("hm size: " + hm.size());
//				while (!stack.isEmpty()) {
//					System.out.println("stack not empty");
//
//					if (hm.size() >= numCourses)
//						return true;
//
//					CourseNode node = stack.pop();
//					for (int i = 0; i < prerequisites.length; i++) {
//						if (prerequisites[i][0] == node.val) {
//							CourseNode next = new CourseNode(prerequisites[i][1]);
//							System.out.println("??");
//							if (hm.containsKey(next)) {
//								if (reject(hm, next, node)) {
//									System.out.println("合法");
//									if (node.child == null) {
//										LinkedList<CourseNode> child = new LinkedList<>();
//										child.add(new CourseNode(prerequisites[i][0]));
//										node.child = child;
//									} else {
//										node.child.add(new CourseNode(prerequisites[i][0]));
//									}
//								} else
//									return false;
//							} else {
//								hm.put(new CourseNode(prerequisites[i][1]), true);
//								if (hm.size() >= numCourses)
//									return true;
//								stack.push(new CourseNode(prerequisites[i][1]));
//								if (node.child == null) {
//									LinkedList<CourseNode> child = new LinkedList<>();
//									child.add(new CourseNode(prerequisites[i][0]));
//									node.child = child;
//								} else {
//									node.child.add(new CourseNode(prerequisites[i][0]));
//								}
//
//								System.out.println(node.val + "->" + printList(node.child));
//							}
//						} else {
//							hm.put(new CourseNode(prerequisites[i][1]), true);
//							if (hm.size() >= numCourses)
//								return true;
//							stack.push(new CourseNode(prerequisites[i][1]));
//							if (node.child == null) {
//								LinkedList<CourseNode> child = new LinkedList<>();
//								child.add(new CourseNode(prerequisites[i][0]));
//								node.child = child;
//							} else {
//								node.child.add(new CourseNode(prerequisites[i][0]));
//							}
//
//							System.out.println(node.val + "->" + printList(node.child));
//						}
//					}
//				}
//			}
//			return true;
//		}
//
////		for (int i = 0; i < prerequisites.length; i++) {
////			if (!hm.containsKey(prerequisites[i][0])) {
////				hm.put(prerequisites[i][0], true);
////				CourseNode node = new CourseNode(prerequisites[i][0]);
////				for (int j = 1; j < prerequisites.length; j++) {
////					hm.put(prerequisites[j][0], true);
////					CourseNode tmp = new CourseNode(prerequisites[j][0]);
////					if (prerequisites[j][0] == prerequisites[i][1]) {
////						if (node.child == null) {
////							LinkedList<CourseNode> child = new LinkedList<>();
////							child.add(prerequisites[j][1]);
////							node.child = child;
////						}else{
////							
////						}
////					}
////				}
////			}
////		}
//	}
//
//	private String printList(LinkedList<CourseNode> child) {
//		String s = "";
//		for (int i = 0; i < child.size(); i++) {
//			s = s + child.get(i).val + " -> ";
//		}
//		return s;
//	}
//
//	private boolean reject(HashMap<CourseNode, Boolean> hm, CourseNode next, CourseNode node) {
//		// TODO Auto-generated method stub
//
//		for (Entry<CourseNode, Boolean> entry : hm.entrySet()) {
//			if (entry.getKey() == next) {
//				if (next.child.contains(node))
//					return false;
//			}
//		}
//
//		return true;
//	}
//}
//
//class CourseNode {
//	int val;
//	int size;
//	LinkedList<CourseNode> child;
//
//	CourseNode(int val) {
//		this.val = val;
//		size = 1;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		boolean bres = false;
//		if (obj instanceof CourseNode) {
//			CourseNode o = (CourseNode) obj;
//			bres = (this.val == o.val);
//		}
//		return bres;
//	}
//
//	@Override
//	public int hashCode() {
//		return this.val;
//	}
//}