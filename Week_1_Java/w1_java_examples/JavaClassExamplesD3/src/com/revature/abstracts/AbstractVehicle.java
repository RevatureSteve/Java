package com.revature.abstracts;

public abstract class AbstractVehicle {

	protected String model;
	protected int doors;
	public boolean isDriving;
	protected int maxMph;
	
	//Common method for all 
	protected void startEngine(){
		System.out.println("Engine has started");
	}
	
	//different implementation for each subclass
	protected abstract void drive();
	
	public abstract void brake();

	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public boolean isDriving() {
		return isDriving;
	}

	public void setDriving(boolean isDriving) {
		this.isDriving = isDriving;
	}

	public int getMaxMph() {
		return maxMph;
	}

	public void setMaxMph(int maxMph) {
		this.maxMph = maxMph;
	}
	
	
	
	
}
