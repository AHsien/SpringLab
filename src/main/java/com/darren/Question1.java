package com.darren;

import java.util.Iterator;
import java.util.List;

public class Question1 {

	private int id;
	private String name;
	private List<String> answers;

	public Question1() {

	}

	public Question1(int id, String name, List<String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println(id + " " + name);
		System.out.println("answers are:");
		Iterator<String> itr = answers.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}