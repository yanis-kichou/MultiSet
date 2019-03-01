package pobj.tme4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface MultiSet<T> extends Collection<T>,Iterable<T>,Comparator<T>{
	public boolean add(T e, int count);
	public boolean add(T e);
	public boolean remove(Object e);
	public boolean remove(Object e, int count);
	public int count(T o);
	public void clear();	
	public int size();
	List<T> elements();
	
}
