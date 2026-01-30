package estdatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListSet<E> extends AbstractSet<E> implements Set<E> {

	protected List<E> list; //Lista interna
	
	//Constructores
	public ListSet() {
		this.list = new ArrayList<>(); //ArrayList para tiempo constante
	}
	
	public ListSet(Collection<? extends E> collection) {
        this.list = new ArrayList<>(collection);
        this.addAll(collection); //	garantiza el Set (sin duplicados)
    }
	
	public ListSet(List<E> collection) {
		this.list = new ArrayList<>(collection); //List es collection
	}
	
	@Override
	public boolean add(E e) {
		if(!contains(e)) {
			list.add(e);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}
	
	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}
	
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	 @Override
	    public boolean isEmpty() {
	        return list.isEmpty();
	    }

	  @Override
	    public void clear() {
	        list.clear();
	   }
}
