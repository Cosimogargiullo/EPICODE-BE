package it.epicode.be.gestioneventi;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import it.epicode.be.gestioneventi.model.Concerto;
import it.epicode.be.gestioneventi.model.Evento;
import it.epicode.be.gestioneventi.model.GenereConcerto;
import it.epicode.be.gestioneventi.model.Location;
import it.epicode.be.gestioneventi.model.Partecipazione;
import it.epicode.be.gestioneventi.model.PartitaDiCalcio;
import it.epicode.be.gestioneventi.model.Persona;
import it.epicode.be.gestioneventi.model.Sesso;
import it.epicode.be.gestioneventi.model.StatoPartecipazione;
import it.epicode.be.gestioneventi.model.TipoEvento;
import it.epicode.be.gestioneventi.model.dao.EventoDAO;
import it.epicode.be.gestioneventi.model.dao.LocationDAO;
import it.epicode.be.gestioneventi.model.dao.PartecipazioneDAO;
import it.epicode.be.gestioneventi.model.dao.PersonaDAO;

public class GestioneEventi {

	public static void main(String[] args) {

		Location location = saveLocation();
//		Evento evento = saveEvento(location);
//		Persona persona = savePersona();
//		Partecipazione partecipazione = savePartecipazione(evento, persona);

		Evento c1 = new Concerto("Concerto-1", new Date(), "concerto-1", TipoEvento.PUBBLICO, 500, location,
				GenereConcerto.ROCK, true);
		Evento c2 = new Concerto("Concerto-2", new Date(), "concerto-2", TipoEvento.PRIVATO, 200, location,
				GenereConcerto.POP, false);
//		 saveEvento(c1);
//		 saveEvento(c2);
//		 EventoDAO.getConcertiInStreaming(false);
//		 EventoDAO.getConcertiPerGenere(GenereConcerto.POP);
		
		Evento pc1 = new PartitaDiCalcio("Partita di calcio-1", new Date(), "Partita di calcio-1", TipoEvento.PUBBLICO, 50, location, "Lazio", "Napoli", "Lazio", 2, 0);
		Evento pc2 = new PartitaDiCalcio("Partita di calcio-2", new Date(), "Partita di calcio-2", TipoEvento.PUBBLICO, 60, location, "Roma", "Crotone", "Roma", 3, 1);
		
		 saveEvento(pc1);
		 saveEvento(pc2);
		 EventoDAO.getPartiteVinteInCasa();

	}

	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(StatoPartecipazione.CONFERMATA);

		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.save(part);
		return part;
	}

	private static Persona savePersona() {
		Persona per = new Persona();
		per.setNome("Mario");
		per.setCognome("Rossi");
		per.setEmail("m.rossi@google.com");
		per.setSesso(Sesso.MASCHIO);
		per.setDataDiNascita(new GregorianCalendar(1980, 9, 23).getTime());
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.save(per);
		return per;
	}

	private static Location saveLocation() {
		Location loc = new Location();
		loc.setCitta("Roma");
		loc.setNome("Stadio Olimpico");

		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}

	private static Evento saveEvento(Location loc) {
		Evento ev = new Evento();
		ev.setDataEvento(new Date());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);

		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

	private static Evento saveEvento(Evento ev) {
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

}
