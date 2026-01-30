
public abstract class Bebidas extends Carta {

	private double medida;
	
	public Bebidas(String nombre, double precio, double medida) {
		super( nombre, precio);
		this.setMedida(medida);
	}

	public double getMedida() {
		return medida;
	}

	public void setMedida(double medida) {
		this.medida = medida;
	}

	@Override
	public String toString() {
		return "Bebidas [getMedida()=" + getMedida() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
