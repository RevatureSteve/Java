package annotated.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctxt = 	new AnnotationConfigApplicationContext(	BasicExampleConfigClass.class );
		System.out.println(ctxt.getBean("jon"));
	}
}
