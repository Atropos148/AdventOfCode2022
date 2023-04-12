package com.atropos148.solutions;

import com.atropos148.main.Day;
import com.atropos148.main.DataReader;

public class Day8 implements Day {

    private String testData = DataReader.readData("Day8TestData.txt");
    private String realData = DataReader.readData("Day8Data.txt");

    private int countOuterTrees(String data) {
        int columns = data.split("\n")[0].length();
        int rows = data.split("\n").length;
        int totalOuterTrees = (columns * 2) + ((rows * 2) - 4);
        return totalOuterTrees;
    }

    private boolean isTreeVisible(String data, int row, int column) {
        // System.out.println("Checking tree: row:" + row + " column:" + column);
        String rowToCheck = data.split("\n")[row];

        String leftCheck = rowToCheck.substring(0, column + 1);
        String rightCheck = rowToCheck.substring(column);

        String topCheck = getColumnToCheckTrees(data, column).substring(0, row + 1);
        String bottomCheck = getColumnToCheckTrees(data, column).substring(row);

        // System.out.println("\n");

        // System.out.println(leftCheck);
        // System.out.println(topCheck);

        // System.out.println();
        // System.out.println("Is tree visible from the top? : " +
        // isTreeVisibleFromTheTop(topCheck));
        // System.out.println("Is tree visible from the bottom? : " +
        // isTreeVisibleFromTheBottom(bottomCheck));
        // System.out.println("Is tree visible from the left? : " +
        // isTreeVisibleFromTheLeft(leftCheck));
        // System.out.println("Is tree visible from the right? : " +
        // isTreeVisibleFromTheRight(rightCheck));

        if (isTreeVisibleFromTheTop(topCheck) || isTreeVisibleFromTheBottom(bottomCheck)
                || isTreeVisibleFromTheLeft(leftCheck) || isTreeVisibleFromTheRight(rightCheck)) {
            return true;
        }

        return false;
    }

    private int countVisibleTrees(String data) {
        int visibleTrees = 0;
        int endColumn = data.split("\n")[0].length() - 2;
        int endRow = data.split("\n").length - 2;

        for (int column = 1; column <= endColumn; column++) {
            for (int row = 1; row <= endRow; row++) {
                if (isTreeVisible(data, row, column)) {
                    visibleTrees += 1;
                    // System.out.println("row:" + row + " column: " + column);
                }
            }
        }

        return visibleTrees;
    }

    private boolean isTreeVisibleFromTheTop(String data) {
        String treesToTest = data.substring(0, data.length() - 1);
        int treeHeight = Character.getNumericValue(data.charAt(data.length() - 1));

        for (char number : treesToTest.toCharArray()) {
            int testingTreeHeight = Character.getNumericValue(number);
            if (testingTreeHeight >= treeHeight) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheBottom(String data) {
        StringBuilder trees = new StringBuilder();
        trees.append(data);
        trees.reverse();
        String treesToTest = trees.toString().substring(0, data.length() - 1);

        int treeHeight = Character.getNumericValue(trees.toString().charAt(data.length() - 1));

        for (char number : treesToTest.toCharArray()) {
            int testingTreeHeight = Character.getNumericValue(number);
            if (testingTreeHeight >= treeHeight) {
                return false;
            }
        }
        return true;
    }

    private boolean isTreeVisibleFromTheLeft(String data) {
        String treesToTest = data.substring(0, data.length() - 1);
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
        String treesToTest = trees.toString().substring(0, data.length() - 1);

        int treeHeight = Character.getNumericValue(trees.toString().charAt(data.length() - 1));

        for (char number : treesToTest.toCharArray()) {
            int testingTreeHeight = Character.getNumericValue(number);
            if (testingTreeHeight >= treeHeight) {
                return false;
            }
        }
        return true;
    }

    private String getColumnToCheckTrees(String data, int column) {
        StringBuilder columnToCheck = new StringBuilder();
        String[] rows = data.split("\n");
        for (String row : rows) {
            columnToCheck.append(row.charAt(column));
        }
        return columnToCheck.toString();
    }

    @Override
    public String getResultTest() {
        int totalVisibleTrees = countOuterTrees(testData) + countVisibleTrees(testData);
        // isTreeVisible(testData, 1, 1);
        return Integer.toString(totalVisibleTrees);
    }

    @Override
    public String getResult() {
        int totalVisibleTrees = countOuterTrees(realData) + countVisibleTrees(realData);
        return Integer.toString(totalVisibleTrees);
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
