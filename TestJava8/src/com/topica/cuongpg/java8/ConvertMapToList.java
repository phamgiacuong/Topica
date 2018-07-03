package com.topica.cuongpg.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");

		System.out.println("\n1. Convert Map Key to List...");

		List<Integer> result = map.keySet().stream().collect(Collectors.toList());

		result.forEach(System.out::println);

		System.out.println("\n2. Convert Map Value to List...");

		List<String> result2 = map.values().stream().collect(Collectors.toList());

		result2.forEach(System.out::println);

	}

}
