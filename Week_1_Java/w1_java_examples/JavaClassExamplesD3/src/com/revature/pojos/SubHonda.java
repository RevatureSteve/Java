package com.revature.pojos;

public class SubHonda extends Honda {

	public SubHonda(String model, int doors, int maxMph) {
		super(model, doors, maxMph);
		System.out.println("Inside SubHonda Constructor");
	}

}
