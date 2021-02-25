package com.mycompany.dept.relationship;

import java.io.File;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		try {
			final RelationResolver rr = new RelationResolver(new File(args[0]));
			rr.printResolveRelation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
