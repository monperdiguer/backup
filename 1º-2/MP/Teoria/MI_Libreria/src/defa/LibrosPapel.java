package defa;

public class LibrosPapel  extends Articulo implements Libros{
	private static double IVA = 0.10; //IVA = 10%
	private String autor;
	private int ISBN;
	private String editorial;
	
	public LibrosPapel(String titulo, double precio, int itemVendidos,
			int anioPublicacion, String autor, int ISBN, String editorial) {
		super(titulo, precio, itemVendidos, anioPublicacion, IVA);
		this.autor = autor;
		this.ISBN = ISBN;
		this.editorial = editorial;
	}

	@Override
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro en papel:" + super.toString() + "autor:" + autor +
				"ISBN: " + ISBN + "editorial: " + editorial;
	}
	
}
