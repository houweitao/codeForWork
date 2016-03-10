package hou.leetcode.single;

import java.util.LinkedList;

/**
 * @author houweitao
 * @date 2015年11月23日 下午4:41:18
 */

public class MinStack {
	LinkedList<Integer> list = new LinkedList<>();
	int min;

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(2);
		stack.push(0);
		stack.push(3);
		stack.push(0);

		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

	public void push(int x) {
		if (list.size() != 0) {
			list.add(x - min);
			if (x < min)
				min = x;
		} else {
			min = x;
			list.add(x);
		}
	}

	public void pop() {
		int p = list.remove(list.size() - 1);
		if (p < 0)
			min = min - p;
	}

	public int top() {
		if (list.size() == 0)
			return -1;
		else
			return list.getLast() + min;
	}

	public int getMin() {
		return min;
	}
}
