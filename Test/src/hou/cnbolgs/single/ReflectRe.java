package hou.cnbolgs.single;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author houweitao
 * @date 2015年11月9日 上午9:29:05
 * @source http://www.cnblogs.com/makaruila/p/4852554.html
 */

public class ReflectRe {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<?> clazz = Class.forName("hou.csdn.me.MakeMinNumber");
		//获取的是该类中所有的公有方法，包含继承和实现的方法。
		Method[] methods = clazz.getMethods();
		//获取的是该类中的所有方法，包含私有方法，但不包含继承的方法。
		methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

//		Method method = clazz.getMethod("makeTiny", int[].class);
//		//想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
//		method.setAccessible(true);
//		Object obj = clazz.newInstance();
//		int[] nums = { 0, 0, 6, 9, 3, 2, 3, 1, 5, 1 };
//		method.invoke(obj,  nums);//执行一个方法

		clazz = Class.forName("hou.cnbolgs.single.PersonToReflect");
		//获取的是该类中所有的公有方法，包含继承和实现的方法。
		methods = clazz.getMethods();
		//获取的是该类中的所有方法，包含私有方法，但不包含继承的方法。
		methods = clazz.getDeclaredMethods();
		for (Method method1 : methods) {
			System.out.println(method1);
		}

		Method method = clazz.getMethod("personToReflect2", int.class, String.class); //这里第一个引号内容不能乱写！！得是方法的名字！
		//想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
		method.setAccessible(true);
		Object obj = clazz.newInstance();
		method.invoke(obj, 39, "hehehe");//执行一个方法
//		clazz.getMethod("personToReflect2", int.class, String.class).invoke(obj, 25, "lalalalla");
		clazz.getMethod("sing", String.class).invoke(obj, "lalalalla");
		
		Field[] field=clazz.getFields();
		for (Field f : field) {
			System.out.println(f);
		}

	}

	//获取类中所有的方法。
	public static void method_1() throws Exception {
		Class clazz = Class.forName("hou.csdn.me.MakeMinNumber");
		//获取的是该类中所有的公有方法，包含继承和实现的方法。
		Method[] methods = clazz.getMethods();
		//获取的是该类中的所有方法，包含私有方法，但不包含继承的方法。
		methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		Method method = clazz.getMethod("show", int[].class);
		//想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
		method.setAccessible(true);
		Object obj = clazz.newInstance();
		int[] nums = { 0, 0, 6, 9, 3, 2, 3, 1, 5, 1 };
		method.invoke(obj, new Object[] { nums });//执行一个方法

		clazz = Class.forName("hou.cnbolgs.single.PersonToReflect");
		//获取的是该类中所有的公有方法，包含继承和实现的方法。
		methods = clazz.getMethods();
		//获取的是该类中的所有方法，包含私有方法，但不包含继承的方法。
		methods = clazz.getDeclaredMethods();
		for (Method method1 : methods) {
			System.out.println(method1);
		}

		method = clazz.getMethod("show", int.class, String.class);
		//想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
		method.setAccessible(true);
		obj = clazz.newInstance();
		method.invoke(obj, 39, "hehehe");//执行一个方法
	}

	//获取指定方法；
	public static void method_2() throws Exception {
		Class clazz = Class.forName("hou.csdn.me.MakeMinNumber");
		//获取指定名称的方法。
		Method method = clazz.getMethod("show", int.class, String.class);
		//想要运行指定方法，当然是方法对象最清楚，为了让方法运行，调用方法对象的invoke方法即可，但是方法运行必须要明确所属的对象和具体的实际参数。
		Object obj = clazz.newInstance();
		method.invoke(obj, 39, "hehehe");//执行一个方法
	}

	//想要运行私有方法。
	public static void method_3() throws Exception {
		Class clazz = Class.forName("hou.csdn.me.MakeMinNumber");
		//想要获取私有方法。必须用getDeclearMethod();
		Method method = clazz.getDeclaredMethod("method", null);
		// 私有方法不能直接访问，因为权限不够。非要访问，可以通过暴力的方式。
		method.setAccessible(true);//一般很少用，因为私有就是隐藏起来，所以尽量不要访问。
	}

	//反射静态方法。
	public static void method_4() throws Exception {
		Class clazz = Class.forName("hou.csdn.me.MakeMinNumber");
		Method method = clazz.getMethod("function", null);
		method.invoke(null, null);
	}
}
