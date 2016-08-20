package com.ex;

public class MainClass {

	public static void main(String[] args) {
		
		//First way of creating and starting a thread
		Runnable job = new MyRunnable(); //job
		Thread worker1 = new Thread(job); //worker
//		
		worker1.start();
		
		//Second way
		Thread worker2 = new MoreSpecificThread();
		worker2.start();
		
		for(int i = 0; i < 20; i++){
			System.out.println(Thread.currentThread().getName());
		}

	}

}
