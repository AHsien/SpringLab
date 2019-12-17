package com.darren;

import java.util.List;

public class Question6 {

	private int id;
	private String name;
	private List<Answer3> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Answer3> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer3> answers) {
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println(id + " " + name);
		System.out.println("answers are :");
		for (Answer3 answer3 : answers) {
			System.out.println(answer3);
		}
	}
}
