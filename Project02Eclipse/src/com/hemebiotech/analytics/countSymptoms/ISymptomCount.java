package com.hemebiotech.analytics.countSymptoms;

import java.util.TreeMap;

/**
 * Transform a string list symptoms to a map where the keys are symptoms and values
 * correspond to number of occurrence of each symptoms in the list.
 * The map is a TreeMap in order to arrange in alphabetic order
 */

public interface ISymptomCount {
/**
 * If no data is available, return an empty TreeMap
 *
 * @return a treeMap listing all of symptoms in alphabetic order and each symptoms
 * are linked to their number of occurrence
 */
    TreeMap<String, Integer> getSymptomCount ();
}
