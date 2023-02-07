package it.epicode.be.gestioneventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.be.gestioneventi.model.Persona;
import it.epicode.be.gestioneventi.util.JpaUtil;

public class PersonaDAO {
	private static final Logger logger = LoggerFactory.getLogger(PersonaDAO.class);

	public void save(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Persona.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Persona object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}





	private <T> List<T> executeNamedQuery(String namedQuery, Class<T> returnClass) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			Query query = em.createNamedQuery(namedQuery);

			return query.getResultList();

		} finally {
			em.close();
		}
	}
	

	
	

	
	
	public List<Persona> getEventiSoldout(){
		
		return executeNamedQuery("eventiSoldout", Persona.class);

	}
	


}