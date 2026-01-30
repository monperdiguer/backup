package estdatos;

import java.util.AbstractList;
import java.util.Collection;

public class MyArrayList<E> extends AbstractList<E> {
	
	private E[] data;
	private int datasize;
	
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.data = (E[]) new Object[10];
		this.datasize = 0;
	}

	@SuppressWarnings("unchecked")
	public MyArrayList(Collection<? extends E> c) {
		this.datasize = 0;
		
		int capacity = Math.max(10, c.size());
		
		this.data =(E[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.data = (E[]) new Object[initialCapacity];
		this.datasize = 0;
	}


	@Override
	public int size() {
		return datasize;
	}

	@Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }
	
	@Override
	public E set(int index, E element) {

		checkIndex(index);
		E e = (E) data[index];
        data[index] = element;
        return e;
    }
	
	@Override
	public boolean add(E e) {
        add(size(), e);
        return true;
	}
	
	@Override
	public void add(int index, E element) {

        ensureCapacity();
        // desplazar a la derecha
        if(index < 0 || index > datasize) {
        	throw new IndexOutOfBoundsException();
        }
        
        System.arraycopy(data, index, data, index + 1, datasize - index);
        data[index] = element;
        datasize++;
        
    }
	
	 @Override
	 public E remove(int index) {
	     checkIndex(index);
	     E removed = (E) data[index];
	     System.arraycopy(data, index + 1, data, index, datasize - index); 
	     datasize--;
	     data[datasize] = null;
	     return removed;
	 }

	
    public int capacity() {
    	return data.length;
	}
	    
    @SuppressWarnings("unchecked")
	protected void ensureCapacity() {
	    if (size() == capacity()){ 
	   		E[] newData = (E[]) new Object[capacity()*2+1]; 
	   		System.arraycopy(data, 0, newData, 0, size()); 
	   		data = newData; 
	   	}
	    	
    }
	
    private void checkIndex(int index) {
    	if (index < 0 || index >= size()) {
	         throw new IndexOutOfBoundsException();
	         }
    }
	
	
	/* 
    @SuppressWarnings({ "unchecked", "unused" })
    private int compare(E e1, E e2) {
		//Si hay comparador lo uso aunque haya orden natural
    	if(cmp != null) {
			return cmp.compare(e1, e2);
		}
    	else {
			if(!(e1 instanceof Comparable)) {
				throw new ClassCastException();
			}
			return (((Comparable<E>)e1).compareTo(e2));
		}
	}
	*/
}
