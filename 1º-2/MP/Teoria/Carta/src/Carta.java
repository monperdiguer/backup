
public abstract class Carta {

	private String nombre;
	private double precio;
	
	public Carta (String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String description() {
		return String.format("Plato:" + getNombre() + "precio:" + getPrecio());
		
	}

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", precio=" + precio + "]";
	}
	
}
