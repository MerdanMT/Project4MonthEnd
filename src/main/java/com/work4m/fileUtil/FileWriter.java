package com.work4m.fileUtil;

import java.io.BufferedWriter;

public class FileWriter {
    public static void writeFile(String fileName, String message) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("textFile",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.close();
        }catch (Exception e){
            throw new RuntimeException("Error writing file");
        }
    }
}
