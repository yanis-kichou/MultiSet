package pobj.tme4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import pobj.util.Chrono;

public class WordCount {

	public static void wordcount(MultiSet<String> ms, String file) {

		BufferedReader br;
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
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MultiSet<String> hashMap = new HashMultiSet<String>();
		MultiSet<String> naiveMultiSet = new NaiveMultiSet<String>();
		
		wordcount(hashMap, "data/WarAndPeace.txt");
		wordcount(naiveMultiSet, "data/WarAndPeace.txt");

		List<String> element = hashMap.elements();
		List<String> element2 = naiveMultiSet.elements();
		

		System.out.println("HashMultiSet:");
		Chrono chrono = new Chrono();
		Collections.sort(element, hashMap);
		chrono.stop();
		
		for (int i = 0; i < 10; i++)
			System.out.println(element.get(i) + " : " + hashMap.count(element.get(i)));

		
		System.out.println("NaiveMultiSet :");
		Chrono chrono2 = new Chrono();
		Collections.sort(element2, naiveMultiSet);
		chrono2.stop();
		
		for (int i = 0; i < 10; i++)
			System.out.println(element2.get(i) + " : " + hashMap.count(element2.get(i)));
	}
}
