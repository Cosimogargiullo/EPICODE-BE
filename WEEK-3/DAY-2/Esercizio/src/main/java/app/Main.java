package app;

import java.time.LocalDate;

import utils.EventoDAO;
import utils.TipoEvento;

public class Main {

	public static void main(String[] args) {
		
		EventoDAO.inserisciEvento("prova2", LocalDate.of(2022,01,01), "descrizione", TipoEvento.PUBBLICO, 25);
		EventoDAO.inserisciEvento("prova3", LocalDate.of(2022,01,01), "descrizione", TipoEvento.PUBBLICO, 35);
//		EventoDAO.getEventoById(3);
//		EventoDAO.deleteEvento(3);
		EventoDAO.refreshEvento(1, "prova4", LocalDate.of(2022,01,01), "descrizione", TipoEvento.PRIVATO, 15);
		
		EventoDAO.closeEm();
	}

}
