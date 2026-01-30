package defa;

public abstract class Articulo {
	
	private String titulo;
	private double precio;
	private int itemVendidos;
	private int anioPublicacion;
	private double iva;
	
	public Articulo(String titulo, double precio, int itemVendidos,
			int anioPublicacion, double iva) {
		this.titulo = titulo;
		this.precio = precio;
		this.itemVendidos = itemVendidos;
		this.anioPublicacion = anioPublicacion;
		this.iva = iva;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getItemVendidos() {
		return itemVendidos;
	}

	public void setItemVendidos(int itemVendidos) {
		this.itemVendidos = itemVendidos;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Articulo: " + "titulo: " + titulo + "precio: "+ precio + 
				"item vendidos:" + itemVendidos + "año:" + anioPublicacion;
	}
}
