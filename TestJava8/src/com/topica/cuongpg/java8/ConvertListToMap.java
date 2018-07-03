package com.topica.cuongpg.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
	public static void main(String[] args) {

		List<User> list = new ArrayList<>();
		list.add(new User("Haha", 60));
		list.add(new User("Hai", 50));
		list.add(new User("Ha", 64));
		list.add(new User("Hang", 46));
		list.add(new User("Hung", 55));

		list.add(new User("Haha", 65)); // new line

		// key = name, value - websites , but the key 'linode' is duplicated!?
		Map<String, Integer> result1 = list.stream()
				.collect(Collectors.toMap(User::getName, User::getWeigh, (oldValue, newValue) -> oldValue));

		System.out.println("Result 1 : " + result1);

	}

}
