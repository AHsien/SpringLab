package com.darren.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");

		// int status = dao.saveEmployee(new Employee(102, "Jack", 35000));
		// System.out.println(status);
		//
		// dao.saveEmployeeByPreparedStatement(new Employee(103, "Andy", 40000));
		//
		// List<Employee> list = dao.getAllEmployees();
		//
		// for (Employee e : list) {
		// System.out.println(e);
		// }

		List<Employee> rowMapperList = dao.getAllEmployeesRowMapper();

		for (Employee e : rowMapperList) {
			System.out.println(e);
		}
	}

}
