package estdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tipo de dato modificable para árboles binarios. Los
 * nodos del árbol no admiten etiquetas nulas.
 * @param <E> el tipo de las etiquetas de los nodos
 */
public class BinaryTreeImp<E> extends AbstractBinaryTree<E> {
	protected E label;				// etiqueta de la raíz
	protected BinaryTree<E> left;	// subárbol izquierdo
	protected BinaryTree<E> right;	// subárbol derecho
	
	public BinaryTreeImp() {}
	
	public BinaryTreeImp(E e) {
		this(e, new BinaryTreeImp<>(), new BinaryTreeImp<>());
	}
	
	public BinaryTreeImp(E e, BinaryTree<E> left, BinaryTree<E> right) {
		if (e == null) {
			throw new NullPointerException();
		}
		
		label = e;
		this.left = new BinaryTreeImp<>(left);
		this.right = new BinaryTreeImp<>(right);
	}
	
	public BinaryTreeImp(BinaryTree<E> bt) {
		if (!bt.isEmpty()) {
			label = bt.label();
			left = new BinaryTreeImp<>(bt.left());
			right = new BinaryTreeImp<>(bt.right());
		}
	}
	
	public boolean isEmpty() {
		return left == null && right == null;
	}
	
	public BinaryTree<E> left() {
		return left;
	}
	
	public BinaryTree<E> right() {
		return right;
	}
	
	public E label() {
		return label;
	}
	
	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	public void setLabel(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		
		label = e;
	}
	

	
	public Iterator<E> iterator() {
	    return new InorderIterator();
	}

	private class InorderIterator implements Iterator<E> {
	    private BinaryThreaded<E> next;

	    InorderIterator() {
	    	// Primer nodo del recorrido: el más a la izquierda desde la raíz.
			BinaryThreaded<E> tree = (BinaryThreaded<E>) BinaryTreeImp.this;
			if (tree == null || tree.isEmpty()) {
				next = null;
				return;
			}

			while (!tree.left.isEmpty() && !tree.isLeftThread) {
				tree = (BinaryThreaded<E>) tree.left;
			}
			next = tree;
	    }

		@Override
	    public boolean hasNext() {
	        return next != null && !next.isEmpty();
	    }

	    @Override
	    public E next() {
	    	if (!hasNext()) {
				throw new NoSuchElementException();
			}

	        E value = next.label;  // devolver etiqueta actual

	        // Avanzar al sucesor inorden
	        if (next.isRightThread) {
	            // Si es hilo, el sucesor está directamente en right
	            next = (BinaryThreaded<E>) next.right;
	        } else {
	            // Si hay hijo derecho real, bajar al más a la izquierda de ese subárbol
	            BinaryThreaded<E> tree = (BinaryThreaded<E>) next.right;
	            if (tree == null || tree.isEmpty()) {
					next = null;
				} else {
					while (!tree.left.isEmpty() && !tree.isLeftThread) {
						tree = (BinaryThreaded<E>) tree.left;
					}
					next = tree;
				}
	        }

	        return value;
	    }

	    @Override
    public void remove() {
	        throw new UnsupportedOperationException("remove()");
	    }
	}
		
	}
