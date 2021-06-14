package com.hemebiotech.analytics.writeSymptoms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteSymptomCountToFile implements ISymptomWrite {

    private TreeMap<String, Integer> symptomCount;

    /**
     * @param symptomCount a TreeMap with K = symptom and V = number of occurrences
     */
    public WriteSymptomCountToFile(TreeMap<String, Integer> symptomCount) {
        this.symptomCount = symptomCount;
    }

    /**
     * @see ISymptomWrite
     */
    @Override
    public void writeSymptomCount(String filePathOut) {
            try {
                FileWriter out = new FileWriter(filePathOut);
                /*
                * We use API Stream for write each K, V from TreeMap to filePathOut
                */
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

