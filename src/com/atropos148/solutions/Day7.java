package com.atropos148.solutions;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day7 implements Day {
    private String testData = DataReader.readData("Day7TestData.txt");

    @Override
    public String getResultTest() {
        String[] rows = testData.split("\n");
        for (String row : rows) {
            System.out.println(row);
        }
        return null;
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
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
