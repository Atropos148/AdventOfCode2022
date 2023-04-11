package com.atropos148.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    public static String readData(String fileLocation) {
        File fileToRead = new File("AdventOfCode2022/src/com/atropos148/main/" + fileLocation.trim());
        StringBuilder st = new StringBuilder();
        String bufferString = "";
        String dataFromFile = "";
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

            finally {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dataFromFile = st.toString();
        return dataFromFile;
    }
}
