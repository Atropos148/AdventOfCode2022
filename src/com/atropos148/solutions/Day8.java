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

    private boolean isTreeVisible(String data, int row, int column) {
        System.out.println("Checking tree: row:" + row + " column:" + column);
        String rowToCheck = data.split("\n")[row];

        String leftCheck = rowToCheck.substring(0, column + 1);
        String rightCheck = rowToCheck.substring(column);

        System.out.println(rightCheck);
        System.out.println("Is tree visible from the left? : " + isTreeVisibleFromTheLeft(leftCheck));
        System.out.println("Is tree visible from the right? : " + isTreeVisibleFromTheLeft(rightCheck));
        return false;
    }

    private boolean isTreeVisibleFromTheLeft(String data) {
        String treesToTest = data.substring(0, data.length() - 2);
        int treeHeight = Character.getNumericValue(data.charAt(data.length() - 1));

        for (char number : treesToTest.toCharArray()) {
            int testingTreeHeight = Character.getNumericValue(number);
            if (testingTreeHeight >= treeHeight) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheRight(String data) {
        StringBuilder trees = new StringBuilder();
        trees.append(data);
        trees.reverse();
        String treesToTest = trees.toString().substring(0, data.length() - 2);

        int treeHeight = Character.getNumericValue(trees.toString().charAt(data.length() - 1));

        for (char number : treesToTest.toCharArray()) {
            int testingTreeHeight = Character.getNumericValue(number);
            if (testingTreeHeight >= treeHeight) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getResultTest() {
        isTreeVisible(testData, 1, 1);
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
