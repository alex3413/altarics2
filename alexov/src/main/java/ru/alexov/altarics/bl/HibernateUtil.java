package ru.alexov.altarics.bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessFact= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		return new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessFact;
	}
	public static void shutdown() {
		getSessionFactory().close();
	}

}
