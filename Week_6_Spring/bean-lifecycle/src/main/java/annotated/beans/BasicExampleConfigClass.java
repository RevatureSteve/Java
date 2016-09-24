package annotated.beans;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import beans.ParentBean;
import beans.ProcessorBean;

/**
 * My Spring beans configuration "file"
 * @author Owner
 *
 */
@Configuration //this class only purpose is Spring bean configuration
public class BasicExampleConfigClass {

	private ParentBean jon;
	private ProcessorBean bppb;
	
	@Bean(initMethod="myCustomInitializationMethod",
			destroyMethod="customDestroyMethod", 
			autowire=Autowire.NO)
	@Scope("singleton")
	public ParentBean jon(){
		return new ParentBean();
	}
	@Bean
	public ProcessorBean bppb(){
		return new ProcessorBean();
	}
}







