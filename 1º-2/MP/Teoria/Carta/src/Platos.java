
public abstract class Platos extends Carta {

	private String fecha;
	
	public Platos(String nombre, double precio, String fecha) {
		super(nombre, precio);
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Platos [getFecha()=" + getFecha() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
