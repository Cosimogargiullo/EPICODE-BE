package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
	
	private static final Logger Logger = LoggerFactory.getLogger (Banca.class);
	
	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1750.5);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			Logger.error("Errore durante il prelievo: " + e, e);
			e.printStackTrace();
		}

		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(2000);

			conto2.stampaSaldo();

		} catch (BancaException e) {
			Logger.error("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
	}
}