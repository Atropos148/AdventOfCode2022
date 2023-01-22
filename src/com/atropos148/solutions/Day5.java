package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.LinkedList;

import com.atropos148.main.Day;

public class Day5 implements Day {
    private String resultTest = "";
    private String result = "";

    private String resultTestExtra = "";
    private String resultExtra = "";

    ArrayList<LinkedList<Character>> stacks = new ArrayList<>();
    String[] orders;

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
        for (LinkedList<Character> stack : stacks) {
            Character topCrate = stack.get(stack.size() - 1);
            result.append(topCrate);
        }
        return result.toString();
    }

    private void getStacksFromData(String data) {
        String[] boxLayers = data.split("\n\n")[0].split("\n ")[0].split("\n");
        int amountOfStacks = data.split("\n\n")[0].split("\n ")[1].strip().split("\\s+").length;

        int currentStack = 0;
        int stackIndex = 1;
        final int stackOffset = 4;

        // for each stack
        for (int x = 0; x < amountOfStacks; x++) {
            stacks.add(new LinkedList<Character>());
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
    }

    private void getOrders(String data) {
        orders = data.split("\n\n")[1].split("\n");
    }

    private void moveCrates() {
        for (String order : orders) {
            int howMany = Integer.parseInt(order.split(" ")[1]);
            int fromStack = Integer.parseInt(order.split(" ")[3]);
            int toStack = Integer.parseInt(order.split(" ")[5]);

            for (int x = 0; x < howMany; x++) {
                stacks.get(toStack - 1).add(stacks.get(fromStack - 1).removeLast());
            }
        }
    }

    @Override
    public String getResultTest() {
        getStacksFromData(testData);
        getOrders(testData);
        moveCrates();
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
