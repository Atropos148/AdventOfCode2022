package com.atropos148.helperClasses;

public class File {
    private int size;
    private String name;

    public File(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

}
