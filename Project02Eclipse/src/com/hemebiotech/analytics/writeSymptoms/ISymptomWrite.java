package com.hemebiotech.analytics.writeSymptoms;

import java.util.TreeMap;

public interface ISymptomWrite {

    void writeSymptomCount (TreeMap<String, Integer> symptomCount, String filePathOut);
}
