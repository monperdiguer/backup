
public class Entrantes extends Platos implements MediaRacion {

	private int unidad;
	private double precioMediaRacion;
	private static double MaxMediaRacion = 0.75;
	
	public Entrantes(String nombre, double precio,
			String fecha, int unidad) {
		super(nombre, precio, fecha);
		this.setUnidad(unidad);
	}
	
	
	public int getUnidad() {
		return unidad;
	}


	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}

	public double getPrecioMediaRacion() {
		return precioMediaRacion;
	}


	public void setPrecioMediaRacion(double precioMediaRacion) {
		this.precioMediaRacion = Math.min(Entrantes.MaxMediaRacion * this.getPrecio(), precioMediaRacion);
	}

	@Override
	public String description() {
		return super.description() + this.getPrecioMediaRacion();
		
	}

	
	@Override
	public String toString() {
		return "Entrantes [getUnidad()=" + getUnidad() + ", getPrecioMediaRacion()=" + getPrecioMediaRacion()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
