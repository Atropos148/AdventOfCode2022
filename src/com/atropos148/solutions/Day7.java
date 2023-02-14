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
            if (currentDirectory != null) {
                if (currentDirectory.findDirectory(commandParts[2]) != null) {
                    changeDirectory(command);
                }
            } else {
                currentDirectory = baseDirectory;
            }
        }
    }

    public void showFileSystem() {
        // baseDirectory.showFiles();
        baseDirectory.showDirectories();
    }

    private boolean isACommand(String line) {
        return line.charAt(0) == '$';
    }

    private void handleFile(String row) {
        currentDirectory.addFile(createFile(row));
    }

    private void handleDirectory(String row) {
        String[] commandParts = row.split(" ");
        if (currentDirectory.findDirectory(commandParts[1]) == null) {
            createDirectory(row);
        }
        // else {
        // currentDirectory = currentDirectory.findDirectory(commandParts[1]);
        // }
    }

    private void changeDirectory(String command) {
        Directory newDirectory;

        String[] commandParts = command.split(" ");
        if (commandParts[2].equals("..")) {
            if (currentDirectory.getParentDirectory() != null) {
                newDirectory = currentDirectory.getParentDirectory();
                currentDirectory = newDirectory;
            } else {
                currentDirectory = baseDirectory;
            }
        } else {
            if (currentDirectory.findDirectory(commandParts[2]) != null) {
                currentDirectory = currentDirectory.findDirectory(commandParts[2]);
            } else {
                newDirectory = createDirectory(command);
                currentDirectory = newDirectory;
            }
        }
    }

    private File createFile(String row) {
        String[] rowParts = row.split(" ");
        File newFile = new File(Integer.parseInt(rowParts[0]), rowParts[1]);
        return newFile;
    }

    private Directory createDirectory(String row) {
        String[] rowParts = row.split(" ");
        Directory newDirectory = new Directory(rowParts[1], currentDirectory);
        currentDirectory.addDirectory(newDirectory);
        return newDirectory;
    }

    @Override
    public String getResultTest() {
        String[] rows = testData.split("\n");
        int index = 0;
        for (index = 0; index < rows.length; index++) {
            String row = rows[index];
            if (isACommand(row)) {
                handleCommand(row);
            } else {
                String[] rowParts = row.split(" ");
                if (!rowParts[0].equals("dir")) {
                    handleFile(row);
                } else {
                    handleDirectory(row);
                }
            }
        }
        showFileSystem();
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
