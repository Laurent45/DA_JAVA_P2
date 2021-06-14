package com.hemebiotech.analytics.readSymptoms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private FileReader fileRead;

	/**
	 *
	 * @param filePath a full or partial path to file with symptom strings in it, one per line
	 *
	 */
	public ReadSymptomDataFromFile(String filePath) {
		try {
			this.fileRead = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			System.err.println("File : " + filePath + " has been not found");
		}
	}

	/**
	 * @see ISymptomReader
	 * */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		BufferedReader reader = new BufferedReader(this.fileRead);

		String line = null;
		//For each line, add in string list and check every time if adding work good
		try {
			line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Error of reading the line : " + line + "\"");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println("Error while bufferReader's closed");
			}
		}

		return result;
	}



}
