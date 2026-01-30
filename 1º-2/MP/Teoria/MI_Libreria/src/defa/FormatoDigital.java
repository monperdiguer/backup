package defa;

public class FormatoDigital extends Articulo{
	private static final double IVA = 0.05; //5%
	private CertificadoDigital certificadoDigital;

	public FormatoDigital(String titulo, double precio, int itemVendidos,
			int anioPublicacion, CertificadoDigital certificadoDigital) {
		super(titulo, precio, itemVendidos, anioPublicacion, IVA);
		this.certificadoDigital = certificadoDigital;
		
	}

	public CertificadoDigital getCertificadoDigital() {
		return certificadoDigital;
	}

	public void setCertificadoDigital(CertificadoDigital certificadoDigital) {
		this.certificadoDigital = certificadoDigital;
	}
	
	public String toString() {
		return "Articulo digital: certificado digital = " + certificadoDigital;
		
	}
}