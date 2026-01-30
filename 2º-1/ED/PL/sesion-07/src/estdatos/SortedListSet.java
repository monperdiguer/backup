package estdatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class SortedListSet<E> extends AbstractSet<E> implements Set<E> {
	 private  ArrayList<E> data;
	 private Comparator<? super E> cmp;

	    // CONSTRUCTORES

	    public SortedListSet() {
	        this.data = new ArrayList<>();
	        this.cmp = null;
	    }

	    public SortedListSet(Comparator<? super E> cmp) {
	        this.data = new ArrayList<>();
	        this.cmp = cmp;
	    }

	    public SortedListSet(Collection<? extends E> c) {
	        this(c, null);
	        for(E e : c) add(e);
	    }

	    public SortedListSet(Collection<? extends E> c, Comparator<? super E> cmp) {
	        this.cmp = cmp;
	        this.data = new ArrayList<>();
	        for(E e : c) add(e);
	    }

	   // MÉTODOS BÁSICOS

	    @Override
	    public Iterator<E> iterator() {
	        return data.iterator();
	    }

	    @Override
	    public int size() {
	        return data.size();
	    }
	    
	    @SuppressWarnings("unchecked")
	    private int compare(E a, E b) {
	        if (cmp != null) {
	            return cmp.compare(a, b);
	        }
	        return ((Comparable<? super E>) a).compareTo(b);
	    }

	    //Busqueda binaria
	    @Override
	    public boolean contains(Object o) {
	    	if(o == null) {
	    		return false;
	    	}
	        @SuppressWarnings("unchecked")
	        E e = (E) o;

	        int low = 0, high = data.size() - 1;

	        while (low <= high) {
	            int mid = (low + high) >>> 1;
	            int c = compare(data.get(mid), e);

	            if (c == 0) return true;
	            if (c < 0) low = mid + 1;
	            else high = mid - 1;
	        }
	        return false;
	    }

	    //Inserccion ordenada
	    @Override
	    public boolean add(E e) {
	    	if(e == null) {
	    		throw new NullPointerException();
	    	}
	        int low = 0, high = data.size() - 1;

	        while (low <= high) {
	            int mid = (low + high) >>> 1;
	            int c = compare(data.get(mid), e);

	            if (c == 0) return false; // duplicado
	            if (c < 0) low = mid + 1;
	            else high = mid - 1;
	        }

	        data.add(low, e);
	        return true;
	    }

	    //Algoritmo de mezcla
	    @Override
	    public boolean addAll(Collection<? extends E> c) {
	    	if(c == null) {
	    		throw new NullPointerException();
	    	}
	        if (c.isEmpty()) return false;

	        SortedListSet<E> other = new SortedListSet<>(c, cmp);

	        ArrayList<E> merged = new ArrayList<>(this.size() + other.size());

	        int i = 0, j = 0;
	        boolean changed = false;

	        while (i < data.size() && j < other.data.size()) {
	            int cmpRes = compare(data.get(i), other.data.get(j));

	            if (cmpRes < 0) {
	                merged.add(data.get(i++));
	            } else if (cmpRes > 0) {
	                merged.add(other.data.get(j++));
	                changed = true;
	            } else {
	                merged.add(data.get(i));
	                i++;
	                j++;
	            }
	        }

	        while (i < data.size()) merged.add(data.get(i++));
	        while (j < other.data.size()) {
	            merged.add(other.data.get(j++));
	            changed = true;
	        }

	        if (changed) {
	            data.clear();
	            data.addAll(merged);
	        }

	        return changed;
	    }

	    //Mezcla lineal
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Set<?> other)) return false;
	        if (this.size() != other.size()) return false;

	        if (other instanceof SortedListSet<?> s) {
	            Iterator<E> it1 = this.iterator();
	            Iterator<?> it2 = s.iterator();

	            while (it1.hasNext()) {
	                if (!it1.next().equals(it2.next())) return false;
	            }
	            return true;
	        }

	        return super.equals(o);
	    }
}


