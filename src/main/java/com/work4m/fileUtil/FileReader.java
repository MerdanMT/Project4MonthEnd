package com.work4m.fileUtil;

import java.io.BufferedReader;

public class FileReader {
    public static void readFile(String fileName) {
        try {
            java.io.FileReader fileReader = new java.io.FileReader("textFile");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());

        } catch (Exception e) {
            throw new RuntimeException("Error reading file");
        }
    }
}
