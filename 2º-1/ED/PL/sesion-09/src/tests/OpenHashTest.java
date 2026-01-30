package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import estdatos.OpenHash;

public class OpenHashTest {

	@Test
	public void testConstructors() {
		OpenHash<Integer> t1 = new OpenHash<Integer>();
		assertTrue(t1.isEmpty());
		assertEquals(11, t1.tablesize());

		t1 = new OpenHash<Integer>(10);
		assertTrue(t1.isEmpty());
		assertEquals(10, t1.tablesize());

		t1 = new OpenHash<Integer>(10, 0.85);
		assertTrue(t1.isEmpty());
		assertEquals(10, t1.tablesize());

		List<Integer> l1 = Arrays.asList(3, 89, 0, 3);
		t1 = new OpenHash<Integer>(l1);
		assertEquals(3, t1.size());
	}

	@Test
	public void testAdd() {
		OpenHash<Integer> t1 = new OpenHash<Integer>(4, 0.5);

		assertTrue(t1.add(1));
		assertTrue(t1.add(2));
		assertTrue(t1.add(3));

		assertTrue(t1.tablesize() > 4); // tablesize increased due to loadfactor

		assertFalse(t1.add(3));
		assertEquals(3, t1.size());
	}

	@Test
	public void testContains() {
		List<Integer> l1 = Arrays.asList(3, 89, 0, 3);
		OpenHash<Integer> t1 = new OpenHash<Integer>(l1);

		assertTrue(t1.contains(3));
		assertTrue(t1.contains(89));
		assertTrue(t1.contains(0));
		assertFalse(t1.contains(1));
	}

	@Test
	public void testRemove() {
		List<Integer> l1 = Arrays.asList(3, 89, 0, 3);
		OpenHash<Integer> t1 = new OpenHash<Integer>(l1);

		assertTrue(t1.contains(89));
		assertTrue(t1.remove(89));
		assertFalse(t1.contains(89));
		assertFalse(t1.remove(1));
	}
	
	@Test
	public void testIterator() {
		List<Integer> l1 = Arrays.asList(3, 89, 0, 3);
		OpenHash<Integer> t1 = new OpenHash<Integer>(l1);
		Iterator<Integer> itr = t1.iterator();
		
		assertTrue(itr.hasNext());
		assertEquals(Integer.valueOf(0), itr.next());
		assertTrue(itr.hasNext());
		assertEquals(Integer.valueOf(89), itr.next());
		assertTrue(itr.hasNext());
		assertEquals(Integer.valueOf(3), itr.next());
		assertFalse(itr.hasNext());

		itr = t1.iterator();
		itr.next();
		itr.remove();
		assertFalse(t1.contains(0));
		assertEquals(2, t1.size());
	}
}
