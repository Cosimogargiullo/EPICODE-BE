package it.epicode.gestioneincendi.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.function.Executable;

import it.epicode.be.gestioneincendi.model.CentroControlloInterface;
import it.epicode.be.gestioneincendi.model.CentroControlloProxy;
import it.epicode.be.gestioneincendi.model.ControlloSonda;
import it.epicode.be.gestioneincendi.model.Sonda;

public class GestioneIncendiTest {

	CentroControlloInterface centroControllo;

	@BeforeAll
	public void setUp() {
		this.centroControllo = new CentroControlloProxy();
	}

	@Test
	public void testRegistraControlloSonda() {

		ControlloSonda controllo1 = new ControlloSonda(1, centroControllo);

		Sonda sonda1 = new Sonda(1, 11.22, 24.22);

		sonda1.addObserver(controllo1);

		assertTrue(sonda1.getObservers().contains(controllo1));

	}

	@Test
	public void testDeRegistraControlloSonda() {

		ControlloSonda controllo1 = new ControlloSonda(1, centroControllo);
		Sonda sonda1 = new Sonda(1, 11.22, 24.22);
		sonda1.addObserver(controllo1);
		assertTrue(sonda1.getObservers().contains(controllo1));

		sonda1.removeObserver(controllo1);
		assertTrue(!sonda1.getObservers().contains(controllo1));

	}

	@Test
	public void testFumoSopraSoglia() {
		CentroControlloInterface centroControlloTest = new CentroControlloTest();

		ControlloSonda controllo1 = new ControlloSonda(1, centroControlloTest);
		Sonda sonda1 = new Sonda(1, 11.22, 24.22);
		sonda1.addObserver(controllo1);

		Executable execute = new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {
				sonda1.setSmokeLevel(7);

			}
		};

		assertThrows(RuntimeException.class, execute);

	}

	@Test
	public void testFumoSottoSoglia() {
		CentroControlloInterface centroControlloTest = new CentroControlloTest();

		ControlloSonda controllo1 = new ControlloSonda(1, centroControlloTest);
		Sonda sonda1 = new Sonda(1, 11.22, 24.22);
		sonda1.addObserver(controllo1);

		Executable execute = new org.junit.jupiter.api.function.Executable() {

			@Override
			public void execute() throws Throwable {
				sonda1.setSmokeLevel(4);

			}
		};

		assertDoesNotThrow(execute);

	}

}
