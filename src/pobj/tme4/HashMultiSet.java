package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	Map<T, Integer> hashMap;

	public HashMultiSet() {
		hashMap = new HashMap<T, Integer>();
	}

	public HashMultiSet(Collection<T> collection) {
		this();
		for (T e : collection)
			add(e);
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
		return add(e, 1);
	}

	@Override
	public boolean remove(Object e) {
		return remove(e, 1);
	}

	@Override
	public boolean remove(Object e, int count) {
		if (hashMap.containsKey(e)) {
			if (hashMap.get(e) > count) {
				hashMap.put((T) e, hashMap.get(e) - count);
				return false;
			}
			hashMap.remove(e);
			return true;
		}
		return false;

	}

	@Override
	public int count(T o) {

		return hashMap.get(o);
	}

	@Override
	public void clear() {
		hashMap.clear();

	}

	@Override
	public int size() {
		int cpt = 0;
		for (T e : hashMap.keySet())
			cpt += hashMap.get(e);
		return cpt;
	}

	class HashMultiSetIterator implements Iterator<T> {
		Iterator<Map.Entry<T, Integer>> iterateur;
		int count = 0;
		T courent = null;

		public HashMultiSetIterator() {
			iterateur = hashMap.entrySet().iterator();
		}

		@Override
		public boolean hasNext() {
			if (count > 0) {
				count--;
				return true;
			}
			if (count <= 0)
				if (iterateur.hasNext()) {
					courent = iterateur.next().getKey();
					count = count(courent) - 1;
					return true;
				}

			return false;
		}

		@Override
		public T next() {
			return courent;
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new HashMultiSetIterator();
	}

	@Override
	public List<T> elements() {
		List<T> unique=new ArrayList<T>();
		unique.addAll(hashMap.keySet());
		return unique;
	}

	@Override
	public int compare(T e, T f) {
		return Integer.compare(count(f), count(e));
	}
}
