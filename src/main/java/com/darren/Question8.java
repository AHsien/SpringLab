package com.darren;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Question8 {

	private int id;
	private String name;
	private Map<Answer4, User2> answers;

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

	public Map<Answer4, User2> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Answer4, User2> answers) {
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println("question id : " + id);
		System.out.println("question name : " + name);
		System.out.println("Answers....");
		Iterator<Entry<Answer4, User2>> itr = answers.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Answer4, User2> entry = itr.next();
			System.out.println("Answer Information : ");
			System.out.println(entry.getKey());
			System.out.println("Posted By : ");
			System.out.println(entry.getValue());
		}
	}
}
