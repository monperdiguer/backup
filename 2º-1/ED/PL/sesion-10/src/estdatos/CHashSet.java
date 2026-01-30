package estdatos;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class CHashSet<E> extends AbstractSet<E> implements Set<E> {

	//Area de datos
	private E[] table;     // tabla de elementos         
	private statusType[] status; // estado de cada posición de la tabla  
	private double loadFactorLimit;  // factor de carga límite 
	private int elements; // número de elementos        
	private int deleted;  // número de posiciones borradas        
	private int tablesize; // dimensión de la tabla      
	
//	Estado de cada posicion: EMPTY = nunca se ha usado, BUSY: contiene un elemtnto vacio
//	y ERASE = habia elemento pero fue borrado
	private enum statusType {EMPTY, ERASE, BUSY}; 
	
	
	//Contructor vacio
	public CHashSet() {
		this(11, 0.5);
	}
	
	//Constrcutor capacidad inicial
	public CHashSet (int initialCapacity) {
		this(initialCapacity, 0.5);
	}
	
	//Constructor capacidad inicial y factor de cargs
	@SuppressWarnings("unchecked")
	public CHashSet (int initialCapacity, double theLoadFactor) {
		
		this.elements = 0;
		this.tablesize = initialCapacity;
		this.loadFactorLimit= theLoadFactor;
		this.deleted = 0;
		
		this.table = (E[]) new Object[tablesize];

        this.status = new statusType[tablesize];
        for (int i = 0; i < tablesize; i++) { 
        	status[i] = statusType.EMPTY;
        }
        
	}
	
//	Constructor collection
	public CHashSet (Collection<? extends E> c) {
		this(11, 0.5);
	    addAll(c);
	}
	
	@Override
	public int size() {
		return this.elements; //size debe devolver el numero de elementos, no tablasize
	}
	
	//Metodo para que sea modificable
	@Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        
        int pos = firstEqualEmpty(e);

        // si ya existe → no se añade
        if (status[pos] == statusType.BUSY && table[pos].equals(e))
            return false;
     
        
        // insertar en primera ERASE/EMPTY
        int pos2 = firstEraseEmpty(e);
        if (status[pos2] == statusType.ERASE) {
            deleted--;
        }
        table[pos2] = e;
        status[pos2] = statusType.BUSY;
        elements++;
        return true;
    }
	
	//Metodos para menor coste temporal
	@SuppressWarnings("unchecked")
	@Override
    public boolean contains(Object o) {
        if (o == null) return false;

        E e = (E) o;
        int pos = firstEqualEmpty(e);

        // si estaba → BUSY + igual
        return (status[pos] == statusType.BUSY && table[pos].equals(e));
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
	 E e = (E) o;
	 int pos = firstEqualEmpty(e);
	 if (status[pos] == statusType.BUSY && table[pos].equals(e)) {
		 status[pos] = statusType.ERASE;
		 table[pos] = null;
		 elements--;
		 deleted++;
       return true;
      }
	        return false;
	}
	

	//Metodos privados
	private int hash(E e){ 
		return e.hashCode() % tablesize; 
	} 
	
	private int rehash(E e, int col){ 
		return (hash(e)  + col) % tablesize; 
	}
	
	//Metdodo que redimensione loadFactorLimit
	@SuppressWarnings("unused")
	private boolean exceedsLoadFactor() {
	    double load = (elements + deleted) / (double) tablesize;
	    return load > loadFactorLimit;
	}
	
	// Recorre la secuencia de posiciones hash/rehash para un elemento e y retorna  
//  la posición donde está el elemento e o una posición vacía (si e no está en la tabla)
	
	private int firstEraseEmpty(E e){ 
		int pos = hash(e); 
		int colisiones = 0; 
		while (colisiones < tablesize){ 
			if (status[pos] == statusType.BUSY) 
				pos = rehash(e, ++colisiones); 
			else 
				return pos; 
		} 
		throw new RuntimeException("demasiados intentos"); 
	}

	// Recorre la secuencia de posiciones hash/rehash para un elemento e y retorna la   
	// primera posición borrada o vacía que encuentra
	private int firstEqualEmpty(E e) {
        int pos = hash(e);
        int colisiones = 0;

        while (colisiones < tablesize) {
            if (status[pos] == statusType.BUSY) {
                if (table[pos].equals(e))
                    return pos;           // encontrada
                pos = rehash(e, ++colisiones);
            } else {
                return pos;               // primera vacía → e NO está
            }
        }
        throw new RuntimeException("demasiados intentos");
    }
	
	
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<E> {

        private int pos;            // posición de la tabla
        private int lastPosReturned;   //para gestionar los borrados 

        public MyIterator() {
            pos = 0;
            lastPosReturned = -1;
           
        }

        @Override
        public boolean hasNext() {
        	
        	//Avanza hasta encontrar una posicion BUSY
             while (pos < tablesize && status[pos] != statusType.BUSY) {
             	pos++;
             }
             return pos < tablesize;
        }

        @Override
        public E next() {
        	if (!hasNext()) throw new NoSuchElementException();
        	
            lastPosReturned = pos;
            E e = table[pos];
            pos++;

            return e;
        }

        @Override
        public void remove() {
        	if (lastPosReturned < 0) 
        		throw new IllegalStateException();
            
        	status[lastPosReturned] = statusType.ERASE;
            elements--;
            deleted++;
            lastPosReturned = -1;
        }
    }


}
