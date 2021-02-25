/**
 * Licensed under Apache License 2.0
 */
package com.mycompany.dept.relationship;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * This class wraps {@link RelationGraph} to provide capability to run with
 * files.
 *
 */
public class RelationResolver {
	/**
	 * Instancve of relationn graph.
	 */
	final RelationGraph graph = new RelationGraph();

	/**
	 * Init service with data in file.
	 * 
	 * @param file to read tupples
	 * @throws IOException when problem in reading file.
	 */
	public RelationResolver(File file) throws IOException {

		BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()));

		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord record : csvParser) {
			graph.addEdge(record.get(0), record.get(1));
		}
	}

	/**
	 * Get result of file data resolutions.
	 * 
	 * @return linear resolutions.
	 */
	public List<LinkedList<String>> resolveRelation() {

		// print all linear relations
		return graph.resolveLR();

	}

	/**
	 * Print result on console.
	 */
	public void printResolveRelation() {
		graph.printLR();
	}
}
