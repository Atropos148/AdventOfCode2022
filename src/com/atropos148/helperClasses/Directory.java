package com.atropos148.helperClasses;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private List<Directory> directories = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    private String name;
    private Directory parentDirectory;
    private int totalSize;

    public Directory(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
    }

    public void addFile(File newFile) {
        files.add(newFile);
        totalSize += newFile.getSize();
    }

    public void addDirectory(Directory newDirectory) {
        directories.add(newDirectory);
    }

    public Directory findDirectory(String name) {
        for (Directory directory : directories) {
            if (directory.name.equals(name)) {
                return directory;
            }
        }
        return null;
    }

    public void showFiles() {
        for (File currentFile : files) {
            System.out.println(currentFile.getSize() + " " + currentFile.getName());
        }
    }

    public void showDirectories() {
        for (Directory currentDirectory : directories) {
            System.out.println(String.valueOf(currentDirectory.getTotalSize()) + " " + currentDirectory.getName());
        }
    }

    public Directory(String name) {
        this.name = name;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    @Override
    public String toString() {
        return "Directory [name=" + name + ", pD=" + parentDirectory + "]";
    }

    public int getTotalSize() {
        return totalSize;
    }

}
