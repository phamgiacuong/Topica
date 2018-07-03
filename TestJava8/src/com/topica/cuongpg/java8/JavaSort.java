package com.topica.cuongpg.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class JavaSort {
	

	public static void main(String[] args) {
		ArrayList<Integer> intarray = new ArrayList<>();


		for (int i = 0; i < 10; i++) {
			int rd = new Random().nextInt(10);
			intarray.add(rd);
		}
		Collections.sort(intarray);
		System.out.println(intarray);

		Collections.sort(intarray, new SortType.SortInt());
		System.out.println(intarray);
	}
}
