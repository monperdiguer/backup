package granja;


public abstract class ArbolFrutal extends Planta {
	
	public ArbolFrutal(String nombre, String fecha, double litros, Fertilizante fertilizante) {
		super(nombre, fecha, litros, fertilizante);
	}
	
	@Override
	public String cuidar() {
		return "Podar";
	}

	@Override
	public String toString() {
		return "ArbolFrutal [cuidar()=" + cuidar() + ", toString()=" + super.toString() + "]";
	}
	
}
