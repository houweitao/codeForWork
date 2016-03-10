package hou.cnbolgs.single;

/**
 * @author houweitao
 * @date 2015年10月20日 下午4:33:24
 * http://www.cnblogs.com/0201zcr/p/4858607.html
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester2 {

	//方法实现对Customer对象的拷贝操作
	public Object copy(Object object) throws Exception {
		Class<?> classType = object.getClass();

		Object ObjectCopy = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});

		//获得成员变量

		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();

			String firstLetter = name.substring(0, 1).toUpperCase(); //将属性的首字母转换为大写

			String getMethodName = "get" + firstLetter + name.substring(1);

			String setMethodName = "set" + firstLetter + name.substring(1);

			Method getMethod = classType.getMethod(getMethodName, new Class[] {});

			Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });

			Object value = getMethod.invoke(object, new Object[] {});

			setMethod.invoke(ObjectCopy, new Object[] { value });

		}

		return ObjectCopy;
	}

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer("tom", 20);

		customer.setId(1L);

		ReflectTester2 test = new ReflectTester2();

		Customer cus = (Customer) test.copy(customer);

		System.out.println(cus.getAge() + "," + cus.getName() + "," + cus.getId());
	}

}