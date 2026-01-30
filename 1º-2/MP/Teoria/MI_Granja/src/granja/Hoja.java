package granja;

public class Hoja extends Hortalizas {

	private int altura;
	
	public Hoja(String nombre, String fecha, Fertilizante fertilizante,
			double litros, int altura) {
		super(nombre, fecha, litros, fertilizante);
		setAltura(altura);
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Hoja [getAltura()=" + getAltura() + ", getNombre()=" + getNombre() + ", getFecha()=" + getFecha()
				+ ", getLitros()=" + getLitros() + ", getFertilizante()=" + getFertilizante() + "]";
	}
	
	
}
