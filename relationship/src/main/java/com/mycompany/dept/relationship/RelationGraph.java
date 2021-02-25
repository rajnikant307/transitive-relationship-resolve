/**
 * Licensed under Apache License 2.0
 */
package com.mycompany.dept.relationship;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Graph to hold and resolve relationships.
 * 
 * @author RDixit
 *
 */
public class RelationGraph {

	/**
	 * graph instance
	 */
	private Map<String, LinkedList<String>> graph = new HashMap<>();

	/**
	 * Add relation to graph.
	 * 
	 * @param e1 first element
	 * @param e2 second element
	 */
	public void addEdge(String e1, String e2) {
		if (graph.containsKey(e1)) {
			graph.get(e1).add(e2);
		} else {
			LinkedList<String> list = new LinkedList<>();
			list.add(e2);
			graph.put(e1, list);
		}
		if (graph.containsKey(e2)) {
			graph.get(e2).add(e1);
		} else {
			LinkedList<String> list = new LinkedList<>();
			list.add(e1);
			graph.put(e2, list);
		}
	}

	/**
	 * Helper method to print resolved linear relations
	 */
	public void printLR() {
		List<LinkedList<String>> results = resolveLR();
		for (LinkedList<String> line : results) {
			System.out.print(line);
		}

	}

	/**
	 * Resolved linear relations from data.
	 * 
	 * @return array of linear relations
	 */
	public List<LinkedList<String>> resolveLR() {
		Set<String> visited = new HashSet<>();
		Set<String> keys = graph.keySet();
		List<LinkedList<String>> resolutions = new LinkedList<>();

		for (String key : keys) {
			if (visited.contains(key)) {
				continue;
			}
			visited.add(key);
			LinkedList<String> list = new LinkedList<>();
			list.add(key);
			for (String val : graph.get(key)) {
				visitUtil(visited, val, list);
			}
			resolutions.add(list);
		}

		return resolutions;
	}

	/**
	 * Helper to visit nodes recursively.
	 * 
	 * @param visited list of visited nodes
	 * @param e       current element
	 * @param list    linear relation list
	 */
	private void visitUtil(Set<String> visited, String e, LinkedList<String> list) {
		visited.add(e);
		list.add(e);
		LinkedList<String> rels = graph.get(e);
		for (String str : rels) {

			if (visited.contains(str)) {
				continue;
			}
			visitUtil(visited, str, list);
		}
	}

}
