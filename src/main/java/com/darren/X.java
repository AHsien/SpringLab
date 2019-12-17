package com.darren;

public class X {

	private static final X obj = new X();

	private X() {
		System.out.println("private constructor");
	}

	public static X getX() {
		System.out.println("factory method");
		return obj;
	}

	public void msg() {
		System.out.println("hello user");
	}
}
