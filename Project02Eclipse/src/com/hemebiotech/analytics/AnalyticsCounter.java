package com.hemebiotech.analytics;

import com.hemebiotech.analytics.countSymptoms.*;
import com.hemebiotech.analytics.readSymptoms.*;
import com.hemebiotech.analytics.writeSymptoms.*;

public class AnalyticsCounter {

	public static void main(String[] args) {

		ISymptomReader readFileSymptom = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomCount countOccurrenceSymptom = new CountOccurrenceSymptom(readFileSymptom.getSymptoms());
		ISymptomWrite writeSymptomsOccurrence = new WriteSymptomCountToFile(countOccurrenceSymptom.getSymptomCount());

		writeSymptomsOccurrence.writeSymptomCount("result.out");

	}
}
