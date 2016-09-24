package base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.DAO;
import database.SessionFactory;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aop-beans.xml");
		DAO bean = context.getBean("dao", DAO.class);
		SessionFactory sf = bean.getSessionFactory();
		System.out.println(sf);
		//bean.getSomething("dan");
		//bean.getSomething(10);
		//bean.getSomethingElse(12, 34);
	}
	
}
