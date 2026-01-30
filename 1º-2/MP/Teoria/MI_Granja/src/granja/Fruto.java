package granja;

public class Fruto extends Hortalizas implements Hongos {
	
	private boolean entutoradas;
	private String fungicida;
	
	public Fruto(String nombre, String fecha, Fertilizante fertilizante,
			double litros, boolean entutoradas, String fungicida) {
		super( nombre, fecha, litros, fertilizante);
		this.entutoradas = entutoradas;
		this.fungicida = fungicida;
	}

	public boolean isEntutoradas() {
		return entutoradas;
	}

	public void setEntutoradas(boolean entutoradas) {
		this.entutoradas = entutoradas;
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
	public String cuidar() {
		if(isEntutoradas())
			return "Regar";
		else 
			return super.cuidar();
	}

}
