package granja;

public class Pepita extends ArbolFrutal {

	private static double maxLitros = 10;
	
	public Pepita(String nombre, String fecha, Fertilizante fertilizante, double litros) {
		super( nombre,  fecha, Math.min(litros, maxLitros), fertilizante);
	}

	@Override
	public void setLitros(double litros) {
		super.setLitros(Math.min(litros, maxLitros));
	}
	
	@Override
	public String toString() {
		return "Pepita [toString()=" + super.toString() + "]";
	}

}
