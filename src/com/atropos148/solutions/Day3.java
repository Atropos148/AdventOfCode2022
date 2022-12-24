package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.List;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day3 implements Day {

    private String resultTest = "";
    private String result = "";

    private String resultTestExtra = "";
    private String resultExtra = "";

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

    private String calculateGroupBadgesPriority(String data) {
        String[] allBackpacks = data.split("\n");

        int totalGroupBadgesPriority = 0;

        int groupIndex;
        for (groupIndex = 0; groupIndex < allBackpacks.length; groupIndex += 3) {
            String[] group = { allBackpacks[groupIndex], allBackpacks[groupIndex + 1], allBackpacks[groupIndex + 2] };
            Character groupBadge = findGroupBadge(group);
            totalGroupBadgesPriority += countPriority(groupBadge);
        }

        return String.valueOf(totalGroupBadgesPriority);
    }

    private Character findGroupBadge(String[] group) {
        int bagIndex;
        Character groupBadge = 'a';
        for (bagIndex = 0; bagIndex < group[0].length(); bagIndex++) {
            String currentItem = String.valueOf(group[0].charAt(bagIndex));
            if (group[1].contains(currentItem)) {
                if (group[2].contains(currentItem)) {
                    groupBadge = currentItem.charAt(0);
                }
            }
        }
        return groupBadge;
    }

    private int countPriority(List<Character> items) {
        String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int totalPriority = 0;

        for (char item : items) {
            totalPriority += priorities.indexOf(item) + 1;
        }
        return totalPriority;
    }

    private int countPriority(Character item) {
        String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        return priorities.indexOf(item) + 1;
    }

    @Override
    public String getResultTest() {
        resultTest = calculateTotalPriority(testData);
        return resultTest;
    }

    @Override
    public String getResult() {
        String realData = DataReader.readData("Day3Data.txt");
        result = calculateTotalPriority(realData);
        return result;
    }

    @Override
    public String getResultExtraTest() {
        resultTestExtra = calculateGroupBadgesPriority(testData);
        return resultTestExtra;
    }

    @Override
    public String getResultExtra() {
        String realData = DataReader.readData("Day3Data.txt");
        resultExtra = calculateGroupBadgesPriority(realData);
        return resultExtra;
    }

}
