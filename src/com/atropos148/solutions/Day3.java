package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.List;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day3 implements Day {

    private String resultTest = "";
    private String result = "";

    private String testData = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw""";

    public Day3() {
    }

    private String calculateTotalPriority(String data) {
        String[] allBackpacks = data.split("\n");
        List<Character> foundObjects = new ArrayList<Character>();

        for (String backpack : allBackpacks) {
            String firstHalf = backpack.substring(0, backpack.length() / 2);
            String secondHalf = backpack.substring(backpack.length() / 2, backpack.length());

            if (firstHalf.length() == secondHalf.length()) {
                for (int i = 0; i < firstHalf.length(); i++) {
                    if (secondHalf.contains(String.valueOf(firstHalf.charAt(i)))) {
                        foundObjects.add(firstHalf.charAt(i));
                        break;
                    }
                }
            }
        }

        int totalPriority = countPriority(foundObjects);
        return String.valueOf(totalPriority);
    }

    private int countPriority(List<Character> items) {
        String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int totalPriority = 0;

        for (char item : items) {
            totalPriority += priorities.indexOf(item) + 1;
        }
        return totalPriority;
    }

    @Override
    public String getResultTest() {
        resultTest = calculateTotalPriority(testData);
        return resultTest;
    }

    @Override
    public String getResult() {
        // C:\\CODE\\Java\\projects\\AdventOfCode2022\\src\\Day3Data.txt
        String realData = DataReader.readData("Day3Data.txt");
        result = calculateTotalPriority(realData);
        return result;
    }

    @Override
    public String getResultExtraTest() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getResultExtra() {
        // TODO Auto-generated method stub
        return null;
    }

}
