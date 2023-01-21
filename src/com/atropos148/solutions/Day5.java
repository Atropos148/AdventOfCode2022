package com.atropos148.solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.atropos148.main.Day;

public class Day5 implements Day {
    private String resultTest = "";
    private String result = "";

    private String resultTestExtra = "";
    private String resultExtra = "";

    private ArrayList<Character> stackA = new ArrayList<>();
    private ArrayList<Character> stackB = new ArrayList<>();
    private ArrayList<Character> stackC = new ArrayList<>();

    private String testData = """
                [D]
            [N] [C]
            [Z] [M] [P]
             1   2   3

            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2""";

    private String getTopOfStacks(String data) {
        char result = data.split("\n\n")[0].split("\n")[2].split(" ")[0].charAt(1);
        return String.valueOf(result);
    }

    // private void setupStacksFromData(String data) {
    // int numberOfStacks = 0;
    // String[] dataRows = data.split("\n\n")[0].split("\n");
    // for (String character : dataRows[dataRows.length - 1].strip().split(" ")) {
    // try {
    // int stackNumber = Integer.parseInt(character);
    // numberOfStacks += 1;
    // } catch (NumberFormatException e) {
    // // e.printStackTrace();
    // }
    // }
    // System.out.println(numberOfStacks);
    // }

    private ArrayList<ArrayList<Character>> getStacksFromData(String data) {
        ArrayList<ArrayList<Character>> stacks = new ArrayList<>();
        String[] boxLayers = data.split("\n\n")[0].split("\n ")[0].split("\n");
        int amountOfStacks = data.split("\n\n")[0].split("\n ")[1].strip().split("\\s+").length;

        int currentStack = 0;
        int stackIndex = 1;
        final int stackOffset = 4;

        // for each stack
        for (int x = 0; x < amountOfStacks; x++) {
            stacks.add(new ArrayList<Character>());
            // for each layer of boxes
            for (int i = boxLayers.length - 1; i >= 0; i--) {
                String line = boxLayers[i];
                if (line.length() >= stackIndex) {
                    if (line.charAt(stackIndex) != ' ') {
                        stacks.get(currentStack).add(line.charAt(stackIndex));
                    }
                } else {
                    break;
                }

            }
            currentStack += 1;
            stackIndex += stackOffset;
        }

        System.out.println(stacks);

        return stacks;
    }

    // private int countNumberOfStacks(String data) {
    // int numberOfStacks = 0;
    // String[] dataRows = data.split("\n\n")[0].split("\n");
    // for (String character : dataRows[dataRows.length - 1].strip().split(" ")) {
    // try {
    // int stackNumber = Integer.parseInt(character);
    // numberOfStacks += 1;
    // } catch (NumberFormatException e) {
    // // e.printStackTrace();
    // }
    // }
    // return numberOfStacks;
    // }

    @Override
    public String getResultTest() {
        getStacksFromData(testData);
        return getTopOfStacks(testData);
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
