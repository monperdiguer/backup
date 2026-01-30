package estdatos;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListBag<E> extends AbstractCollection<E> implements Set<E>{

	//Lista interna almacena TODOS los elementos
	private ArrayList<E> list;
	
//	Constructor vacio
	public ListBag() {
		this.list = new ArrayList<>();
	}
	
//	Constrcutor desde una lista (incluye repetidos)
	public ListBag(List<E> c) {
		this.list = new ArrayList<>(c);
	}
	
//	Constructor desde cualquier coleccion 
	public ListBag(Collection<? extends E> c) {
        this.list = new ArrayList<>(c);
	}
	
	@Override
	public boolean add(E e) {
		return list.add(e); //Acepta repetidos
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
