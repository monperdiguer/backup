package estdatos;

import java.nio.BufferOverflowException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagMod<E>  extends AbstractCollection<E> {

   
    protected E[] data;
    
    protected int datasize;

  
    @SuppressWarnings("unchecked")
	public BagMod(int capacity) {
    	data = (E[]) new Object[capacity];
        datasize = 0;
    }

    public BagMod(Collection<? extends E> c) {
        this(c.size());
        this.addAll(c);
    }
    
    @SuppressWarnings("unchecked")
	public BagMod(E...elements) {
    	
    	this(elements.length);
    	for(E e : elements) {
    		add(e);
    	}
    }


    @Override
    public Iterator<E> iterator() {
        return new IteratorImp();
    }

    @Override
    public int size() {
        return datasize;
    }

   
    @Override
    public boolean add(E e) {
        if (datasize == data.length) {
            throw new BufferOverflowException();
        }

        data[size()] = e;
        datasize++;
        
        return true;
    }
    
    public class IteratorImp implements Iterator<E> {
    	
    		private int index = 0;
    		private int last = -1;

		@Override
		public boolean hasNext() {
			return index < datasize;
		}

		@Override
		public E next() {
			E temp = data[index];
			if(!hasNext()) 
				throw new NoSuchElementException();
			else {
				last = index; 
				index++;
				return temp;
			}
		}
		
		@Override
	    public void remove() {
			
	        // No se ha llamado a next() o ya se hizo remove() tras el último next()
	        if (last < 0) {
	            throw new IllegalStateException();
	        }

	        // Mover el último elemento a la posición eliminada (bolsa no ordenada)
	        datasize--;                       // reduce tamaño lógico
	        data[last] = data[datasize];      // swap con el último
	        data[datasize] = null;            // evitar memory leak (opcional)

	        // Si el elemento movido quedó antes del cursor, retroceder cursor
	        if (last < index) {
	            index--;
	        }

	        // invalidar para no permitir dos remove() seguidos
	        last = -1;
	    }
		
		
		
    }

}