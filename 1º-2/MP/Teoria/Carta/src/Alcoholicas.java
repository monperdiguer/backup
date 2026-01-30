
public class Alcoholicas extends Bebidas implements MediaRacion {

	private double grado;
	private double precioMediaRacion;
	private static double MaxMediaRacion = 0.75;
	
	public Alcoholicas (String nombre, double precio, double medida,
			double grado, double precioMediaRacion) {
		super( nombre, precio, medida);
		this.setGrado(grado);
		this.setPrecioMediaRacion(precioMediaRacion);
	}
	
	public double getGrado() {
		return grado;
	}


	public void setGrado(double grado) {
		this.grado = grado;
	}
	
	public double getPrecioMediaRacion() {
		return precioMediaRacion;
	}

	public void setPrecioMediaRacion(double precioMediaRacion) {
		this.precioMediaRacion = Math.min(Alcoholicas.MaxMediaRacion * this.getPrecio(), precioMediaRacion);
	}

	@Override
	public String description() {
		return super.description() + this.getPrecioMediaRacion();
	}

	@Override
	public String toString() {
		return "Alcoholicas [getGrado()=" + getGrado() + ", getPrecioMediaRacion()=" + getPrecioMediaRacion()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
