package it.epicode.week3day5.models;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaUtil {
	private static final Logger logger = LoggerFactory.getLogger(JpaUtil.class);


	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("CatalogoBibliografico");
		} catch (Throwable ex) {
			logger.error("Initial EntityManagerFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}