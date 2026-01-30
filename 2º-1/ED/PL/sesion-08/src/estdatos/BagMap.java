package estdatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BagMap<E> extends AbstractSet<E> implements Set<E> {

	private TreeMap<E, Integer> data; //mapa almacena ordenado elementos y sus repeticiones
	private int size; // size almacena n de repeticiones
	
//	Constrcutores habituales: Vacio, comparador y collection
	public BagMap() {
		this.data = new TreeMap<>();
		this.size = 0;
	}
	
	public BagMap(Comparator<? super E> c) {
		this.data = new TreeMap<>(c);
		this.size = 0;
	}
	
	public BagMap(Collection<? extends E> c) {
	    this();
	    for (E e : c) {
	        this.add(e);
	    }
	}
	
	
	@Override
	public int size() {
		return this.size;
	}

//	Operacion de adicion
	 @Override
	 public boolean add(E e) {
	     Integer repeticiones = data.get(e);

	     if (repeticiones == null) {
	          data.put(e, 1);    // primera aparición
	     } else {
	          data.put(e, repeticiones + 1);  // incremento repeticiones
	     }

	     size++;  
	     return true;  
    }
	 
//	Operacion eliminacion de una repeticion
	 
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
	  Integer repeticiones = data.get(o);

	  if (repeticiones == null) 
		  return false;

	   if (repeticiones == 1) {
	      data.remove(o);     // última repetición → eliminar del todo
	   } else {
	      data.put((E) o, repeticiones - 1);  // decrementa repeticiones
	   }

	   size--;
	   return true;
	 }
	
	@Override
    public boolean contains(Object o) {
        return data.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

//Iterador que devuelve cada elemento tantas veces como indique su contador (multiconjunto)
	@Override
	public Iterator<E> iterator() {
	 return new Iterator<E>() {

		 private Iterator<E> keyIterator = data.keySet().iterator();
		 private E current = null;
		 private int repsLeft = 0; //mantiene las repeticiones restantes

		 @Override
		 public boolean hasNext() {
           return repsLeft > 0 || keyIterator.hasNext(); //solo se avanza a la siguiente clave cuando no haya repsLeft
         }

		 @Override
		 public E next() {
	         if (repsLeft == 0) {
		          current = keyIterator.next();
		          repsLeft = data.get(current);
		      }
		       repsLeft--;
		       return current;
		     }
		    };
		}
	
//	Deja SOLO los elementos que estan en c
	@Override
	public boolean retainAll(Collection<?> c) {
	    boolean changed = false;

	    Iterator<Map.Entry<E, Integer>> it = data.entrySet().iterator();

	    while (it.hasNext()) {
	        Map.Entry<E, Integer> entry = it.next();
	        if (!c.contains(entry.getKey())) {
	            size -= entry.getValue();  // restar todas las repeticiones
	            it.remove();               // eliminar del TreeMap
	            changed = true;
	        }
	    }

	    return changed;
	}
	
//	Operacion elimina el elemento completo que estan en c
	@Override
	public boolean removeAll(Collection<?> c) {
	    boolean modified = false;

	    for (Object o : c) {
	        Integer rep = data.remove(o);
	        if (rep != null) {
	            size -= rep;     // restar TODAS las repeticiones
	            modified = true;
	        }
	    }

	    return modified;
	}
	
	//Clases ya dadas
	
	/** Número de ocurrencias de un elemento */ 
	public int count(E e) { 
		Integer count = data.get(e); 
		return (count == null) ? 0 : count; 
	} 
	
	/** Devuelve una lista con los elementos únicos (ordenados) */ 
	public List<E> uniqueElements() { 
		return new ArrayList<>(data.keySet()); 
	} 
	
	@Override 
	public String toString() { 
		return data.toString() + " (size=" + size + ")"; 
	}
}
