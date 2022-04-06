package org.iamsspm07.springCore.Assignment2April02;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AudiEngine {
	
		BeanFactory factory =new ClassPathXmlApplicationContext("\\org\\iamsspm07\\springCore\\Assignment2April02\\EngineContext.xml");
		Engine bean =(Engine) factory.getBean("eng");
		
		public void engineFunctionStart() {
			bean.startEngine();
	}
		public void engineFunctionStop() {
			bean.stopEngine();


}
	
	public static void main(String[] args) {
		AudiEngine ae = new AudiEngine();
		ae.engineFunctionStart();
		ae.engineFunctionStop();
	}
}
