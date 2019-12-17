package com.darren;

public class A {

	// property name 須與 bean id 相同 (byName Mode)
	B b1;
	C c;

	A() {
		System.out.println("a is created");
	}

	A(C c) {
		this.c = c;
	}

	public B getB1() {
		return b1;
	}

	public void setB1(B b1) {
		this.b1 = b1;
	}

	void print() {
		System.out.println("hello a");
	}

	void dispaly() {
		print();
		if (b1 != null) {
			b1.print();
		}
		if (c != null) {
			c.print();
		}
	}
}
