package estdatos;


import java.util.Iterator;


/**
 * Arbol binario con hilos inorden (Threaded Binary Tree)
 */
public class BinaryThreaded<E> extends BinaryTreeImp<E> implements Iterable<E> {

//	Singleton?
	 protected boolean isLeftThread; // indica si left es un hilo o un enlace
	 protected boolean isRightThread; // indica si rightes un hilo o un enlace
	 
	 
	 
	 // arbol vacio compartido para evitar crear multiples instancias
	 private static final BinaryThreaded<?> EMPTY = new BinaryThreaded<>();


	 @SuppressWarnings("unchecked")
	private static <T> BinaryThreaded<T> empty() {
		 return (BinaryThreaded<T>) EMPTY;
	 }

//	 Constructor vacio
	 public BinaryThreaded() {
		 this.label = null;
		 this.left = null;
		 this.right = null;
		 this.isLeftThread = false;
		 this.isRightThread = false;
	 }
	 
//	 Constructor de etiqueta 
	 public BinaryThreaded(E e) {
		 if(e == null) {
			 throw new NullPointerException();
		 }
		 
		 this.label = e;
		 this.left = empty();
		 this.right = empty();
		 this.isLeftThread = false;
		 this.isRightThread = false;
	 }
	 
//	 Constructor con etiqueta y subarboles
	 public BinaryThreaded(E e, BinaryTree<E> leftSubtree, BinaryTree<E> rightSubtree) {
		 if (e == null) throw new NullPointerException();
			this.label = e;
			this.isLeftThread = false;
			this.isRightThread = false;

			// Hijos reales (posiblemente vacíos)
			this.left = (leftSubtree == null) ? empty() : new BinaryThreaded<>(leftSubtree);
			this.right = (rightSubtree == null) ? empty() : new BinaryThreaded<>(rightSubtree);

			// Enhebrado local: conectar extremos de subárboles con el padre.
			if (this.left != null && !this.left.isEmpty()) {
				setRightmostThread((BinaryThreaded<E>) this.left, this);
			}
			if (this.right != null && !this.right.isEmpty()) {
				setLeftmostThread((BinaryThreaded<E>) this.right, this);
			}
	 }
	 
//	 Constructor de copia
	 public BinaryThreaded(BinaryTree<E> bt) {
		 
		 //MUY IMPORTANTE
		 if (bt == null || bt.isEmpty()) {
				// Dejarlo como vacío
				this.label = null;
				this.left = null;
				this.right = null;
				this.isLeftThread = false;
				this.isRightThread = false;
				return;
			}

			this.label = bt.label();
			this.isLeftThread = false;
			this.isRightThread = false;

			BinaryTree<E> l = bt.left();
			BinaryTree<E> r = bt.right();
			
			//Igual que antes
			this.left = (l == null) ? empty() : new BinaryThreaded<>(l);
			this.right = (r == null) ? empty() : new BinaryThreaded<>(r);

			if (this.left != null && !this.left.isEmpty()) {
				setRightmostThread((BinaryThreaded<E>) this.left, this);
			}
			if (this.right != null && !this.right.isEmpty()) {
				setLeftmostThread((BinaryThreaded<E>) this.right, this);
			}
	 }
	 
//	 Clase necesarias de tree
	@Override
	public BinaryTree<E> left() {
		if (isEmpty()) return null;
		return isLeftThread ? empty() : this.left;
	}

	@Override
	public BinaryTree<E> right() {
		if (isEmpty()) return null;
		return isRightThread ? empty() : this.right;
	}

	/**
	 * Busca el nodo MÁS A LA DERECHA del subárbol recibido y le crea un hilo derecho
     * apuntando a 'node' (normalmente el padre).
     *
     * En inorden, el "rightmost" del subárbol izquierdo tiene como sucesor al padre.
     *
     * Recorre a la derecha mientras:
     * - no haya hilo derecho (isRightThread == false)
     * - exista hijo derecho real y no esté vacío
     *
     * Finalmente:
     * - rightmost.right = node
     * - rightmost.isRightThread = true
	 */
	private void setRightmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
		BinaryThreaded<E> rightmost = subtree;
		while (!rightmost.isRightThread && !rightmost.right().isEmpty() && rightmost.right != null) {
			rightmost = (BinaryThreaded<E>) rightmost.right;
		}
		rightmost.right = node;
		rightmost.isRightThread = true;
	}

	 /**
     * Busca el nodo MÁS A LA IZQUIERDA del subárbol recibido y le crea un hilo izquierdo
     * apuntando a 'node' (normalmente el padre).
     *
     * En inorden, el "leftmost" del subárbol derecho tiene como predecesor al padre.
     *
     */
	private void setLeftmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
		BinaryThreaded<E> leftmost = subtree;
		while (!leftmost.isLeftThread && !leftmost.left().isEmpty() && leftmost.left != null) {
			leftmost = (BinaryThreaded<E>) leftmost.left;
		}
		leftmost.left = node;
		leftmost.isLeftThread = true;
	}

	/**
	 * Recorre el árbol en INORDEN usando los hilos.
	 * 
	 */
	public String inorder() {
		StringBuilder sb = new StringBuilder();
		
		//primer nodo, el de mas a la izquierda
		BinaryThreaded<E> current = slideLeft(this);
		
		while (!current.isEmpty() && current != null) {
			sb.append(current.label).append(" ");
			
			//Si hay hilo drecho, el siguiente nodo es el sucesor 
			if (current.isRightThread)
				current = (BinaryThreaded<E>) current.right;
			
			else {
				//El siguiente esta en el subarbol derecho, bajamos por la izquierda
				current = slideLeft((BinaryThreaded<E>) current.right);
			}
		}
		return sb.toString();
	}

	//Funcion auxiliar para llegar al nodo mas a la izquierda
	private static <T> BinaryThreaded<T> slideLeft(BinaryThreaded<T> node) {
		BinaryThreaded<T> cur = node;
		if (cur == null) return null;
		while (cur.left != null && !cur.left.isEmpty() && !cur.isLeftThread) {
			cur = (BinaryThreaded<T>) cur.left;
		}
		return cur;
	}

	//Iterador de BinaryTreeImp
	@Override
	public Iterator<E> iterator() {
		return super.iterator();
	}
}
