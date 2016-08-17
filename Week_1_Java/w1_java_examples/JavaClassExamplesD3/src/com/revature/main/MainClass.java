package com.revature.main;

import com.revature.pojos.SubHonda;

public class MainClass {

	public static void main(String[] args) {
		//Changed Honda to SubHonda
		SubHonda civic = new SubHonda("Civic",2,125);
		
		System.out.println();
		System.out.println(civic.getMaxMph());
		System.out.println("Civic is driving: " + civic.isDriving);
		civic.drive();
		System.out.println("Civic is driving: " + civic.isDriving);
		civic.increaseVehicleSpeed();
		civic.increaseVehicleSpeed();
		System.out.println(civic.getMaxMph());
		civic.increaseVehicleSpeed();
		civic.increaseVehicleSpeed();
		System.out.println(civic.getMaxMph());

	}

}
