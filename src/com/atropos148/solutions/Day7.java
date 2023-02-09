package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.List;

import com.atropos148.helperClasses.Directory;
import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day7 implements Day {
    private String testData = DataReader.readData("Day7TestData.txt");
    private List<Directory> directories = new ArrayList<>();

    private Directory baseDirectory = new Directory("/");
    private Directory currentDirectory;

    private void handleCommand(String command) {
        String[] commandParts = command.split(" ");
        if (commandParts[1].equals("cd")) {
            System.out.println("command is cd");
            Directory newDir = changeDirectory(command);
            if (!directories.contains(newDir)) {
                directories.add(newDir);
            }
            System.out.println(directories);
        } else if (commandParts[1].equals("ls")) {
            System.out.println("command ls");
        }
    }

    private boolean isACommand(String line) {
        return line.charAt(0) == '$';
    }

    private Directory changeDirectory(String command) {
        Directory newDirectory;

        String[] commandParts = command.split(" ");
        if (commandParts[2].equals("..")) {
            if (currentDirectory.getParentDirectory() != null) {
                newDirectory = currentDirectory.getParentDirectory();
                currentDirectory = newDirectory;
            } else {
                newDirectory = baseDirectory;
                currentDirectory = baseDirectory;
            }
        } else {
            newDirectory = new Directory(commandParts[2], currentDirectory);
            currentDirectory = newDirectory;
        }

        return newDirectory;
    }

    @Override
    public String getResultTest() {
        String[] rows = testData.split("\n");
        for (String row : rows) {
            System.out.println(row);
            if (isACommand(row)) {
                handleCommand(row);
            }
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
