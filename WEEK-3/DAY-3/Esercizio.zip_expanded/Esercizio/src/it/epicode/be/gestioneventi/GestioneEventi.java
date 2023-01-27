package it.epicode.be.gestioneventi;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.epicode.be.gestioneventi.model.Evento;
import it.epicode.be.gestioneventi.model.Partecipazione;
import it.epicode.be.gestioneventi.model.TipoEvento;
import it.epicode.be.gestioneventi.model.dao.EventoDAO;


public class GestioneEventi {

	public static void main(String[] args) {
		
		Evento evento = saveEvento();

	}

	Set<Partecipazione> pertecipazioni = new HashSet<Partecipazione>() {{
	}};
	
	private static Evento saveEvento() {
		Evento ev = new Evento();
		ev.setDataEvento(new Date());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
//		ev.setPartecipazione();
//		ev.setLocation(null);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

}
