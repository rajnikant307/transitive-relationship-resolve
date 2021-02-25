/**
 * Licensed under Apache License 2.0
 */
package com.mycompany.dept.relationship;

import java.io.File;
import java.io.IOException;

/**
 * Main class to execute relationship resolver on external files.
 * 
 * @author RDixit
 *
 */
public class App {
	/**
	 * Main method.
	 * 
	 * @param args one argument with file path is expected
	 */
	public static void main(String[] args) {
		try {
			final RelationResolver rr = new RelationResolver(new File(args[0]));
			rr.printResolveRelation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
