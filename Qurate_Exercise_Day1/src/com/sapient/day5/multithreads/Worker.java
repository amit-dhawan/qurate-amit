package com.sapient.day5.multithreads;

public class Worker extends Thread {
	Work w;

	public Worker(Work w) {
		this.w = w;
	}

	@Override
	public void run() {
		w.workUnit();
	}

}
