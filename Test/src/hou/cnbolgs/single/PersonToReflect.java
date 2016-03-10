package hou.cnbolgs.single;

/**
 * @author houweitao
 * @date 2015年11月9日 上午9:44:58
 */

public class PersonToReflect {
	String name;
	int age;

	PersonToReflect() {
		this.name = "null";
		this.age = 1;
	}

	PersonToReflect(int age, String name) {
		this.name = name;
		this.age = age;
		System.out.println("do");
	}
	
	public void personToReflect2(int age, String name) {
		this.name = name;
		this.age = age;
		System.out.println("do");
	}
	
	public void sing(String s){
		System.out.println("lalala "+s);
	}
}
