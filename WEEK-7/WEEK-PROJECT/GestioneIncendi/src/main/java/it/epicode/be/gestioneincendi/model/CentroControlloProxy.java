package it.epicode.be.gestioneincendi.model;

public class CentroControlloProxy implements CentroControlloInterface {
	
	private CentroControlloInterface concreteCentroControllo;
	
	public CentroControlloProxy() {
		concreteCentroControllo = CentroControlloFactory.createCentroControllo();
	}
	
	@Override
	public void rilevaIncendio(InfoSonda info) {
		concreteCentroControllo.rilevaIncendio(info);
	}

}
