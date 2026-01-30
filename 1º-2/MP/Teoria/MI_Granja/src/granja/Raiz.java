package granja;

public class Raiz extends Hortalizas {
	
	public Raiz(String nombre, String fecha, Fertilizante fertilizante, double litros) {
		super(nombre, fecha, litros, fertilizante);
	}
	
	@Override
	public void setFertilizante(Fertilizante fertilizante) {
		if(fertilizante.getFosforo() > fertilizante.getNitrogeno())
			super.setFertilizante(fertilizante);
		
		else setFertilizante(null);
	}

	@Override
	public String toString() {
		return "Raiz [toString()=" + super.toString() + "]";
	}
	
}
