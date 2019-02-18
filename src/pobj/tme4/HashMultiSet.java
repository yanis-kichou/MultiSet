package pobj.tme4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMultiSet<T> implements MultiSet<T> {

	private HashMap<T, Integer> hashMap;

	public HashMultiSet() {
		hashMap = new HashMap<>();
	}

	public HashMultiSet(Collection<T> col) {
		Iterator<T> i = col.iterator();
		while (i.hasNext()) {
			T suivant = i.next();
			hashMap.put(suivant, hashMap.get(suivant) + 1);
		}
	}

	@Override
	public boolean add(T e, int count) {
		if (hashMap.containsKey(e)) {
			int tmp = hashMap.get(e) + count;
			hashMap.remove(e);
			hashMap.put(e, tmp);
		} else {
			hashMap.put(e, count);
			return true;
		}
		return false;
	}

	@Override
	public boolean add(T e) {
		if (!hashMap.containsKey(e)) {
			hashMap.put(e, 1);
			return true;
		}
		Integer cpm = hashMap.get(e) + 1;
		hashMap.remove(e);
		hashMap.put(e, cpm);
		return false;
	}

	@Override
	public boolean remove(Object e) {
		if (hashMap.containsKey(e)) {
			hashMap.remove(e);
			return true;
		}
		return false;

	}

	@Override
	public boolean remove(Object e, int count) {
		if (hashMap.containsKey(e)) {
			int cpt = hashMap.get(e);
			hashMap.remove(e);
			if (cpt > count) {
				hashMap.put(((T)e), cpt - count);
				return false;
			} else
				return true;
		}
		return false;
	}

	@Override
	public int count(T o) {
		if (hashMap.containsKey(o))
			return hashMap.get(o).intValue();
		return 0;
	}

	@Override
	public void clear() {
		for (T e : hashMap.keySet()) {
			hashMap.remove(e);
		}

	}

	@Override
	public int size() {
		int compte = 0;
		for (T e : hashMap.keySet()) {
			compte += hashMap.get(e);
		}
		return compte;
	}

	public class HashMultiSetIterator implements Iterator<T> {

		private ArrayList<T> ens;

		public HashMultiSetIterator() {
			ens = new ArrayList<>();
			for (T e : hashMap.keySet()) {
				for (int i = 0; i < hashMap.get(e); i++) {
					ens.add(e);
				}
			}
		}

		@Override
		public boolean hasNext() {
			return ens.size() > 0;
		}

		@Override
		public T next() {
			return ens.remove(0);
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new HashMultiSetIterator();
	}
}
