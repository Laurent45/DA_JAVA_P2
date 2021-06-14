package com.hemebiotech.analytics.countSymptoms;

import java.util.List;
import java.util.TreeMap;

public class CountOccurenceSymptom implements ISymptomCount {

    private List<String> symptoms;

    public CountOccurenceSymptom(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public TreeMap<String, Integer> getSymptomCount() {
        TreeMap<String, Integer> symptomCount = new TreeMap<>();

        for (String symptom : this.symptoms) {
            if (symptomCount.containsKey(symptom)) {
                symptomCount.put(symptom, symptomCount.get(symptom) + 1);
            } else {
                symptomCount.put(symptom, 1);
            }
        }

        return symptomCount;
    }
}
