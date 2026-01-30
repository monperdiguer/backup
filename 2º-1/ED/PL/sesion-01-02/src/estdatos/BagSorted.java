package estdatos;

import java.util.Comparator;


public class BagSorted<E> extends BagMod<E> {
	
	 
	private final Comparator<E> comparator;
	
	@SuppressWarnings("unchecked")
	public BagSorted() {
		super();
	    this.comparator = null;
	}
	 
	public BagSorted(int capacity) {
    	super(capacity);
    	this.comparator = null;
    }
	
	public BagSorted(int capacity, Comparator<E> cmp) {
	     super(capacity);
	     this.comparator = cmp;
	 }
	
	@SuppressWarnings("unchecked")
	public BagSorted(Comparator<E> cmp) {
	     super();
	     this.comparator = cmp;
	 }
	
	
	@Override
	public int size() {
		return datasize;
	}
	
	public boolean add(E e) {
		
		 int i = 0; //si pones datasize empiezas fuera del rango
		 
	     while (i < datasize && compare(data[i], e) <= 0) {  //compare(data[i], e) <= 0 salta los menores de e para hacer el orden ascendente
	   
	            i++;
	     }

	     // Desplazar a la derecha y colocar en i
	     if (i < datasize) {
	    	 System.arraycopy(data, i, data, i + 1, datasize - i);
	     }
	     data[i] = e; //Si i == datasize
         datasize++;
         return true;
		 	
	}
	
	
	@SuppressWarnings({ "unchecked"})
	private int compare(E e1, E e2) {
		
		//Si hay comparador lo uso aunque haya orden natural
		
		if(this.comparator != null) {
			return this.comparator.compare(e1, e2);
		}
		if(e1 == null || e2 == null) {
			throw new NullPointerException();
		}
		else {
			if(!(e1 instanceof Comparable)) {
				throw new ClassCastException();
			}
			return ((Comparable<E>)e1).compareTo(e2);
		}
	}

	
	
}
