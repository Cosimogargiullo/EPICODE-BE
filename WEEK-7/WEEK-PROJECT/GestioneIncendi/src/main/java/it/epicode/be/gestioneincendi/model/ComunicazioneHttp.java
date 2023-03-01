package it.epicode.be.gestioneincendi.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComunicazioneHttp extends CanaleComunicazione {
	private static final Logger logger = LoggerFactory.getLogger(ComunicazioneHttp.class);
	private String baseurlnotifica;

	public ComunicazioneHttp(String baseurlnotifica) {
		this.baseurlnotifica = baseurlnotifica;
	}

	public void sendGet(int idSonda,int smokeLevel, double latitudine, double longitudine ) {
		logger.info("Allarme sonda: {} - lat: {} lon: {} - Livello fumo: {}", idSonda, latitudine, longitudine, smokeLevel);
	
		String url = baseurlnotifica + "?=idsonda=" + idSonda + "&lat=" + latitudine + "&lon=" + longitudine + "&smokelevel=" +smokeLevel;
		logger.info("Call: {}", url);
	}

}
