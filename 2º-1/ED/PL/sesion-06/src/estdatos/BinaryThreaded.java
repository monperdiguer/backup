package estdatos;


import java.util.Iterator;


/**
 * Arbol binario con hilos inorden (Threaded Binary Tree)
 */
public class BinaryThreaded<E> extends BinaryTreeImp<E> implements Iterable<E> {

	 protected boolean isLeftThread; // indica si left es un hilo o un enlace
	 protected boolean isRightThread; // indica si rightes un hilo o un enlace
	 
	 
	 
	 // arbol vacio compartido para evitar crear multiples instancias
	 private static final BinaryThreaded<?> EMPTY = new BinaryThreaded<>();


	 @SuppressWarnings("unchecked")
	private static <T> BinaryThreaded<T> empty() {
		 return (BinaryThreaded<T>) EMPTY;
	 }

	 public BinaryThreaded() {
		 this.label = null;
		 this.left = null;
		 this.right = null;
		 this.isLeftThread = false;
		 this.isRightThread = false;
	 }
	 
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
	 
	 public BinaryThreaded(BinaryTree<E> bt) {
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
			this.left = (l == null) ? empty() : new BinaryThreaded<>(l);
			this.right = (r == null) ? empty() : new BinaryThreaded<>(r);

			if (this.left != null && !this.left.isEmpty()) {
				setRightmostThread((BinaryThreaded<E>) this.left, this);
			}
			if (this.right != null && !this.right.isEmpty()) {
				setLeftmostThread((BinaryThreaded<E>) this.right, this);
			}
	 }
	 
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
	 * For a given node, finds the right-most node in subtree and threads it back to
	 * node
	 * 
	 * @param subtree for which we will find the right-most node
	 * @param node    to be threaded
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
	 * For a given node, finds the left-most node in subtree and threads it back to
	 * node
	 * 
	 * @param subtree for which we will find the left-most node
	 * @param node    to be threaded
	 */
	private void setLeftmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
		BinaryThreaded<E> leftmost = subtree;
		while (!leftmost.isLeftThread && !leftmost.left().isEmpty() && leftmost.right != null) {
			leftmost = (BinaryThreaded<E>) leftmost.left;
		}
		leftmost.left = node;
		leftmost.isLeftThread = true;
	}

	/**
	 * Returns the string representation of the nodes of the tree, traversed in
	 * inorder using threads and separated by a whitespace
	 * 
	 * @return the string representation of the tree
	 */
	public String inorder() {
		StringBuilder sb = new StringBuilder();
		BinaryThreaded<E> current = slideLeft(this);
		while (!current.isEmpty() && current != null) {
			sb.append(current.label).append(" ");
			if (current.isRightThread)
				current = (BinaryThreaded<E>) current.right;
			else {
				current = slideLeft((BinaryThreaded<E>) current.right);
			}
		}
		return sb.toString();
	}

	private static <T> BinaryThreaded<T> slideLeft(BinaryThreaded<T> node) {
		BinaryThreaded<T> cur = node;
		if (cur == null) return null;
		while (cur.left != null && !cur.left.isEmpty() && !cur.isLeftThread) {
			cur = (BinaryThreaded<T>) cur.left;
		}
		return cur;
	}

	@Override
	public Iterator<E> iterator() {
		return super.iterator();
	}
}
