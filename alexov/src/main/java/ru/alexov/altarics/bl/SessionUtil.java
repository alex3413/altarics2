package ru.alexov.altarics.bl;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {
	private Session session;
	private Transaction transaction;
	
	public Session getSession() {
		return session;
	}
	public Session openSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public Session TransactionSession() {
		session = openSession();
		transaction = session.beginTransaction();
		return session;
	}
	public void closeSession() {session.close();}
	public void closeTransactionSession() {transaction.commit(); closeSession();}
}
