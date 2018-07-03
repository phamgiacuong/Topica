package com.topica.cuongpg.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStream {
	public static void main(String[] args) {
		List<String> values = createDummyData();

		long startTime = System.nanoTime();

		values.stream().forEach((i) -> {
			System.out.println(i);
		});
//		System.out.println(count);

		long endTime = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

		System.out.println(String.format("sequential took: %d ms", millis));

		startTime = System.nanoTime();

		values.parallelStream().forEach((i) -> {
			System.out.print(i);
		});
//		System.out.println(count);

		endTime = System.nanoTime();

		millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

		System.out.println(String.format("parallel took: %d ms", millis));

	}


	public static List<String> createDummyData() {
		int max = 100;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		return values;
	}
}
