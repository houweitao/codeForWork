package hou.text;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年1月15日 下午2:19:08
 * http://stackoverflow.com/questions/683041/java-how-do-i-use-a-priorityqueue
 */

public class PriorityQueueTest {

	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		while (queue.size() != 0) {
			System.out.println(queue.remove());
		}

		Comparator<Person> myComparator = new MyComparator();
		PriorityQueue<Person> myQueue = new PriorityQueue<Person>(10, myComparator);

		myQueue.add(new Person("hahah", 3));
		myQueue.add(new Person("fasef", 1));
		myQueue.add(new Person("fasfs", 32));

		while (myQueue.size() != 0) {
			System.out.println(myQueue.remove().toString());
		}
	}
}

class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String x, String y) {
		// Assume neither string is null. Real code should
		// probably be more robust
		// You could also just return x.length() - y.length(),
		// which would be more efficient.
		if (x.length() < y.length()) {
			return -1;
		}
		if (x.length() > y.length()) {
			return 1;
		}
		return 0;
	}
}

class MyComparator implements Comparator<Person> {
	@Override
	public int compare(Person a, Person b) {
		if (a.getAge() < b.getAge())
			return -1;
		if (a.getAge() > b.getAge())
			return 1;
		return 0;
	}
}

class Person {
	int age;
	String name;

	@Override
	public String toString() {
		return name + "," + age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}