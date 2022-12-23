package com.atropos148.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public static String readData(String fileLocation) {
        File fileToRead = new File("src/com/atropos148/main/" + fileLocation);
        StringBuilder st = new StringBuilder();
        String bufferString = "";
        String day3data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToRead));

            try {
                while ((bufferString = br.readLine()) != null) {
                    st.append(bufferString);
                    st.append("\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        day3data = st.toString();
        return day3data;
    }
}
