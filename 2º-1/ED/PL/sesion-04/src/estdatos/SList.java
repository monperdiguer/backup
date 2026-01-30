package estdatos;

import java.util.Iterator;
import java.util.Objects;


public class SList<E> implements IList<E> {
	
	Node<E> first;   // nodo del  primer elemento de la lista 
	Node<E> last;   // nodo del último elemento de la lista 
	int size;      // número de elementos de la lista        
	
	
	//Clase interna para los nodos
	
	private static class Node<E> { 
		E item; 
		Node<E> next; 
		
		Node(E e, Node<E> theNext) { 
			this.item = e; 
			this.next = theNext; 
		} 
	}
	
	//a)
	
	//Constructor vacio
	public SList(){
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	//Constructor de conversion
	public SList(Iterable<E> o) {
		this(); //inicializas la vacia 
		for(E e : o) {
			Node <E> newNode = new Node<>(e, null);
			if(first == null) {
				first = newNode;
				last = newNode;
			}
			else {
				last.next = newNode;
				last = newNode;
			}
			size++;
		}
	}
	
	//c) 
	
	@Override
	public Iterator<E> iterator() {
		return new SListIterator();
	}

	//b)
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño: " + size);
        }
		 	
		Node <E> newNode = new Node<>(e, null);
		
		if(index == 0) { //empezamos a insertar por el primer elemento
			newNode.next = first;
			first = newNode;
			
			if(size == 0) { // si esta vacia tambien actualizo el ultimo
				last = newNode;
			}

		}
		else if(index == size){ //Insertar al final
			last.next = newNode;
			last = newNode;
		}
		else {
			Node<E> anterior = first;
			//avanzar hasta el nodo anterior a la posicion
			for(int i = 0; i < index; i++) {
				anterior = anterior.next;
			}
			//enlazar en medio (ajustar punteros)
			newNode.next = anterior.next;
			anterior.next = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
		
		Node<E> actual = first; //creamos el nodo
		
        for (int i = 0; i < index; i++) {
            actual = actual.next; //lo recorremos hasta la posicion en la que este
        }
        return actual.item; //eviamos lo que contiene el nodo
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		
		Node<E> actual = first;
        Node<E> anterior = null; //porque no hay nodo antes

        while (actual != null) {
            if (e.equals(actual.item)) { // Caso 1: borrar primer elemento
                
                if (anterior == null) {
                    first = actual.next;
                    if (actual == last) //solo habia un nodo
                        last = null;
                }
                // Caso 2: borrar en medio o al final
                else {
                    anterior.next = actual.next;
                    if (actual == last) //borramos el último
                        last = anterior;
                }
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.next; //recorremos la lista nodo a nodo
        }
       
		return false;
	}

	//c)
	
	class SListIterator implements Iterator<E> {

		// c) pedía solo 'current' y funcionaba para iterar.
	    // e) añadimos campos mínimos para poder eliminar correctamente.
	    private Node<E> current = first;           // siguiente nodo a devolver en next()
	    private Node<E> previous = null;           // nodo anterior a 'current'
	    private Node<E> lastReturned = null;       // último nodo devuelto por next()
	    private Node<E> prevLastReturned = null; // nodo anterior a 'lastReturned'
	   
	    @Override
	    public boolean hasNext() {
	        return current != null;
	    }

	    @Override
	    public E next() {
	        if (current == null)
	            throw new java.util.NoSuchElementException();

	        lastReturned = current;            // el que vamos a devolver
	        prevLastReturned = previous;       // su anterior
	        previous = current;                // avanzamos 'previous'
	        current = current.next;            // y avanzamos 'current'

	        return lastReturned.item;
	    }
	    
	    //e)
	    
	    @Override
	    public void remove() {
	        if (lastReturned == null) {
	            // Aún no se llamó a next() o ya se llamó a remove() sin un next() intermedio
	        	throw new java.util.NoSuchElementException();
	        }

	        // Desenlazar 'lastReturned' de la SList externa
	        if (prevLastReturned == null) {
	            // Se elimina el primero de la lista
	            first = lastReturned.next;
	            if (lastReturned == last) {
	                // era el único elemento
	                last = null;
	            }
	        } else {
	            // Se elimina en medio o al final
	            prevLastReturned.next = lastReturned.next;
	            if (lastReturned == last) {
	                last = prevLastReturned;
	            }
	        }

	        size--;  // ajustamos tamaño

	        // Recolocar 'previous' para que la iteración continúe
	        previous = prevLastReturned;

	        // no se puede volver a llamar a remove() hasta que se haga otro next()
	        lastReturned = null;
	        prevLastReturned = null;
	    }
	    
	}

	//d)
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append('[');
	    
	    Node<E> n = first;
	    
	    while (n != null) {
	    	
	    	sb.append(" ");
	    	
	        sb.append(n.item);   
	        n = n.next;
	        	
	    }
	    sb.append(" ");
	    sb.append(']');
	    return sb.toString();
	    
	}

	//f))
	
	@Override
	public int hashCode() {
		int h = 1;
		Node<E> n = first;
		while (n != null) {
		    h = 31 * h + (n.item == null ? 0 : n.item.hashCode());
		    n = n.next;
		}
		
		return h;
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null|| getClass() != obj.getClass())
			return false;
		
		SList<E> other = (SList<E>) obj;
		
		if(this.size != other.size) 
			return false;
		
		Node<E> a = this.first;
	    Node<?> b = other.first;

	    while (a != null) { // tamaños iguales ⇒ basta con uno
	        if (!Objects.equals(a.item, b.item))
	        	return false;
	        a = a.next;
	        b = b.next;
	    }
	    return true; // mismos elementos en el mismo orden
	
	}
	
	
	
	

}
