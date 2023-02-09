package com.atropos148.helperClasses;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private List<Directory> directories = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    private String name;
    private Directory parentDirectory;

    public Directory(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
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

}
