package pobj.tme5.test;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	Map<T, Integer> hashMap;
	int size;
	public HashMultiSet() {
		hashMap = new HashMap<T, Integer>();
		size=0;
	}

	public HashMultiSet(Collection<T> collection) {
		this();
		for (T e : collection)
			add(e);
	}

	@Override
	public boolean add(T e, int count) {
		if (count < 0)
			throw new IllegalArgumentException(" erreru ajoute d'un valeur a occurence negatif ");
		size+=count;
		if (hashMap.containsKey(e)) {
			hashMap.put(e, hashMap.get(e) + count);
			assert isConsistent();
			return false;
		} else {
			hashMap.put(e, count);
			assert isConsistent();
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
		if (count < 0 || count>count((T)e))
			throw new IllegalArgumentException("Suppresion d'un nombre negatif d'occurence d'un objet");
		size-=count;
		if (hashMap.containsKey(e)) {
			if (hashMap.get(e) > count) {
				hashMap.put((T) e, hashMap.get(e) - count);
				assert isConsistent();
				return false;
			}
			if(hashMap.get(e)==count) {
				hashMap.remove(e);
				assert isConsistent();
				return true;
			}
		}
		assert isConsistent();
		return false;
		

	}

	@Override
	public int count(T o) {
		if (hashMap.containsKey(o))
			return hashMap.get(o);
		else return 0;
	}

	@Override
	public void clear() {
		hashMap.clear();
		size=0;

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
		List<T> unique = new ArrayList<T>();
		unique.addAll(hashMap.keySet());
		return unique;
	}

	@Override
	public int compare(T e, T f) {
		return Integer.compare(count(f), count(e));
	}

		public boolean isConsistent() {
			int cpt=0;
			for (T e: hashMap.keySet()) {
				if(hashMap.get(e)<0)
					return false;
				cpt+=hashMap.get(e);
			}
			return size==cpt;
			
		}
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("[");
		int i = 0;
		for (T e : hashMap.keySet()) {
			i++;
			s.append(e + ":" + hashMap.get(e));
			if (i < hashMap.keySet().size())
				s.append(",");
		}
		s.append("]");
		return s.toString();
	}
}
