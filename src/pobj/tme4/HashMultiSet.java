package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	private Map<T, Integer> hashMap;

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
			hashMap.put(e, hashMap.get(e) + count);
			return false;
		} else {
			hashMap.put(e, count);
			return true;
		}
	}

	@Override
	public boolean add(T e) {
		if (!hashMap.containsKey(e)) {
			hashMap.put(e, 1);
			return true;
		}
		hashMap.put(e, hashMap.get(e) + 1);
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
				hashMap.put((T) e, cpt - count);
				return false;
			} else
				return true;
		}
		return false;
	}

	@Override
	public int count(T o) {
		if (hashMap.containsKey(o))
			return hashMap.get(o);
		return 0;
	}

	@Override
	public void clear() {
		hashMap.clear();

	}

	@Override
	public int size() {
		int compte = 0;
		for (T e : hashMap.keySet()) {
			compte += hashMap.get(e);
		}
		return compte;
	}

	// sous classe iterator
	public class HashMultiSetIterator implements Iterator<T> {

		private Iterator<Map.Entry<T, Integer>> iterator;
		private int suivant;
		private T current;

		public HashMultiSetIterator() {
			iterator = hashMap.entrySet().iterator();
			suivant = 0;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public T next() {
			if (suivant == 0) {
			 current=iterator.next().getKey();
			 suivant =hashMap.get(current)-1;	
			
			}
			else
				suivant --;
		return current;
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator();
	}

	@Override
	public List<T> elements() {
		List<T> elt = new ArrayList<T>();
		elt.addAll(hashMap.keySet());
		return elt;
	}

	@Override
	public int compare(T arg0, T arg1) {
		if (count(arg0) > count(arg1))
			return 1;
		else if (count(arg0) == count(arg1))
			return 0;
		return -1;
	}

}
