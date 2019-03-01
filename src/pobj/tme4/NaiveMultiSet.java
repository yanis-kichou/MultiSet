package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	List <T> list;
	 public NaiveMultiSet() {
		 list=new ArrayList<T>();
	 }
	 public NaiveMultiSet(Collection<T> collection ){
		 this();
		 for (T e :collection)
			 list.add(e);
	 }
	 
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return Integer.compare(count(o2),count(o1));
	}

	@Override
	public boolean add(T e, int count) {
		boolean contient=list.contains(e);
		for(int i=0;i<count;i++)
			list.add(e);
		return !contient;
	}

	@Override
	public boolean remove(Object e, int count) {
		while (count((T)e)>count)
			list.remove((T)e);
		return list.contains(e);
	}

	@Override
	public boolean add(T e) {
		return list.add(e);
	}
	
	@Override
	public boolean remove(Object e) {
		return list.remove(e);
	}
	@Override
	public int count(T o) {
		int cpt=0;
		for (T e:list)
			if(o.equals(e))
				cpt++;
		return cpt;
	}

	@Override
	public List<T> elements() {
		List<T> unique=new ArrayList<T>();
		for (T e:list)
			if(!unique.contains(e))
				unique.add(e);
		return unique;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

}
