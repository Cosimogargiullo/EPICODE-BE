package it.epicode.be.gestioneincendi.model;

import lombok.Getter;

@Getter
public class ControlloSonda implements Observer {
	
	private int id;
	private CentroControlloInterface centroControllo;
	
	public ControlloSonda(int id, CentroControlloInterface centroControllo) {
		this.id = id;
		this.centroControllo = centroControllo;
	}
	
	@Override
	public void update(Object o) {
		InfoSonda info = createInfoSonda((Sonda)o);
		centroControllo.rilevaIncendio(info);
	}

	private InfoSonda createInfoSonda(Sonda o) {
		return new InfoSonda(o.getId(),o.getSmokeLevel(), o.getLatitudine(), o.getLongitudine());
	}
}
