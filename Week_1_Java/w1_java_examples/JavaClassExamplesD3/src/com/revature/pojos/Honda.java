package com.revature.pojos;

import com.revature.abstracts.AbstractVehicle;
import com.revature.abstracts.Turbo;

public class Honda extends AbstractVehicle implements Turbo {

	//Constructor for my Honda Class
	public Honda(String model, int doors, int maxMph){
		System.out.println("Honda Constructor");
		this.model = model;
		this.doors = doors;
		this.maxMph = maxMph;
	}
	
	@Override
	public void drive() {
		System.out.println("Started Driving");
		this.isDriving = true;
	}

	@Override
	public void brake() {
		System.out.println("Stopped Driving");
		this.isDriving = false;
		
	}

	@Override
	public String toString() {
		return "Honda [model=" + model + ", doors=" + doors + ", isDriving=" + isDriving + ", maxMph=" + maxMph + "]";
	}

	@Override
	public void increaseVehicleSpeed() {
		this.maxMph += Turbo.turboSpeed;//turboSpeed speed is Static, we did not inherit
										//Only inherited the abstract method
		
	}

	
}
