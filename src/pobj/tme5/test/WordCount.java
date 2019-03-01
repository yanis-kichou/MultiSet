package pobj.tme5.test;

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

		wordcount(hashMap, "data/WarAndPeace.txt");

		List<String> element = hashMap.elements();

		
		Chrono chrono = new Chrono();
		Collections.sort(element, hashMap);
		chrono.stop();

		System.out.println(hashMap.toString());

	}
}
