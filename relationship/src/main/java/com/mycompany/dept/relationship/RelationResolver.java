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
 * Hello world!
 *
 */
public class RelationResolver {
	final RelationGraph graph = new RelationGraph();

	public RelationResolver(File file) throws IOException {

		BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()));

		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord record : csvParser) {
			graph.addEdge(record.get(0), record.get(1));
		}
	}

	public List<LinkedList<String>> resolveRelation() throws IOException {

		// print all linear relations
		return graph.resolveLR();

	}

	public void printResolveRelation() {
		graph.printLR();
	}
}
