
public class Postres extends Platos {

	private boolean casero;
	
	public Postres(String nombre, double precio,
			String fecha, boolean casero) {
		super( nombre, precio, fecha);
		this.setCasero(casero);
	}

	public boolean isCasero() {
		return casero;
	}

	public void setCasero(boolean casero) {
		this.casero = casero;
	}

	@Override
	public String toString() {
		return "Postres [isCasero()=" + isCasero() + ", toString()=" + super.toString() + "]";
	}
	
	
}
