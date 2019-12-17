package com.darren;

public class PrintableFactory {

	public static Printable getPrintable() {
		return new PrintableA();
	}
}
