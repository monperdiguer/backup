package granja;

public abstract class Hortalizas extends Planta {
	
	private static double maxLitros = 0.5;
	
	public Hortalizas(String nombre, String fecha, double litros, Fertilizante fertilizante) {
		super(nombre, fecha, Math.min(litros, maxLitros), fertilizante);
	}

	@Override
	public void setLitros(double litros) {
		super.setLitros(Math.min(litros, maxLitros));
	}

	@Override
	public String cuidar() {
		return "Entutoar";
	}
	
}
