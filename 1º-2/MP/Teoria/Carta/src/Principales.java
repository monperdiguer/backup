
public class Principales extends Platos {

	private static String[] posiblesGuarniciones = {"patatas", "verduras", "ensalada"};
	private static String sinGuarnicion = "sin guarnicion";
	private String guarnicion;
	
	public Principales(String nombre, double precio,
			String fecha, String guarnicion) {
		super( nombre, precio, fecha);
		this.setGuarnicion(guarnicion);
	}

	public String getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(String guarnicion) {
		boolean valido = true;
		for(int i = 0; i < Principales.posiblesGuarniciones.length; i++) {
			valido = Principales.posiblesGuarniciones[i].equals(guarnicion);
		}
		if(valido)
			this.guarnicion = guarnicion;
		else
			this.guarnicion = Principales.sinGuarnicion;
	}

	@Override
	public String toString() {
		return "Principales [getGuarnicion()=" + getGuarnicion() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
