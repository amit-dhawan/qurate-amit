package com.sapient.day5.multithreads;

public class WorkTest {

	public static void main(String[] args) {

		Work work = new Work();

		Worker worker1 = new Worker(work);
		Worker worker2 = new Worker(work);
		Worker worker3 = new Worker(work);
		Worker worker4 = new Worker(work);
		Worker worker5 = new Worker(work);

		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(worker2);
		Thread t3 = new Thread(worker3);
		Thread t4 = new Thread(worker4);
		Thread t5 = new Thread(worker5);

		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t3.setName("Thread-3");
		t4.setName("Thread-4");
		t5.setName("Thread-5");

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t4.start();
		try {
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t5.start();
		try {
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
