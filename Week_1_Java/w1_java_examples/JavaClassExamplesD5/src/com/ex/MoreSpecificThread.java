package com.ex;

public class MoreSpecificThread extends Thread{

	@Override
	public void run() {
		
		for(int i = 0; i < 20; i++){
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}
	
	

}
