package granja;

public abstract class Planta {
	
	private String nombre;
	private String fecha;
	private double litros;
	private Fertilizante fertilizante;
	
	public Planta(String nombre, String fecha, double litros, Fertilizante fertilizante) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.litros = litros;
		this.fertilizante = fertilizante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	
	public Fertilizante getFertilizante() {
		return fertilizante;
	}

	public void setFertilizante(Fertilizante fertilizante) {
		this.fertilizante = fertilizante;
	}

	public abstract String cuidar();
	
	@Override
	public String toString() {
		return "Planta [getNombre()=" + getNombre() + ", getFecha()=" + getFecha() + ", getLitros()=" + getLitros()
				+ ", getFertilizante()=" + getFertilizante() + "]";
	}

}
