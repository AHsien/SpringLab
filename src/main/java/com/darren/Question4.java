package com.darren;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question4 {

	private int id;
	private String name;
	private Map<Answer2, User> answers;

	public Question4() {

	}

	public Question4(int id, String name, Map<Answer2, User> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println("question id:" + id);
		System.out.println("question name:" + name);
		System.out.println("Answers....");
		Set<Entry<Answer2, User>> set = answers.entrySet();
		Iterator<Entry<Answer2, User>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Answer2, User> entry = itr.next();
			Answer2 ans = entry.getKey();
			User user = entry.getValue();
			System.out.println("Answer Information:");
			System.out.println(ans);
			System.out.println("Posted By:");
			System.out.println(user);
		}
	}
}
