package hou.JulyAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年1月7日 上午12:37:40
 * p72 t23 数组分割。
 * @notfinished 2016年1月7日00:46:04
 * @end 2016年1月7日02:34:40
 * 竟然完美解决了...我是天才..
 * 
 * 简而言之，本身肯定是一个集合。然后从2到数组的size，开始循环。
 * 这样就转化成了，给定一个数组和分组数目n，是否可以存在这样的分组满足，分成n组，每组的加和为sum/n。
 * 这也就是figure的工作了。
 */

public class ArraysSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(4);
		list.add(10);
		list.add(8);
		list.add(8);
		list.add(8);

		ArraysSplit as = new ArraysSplit();

//		Stack<Integer> one = new Stack<>();
//		one.push(3);
//		one.push(4);
//		ArrayList<Integer> ret = as.deal(list, one);
//		as.print(ret);

		List<List<List<Integer>>> ret = as.split(list);
		System.out.println("print!!!!");
		as.printList(ret);

//		Stack<Integer> one = as.findOne(list, 6);
//		System.out.println(one);
	}

	List<List<List<Integer>>> split(ArrayList<Integer> list) {
		List<List<List<Integer>>> ret = new LinkedList<>();
		if (list.size() == 0)
			return ret;
		else {

			int sum = 0;

			for (int i = 1; i <= list.size(); i++) {
				List<Integer> tmp = new LinkedList<>();
				List<List<Integer>> tmp2 = new LinkedList<>();
				if (i == 1) {
					for (int j = 0; j < list.size(); j++) {
						tmp.add(list.get(j));
						sum = sum + list.get(j);
					}
					System.out.println("sum: " + sum);
					tmp2.add(tmp);
					ret.add(tmp2);
				} else {
					if (sum % i == 0) {
						System.out.println(i + " 个分组， 每个分组的和为: " + sum / i);
						ArrayList<Integer> now = new ArrayList<>();
						for (int ind : list) {
							now.add(ind);
						}
						List<List<Integer>> l = new LinkedList<>();
						l = figure(now, i, sum / i);
						if (l != null && l.size() != 0) {
							System.out.println("l size: " + l.size());
							ret.add(l);
						}
					}
				}
			}
		}
		return ret;

	}

	List<List<Integer>> figure(ArrayList<Integer> list, int n, int target) {
		System.out.println("-------");
		print(list);
		System.out.println(n + " 个分组， 每个分组和为： " + target);
		System.out.println("-------");

		List<List<Integer>> ret = new LinkedList<>();
		int sum = 0;
		for (int i : list) {
			sum = sum + i;
		}

		if (sum % n != 0)
			return null;
		else if (n == 1) {
			if (sum == target) {
				List<Integer> tmp = new LinkedList<>();
				for (int i : list) {
					tmp.add(i);
				}
				ret.add(tmp);
			}
			return ret;
		} else {
			ArrayList<Integer> newList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == target) {
					List<Integer> tmp = new LinkedList<>();
					tmp.add(target);
					ret.add(tmp);
				} else if (list.get(i) > target)
					return null;
				else
					newList.add(list.get(i));
			}

			if (ret.size() == list.size())
				return ret;
			else if (ret.size() != 0) {
				List<List<Integer>> next = figure(newList, n - ret.size(), target);
				if (next != null)
					ret.addAll(next);
				return ret;
			} else {
				// can not finish...
				while (list.size() > 0) {
					Stack<Integer> one = findOne(list, target);
					System.out.println("stack one");
					printStack(one, list);

					List<Integer> tmp = new LinkedList<>();
					if (one != null) {
						ArrayList<Integer> l = new ArrayList<>();
						for (int k = 0; k < one.size(); k++) {
							l.add(list.get(one.get(k)));
						}
						tmp.addAll(l);
						list = deal(list, one);
						System.out.println("after");
						print(list);
					} else
						return null;

					ret.add(tmp);
				}

				return ret;
			}
		}
	}

	private void print(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		for (int i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	private ArrayList<Integer> deal(ArrayList<Integer> list, Stack<Integer> one) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0, j = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println(list.get(one.get(j)));

			if (list.get(i) == list.get(one.get(j))) {
				System.out.println("跳过");
				if (j < one.size() - 1)
					j++;
			} else {
				System.out.println("no ==");
				ret.add(list.get(i));
			}
		}
		return ret;
	}

	private Stack<Integer> findOne(ArrayList<Integer> list, int target) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		int i = 0;

		while ((!stack.isEmpty() || i >= 0) && (i < list.size())) {
//			System.out.println("循环");
//			printStack(stack, list);
			if (stack.isEmpty())
				stack.push(i);

			int sum = count(stack, list);
//			System.out.println("sum: " + sum);

			if (sum < target) {
				if (stack.peek() + 1 < list.size())
					stack.push(stack.peek() + 1);
				else {
					stack.pop();
					if (!stack.isEmpty())
						stack.push(stack.pop() + 1);
				}

			} else if (sum == target) {
				System.out.println("find one !!");
				printStack(stack, list);
				return stack;
			} else {
				stack.pop();
				if (!stack.isEmpty()) {
					int push = stack.pop() + 1;
//					System.out.println("push: "+push+", "+list.get(push));
					stack.push(push);
				}
			}

			if (stack.isEmpty())
				i++;
		}
		return null;
	}

	private void printStack(Stack<Integer> stack, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (stack == null) {
			System.out.println("cannot print");
			return;
		}

		System.out.println("%%%");
		for (int i = 0; i < stack.size(); i++)
			System.out.print(stack.get(i) + ",");
		System.out.println();

		for (int i = 0; i < stack.size(); i++)
			System.out.print(list.get(stack.get(i)) + ",");
		System.out.println();
		System.out.println("%%%");
	}

	private int count(Stack<Integer> stack, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum = sum + list.get(stack.get(i));
		}

		return sum;
	}

	void printList(List<List<List<Integer>>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + ",");
			}
			System.out.println();
		}

		System.out.println(list.size());
	}
}
