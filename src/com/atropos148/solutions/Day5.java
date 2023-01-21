package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.List;

import com.atropos148.main.Day;

public class Day5 implements Day {
    private String resultTest = "";
    private String result = "";

    private String resultTestExtra = "";
    private String resultExtra = "";

    ArrayList<ArrayList<Character>> stacks = new ArrayList<>();

    private String testData = """
                [D]
            [N] [C]
            [Z] [M] [P]
             1   2   3

            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2""";

    private String getTopOfStacks() {
        StringBuilder result = new StringBuilder();
        for (List<Character> stack : stacks) {
            Character topCrate = stack.get(stack.size() - 1);
            result.append(topCrate);
        }
        return result.toString();
    }

    private ArrayList<ArrayList<Character>> getStacksFromData(String data) {
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
        getTopOfStacks();

        return stacks;
    }

    @Override
    public String getResultTest() {
        getStacksFromData(testData);
        return getTopOfStacks();
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
