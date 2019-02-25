package pobj.tme4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import java.util.List;

import pobj.util.Chrono;

public class WordCount {

	public static void wordCount(MultiSet<String> ms) {
		BufferedReader br = null;
		String file = "data/test.txt";
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				for (String word : line.split("\\P{L}+")) { 
					if (word.equals(""))
						continue;
					ms.add(word);
				}
			}
			br.close();
			List<String> e1 = ms.elements();
			Collections.sort(e1, ms);
		System.out.println(e1);
		

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MultiSet<String> hasMusltSet = new HashMultiSet<String>();
		MultiSet<String> naiveMultSet = new NaiveMultiSet<String>();
		Chrono c1 = new Chrono();
		wordCount(hasMusltSet);
			
		c1.stop();
		Chrono c2 = new Chrono();
		wordCount(naiveMultSet);
		c2.stop();
	}
}
