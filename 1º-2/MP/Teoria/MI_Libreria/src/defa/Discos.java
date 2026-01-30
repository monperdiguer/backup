package defa;

public class Discos extends FormatoDigital{
	
	private String artista;
	private String[] canciones;

	public Discos(String titulo, double precio, int itemVendidos,
			int anioPublicacion, CertificadoDigital certificadoDigital,
			String artista, String[] canciones) {
		super(titulo, precio, itemVendidos, anioPublicacion, certificadoDigital);
		this.artista = artista;
		this.canciones = canciones;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String[] getCanciones() {
		return canciones;
	}

	public void setCanciones(String[] canciones) {
		this.canciones = canciones;
	}
	
	@Override
	public String toString() {
		return "Discos: " + super.toString() + "artista: " + artista
				+ "canciones: " + canciones;
	}
}
