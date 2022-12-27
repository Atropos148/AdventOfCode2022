package com.atropos148.solutions;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day4 implements Day {

    private String resultTest = "";
    private String result = "";

    private String resultTestExtra = "";
    private String resultExtra = "";

    private String testData = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8""";

    private String checkRanges(String ranges) {
        int result = 0;
        String[] allRanges = ranges.split("\n");
        for (String range : allRanges) {
            String firstRange = range.split(",")[0];
            String secondRange = range.split(",")[1];

            if (isRangeWithin(firstRange, secondRange)) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }

    private String checkRanges(String ranges, boolean checkOverlap) {
        int result = 0;
        String[] allRanges = ranges.split("\n");
        for (String range : allRanges) {
            String firstRange = range.split(",")[0];
            String secondRange = range.split(",")[1];

            if (doesRangeOverlap(firstRange, secondRange)) {
                result += 1;
            }
        }
        return String.valueOf(result);
    }

    private boolean isRangeWithin(String firstRange, String secondRange) {
        String[] firstRangeDetails = firstRange.split("-");
        String[] secondRangeDetails = secondRange.split("-");

        if (Integer.parseInt(firstRangeDetails[0]) <= Integer.parseInt(secondRangeDetails[0])) {
            if (Integer.parseInt(firstRangeDetails[1]) >= Integer.parseInt(secondRangeDetails[1])) {
                return true;
            }
        }

        if (Integer.parseInt(secondRangeDetails[0]) <= Integer.parseInt(firstRangeDetails[0])) {
            if (Integer.parseInt(secondRangeDetails[1]) >= Integer.parseInt(firstRangeDetails[1])) {
                return true;
            }
        }

        return false;
    }

    private boolean doesRangeOverlap(String firstRange, String secondRange) {
        String[] firstRangeDetails = firstRange.split("-");
        String[] secondRangeDetails = secondRange.split("-");

        int firstStart = Integer.parseInt(firstRangeDetails[0]);
        int firstEnd = Integer.parseInt(firstRangeDetails[1]);

        int secondStart = Integer.parseInt(secondRangeDetails[0]);
        int secondEnd = Integer.parseInt(secondRangeDetails[1]);

        if (firstStart <= secondEnd && firstEnd >= secondStart) {
            return true;
        }

        return false;
    }

    @Override
    public String getResultTest() {
        return checkRanges(testData);
    }

    @Override
    public String getResult() {
        String realData = DataReader.readData("Day4Data.txt");
        return checkRanges(realData);
    }

    @Override
    public String getResultExtraTest() {
        return checkRanges(testData, true);
    }

    @Override
    public String getResultExtra() {
        String realData = DataReader.readData("Day4Data.txt");
        return checkRanges(realData, true);
    }

}
