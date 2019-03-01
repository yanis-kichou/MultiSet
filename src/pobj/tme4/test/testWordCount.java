package pobj.tme4.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import pobj.tme4.HashMultiSet;
import pobj.tme4.MultiSet;
import pobj.tme4.NaiveMultiSet;
import pobj.tme4.WordCount;

public class testWordCount {

	@Test
	public void testTextPetitHashMap() {
		
		MultiSet<String>hashMap=new HashMultiSet<String>();
		WordCount.wordcount(hashMap,"data/test.txt");
		
		System.out.println(" HashMultiSet :");
		System.out.println(hashMap);
		assertEquals(16,hashMap.size());
		
		
		List<String> element=hashMap.elements();
		Collections.sort(element,hashMap);
		
		assertEquals(2,element.size());
		System.out.println(element);
	}
	@Test
	public void testTextPetitNaiveList() {
		
		MultiSet<String>naiveMultiSet=new NaiveMultiSet<String>();
		WordCount.wordcount(naiveMultiSet,"data/test.txt");
		
		System.out.println(" NaiveMultiSet");
		System.out.println(naiveMultiSet);
		assertEquals(16,naiveMultiSet.size());
	
		List<String> element=naiveMultiSet.elements();
		Collections.sort(element,naiveMultiSet);
		
		assertEquals(2,element.size());
		System.out.println(element);
	
}
}
