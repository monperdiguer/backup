package estdatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class OpenHash<E> extends AbstractSet<E> implements Set<E> {

	//Area de datos
	private List<SortedSet<E>> table;  //tabla de colecciones 
	private int elements;         //número de elementos 
	private int tablesize;        //tamaño de la tabla
	private double loadFactorLimit;  //límite del factor de carga
	
	//Constructor vacio
	public OpenHash() {
		this(11, 0.75);
	}
	
//	Constructor capacidad inicial
	public OpenHash(int initialCapacity) {
		this(initialCapacity, 0.75);
	}
	
//	Constructor inicial y factor de carga
	public OpenHash(int initialCapacity, double theLoadFactor) {
		
		this.elements = 0;
		this.tablesize = initialCapacity;
		this.loadFactorLimit= theLoadFactor;
		
		this.table = new ArrayList<> (tablesize);
		
		for(int i = 0; i < tablesize; i++) {
			this.table.add(new TreeSet<>());
		}
	}
	
//	Constructor collection
	public OpenHash(Collection<? extends E> c) {
		this(11, 0.75);
	    addAll(c);
	}
	
	@Override
	public int size() {
		return this.elements; //size debe devolver el numero de elementos, no tablasize
	}
	
	//Ncesario para que sea modificable
	@Override
	 public boolean add(E e) {
		
		int pos = hash(e);
       SortedSet<E> bucket = table.get(pos);

       if (!bucket.add(e)) return false; // ya estaba

       elements++;

       if ((double) elements / tablesize > loadFactorLimit)
           rehash();

       return true;
  }
	
	//Trabajan tabla hash abierta y tienen coste O(1)
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
	    return table.get(hash((E) o)).contains(o);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	  public boolean remove(Object o) {
	        boolean removed = table.get(hash((E) o)).remove(o);
	        if (removed) elements--;
	            return removed;
	       
	}


	//Metodo complementario para obetner las posiciones de los elementos en la tabla hash
	private int hash(E e){ 
		return e.hashCode()%tablesize; 
	} 
	
	//Para modificar el tamaño de la tabla hash cada vez que se añade un elemento
	private void rehash() {
		List<SortedSet<E>> oldTable = table;
        int oldSize = tablesize;

        tablesize = tablesize * 2 + 1;  // tamaño primo aproximado

        table = new ArrayList<>(tablesize);
        for (int i = 0; i < tablesize; i++)
            table.add(new TreeSet<>());

        elements = 0;

        // Reinsertar todos los elementos (Tema 5)
        for (int i = 0; i < oldSize; i++)
            for (E e : oldTable.get(i))
                add(e);
		
	}
	
	//número de posiciones de la tabla interna 
	public int tablesize() {
		return tablesize;
	}
	
//	 cadena con los elementos de la tabla hash asociados a cada posición
	 public String printTable() {
		 
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < tablesize; i++) {
	            sb.append(i).append(": ");
	            for (E e : table.get(i))
	                sb.append(e).append(" ");
	            if (i < tablesize - 1) sb.append("\n");
	        }
	        return sb.toString();
	    }

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

	    private int pos;            // posición actual de la tabla
	    private Iterator<E> itr;    // iterador de la cubeta table[pos]
	    private E lastReturned;     // último elemento devuelto (para controlar remove)

	    // Campo auxiliar imprescindible para que remove() sea correcto
	    private Iterator<E> lastItr; // iterador que devolvió lastReturned

	    public MyIterator() {
	        this.pos = -1;          // aún no estamos en ninguna cubeta válida
	        this.itr = null;
	        this.lastReturned = null;
	        this.lastItr = null;
	        avanzar();              // deja itr listo en la primera cubeta no vacía (si existe)
	    }

	    /**
	     * Avanza 'pos' hasta encontrar una cubeta con elementos pendientes.
	     * Tras ejecutar:
	     *  - o bien itr != null y itr.hasNext() == true,
	     *  - o bien itr == null (no quedan elementos).
	     */
	    private void avanzar() {
	        while ((itr == null || !itr.hasNext()) && pos < tablesize - 1) {
	            pos++;
	            itr = table.get(pos).iterator();
	        }
	        if (itr != null && !itr.hasNext()) {
	            itr = null;
	        }
	    }

	    @Override
	    public boolean hasNext() {
	        avanzar();
	        return itr != null && itr.hasNext();
	    }

	    @Override
	    public E next() {
	        if (!hasNext()) throw new NoSuchElementException();

	        // Guardamos el iterador que produce el elemento, porque remove() debe actuar sobre ese MISMO iterador.
	        lastItr = itr;
	        lastReturned = itr.next();

	        return lastReturned;
	    }

	    @Override
	    public void remove() {
	        // remove() solo es válido justo después de next()
	        if (lastReturned == null) throw new IllegalStateException();

	        /*
	         * Borrado correcto:
	         * - Hay que borrar usando el iterador que devolvió lastReturned (lastItr.remove()).
	         * - Así evitamos IllegalStateException y mantenemos consistencia con el iterador.
	         */
	        lastItr.remove();
	        elements--;

	        // Impide remove() doble sin next() intermedio
	        lastReturned = null;
	        lastItr = null;
	    }
	}



}
