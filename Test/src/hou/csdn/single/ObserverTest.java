package hou.csdn.single;

import java.util.Observable;
import java.util.Observer;

/**
 * @author houweitao
 * @date 2015年11月3日 下午4:31:32
 * http://blog.csdn.net/kongxx/article/details/49516829
 */

/*
Observer接口

这个接口定义了一个update()方法，当被观察者对象的状态发生变化时，这个方法就会被调用。
这个方法的实现类应当调用每一个被观察者对象的notifyObservers()方法，从而通知所有的观察对象。

Observable类

被观察者类都是java.util.Observable类的子类。 
这个类主要提供下面几个方法： 
setChanged() - 被调用之后会设置一个内部标记变量，代表被观察者对象的状态发生了变化。 
notifyObservers() - 被调用时，会调用所有登记过的观察者对象的update()方法，使这些观察者对象可以更新自己。 
addObserver() - 添加观察者对象。
*/

public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventObservable eventObservable = new EventObservable("My Event Observer");
		eventObservable.addObserver(new EventObserver("Event Observer 1"));
		eventObservable.addObserver(new EventObserver("Event Observer 2"));
		eventObservable.addObserver(new EventObserver("Event Observer 3"));
		eventObservable.doSomeChanges();
		eventObservable.doSomeChanges();
		eventObservable.doSomeChanges();
	}

}

class EventObservable extends Observable {
	private String name = null;

	public EventObservable(String name) {
		this.name = name;
	}

	public void doSomeChanges() {
		this.setChanged();
		this.notifyObservers("out: " + System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return this.name;
	}
}

class EventObserver implements Observer {
	private String name = null;

	public EventObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		EventObservable eventObservable = (EventObservable) o;
		System.out.println("changed");
		System.out.printf("%s, %s, %s \n", this.name, eventObservable, arg);
	}

	@Override
	public String toString() {
		return this.name;
	}
}