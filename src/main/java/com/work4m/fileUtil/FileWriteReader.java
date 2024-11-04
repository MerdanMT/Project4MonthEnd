package com.work4m.fileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriteReader {
    public static void writeFile(String fileName, String message) {
        try {
            FileWriter fileWriter = new FileWriter("textFile",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.close();
        }catch (Exception e){
           throw new RuntimeException("Error writing file");
        }
    }
    public static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader("textFile");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());

        } catch (Exception e) {
            throw new RuntimeException("Error reading file");
        }
    }
}
