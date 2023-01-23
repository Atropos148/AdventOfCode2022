package com.atropos148.solutions;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day6 implements Day {
    String testData = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    String realData = DataReader.readData("Day6Data.txt");

    private boolean areCharactersUnique(String characters) {
        for (int i = 0; i < characters.length(); i++) {
            Character currentLetter = characters.charAt(i);
            if (characters.chars().filter(ch -> ch == currentLetter).count() > 1) {
                return false;
            }
        }
        return true;
    }

    private int findPacketStart(String data) {
        int currentIndex = 0;

        for (currentIndex = 4; currentIndex < data.length(); currentIndex++) {
            if (areCharactersUnique(data.substring(currentIndex - 4, currentIndex)) == true) {
                return currentIndex;
            }
        }
        return currentIndex;
    }

    @Override
    public String getResultTest() {
        return String.valueOf(findPacketStart(testData));
    }

    @Override
    public String getResult() {
        return String.valueOf(findPacketStart(realData));
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
