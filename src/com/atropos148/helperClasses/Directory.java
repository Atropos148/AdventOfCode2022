package com.atropos148.helperClasses;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private List<Directory> directories = new ArrayList<>();
    private List<File> files = new ArrayList<>();
    private String name;

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

}
