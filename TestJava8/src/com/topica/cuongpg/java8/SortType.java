package com.topica.cuongpg.java8;

import java.util.Comparator;

public class SortType {
	public static class SortInt implements Comparator<Integer> {

		@Override
		public int compare(Integer int1, Integer int2) {
			return int1 - int2;
		}
	}
}
