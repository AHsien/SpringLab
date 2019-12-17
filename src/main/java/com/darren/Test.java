package com.darren;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {

		// Usually, the implementations use lazy loading, which means that beans are only instantiating when we directly
		// calling them through the getBean() method
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);


		// ApplicationContext is BeanFactory's sub-interface
		// must add spring-expression.jar
		// It uses eager loading, so every bean instantiate after the ApplicationContext is started up.
		// ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


		// Student student = (Student) factory.getBean("studentbean");
		// student.displayInfo();


		/**
		 * Dependency Injection by Constructor
		 */
		// Employee emp = (Employee) factory.getBean("emp");
		// emp.show();


		// Question1 question1 = (Question1) factory.getBean("question1");
		// question1.displayInfo();


		// Question2 question2 = (Question2) factory.getBean("question2");
		// question2.displayInfo();


		// Question3 question3 = (Question3) factory.getBean("question3");
		// question3.displayInfo();


		// Question4 question4 = (Question4) factory.getBean("question4");
		// question4.displayInfo();


		// Employee emp2 = (Employee) factory.getBean("emp2");
		// emp2.show2();


		/**
		 * Dependency Injection by setter method
		 */
		// Employee2 emp3 = (Employee2) factory.getBean("emp3");
		// emp3.dispaly();


		// Employee3 emp4 = (Employee3) factory.getBean("emp4");
		// emp4.displayInfo();


		// Question5 question5 = (Question5) factory.getBean("question5");
		// question5.displayInfo();


		// Question6 question6 = (Question6) factory.getBean("question6");
		// question6.displayInfo();


		// Question7 question7 = (Question7) factory.getBean("question7");
		// question7.dispalyInfo();


		// Question8 question8 = (Question8) factory.getBean("question8");
		// question8.displayInfo();


		/**
		 * Autowire
		 */
		// A a = (A) factory.getBean("a");
		// a.dispaly();


		// A a1 = (A) factory.getBean("a1");
		// a1.dispaly();


		// A a2 = (A) factory.getBean("d");
		// a2.dispaly();


		/**
		 * Factory Method
		 */
		// X x = (X) factory.getBean("x");
		// x.msg();

		// Printable printable = (Printable) factory.getBean("printable");
		// printable.print();

		Printable printable2 = (Printable) factory.getBean("printable2");
		printable2.print();
	}
}