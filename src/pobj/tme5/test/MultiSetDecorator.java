package pobj.tme5.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;



public class MultiSetDecorator<T> implements MultiSet<T> {

	MultiSet<T> decorated;
	
	public MultiSetDecorator(MultiSet<T> ms) {
		decorated=ms;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return decorated.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return decorated.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return decorated.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return decorated.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return decorated.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return decorated.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return decorated.retainAll(c);
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return decorated.compare(o1, o2);
	}

	@Override
	
	public boolean add(T e, int count) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		 return decorated.add(e);
		
	}

	@Override
	public boolean add(T e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return decorated.add(e);
	}

	@Override
	public boolean remove(Object e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return decorated.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return decorated.remove(e);
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return decorated.count(o);
	}

	@Override
	public void clear() {
		decorated.clear();
	}

	@Override
	public int size() {
		return decorated.size();
	}

	@Override
	public List<T> elements() {
		return decorated.elements();
	}
	
}
