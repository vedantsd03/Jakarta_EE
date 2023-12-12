package mypack;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("tech.xml");
		 Soldier soldier=(Soldier)bf.getBean("soldier");
	        soldier.perform();
	}
}
