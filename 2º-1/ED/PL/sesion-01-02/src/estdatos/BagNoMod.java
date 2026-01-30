package estdatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagNoMod<E> extends AbstractCollection<E> {

	private final E[] data;
	private final int datasize;
	
	
	@SuppressWarnings("unchecked")
	
	public BagNoMod(Collection<? extends E> c) {
		if(c instanceof BagNoMod<?>) {
			BagNoMod<E> other = (BagNoMod<E>)c;
			this.data = other.data;
			this.datasize = other.datasize;
			
		} else {
			this.data = (E[]) new Object[c.size()];
			int index = 0;
			for(E e : c) data[index++] = e;
			this.datasize = index;
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public BagNoMod(int capacity) {
		if(capacity > 0) {
			this.data = (E[]) new Object[capacity];
			this.datasize = 0;
		}
		else {
			this.data = null;
			this.datasize = 0; //bolsa vacia
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public BagNoMod(final E...e) {
		this.data = (E[]) new Object[e.length];
		System.arraycopy(e, 0, this.data, 0, e.length);
		this.datasize = e.length;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImp(); // completo en la clase BagMod.
	}

	@Override
	public int size() {
		return datasize;
	}
	
	class IteratorImp implements Iterator<E> {
    	
    	private int index = 0;

		@Override
		public boolean hasNext() {
			return index < data.length;
		}

		@Override
		public E next() {
			E temp = data[index];
			if(!hasNext()) 
				throw new NoSuchElementException();
			else {
				index++;
				return temp;
			}
		}
		
		
    }
}
