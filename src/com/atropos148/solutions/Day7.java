package com.atropos148.solutions;

import java.util.ArrayList;
import java.util.List;

import com.atropos148.helperClasses.Directory;
import com.atropos148.helperClasses.File;
import com.atropos148.main.DataReader;
import com.atropos148.main.Day;

public class Day7 implements Day {
    private String testData = DataReader.readData("Day7TestData.txt");
    private List<Directory> directories = new ArrayList<>();

    private Directory baseDirectory = new Directory("/");
    private Directory currentDirectory;

    private int totalSize;

    private void handleCommand(String command) {
        String[] commandParts = command.split(" ");
        if (commandParts[1].equals("cd")) {
            // System.out.println("command is cd");
            Directory newDir = changeDirectory(command);
            if (!directories.contains(newDir)) {
                directories.add(newDir);
            }
            // System.out.println(directories);
        } else if (commandParts[1].equals("ls")) {
            System.out.println("command ls");
        }
    }

    public void showFileSystem() {
        for (Directory directory : directories) {
            System.out.println(directory.getName());
            // directory.showFiles();
            System.out.println(directory.getTotalSize());
        }
    }

    private boolean isACommand(String line) {
        return line.charAt(0) == '$';
    }

    private void handleFile(String row) {
        currentDirectory.addFile(createFile(row));
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

    private File createFile(String row) {
        String[] rowParts = row.split(" ");
        File newFile = new File(Integer.parseInt(rowParts[0]), rowParts[1]);
        return newFile;
    }

    @Override
    public String getResultTest() {
        String[] rows = testData.split("\n");
        int index = 0;
        for (index = 0; index < rows.length; index++) {
            String row = rows[index];
            System.out.println(row);
            if (isACommand(row)) {
                handleCommand(row);
            } else {
                String[] rowParts = row.split(" ");
                if (!rowParts[0].equals("dir")) {
                    handleFile(row);
                }
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
