package com.sapient.day5.multithreads;

public class Work {
	
	
	public void workUnit() {
		
		for(int i=1; i <=50; i++) {
			System.out.println("Current thread is: " + Thread.currentThread().getName());
			System.out.println("number: " + i);
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
