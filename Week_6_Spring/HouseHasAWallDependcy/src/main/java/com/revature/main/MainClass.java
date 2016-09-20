package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.House;

public class MainClass {

	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext is 1 way to get the AC
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		House h = (House) ac.getBean("house");
		System.out.println(h.getWallVariable().getMaterial());
		
		//Change h1 material to Brick
		h.getWallVariable().setMaterial("Brick");

		//What is h2 material?
		House h2 = (House) ac.getBean("house");
		System.out.println(h2.getWallVariable().getMaterial());
	}

}
