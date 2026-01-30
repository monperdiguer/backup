package estdatos;

import java.util.Comparator;
import java.util.Collection;

public class SortedList<E> extends MyArrayList<E> {
    private final Comparator<E> comparator;

    //constructor sin comparador orden natural
    public SortedList() {
        super();
        this.comparator = null;
    }

    //" con capacidad inicial
    public SortedList(int initialCapacity) {
        super(initialCapacity);
        this.comparator = null;
    }

    //" " con comparador
    public SortedList(Comparator<E> comparator) {
        super();
        this.comparator = comparator;
    }

    //" con capacidad inicial y comparador
    public SortedList(int initialCapacity, Comparator<E> comparator) {
        super(initialCapacity);
        this.comparator = comparator;
    }

    //" con colección y comparador (necesario????????)
    public SortedList(Collection<? extends E> c, Comparator<E> comparator) {
        super();
        this.comparator = comparator;
        addAll(c); // Los elementos se añaden en orden
    }

    @Override
    public boolean add(E element) {
    	// Si no hay comparador, el elemento debe ser Comparable
        if (comparator == null && !(element instanceof Comparable)) {
            throw new ClassCastException();
        }
    	
        // Encuentra la posición donde insertar p/ mantener el orden
        int index = findInsertionPoint(element);
        super.add(index, element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        // No permitir inserción por índice específico (rompería el orden)
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        // No permitir modificación directa por índice (rompería el orden)
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // Añadir todos los elementos manteniendo el orden
        for (E element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // No permitir inserción por índice específico
        throw new UnsupportedOperationException("Cannot addAll at specific index in sorted list");
    }

    // Método auxiliar para encontrar la posición de inserción
    @SuppressWarnings("unchecked")
    private int findInsertionPoint(E element) {
    	checkOrdenPosible();
        int low = 0;
        int high = size();
        
        while (low < high) {
            int mid = (low + high) / 2;
            E midElement = get(mid);
            
            int comparison;
            if (comparator != null) {
                comparison = comparator.compare(element, midElement);
            } else {
                comparison = ((Comparable<? super E>) element).compareTo(midElement);
            }
            
            if (comparison < 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    //verifica que se puede establecer un orden
    private void checkOrdenPosible() {
        if (comparator == null) {
            // Verificar que los elementos son Comparable
            if (size() > 0 && !(get(0) instanceof Comparable)) {
                throw new ClassCastException();
            }
        }
    }
}