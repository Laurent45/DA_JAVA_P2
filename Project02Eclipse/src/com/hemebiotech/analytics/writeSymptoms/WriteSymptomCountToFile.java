package com.hemebiotech.analytics.writeSymptoms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteSymptomCountToFile implements ISymptomWrite {

    @Override
    public void writeSymptomCount(TreeMap<String, Integer> symptomCount, String filePathOut) {
            try {
                FileWriter out = new FileWriter(filePathOut);
                symptomCount.entrySet()
                        .forEach(line -> {
                            try {
                                out.write(line.getKey() + " : " + line.getValue() + "\n");
                            } catch (IOException e) {
                                System.err.println("Error while writing of line : " + line);
                            }
                        });
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("Error while fileWriter's closed");
                }
            } catch (IOException e) {
                System.err.println("Error about file : " + filePathOut);
            }
    }
}

