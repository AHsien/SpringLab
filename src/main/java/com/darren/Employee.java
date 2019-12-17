package com.darren;

public class Employee {

	private int id;
	private String name;
	private Address address;// Aggregation
	private Address2 address2;

	public Employee() {
		System.out.println("def cons");
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Employee(int id, String name, Address2 address2) {
		super();
		this.id = id;
		this.name = name;
		this.address2 = address2;
	}

	void show() {
		System.out.println(id + " " + name);
		System.out.println(address.toString());
	}

	void show2() {
		System.out.println(id + " " + name);
		System.out.println(address2.toString());
	}

}