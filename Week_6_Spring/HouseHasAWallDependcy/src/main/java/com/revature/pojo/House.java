package com.revature.pojo;

public class House {

	
	private String name = "My Awesome House";
	
	private Wall wallVariable;
	
	public House () {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "House [name=" + name + "]";
	}

	public Wall getWallVariable() {
		return wallVariable;
	}

	public void setWallVariable(Wall wallVariable) {
		this.wallVariable = wallVariable;
	}



	
	
}
