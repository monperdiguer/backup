package defa;

public class CertificadoDigital {
	private int anioCertificacion;
	private String entidadCertificadora;
	
	public CertificadoDigital(int anioCertificacion, String entidadCertificadora) {
		this.anioCertificacion = anioCertificacion;
		this.entidadCertificadora = entidadCertificadora;
	}

	public int getAnioCertificacion() {
		return anioCertificacion;
	}

	public void setAnioCertificacion(int anioCertificacion) {
		this.anioCertificacion = anioCertificacion;
	}

	public String getEntidadCertificadora() {
		return entidadCertificadora;
	}

	public void setEntidadCertificadora(String entidadCertificadora) {
		this.entidadCertificadora = entidadCertificadora;
	}
	
	public String toString() {
		return "Certificado digital:" + "año:" + anioCertificacion + 
				"entidad: " + entidadCertificadora;
	}
}
