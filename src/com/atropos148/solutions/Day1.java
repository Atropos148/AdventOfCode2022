package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.Collections;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day1 implements Day {
	private String inputData = "";

	private String resultTest = "";
	private String result = "";

	private String resultTestTopThree = "";
	private String resultTopThree = "";

	private String inputDataTest = """
			1000
			2000
			3000

			4000

			5000
			6000

			7000
			8000
			9000

			10000""";

	public Day1() {
		calculateResultTest();
		setInputData(DataReader.readData("Day1Data.txt"));
		calculateResultTopThreeTest();
	}

	private String calculateResultTopThree(String data) {
		String[] listOfBags = data.split("\n\n");

		ArrayList<Integer> topBags = new ArrayList<>();

		for (String bag : listOfBags) {
			String[] calories = bag.split("\n");
			int bagCalories = 0;

			for (String row : calories) {
				bagCalories += Integer.parseInt(row);
			}
			topBags.add(bagCalories);
		}
		Collections.sort(topBags, Collections.reverseOrder());
		int topBagsTogether = topBags.get(0) + topBags.get(1) + topBags.get(2);
		return String.valueOf(topBagsTogether);
	}

	private String calculateResult(String data) {
		String[] listOfBags = data.split("\n\n");

		int mostCalories = 0;
		for (String bag : listOfBags) {
			String[] calories = bag.split("\n");
			int bagCalories = 0;

			for (String row : calories) {
				bagCalories += Integer.parseInt(row);
			}
			if (bagCalories > mostCalories) {
				mostCalories = bagCalories;
			}
		}
		return String.valueOf(mostCalories);
	}

	private void calculateResultTopThreeTest() {
		String data = inputDataTest;
		String[] listOfBags = data.split("\n\n");

		ArrayList<Integer> topBags = new ArrayList<>();

		for (String bag : listOfBags) {
			String[] calories = bag.split("\n");
			int bagCalories = 0;

			for (String row : calories) {
				bagCalories += Integer.parseInt(row);
			}
			topBags.add(bagCalories);
		}
		Collections.sort(topBags, Collections.reverseOrder());
		int topBagsTogether = topBags.get(0) + topBags.get(1) + topBags.get(2);
		resultTestTopThree = String.valueOf(topBagsTogether);
	}

	private void calculateResultTest() {
		String data = inputDataTest;
		String[] listOfBags = data.split("\n\n");

		int mostCalories = 0;
		for (String bag : listOfBags) {
			String[] calories = bag.split("\n");
			int bagCalories = 0;

			for (String row : calories) {
				bagCalories += Integer.parseInt(row);
			}
			if (bagCalories > mostCalories) {
				mostCalories = bagCalories;
			}
		}
		resultTest = String.valueOf(mostCalories);
	}

	@Override
	public String getResultTest() {
		return resultTest;
	}

	@Override
	public String getResult() {
		return result;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
		result = calculateResult(this.inputData);
		resultTopThree = calculateResultTopThree(this.inputData);
	}

	public String getResultExtraTest() {
		return resultTestTopThree;
	}

	public String getResultExtra() {
		return resultTopThree;
	}

}
