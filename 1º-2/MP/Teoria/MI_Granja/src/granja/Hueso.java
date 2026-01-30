package granja;

public class Hueso extends ArbolFrutal implements Hongos {

	private int calcio;
	private static double maxLitros = 8;
	private String fungicida;
	
	public Hueso(String nombre, String fecha, Fertilizante fertilizante,double litros, int calcio, String fungicida) {
		super(nombre, fecha, Math.min(litros, maxLitros),fertilizante);
		this.calcio = calcio;
		this.fungicida = fungicida; 
	}
	
	public int getCalcio() {
		return calcio;
	}

	public void setCalcio(int calcio) {
		this.calcio = calcio;
	}

	public String getFungicida() {
		return fungicida;
	}

	public void setFungicida(String fungicida) {
		this.fungicida = fungicida;
	}

	@Override
	public String fungicida() {
		return fungicida;
	}
	
	@Override
	public void setLitros(double litros) {
		super.setLitros(Math.min(litros, maxLitros));
	}

	@Override
	public String cuidar() {
		return super.cuidar() + getCalcio();
	}

	@Override
	public String toString() {
		return "Hueso [calcio=" + calcio + ", fungicida=" + fungicida + ", toString()=" + super.toString() + "]";
	}
	
}
