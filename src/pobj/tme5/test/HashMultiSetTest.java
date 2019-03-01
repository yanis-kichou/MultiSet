package pobj.tme5.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class HashMultiSetTest {
	
	private MultiSet<String> m;
	
	@Before
	public void before() {
		m = new HashMultiSet<>();
	}
	
	@Test 
	public void testAdd1() {
		m.add("a");
		m.add("a",5);
		assertEquals(6, m.count("a"));
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testAdd2() {
		m.add("a");
		m.add("a",-1);
	}
	@Test
	public void testRemove() {
		m.add("K");
		m.add("K",4);
		m.remove("K",5);
		assertEquals(0, m.count("K"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testRemove2() {
		m.add("test",2);
		m.remove("test",2);
		m.remove("test",-3);
	}
	
	@Test
	public void testSize() {
		int size=m.size();
		m.add("c",10);
		assertEquals(m.size(), size+10);
	}
	@Test
	public void testSize2() {
		m.clear();
		assertEquals(m.size(),0);
	}
	@Test
	public void testClear() {
		
		m.add("yanis",100);
		m.clear();
		assertEquals(m.size(),0);
	}
	@Test
	public void testToString() {
		m.clear();
		m.add("a",1);
		m.add("b",2);
		String s="[a:1,b:2]";
		assertEquals(s,m.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void  testComplexe1() {
		m.clear();
		m.add("a",10);
		m.add("b",20);
		m.add("c",30);
		assertEquals(60,m.size());
		m.remove("c",20);
		m.remove("a",15);
		assertEquals(40,m.size());
		m.remove("d");
		m.add("d");
		assertEquals(41,m.size());
		
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCasParticulier1() {
		m.clear();
		m.add("a",0);
		m.add("b",0);
		assertEquals(0, m.size());
		m.remove("a",10);
		m.remove("c",0);
		assertEquals(0, m.size());
		
	}
}
