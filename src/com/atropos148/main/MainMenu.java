package com.atropos148.main;

import com.atropos148.solutions.Day1;
import com.atropos148.solutions.Day2;
import com.atropos148.solutions.Day3;
import com.atropos148.solutions.Day4;
import com.atropos148.solutions.Day5;
import com.atropos148.solutions.Day6;
import com.atropos148.solutions.Day7;

public class MainMenu {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		Day day1 = new Day1();
		System.out.println("Day 1: Test: " + day1.getResultTest());
		System.out.println("Day 1: Result: " + day1.getResult());
		System.out.println("Day 1: Test TopThree: " + day1.getResultExtraTest());
		System.out.println("Day 1: Result TopThree: " + day1.getResultExtra());

		Day day2 = new Day2();
		System.out.println("Day 2 Test: " + day2.getResultTest());
		System.out.println("Day 2 Result: " + day2.getResult());
		System.out.println("Day 2 Extra Test: " + day2.getResultExtraTest());
		System.out.println("Day 2 Extra Result: " + day2.getResultExtra());

		Day day3 = new Day3();
		System.out.println("Day 3 Test: " + day3.getResultTest());
		System.out.println("Day 3: " + day3.getResult());
		System.out.println("Day 3 Extra Test: " + day3.getResultExtraTest());
		System.out.println("Day 3 Extra: " + day3.getResultExtra());

		Day day4 = new Day4();
		System.out.println("Day 4 Test: " + day4.getResultTest());
		System.out.println("Day 4: " + day4.getResult());
		System.out.println("Day 4 Extra Test: " + day4.getResultExtraTest());
		System.out.println("Day 4 Extra: " + day4.getResultExtra());

		Day day5 = new Day5();
		// System.out.println("Day 5 Test: " + day5.getResultTest());
		// System.out.println("Day 5: " + day5.getResult());

		Day day6 = new Day6();
		System.out.println("Day 6 Test: " + day6.getResultTest());
		System.out.println("Day 6: " + day6.getResult());
		System.out.println("Day 6 Extra Test: " + day6.getResultExtraTest());
		System.out.println("Day 6 Extra: " + day6.getResultExtra());

		Day day7 = new Day7();
		System.out.println("Day 7 Test: " + day7.getResultTest());
	}

}
