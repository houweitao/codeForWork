package hou.cnbolgs.single;

import java.lang.reflect.Constructor;

/**
 * @author houweitao
 * 2015年10月20日 下午4:24:14
 * http://www.cnblogs.com/0201zcr/p/4858607.html
 */

public class ReflectTester {

	//方法实现对Customer对象的拷贝操作
	public Object copy(Object object) throws Exception {
		Class<?> classType = object.getClass();
		/*Constructor cons = classType.getConstructor(new Class[]{});
		
		Object obj = cons.newInstance(new Object[]{});
		System.out.println(obj);
		System.out.println("-----------");*/

		//以上的两行代码等价于下面一行
		//Object obj2 = classType.newInstance();
		
//		Object obj3 = classType.newInstance();
//		System.out.println(obj3);
		
		Constructor<?> cons2 = classType.getConstructor(new Class[] { String.class, int.class });
		Object obj2 = cons2.newInstance(new Object[] { "hello", 3 });
		System.out.println(obj2);
//		System.out.println(obj2.toString());

		return null;
	}

	public static void main(String[] args) throws Exception {
		ReflectTester test = new ReflectTester();
		test.copy(new Customer());
	}

}

class Customer {
	private Long id;

	private int age;

	private String name;

	public Customer() {

	}

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

//	public Object newInstance(){
//		return new Customer("test",20);
//	}

	@Override 
	public String toString(){
//		System.out.println(name+" "+age);
		String return_ = name+" "+age;
		return return_;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
