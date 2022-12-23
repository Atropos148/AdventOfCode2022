package com.atropos148.solutions;

import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day2 implements Day {
    private String resultTest = "";
    private String result = "";

    private String testData = """
            A Y
            B X
            C Z""";

    public Day2() {
    }

    private int calculateResult(String data, boolean countFromResult) {
        int dayResult = 0;
        String[] matchData = data.split("\n");
        for (String match : matchData) {
            if (countFromResult) {
                dayResult += countMatchResult(match, countFromResult);
            } else {
                dayResult += countMatchResult(match);
            }
        }
        return dayResult;
    }

    private int countMatchResult(String match) {
        // Rock A,X
        // Paper B,Y
        // Scissors C,Z

        int score = 0;

        String[] symbols = match.split(" ");
        score += handResult(symbols[1], symbols[0]);
        switch (symbols[1]) {
            case "X":
                score += 1;
                break;
            case "Y":
                score += 2;
                break;
            case "Z":
                score += 3;
                break;
        }
        return score;
    }

    private int countMatchResult(String match, boolean countFromResult) {
        // Rock A,X
        // Paper B,Y
        // Scissors C,Z

        int score = 0;

        String[] symbols = match.split(" ");
        String playerSymbol = calculatePlayerSymbol(symbols[0], symbols[1]);
        score += handResult(playerSymbol, symbols[0]);
        switch (playerSymbol) {
            case "X":
                score += 1;
                break;
            case "Y":
                score += 2;
                break;
            case "Z":
                score += 3;
                break;
        }
        return score;
    }

    private String calculatePlayerSymbol(String opponent, String result) {
        // Rock A,X
        // Paper B,Y
        // Scissors C,Z

        String player = "";

        if (result.equals("Y")) {
            switch (opponent) {
                case "A":
                    player = "X";
                    break;
                case "B":
                    player = "Y";
                    break;
                case "C":
                    player = "Z";
                    break;
            }
        } else {
            if (result.equals("X")) {
                switch (opponent) {
                    case "A":
                        player = "Z";
                        break;
                    case "B":
                        player = "X";
                        break;
                    case "C":
                        player = "Y";
                        break;
                }
            } else {
                switch (opponent) {
                    case "A":
                        player = "Y";
                        break;
                    case "B":
                        player = "Z";
                        break;
                    case "C":
                        player = "X";
                        break;
                }
            }
        }
        return player;
    }

    private int handResult(String player, String opponent) {
        int result = 0;

        // Rock A,X
        // Paper B,Y
        // Scissors C,Z

        switch (player) {
            case "A":
                player = "X";
                break;
            case "B":
                player = "Y";
                break;
            case "C":
                player = "Z";
                break;
        }

        switch (player) {
            case "X":
                if (opponent.equals("A")) {
                    // rock v rock
                    result = 3;
                } else if (opponent.equals("B")) {
                    // rock v paper
                    result = 0;
                } else if (opponent.equals("C")) {
                    // rock v scissors
                    result = 6;
                }
                break;
            case "Y":
                if (opponent.equals("B")) {
                    // paper v paper
                    result = 3;
                } else if (opponent.equals("C")) {
                    // paper v scissors
                    result = 0;
                } else if (opponent.equals("A")) {
                    // paper v rock
                    result = 6;
                }
                break;
            case "Z":
                if (opponent.equals("C")) {
                    // scissors v scissors
                    result = 3;
                } else if (opponent.equals("A")) {
                    // scissors v rock
                    result = 0;
                } else if (opponent.equals("B")) {
                    // scissors v paper
                    result = 6;
                }
                break;
        }

        return result;
    }

    @Override
    public String getResultTest() {
        resultTest = String.valueOf(calculateResult(testData, false));
        return resultTest;
    }

    @Override
    public String getResult() {
        String realData = DataReader.readData("Day2Data.txt");
        result = String.valueOf(calculateResult(realData, false));
        return result;
    }

    public String getResultExtraTest() {
        result = String.valueOf(calculateResult(testData, true));
        return result;
    }

    public String getResultExtra() {
        String realData = DataReader.readData("Day2Data.txt");
        result = String.valueOf(calculateResult(realData, true));
        return result;
    }

}
