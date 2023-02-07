package it.epicode.bw.models;

public enum TratteEnum {
	ANAGNINA_BATTISTINI(20),
	BATTISTINI_ANAGNINA(20),
	REBBIBBIA_LAURENTINA(25),
	LAURENTINA_REBBIBBIA(25),
	LAURENTINA_IONIO(23),
	IONIO_LAURENTINA(23),
	SANGIOVANNI_PANTANO(50),
	PATANO_SANGIOVANNI(50);
	
	public final double tempoPercorrenzaPrevisto;
	
	private TratteEnum (double t) {
		this.tempoPercorrenzaPrevisto = t;
	}
}
