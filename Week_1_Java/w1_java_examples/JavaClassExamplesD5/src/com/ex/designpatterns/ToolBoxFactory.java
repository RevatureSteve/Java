package com.ex.designpatterns;

public class ToolBoxFactory {
	/**
	 * @param	String "hammer" returns Hammer
	 * @param	String "wrench" returns Wrench
	 */
	public ToolBox workWithTool(String toolType){
		
		//Simple factory but imagine if we had 30+ dependencies 
		//to determine what type of Vehicle and its properties to return
		
		if(toolType.equalsIgnoreCase("hammer")){
			return new Hammer();
		}else if(toolType.equalsIgnoreCase("wrench")){
			return new Wrench();
		}else{
			return null;
		}
		
	}
}
