package defa;

public class LibrosElectronicos extends FormatoDigital implements Libros{
	private String autor;
	private int ISBN;
	private String editorial;
	
	public LibrosElectronicos(String titulo, double precio, int itemVendidos,
			int anioPublicacion, CertificadoDigital certificadoDigital, String autor, int ISBN, String editorial) {
		super(titulo, precio, itemVendidos, anioPublicacion, certificadoDigital);
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
		return "Libro electronicos:" + super.toString() + "autor:" + autor +
				"ISBN: " + ISBN + "editorial: " + editorial;
	}

}
