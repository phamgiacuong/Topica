package com.topica.cuongpg.java8;

public class User {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeigh() {
		return weigh;
	}

	public void setWeigh(int weigh) {
		this.weigh = weigh;
	}

	String name;
	int weigh;

	public User(String name, int weigh) {
		this.name = name;
		this.weigh = weigh;
	}

}
