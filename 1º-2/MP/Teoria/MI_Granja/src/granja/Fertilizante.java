package granja;

public class Fertilizante {
	
	private int nitrogeno;
	private int fosforo;
	private int potasio;
	
	public Fertilizante(int nitrogeno, int fosforo, int potasio) {
		this.nitrogeno = nitrogeno;
		this.fosforo = fosforo;
		this.potasio = potasio;
	}

	public int getNitrogeno() {
		return nitrogeno;
	}

	public void setNitrogeno(int nitrogeno) {
		this.nitrogeno = nitrogeno;
	}

	public int getFosforo() {
		return fosforo;
	}

	public void setFosforo(int fosforo) {
		this.fosforo = fosforo;
	}

	public int getPotasio() {
		return potasio;
	}

	public void setPotasio(int potasio) {
		this.potasio = potasio;
	}

	@Override
	public String toString() {
		return "Fertlizante [getNitrogeno()=" + getNitrogeno() + ", getFosforo()=" + getFosforo() + ", getPotasio()="
				+ getPotasio() + "]";
	}
	
}
