package com.hemebiotech.analytics.writeSymptoms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteSymptomCountToFile implements ISymptomWrite {

    TreeMap<String, Integer> symptomCount;

    public WriteSymptomCountToFile(TreeMap<String, Integer> symptomCount) {
        this.symptomCount = symptomCount;
    }

    @Override
    public void writeSymptomCount(String filePathOut) {
            try {
                FileWriter out = new FileWriter(filePathOut);
                this.symptomCount.entrySet()
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

