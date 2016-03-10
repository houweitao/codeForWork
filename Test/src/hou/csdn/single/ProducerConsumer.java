package hou.csdn.single;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月4日 上午9:53:35
 * http://blog.csdn.net/rainnnbow/article/details/50787672
 */

public class ProducerConsumer {
	public static void main(String[] args) {

		// Creates an event storage
		EventStorage storage = new EventStorage();

		// Creates a Producer and a Thread to run it
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);

		// Creates a Consumer and a Thread to run it
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);

		// Starts the thread
		thread2.start();
		thread1.start();
	}

}

class Producer implements Runnable {

	/**
	 * Store to work with
	 */
	private EventStorage storage;

	/**
	 * Constructor of the class. Initialize the storage.
	 * @param storage The store to work with
	 */
	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	/**
	 * Core method of the producer. Generates 100 events.
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.set();
		}
	}
}

class Consumer implements Runnable {

	/**
	 * Store to work with
	 */
	private EventStorage storage;

	/**
	 * Constructor of the class. Initialize the storage
	 * @param storage The store to work with
	 */
	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	/**
	 * Core method for the consumer. Consume 100 events
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();
		}
	}

}

class EventStorage {

	/**
	 * Maximum size of the storage
	 */
	private int maxSize;
	/**
	 * Storage of events
	 */
	private List<Date> storage;

	/**
	 * Constructor of the class. Initializes the attributes.
	 */
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<>();
	}

	/**
	 * This method creates and storage an event.
	 */
	public synchronized void set() {
		while (storage.size() >= maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.printf("Set: %d\n", storage.size());
		notify();
	}

	/**
	 * This method delete the first event of the storage.
	 */
	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>) storage).poll());
		notify();
	}

}