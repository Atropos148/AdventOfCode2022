package com.atropos148.solutions;

import com.atropos148.main.Day;
import com.atropos148.main.DataReader;

public class Day8 implements Day {

    private String testData = DataReader.readData("Day8TestData.txt");

    private int countOuterTrees(String data) {
        int columns = data.split("\n")[0].length();
        int rows = data.split("\n").length;
        int totalOuterTrees = (columns * 2) + ((rows * 2) - 4);
        return totalOuterTrees;
    }

    @Override
    public String getResultTest() {
        return Integer.toString(countOuterTrees(testData));
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResult'");
    }

    @Override
    public String getResultExtraTest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultExtraTest'");
    }

    @Override
    public String getResultExtra() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultExtra'");
    }

}
