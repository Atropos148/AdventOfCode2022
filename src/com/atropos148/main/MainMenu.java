package com.atropos148.main;

import com.atropos148.solutions.Day1;
import com.atropos148.solutions.Day2;
import com.atropos148.solutions.Day3;
import com.atropos148.solutions.Day4;

public class MainMenu {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		Day1 day1 = new Day1();
		System.out.println("Day 1: Test: " + day1.getResultTest());
		System.out.println("Day 1: Result: " + day1.getResult());
		System.out.println("Day 1: Test TopThree: " + day1.getResultExtraTest());
		System.out.println("Day 1: Result TopThree: " + day1.getResultExtra());

		Day2 day2 = new Day2();
		System.out.println("Day 2 Test: " + day2.getResultTest());
		System.out.println("Day 2 Result: " + day2.getResult());
		System.out.println("Day 2 Extra Test: " + day2.getResultExtraTest());
		System.out.println("Day 2 Extra Result: " + day2.getResultExtra());

		Day3 day3 = new Day3();
		System.out.println("Day 3 Test: " + day3.getResultTest());
		System.out.println("Day 3: " + day3.getResult());
		System.out.println("Day 3 Extra Test: " + day3.getResultExtraTest());
		System.out.println("Day 3 Extra: " + day3.getResultExtra());

		Day4 day4 = new Day4();
		System.out.println("Day 4 Test: " + day4.getResultTest());
		System.out.println("Day 4: " + day4.getResult());
		System.out.println("Day 4 Extra Test: " + day4.getResultExtraTest());
		System.out.println("Day 4 Extra: " + day4.getResultExtra());
	}

}
