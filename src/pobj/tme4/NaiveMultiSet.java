package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	private ArrayList<T> maList;

	public NaiveMultiSet(Collection<T> e) {
		maList = new ArrayList<T>();
		Iterator<T> it = e.iterator();
		while (it.hasNext()) {
			maList.add(it.next());
		}
	}

	public NaiveMultiSet() {
		maList = new ArrayList<>();
	}

	@Override
	public boolean add(T e, int count) {
		boolean a = false;
		if (!maList.contains(e)) {
			a = true;
		}
		for (int i = 0; i < count; i++) {
			maList.add(e);
		}
		return a;
	}

	@Override
	public boolean add(T e) {
		return maList.add(e);
	}

	@Override
	public boolean remove(Object e) {
		return maList.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		Iterator<T> it = maList.iterator();
		boolean a = false;
		if (count((T) e) < count)
			a = true;
		while (it.hasNext() && this.count((T) e) < count) {
			maList.remove(e);
		}
		return a;
	}

	@Override
	public int count(T o) {
		int cpt = 0;
		for (T e : maList) {
			if (e.equals(o))
				cpt++;
		}
		return cpt;
	}

	@Override
	public void clear() {
		maList = new ArrayList<T>();
	}

	@Override
	public int size() {
		return maList.size();
	}

	@Override
	public int compare(T arg0, T arg1) {
		return Integer.compare(count(arg0), count(arg1));
	}

	@Override
	public List<T> elements() {
		List<T> copy=new ArrayList<T>();
		for (T e:maList) {
			if(!copy.contains(e))
				copy.add(e);
		}
return copy;
	}

	@Override
	public Iterator<T> iterator() {
		return maList.iterator();
	}

	

}