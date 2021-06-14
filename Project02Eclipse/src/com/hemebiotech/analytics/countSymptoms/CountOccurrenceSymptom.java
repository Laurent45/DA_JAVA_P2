package com.hemebiotech.analytics.countSymptoms;

import java.util.List;
import java.util.TreeMap;

public class CountOccurrenceSymptom implements ISymptomCount {

    private List<String> symptoms;

    /**
     * @param symptoms a symptoms list with duplication or not
     * */
    public CountOccurrenceSymptom(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    /**
     * @see ISymptomCount
     * */
    @Override
    public TreeMap<String, Integer> getSymptomCount() {
        TreeMap<String, Integer> symptomCount = new TreeMap<>();

        /*
        Each lap of the loop, we create a couple K, V,
        if K already exists we increment the V
        */
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
