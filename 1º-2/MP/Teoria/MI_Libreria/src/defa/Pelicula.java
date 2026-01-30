package defa;

public class Pelicula extends FormatoDigital{

	private String director;
	private int duracion;
	private String[] actores;
	
	public Pelicula(String titulo, double precio, int itemVendidos,
			int anioPublicacion, CertificadoDigital certificadoDigital,
			String director, int duracion, String[] actores) {
		super(titulo, precio, itemVendidos, anioPublicacion, certificadoDigital);
		this.director = director;
		this.duracion = duracion;
		this.actores = actores;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String[] getActores() {
		return actores;
	}

	public void setActores(String[] actores) {
		this.actores = actores;
	}
	
	@Override
	public String toString() {
		return "Pelicula: " + super.toString() + "director: " + director +
				"duracion: " + duracion + "actores: " + actores;
	}
}
