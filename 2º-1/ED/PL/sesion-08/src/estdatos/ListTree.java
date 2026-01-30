package estdatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTree<E> extends AbstractTree<E>{

	//Datos
	private E labelRoot; //etiqueta raíz
	private Tree<E> parent; 
	private List<Tree<E>> children; //secuencia arboles ordenados
	
	
	@SuppressWarnings("unchecked")
	
//Este constructor crea un árbol cuya raíz tiene etiqueta e y los hijos son los árboles pasados como parámetro.
	public ListTree(E e, Tree<E> ...trees) {
		labelRoot = e;
	    children = new ArrayList<>();

	    // Se añaden los subárboles como hijos
	    for (Tree<E> t : trees) {
	        children.add(t);
	        
	        ((ListTree<E>) t).parent = this; // Esto permite implementar correctamente la operación parent()
	    }

	    // La raíz no tiene padre
	    parent = null;
	}
	
//Contructor de copia
	public ListTree(Tree<E> t) {
		this.labelRoot = t.label();
		this.children = new ArrayList<>();
		
		Iterator<Tree<E>> itr = t.childrenIterator();
		while(itr.hasNext()) {
			//RECURSIVIDAD
			ListTree<E> listTree = new ListTree<E>(itr.next());
			listTree.parent = this;
			children.add(listTree);
		}
	}
	
	//Metodo parent
	public Tree<E> parent(){
		return this.parent;
	}
	
	//Operaciones de árboles ordenados	
	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	@Override
	public E label() {
		return this.labelRoot;
	}
	
	@Override
	public ChildrenIterator<Tree<E>> childrenIterator() {
		return new ListChildrenIterator();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		
		//Si son iguales
		if(this == obj) {
			return true;
		}
		
		//Si es nulo o de distinta clase
		if(obj == null || !(obj instanceof ListTree)){
			return false;
		}
		
		ListTree<E> tree = (ListTree<E>) obj;
		
		//Tienen que tener la misma etiqueta en la raiz
		if(!this.label().equals(tree.label())) {
			return false;
		}
		
		//Comparan los hijos en orden
		Iterator<Tree<E>> itr1 = this.childrenIterator();
		Iterator<Tree<E>> itr2 = tree.childrenIterator();
		
		while(itr1.hasNext() && itr2.hasNext()) {
			if(!itr1.next().equals(itr2.next())) {
				return false;
			}
		}
		
		//Ambos iteraodres deben acabar a la vez
		return !itr1.hasNext() && !itr2.hasNext();
	}
	
	//Iterador de la clase 
	private class ListChildrenIterator implements ChildrenIterator<Tree<E>>{

		ListIterator<Tree<E>> itr;
		
		public ListChildrenIterator() {
			itr = children.listIterator();
		}
		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		@Override
		public Tree<E> next() {
			return itr.next();
		}
		
		public void remove() {
			itr.remove();
		}
		
		@Override
		public void add(Tree<E> e) {
			var tree = new ListTree<E>(e);
			tree.parent = ListTree.this;
			itr.add(tree);
		}
		
		@Override
		public void set(Tree<E> e) {
			var tree = new ListTree<E>(e);
			tree.parent = ListTree.this;
			itr.set(tree);
		}
	}


}
