package mypack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		BeanFactory beanf = new ClassPathXmlApplicationContext("bean_confgration.xml");
		Soldier s = (Soldier)beanf.getBean("soldier");
		s.perform();

	}

}
