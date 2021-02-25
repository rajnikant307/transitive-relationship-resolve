package com.mycompany.dept.relationship;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for Relation resolver App.
 */
public class RelationResolverTest {

	@Test
	public void testRelationResolveCorrectly() throws Exception {
		RelationResolver relationResolver = new RelationResolver(getFile("Simple.csv"));
		List<LinkedList<String>> results = relationResolver.resolveRelation();
		System.out.println(results);
		assertEquals("2 linear results should be there", 2, results.size());

	}

	private File getFile(final String name) {
		return new File(RelationResolverTest.class.getClassLoader().getResource(name).getFile());
	}
}
